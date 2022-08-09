package com.naskete.manage.service;

import com.naskete.manage.entity.Ware;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WareService {
    List<Ware> findAll();

    List<Ware> findAfterTime(String time);

    List<Ware> findBetweenTime(String start, String end);

    void saveWare(Ware ware);
}
