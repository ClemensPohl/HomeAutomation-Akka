package org.clemens;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class Main {
    public static void main(String[] args) throws Exception {
        Server server = ServerBuilder.forPort(50051)
                .addService(new FridgeServiceImpl())
                .build()
                .start();
        System.out.println("Fridge gRPC server started on port 50051");
        server.awaitTermination();
    }
}