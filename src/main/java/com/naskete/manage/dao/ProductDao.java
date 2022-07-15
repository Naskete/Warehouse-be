package com.naskete.manage.dao;

import com.naskete.manage.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {

    Product findByPnameAndStore(String pname, String store);
}
