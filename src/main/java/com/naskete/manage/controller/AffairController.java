package com.naskete.manage.controller;

import com.naskete.manage.entity.Delivery;
import com.naskete.manage.entity.Product;
import com.naskete.manage.entity.Ware;
import com.naskete.manage.service.DeliveryService;
import com.naskete.manage.service.WareService;
import com.naskete.manage.util.ResultJson;
import com.naskete.manage.util.TimeHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        return new ResultJson(200, "success", deliveries);
    }

    @GetMapping("/ware/{time}")
    public ResultJson getWare(@PathVariable String time) {
        List<Ware> wares = wareService.findAfterTime(time);
        return new ResultJson(200, "success", wares);
    }

    @GetMapping("/delivery/{time}")
    public ResultJson getDelivery(@PathVariable String time) {
        List<Delivery> deliveries = deliveryService.findAfterTime(time);
        return new ResultJson(200, "success", deliveries);
    }

    @GetMapping("/wares")
    public ResultJson getWare(@RequestParam("start") String start,
                              @RequestParam("end") String end) {
        List<Ware> wares = wareService.findBetwinTime(start, end);
        return new ResultJson(200, "success", wares);
    }

    @GetMapping("/deliveries")
    public ResultJson getDelivery(@RequestParam("start") String start,
                                  @RequestParam("end") String end) {
        List<Delivery> deliveries = deliveryService.findBetwinTime(start, end);
        return new ResultJson(200, "success", deliveries);
    }
}
