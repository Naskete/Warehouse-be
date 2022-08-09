package com.naskete.manage.dao;

import com.naskete.manage.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {

    @Query(value = "SELECT * FROM product WHERE pname = ?1 AND store = ?2" ,nativeQuery = true)
    Product findByPnameAndStore(String pname, String store);

    @Query(value = "UPDATE product SET num = num + ?3 WHERE pname = ?1 AND store = ?2", nativeQuery = true)
    void updateNum(String pname, String store, Integer num);
}
