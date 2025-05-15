package fridge;

import akka.protobufv3.internal.Empty;
import io.grpc.stub.StreamObserver;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.63.0)",
    comments = "Source: fridge.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class FridgeServiceGrpc {

  private FridgeServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "fridge.FridgeService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<fridge.Fridge.Product,
      fridge.Fridge.AddProductResponse> getAddProductMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddProduct",
      requestType = fridge.Fridge.Product.class,
      responseType = fridge.Fridge.AddProductResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<fridge.Fridge.Product,
      fridge.Fridge.AddProductResponse> getAddProductMethod() {
    io.grpc.MethodDescriptor<fridge.Fridge.Product, fridge.Fridge.AddProductResponse> getAddProductMethod;
    if ((getAddProductMethod = FridgeServiceGrpc.getAddProductMethod) == null) {
      synchronized (FridgeServiceGrpc.class) {
        if ((getAddProductMethod = FridgeServiceGrpc.getAddProductMethod) == null) {
          FridgeServiceGrpc.getAddProductMethod = getAddProductMethod =
              io.grpc.MethodDescriptor.<fridge.Fridge.Product, fridge.Fridge.AddProductResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddProduct"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  fridge.Fridge.Product.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  fridge.Fridge.AddProductResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FridgeServiceMethodDescriptorSupplier("AddProduct"))
              .build();
        }
      }
    }
    return getAddProductMethod;
  }

  private static volatile io.grpc.MethodDescriptor<fridge.Fridge.RemoveProductRequest,
      fridge.Fridge.RemoveProductResponse> getRemoveProductMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RemoveProduct",
      requestType = fridge.Fridge.RemoveProductRequest.class,
      responseType = fridge.Fridge.RemoveProductResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<fridge.Fridge.RemoveProductRequest,
      fridge.Fridge.RemoveProductResponse> getRemoveProductMethod() {
    io.grpc.MethodDescriptor<fridge.Fridge.RemoveProductRequest, fridge.Fridge.RemoveProductResponse> getRemoveProductMethod;
    if ((getRemoveProductMethod = FridgeServiceGrpc.getRemoveProductMethod) == null) {
      synchronized (FridgeServiceGrpc.class) {
        if ((getRemoveProductMethod = FridgeServiceGrpc.getRemoveProductMethod) == null) {
          FridgeServiceGrpc.getRemoveProductMethod = getRemoveProductMethod =
              io.grpc.MethodDescriptor.<fridge.Fridge.RemoveProductRequest, fridge.Fridge.RemoveProductResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RemoveProduct"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  fridge.Fridge.RemoveProductRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  fridge.Fridge.RemoveProductResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FridgeServiceMethodDescriptorSupplier("RemoveProduct"))
              .build();
        }
      }
    }
    return getRemoveProductMethod;
  }

  private static volatile io.grpc.MethodDescriptor<fridge.Fridge.Empty,
      fridge.Fridge.ProductList> getListProductsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListProducts",
      requestType = fridge.Fridge.Empty.class,
      responseType = fridge.Fridge.ProductList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<fridge.Fridge.Empty,
      fridge.Fridge.ProductList> getListProductsMethod() {
    io.grpc.MethodDescriptor<fridge.Fridge.Empty, fridge.Fridge.ProductList> getListProductsMethod;
    if ((getListProductsMethod = FridgeServiceGrpc.getListProductsMethod) == null) {
      synchronized (FridgeServiceGrpc.class) {
        if ((getListProductsMethod = FridgeServiceGrpc.getListProductsMethod) == null) {
          FridgeServiceGrpc.getListProductsMethod = getListProductsMethod =
              io.grpc.MethodDescriptor.<fridge.Fridge.Empty, fridge.Fridge.ProductList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListProducts"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  fridge.Fridge.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  fridge.Fridge.ProductList.getDefaultInstance()))
              .setSchemaDescriptor(new FridgeServiceMethodDescriptorSupplier("ListProducts"))
              .build();
        }
      }
    }
    return getListProductsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FridgeServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FridgeServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FridgeServiceStub>() {
        @java.lang.Override
        public FridgeServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FridgeServiceStub(channel, callOptions);
        }
      };
    return FridgeServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FridgeServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FridgeServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FridgeServiceBlockingStub>() {
        @java.lang.Override
        public FridgeServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FridgeServiceBlockingStub(channel, callOptions);
        }
      };
    return FridgeServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FridgeServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FridgeServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FridgeServiceFutureStub>() {
        @java.lang.Override
        public FridgeServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FridgeServiceFutureStub(channel, callOptions);
        }
      };
    return FridgeServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void addProduct(fridge.Fridge.Product request,
        io.grpc.stub.StreamObserver<fridge.Fridge.AddProductResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddProductMethod(), responseObserver);
    }

    /**
     */
    default void removeProduct(fridge.Fridge.RemoveProductRequest request,
        io.grpc.stub.StreamObserver<fridge.Fridge.RemoveProductResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRemoveProductMethod(), responseObserver);
    }

    /**
     */
    default void listProducts(fridge.Fridge.Empty request,
        io.grpc.stub.StreamObserver<fridge.Fridge.ProductList> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListProductsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service FridgeService.
   */
  public static abstract class FridgeServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return FridgeServiceGrpc.bindService(this);
    }

      public abstract void listProducts(Empty request, StreamObserver<Fridge.ProductList> responseObserver);
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service FridgeService.
   */
  public static final class FridgeServiceStub
      extends io.grpc.stub.AbstractAsyncStub<FridgeServiceStub> {
    private FridgeServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FridgeServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FridgeServiceStub(channel, callOptions);
    }

    /**
     */
    public void addProduct(fridge.Fridge.Product request,
        io.grpc.stub.StreamObserver<fridge.Fridge.AddProductResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddProductMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void removeProduct(fridge.Fridge.RemoveProductRequest request,
        io.grpc.stub.StreamObserver<fridge.Fridge.RemoveProductResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRemoveProductMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listProducts(fridge.Fridge.Empty request,
        io.grpc.stub.StreamObserver<fridge.Fridge.ProductList> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListProductsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service FridgeService.
   */
  public static final class FridgeServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<FridgeServiceBlockingStub> {
    private FridgeServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FridgeServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FridgeServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public fridge.Fridge.AddProductResponse addProduct(fridge.Fridge.Product request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddProductMethod(), getCallOptions(), request);
    }

    /**
     */
    public fridge.Fridge.RemoveProductResponse removeProduct(fridge.Fridge.RemoveProductRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRemoveProductMethod(), getCallOptions(), request);
    }

    /**
     */
    public fridge.Fridge.ProductList listProducts(fridge.Fridge.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListProductsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service FridgeService.
   */
  public static final class FridgeServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<FridgeServiceFutureStub> {
    private FridgeServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FridgeServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FridgeServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<fridge.Fridge.AddProductResponse> addProduct(
        fridge.Fridge.Product request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddProductMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<fridge.Fridge.RemoveProductResponse> removeProduct(
        fridge.Fridge.RemoveProductRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRemoveProductMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<fridge.Fridge.ProductList> listProducts(
        fridge.Fridge.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListProductsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_PRODUCT = 0;
  private static final int METHODID_REMOVE_PRODUCT = 1;
  private static final int METHODID_LIST_PRODUCTS = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_PRODUCT:
          serviceImpl.addProduct((fridge.Fridge.Product) request,
              (io.grpc.stub.StreamObserver<fridge.Fridge.AddProductResponse>) responseObserver);
          break;
        case METHODID_REMOVE_PRODUCT:
          serviceImpl.removeProduct((fridge.Fridge.RemoveProductRequest) request,
              (io.grpc.stub.StreamObserver<fridge.Fridge.RemoveProductResponse>) responseObserver);
          break;
        case METHODID_LIST_PRODUCTS:
          serviceImpl.listProducts((fridge.Fridge.Empty) request,
              (io.grpc.stub.StreamObserver<fridge.Fridge.ProductList>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getAddProductMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              fridge.Fridge.Product,
              fridge.Fridge.AddProductResponse>(
                service, METHODID_ADD_PRODUCT)))
        .addMethod(
          getRemoveProductMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              fridge.Fridge.RemoveProductRequest,
              fridge.Fridge.RemoveProductResponse>(
                service, METHODID_REMOVE_PRODUCT)))
        .addMethod(
          getListProductsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              fridge.Fridge.Empty,
              fridge.Fridge.ProductList>(
                service, METHODID_LIST_PRODUCTS)))
        .build();
  }

  private static abstract class FridgeServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FridgeServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return fridge.Fridge.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FridgeService");
    }
  }

  private static final class FridgeServiceFileDescriptorSupplier
      extends FridgeServiceBaseDescriptorSupplier {
    FridgeServiceFileDescriptorSupplier() {}
  }

  private static final class FridgeServiceMethodDescriptorSupplier
      extends FridgeServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    FridgeServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (FridgeServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FridgeServiceFileDescriptorSupplier())
              .addMethod(getAddProductMethod())
              .addMethod(getRemoveProductMethod())
              .addMethod(getListProductsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
