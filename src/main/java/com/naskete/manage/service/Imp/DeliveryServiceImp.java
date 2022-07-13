package com.naskete.manage.service.Imp;

import com.naskete.manage.dao.DeliveryDao;
import com.naskete.manage.entity.Delivery;
import com.naskete.manage.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeliveryServiceImp implements DeliveryService {
    @Autowired
    private DeliveryDao deliveryDao;

    @Override
    public List<Delivery> findAll() {
        return deliveryDao.findAll();
    }
}
