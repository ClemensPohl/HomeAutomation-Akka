package at.fhv.sysarch.lab2.homeautomation.devices.fridge;

import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.*;
import at.fhv.sysarch.lab2.homeautomation.commands.fridge.*;
import at.fhv.sysarch.lab2.homeautomation.external.grpc.FridgeGrpcClient;

import java.util.List;

public class Fridge extends AbstractBehavior<FridgeCommand> {
    private final FridgeGrpcClient grpcClient;

    public static Behavior<FridgeCommand> create() {
        return Behaviors.setup(Fridge::new);
    }

    private Fridge(ActorContext<FridgeCommand> context) {
        super(context);
        this.grpcClient = new FridgeGrpcClient("localhost", 50051);
        getContext().getLog().info("Fridge actor started, using remote gRPC fridge");
    }

    @Override
    public Receive<FridgeCommand> createReceive() {
        return newReceiveBuilder()
                .onMessage(AddProduct.class, this::onAddProduct)
                .onMessage(RemoveProduct.class, this::onRemoveProduct)
                .onMessage(ListProducts.class, this::onListProducts)
                .onMessage(ListOrderHistory.class, this::onListOrderHistory)
                .build();
    }

    private Behavior<FridgeCommand> onAddProduct(AddProduct cmd) {
        fridge.Fridge.AddProductResponse response = grpcClient.addProduct(
                cmd.product.getName(), cmd.product.getWeight(), cmd.product.getPrice());
        if (response.getSuccess()) {
            getContext().getLog().info("Receipt of Order: {}, {}", cmd.product.getName(), cmd.product.getPrice());
        } else {
            getContext().getLog().warn("Failed to add product via gRPC: {}. Reason: {}", cmd.product.getName(), response.getMessage());
        }
        return this;
    }

    private Behavior<FridgeCommand> onRemoveProduct(RemoveProduct cmd) {
        boolean success = grpcClient.removeProduct(cmd.productName);
        if (success) {
            getContext().getLog().info("Removed product via gRPC: {}", cmd.productName);
        } else {
            getContext().getLog().warn("Failed to remove product via gRPC: {}", cmd.productName);
        }
        return this;
    }

    private Behavior<FridgeCommand> onListProducts(ListProducts cmd) {
        List<fridge.Fridge.Product> products = grpcClient.listProducts();
        if (products.isEmpty()) {
            System.out.println("Fridge is empty.");
        } else {
            System.out.println("Products in fridge:");
            for (fridge.Fridge.Product p : products) {
                System.out.printf("- %s (%.2f kg, %.2f €)%n", p.getName(), p.getWeight(), p.getPrice());
            }
        }
        return this;
    }

    private Behavior<FridgeCommand> onListOrderHistory(ListOrderHistory cmd) {
        List<fridge.Fridge.Order> orders = grpcClient.getOrderHistory();
        if (orders.isEmpty()) {
            System.out.println("Order history is empty.");
        } else {
            System.out.println("Order history:");
            for (fridge.Fridge.Order o : orders) {
                System.out.printf("- %s (%.2f kg, %.2f €) at %d%n", o.getProductName(), o.getWeight(), o.getPrice(), o.getTimestamp());
            }
        }
        return this;
    }
}
