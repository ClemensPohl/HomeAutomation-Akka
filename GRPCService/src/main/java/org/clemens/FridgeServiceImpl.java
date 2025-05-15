package org.clemens;

import fridge.Fridge;
import fridge.FridgeServiceGrpc;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.List;

public class FridgeServiceImpl extends FridgeServiceGrpc.FridgeServiceImplBase {
    private final List<Fridge.Product> products = new ArrayList<>();
    private final List<Fridge.Order> orderHistory = new ArrayList<>();

    @Override
    public void addProduct(Fridge.Product request, StreamObserver<Fridge.AddProductResponse> responseObserver) {
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
        boolean removed = products.removeIf(p -> p.getName().equalsIgnoreCase(request.getName()));
        Fridge.RemoveProductResponse response = Fridge.RemoveProductResponse.newBuilder()
                .setSuccess(removed)
                .setMessage(removed ? "Product removed" : "Product not found")
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
