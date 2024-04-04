package org.example.basket.impl;

import org.example.basket.response.ProductResponse;
import org.example.basket.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public ProductResponse findProduct(int id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:9094/products/" + id, ProductResponse.class);
    }
}
