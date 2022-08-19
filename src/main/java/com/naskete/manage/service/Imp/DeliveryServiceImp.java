package com.naskete.manage.service.Imp;

import com.naskete.manage.dao.DeliveryDao;
import com.naskete.manage.entity.Delivery;
import com.naskete.manage.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class DeliveryServiceImp implements DeliveryService {
    @Autowired
    private DeliveryDao deliveryDao;

    @Override
    public List<Delivery> findAll() {
        return deliveryDao.findAll();
    }

    @Override
    public List<Delivery> findAfterTime(String time) {
        return deliveryDao.findAfterTime(time);
    }

    @Override
    public List<Delivery> findBetweenTime(String start, String end) {
        return deliveryDao.findBetweenTime(start, end);
    }

    @Override
    public void saveDelivery(Delivery delivery) {
        deliveryDao.save(delivery);
    }

    @Override
    public void deleteDelivery(Integer id) {
        deliveryDao.deleteById(id);
    }
}
