package com.swanjohi.service;

import com.swanjohi.entity.Stock;
import com.swanjohi.grpc.StockRequest;
import com.swanjohi.grpc.StockResponse;
import com.swanjohi.repository.StockRepository;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import org.springframework.grpc.server.service.GrpcService;


@GrpcService
@RequiredArgsConstructor
public class StockServiceImpl extends com.swanjohi.grpc.StockTradingServiceGrpc.StockTradingServiceImplBase {
    private final StockRepository stockRepository;


    @Override
    public void getStockPrice(StockRequest request, StreamObserver<StockResponse> responseObserver) {

        String stockSymbol = request.getStockSymbol();
        Stock stockEntity = stockRepository.findByStockSymbol(stockSymbol);

        StockResponse stockResponse = StockResponse.newBuilder()
                .setStockSymbol(stockEntity.getStockSymbol())
                .setAmount(stockEntity.getPrice())
                .setTimestamp(stockEntity.getLastUpdated().toString())
                .build();

        responseObserver.onNext(stockResponse);
        responseObserver.onCompleted();
    }
}
