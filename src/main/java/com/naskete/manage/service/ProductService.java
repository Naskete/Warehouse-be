package com.naskete.manage.service;

import com.naskete.manage.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {
    void saveProduct(Product product);

    Product findByPnameAndStore(String pname, String store);

    void updateNum(String pname, String store, Integer num);
}
