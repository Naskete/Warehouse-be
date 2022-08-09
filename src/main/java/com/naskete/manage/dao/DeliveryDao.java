package com.naskete.manage.dao;

import com.naskete.manage.entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface DeliveryDao extends JpaRepository<Delivery, Integer> {
    @Query(value = "SELECT * FROM delivery WHERE ptime > ?", nativeQuery = true)
    List<Delivery> findAfterTime(String time);
}
