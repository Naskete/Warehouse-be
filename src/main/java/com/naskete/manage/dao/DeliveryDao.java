package com.naskete.manage.dao;

import com.naskete.manage.entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface DeliveryDao extends JpaRepository<Delivery, Integer> {
    @Query(value = "SELECT * FROM delivery WHERE ptime > DATE(?1) ", nativeQuery = true)
    List<Delivery> findAfterTime(String time);

    @Query(value = "SELECT * FROM delivery WHERE ptime > DATE(?1) AND ptime < DATE(?2) ", nativeQuery = true)
    List<Delivery> findBetweenTime(String start, String end);
}
