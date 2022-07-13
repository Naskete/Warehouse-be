package com.naskete.manage.dao;

import com.naskete.manage.entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryDao extends JpaRepository<Delivery, Integer> {
}
