package at.fhv.sysarch.lab2.homeautomation.external.grpc;

import fridge.Fridge;
import fridge.FridgeServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;


import java.util.List;

public class FridgeGrpcClient {
    private final FridgeServiceGrpc.FridgeServiceBlockingStub stub;

    public FridgeGrpcClient(String host, int port) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        stub = FridgeServiceGrpc.newBlockingStub(channel);
    }

    public boolean addProduct(String name, double weight, double price) {
        Fridge.Product product = Fridge.Product.newBuilder()
                .setName(name)
                .setWeight(weight)
                .setPrice(price)
                .build();
        Fridge.AddProductResponse response = stub.addProduct(product);
        return response.getSuccess();
    }

    public boolean removeProduct(String name) {
        Fridge.RemoveProductRequest request = Fridge.RemoveProductRequest.newBuilder()
                .setName(name)
                .build();
        Fridge.RemoveProductResponse response = stub.removeProduct(request);
        return response.getSuccess();
    }

    public List<Fridge.Product> listProducts() {
        Fridge.ProductList list = stub.listProducts(Fridge.Empty.newBuilder().build());
        return list.getProductsList();
    }
}

