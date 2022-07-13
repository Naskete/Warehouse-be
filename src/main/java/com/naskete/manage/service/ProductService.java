package com.naskete.manage.service;

import com.naskete.manage.entity.Product;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {
    void saveProduct(Product product);
}
