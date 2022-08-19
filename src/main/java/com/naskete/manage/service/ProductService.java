package com.naskete.manage.service;

import com.naskete.manage.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {
    void saveProduct(Product product);

    Product findByPnameAndStore(String pname, String store);

    void updateNum(String pname, String store, Integer num);

    List<Product> findAll();

    List<Product> findByStore(String store);

    Product findByName(String name);

    Optional<Product> findById(Integer id);

    void deleteProd(Integer pid);
}
