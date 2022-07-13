package com.naskete.manage.controller;

import com.naskete.manage.entity.Delivery;
import com.naskete.manage.entity.Ware;
import com.naskete.manage.service.DeliveryService;
import com.naskete.manage.service.WareService;
import com.naskete.manage.util.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AffairController {
    @Autowired
    private WareService wareService;

    @Autowired
    private DeliveryService deliveryService;

    @GetMapping("/ware")
    public ResultJson ware() {
        List<Ware> wareList = wareService.findAll();
        return new ResultJson(200, "success", wareList);
    }

    @GetMapping("/delivery")
    public ResultJson delivery() {
        List<Delivery> deliveries = deliveryService.findAll();
        return new ResultJson(200, "success");
    }
}
