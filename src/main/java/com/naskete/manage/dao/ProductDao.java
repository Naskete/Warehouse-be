package com.naskete.manage.dao;

import com.naskete.manage.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {

    @Query(value = "SELECT * FROM product WHERE pname = ?1 AND store = ?2" ,nativeQuery = true)
    Product findByPnameAndStore(String pname, String store);

    @Query(value = "UPDATE product SET num = num + ?3 WHERE pname = ?1 AND store = ?2", nativeQuery = true)
    @Modifying
    @Transactional
    void updateNum(String pname, String store, Integer num);

    @Query(value = "SELECT * FROM product WHERE store = ?1", nativeQuery = true)
    List<Product> findByStore(String store);

    @Query(value = "SELECT * FROM product WHERE pname = ?1", nativeQuery = true)
    Product findByName(String name);
}
