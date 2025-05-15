package org.clemens;

import fridge.Fridge;
import fridge.FridgeServiceGrpc;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.List;

public class FridgeServiceImpl extends FridgeServiceGrpc.FridgeServiceImplBase {
    private static final int MAX_PRODUCTS = 10;
    private static final double MAX_WEIGHT = 50.0;

    private final List<Fridge.Product> products = new ArrayList<>();
    private final List<Fridge.Order> orderHistory = new ArrayList<>();

    @Override
    public void addProduct(Fridge.Product request, StreamObserver<Fridge.AddProductResponse> responseObserver) {
        double currentWeight = products.stream()
                .mapToDouble(Fridge.Product::getWeight)
                .sum();

        if (products.size() >= MAX_PRODUCTS) {
            Fridge.AddProductResponse response = Fridge.AddProductResponse.newBuilder()
                    .setSuccess(false)
                    .setMessage("Fridge is full! Max products: " + MAX_PRODUCTS)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            return;
        }

        if (currentWeight + request.getWeight() > MAX_WEIGHT) {
            Fridge.AddProductResponse response = Fridge.AddProductResponse.newBuilder()
                    .setSuccess(false)
                    .setMessage("Fridge weight limit exceeded! Max weight: " + MAX_WEIGHT + " kg")
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            return;
        }

        products.add(request);

        // Add to order history as an Order
        Fridge.Order order = Fridge.Order.newBuilder()
                .setProductName(request.getName())
                .setWeight(request.getWeight())
                .setPrice(request.getPrice())
                .setTimestamp(System.currentTimeMillis())
                .build();
        orderHistory.add(order);

        Fridge.AddProductResponse response = Fridge.AddProductResponse.newBuilder()
                .setSuccess(true)
                .setMessage("Product added: " + request.getName())
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void removeProduct(Fridge.RemoveProductRequest request, StreamObserver<Fridge.RemoveProductResponse> responseObserver) {
        // Find and remove the first product with the given name
        Fridge.Product removedProduct = null;
        for (Fridge.Product p : products) {
            if (p.getName().equalsIgnoreCase(request.getName())) {
                removedProduct = p;
                break;
            }
        }

        boolean removed = false;
        if (removedProduct != null) {
            products.remove(removedProduct);
            removed = true;
        }

        // Check if any more of this product remain
        boolean stillExists = products.stream()
                .anyMatch(p -> p.getName().equalsIgnoreCase(request.getName()));

        String autoOrderMsg = "";

        // If none remain, auto-reorder
        if (removed && !stillExists && removedProduct != null) {
            double currentWeight = products.stream().mapToDouble(Fridge.Product::getWeight).sum();
            if (products.size() < MAX_PRODUCTS && currentWeight + removedProduct.getWeight() <= MAX_WEIGHT) {
                products.add(removedProduct);
                // Add to order history
                Fridge.Order order = Fridge.Order.newBuilder()
                        .setProductName(removedProduct.getName())
                        .setWeight(removedProduct.getWeight())
                        .setPrice(removedProduct.getPrice())
                        .setTimestamp(System.currentTimeMillis())
                        .build();
                orderHistory.add(order);
                autoOrderMsg = " (Auto-reordered " + removedProduct.getName() + ")";
                System.out.println("Auto-reordered product: " + removedProduct.getName());
            } else {
                autoOrderMsg = " (Auto-reorder failed: Not enough space or weight capacity!)";
                System.out.println("Auto-reorder failed: Not enough space or weight capacity!");
            }
        }

        Fridge.RemoveProductResponse response = Fridge.RemoveProductResponse.newBuilder()
                .setSuccess(removed)
                .setMessage((removed ? "Product removed" : "Product not found") + autoOrderMsg)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void listProducts(fridge.Fridge.Empty request, StreamObserver<fridge.Fridge.ProductList> responseObserver) {
        Fridge.ProductList.Builder listBuilder = Fridge.ProductList.newBuilder();
        listBuilder.addAllProducts(products);
        responseObserver.onNext(listBuilder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void getOrderHistory(fridge.Fridge.Empty request, StreamObserver<fridge.Fridge.OrderHistoryList> responseObserver) {
        Fridge.OrderHistoryList.Builder historyBuilder = Fridge.OrderHistoryList.newBuilder();
        historyBuilder.addAllOrders(orderHistory);
        responseObserver.onNext(historyBuilder.build());
        responseObserver.onCompleted();
    }
}
