package com.naskete.manage.service;

import com.naskete.manage.entity.Delivery;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DeliveryService {
    List<Delivery> findAll();

    List<Delivery> findAfterTime(String time);

    List<Delivery> findBetweenTime(String start, String end);

    void saveDelivery(Delivery delivery);
}
