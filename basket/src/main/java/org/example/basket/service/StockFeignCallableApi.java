package org.example.basket.service;

import org.example.basket.response.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "stock")
public interface StockFeignCallableApi {

    @GetMapping("/products/{id}")
    ProductResponse findProductById(@PathVariable int id);
}
