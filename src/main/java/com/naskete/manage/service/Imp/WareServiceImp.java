package com.naskete.manage.service.Imp;

import com.naskete.manage.dao.WareDao;
import com.naskete.manage.entity.Ware;
import com.naskete.manage.service.WareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WareServiceImp implements WareService {
    @Autowired
    private WareDao wareDao;
    @Override
    public List<Ware> findAll() {
        return wareDao.findAll();
    }
}
