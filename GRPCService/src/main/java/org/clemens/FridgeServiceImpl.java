package org.clemens;

import akka.protobufv3.internal.Empty;
import fridge.Fridge;
import fridge.FridgeServiceGrpc;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.List;

public class FridgeServiceImpl extends FridgeServiceGrpc.FridgeServiceImplBase {
    private final List<Fridge.Product> products = new ArrayList<>();

    @Override
    public void addProduct(Fridge.Product request, StreamObserver<Fridge.AddProductResponse> responseObserver) {
        // Add your logic for maxProducts/maxWeight here!
        products.add(request);
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
    public void listProducts(Empty request, StreamObserver<Fridge.ProductList> responseObserver) {
        Fridge.ProductList.Builder listBuilder = Fridge.ProductList.newBuilder();
        listBuilder.addAllProducts(products);
        responseObserver.onNext(listBuilder.build());
        responseObserver.onCompleted();
    }
}

