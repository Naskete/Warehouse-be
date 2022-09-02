package com.naskete.manage.controller;

import com.naskete.manage.entity.Delivery;
import com.naskete.manage.entity.Product;
import com.naskete.manage.entity.Ware;
import com.naskete.manage.service.DeliveryService;
import com.naskete.manage.service.ProductService;
import com.naskete.manage.service.WareService;
import com.naskete.manage.util.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class AffairController {
    @Autowired
    private WareService wareService;

    @Autowired
    private DeliveryService deliveryService;

    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public ResultJson prod() {
        List<Product> productList = productService.findAll();
        return new ResultJson(200, "success", productList);
    }

    @PostMapping("/product/store")
    public ResultJson prod(@RequestParam("store") String store) {
        List<Product> productList = productService.findByStore(store);
        return new ResultJson(200, "success", productList);
    }

    @PostMapping("/product/{id}")
    public ResultJson getProdById(@PathVariable Integer id) {
        Optional<Product> products = productService.findById(id);
        Product product = null;
        if (products.isPresent()) {
            product = products.get();
        } else {
            return new ResultJson(400, "not found");
        }
        return new ResultJson(200, "success", product);
    }

    @PostMapping("/product/name")
    public ResultJson getProd(@RequestParam("name") String name) {
        Product product = productService.findByName(name);
        return new ResultJson(200, "success", product);
    }


    @PostMapping("/product/delete")
    public ResultJson deleteProd(@RequestParam("id") Integer pid) {
        productService.deleteProd(pid);
        return new ResultJson(200, "ok");
    }

    @GetMapping("/ware")
    public ResultJson ware() {
        List<Ware> wareList = wareService.findAll();
        return new ResultJson(200, "success", wareList);
    }

    @GetMapping("/ware/{time}")
    public ResultJson getWare(@PathVariable String time) {
        List<Ware> wares = wareService.findAfterTime(time);
        return new ResultJson(200, "success", wares);
    }

    @PostMapping(value = "/ware/delete")
    public ResultJson deleteWare(@RequestParam("id") Integer id) {
        wareService.deleteWare(id);
        return new ResultJson(200, "ok");
    }

    @PostMapping("/wares")
    public ResultJson getWare(@RequestParam("start") String start,
                              @RequestParam("end") String end) {
        List<Ware> wares = wareService.findBetweenTime(start, end);
        return new ResultJson(200, "success", wares);
    }

    @GetMapping("/delivery")
    public ResultJson delivery() {
        List<Delivery> deliveries = deliveryService.findAll();
        return new ResultJson(200, "success", deliveries);
    }

    @PostMapping("/delivery/delete")
    public ResultJson deleteDelivery(@RequestParam("id") Integer id) {
        deliveryService.deleteDelivery(id);
        return new ResultJson(200, "ok");
    }

    @GetMapping("/delivery/{time}")
    public ResultJson getDelivery(@PathVariable String time) {
        List<Delivery> deliveries = deliveryService.findAfterTime(time);
        return new ResultJson(200, "success", deliveries);
    }

    @PostMapping("/deliveries")
    public ResultJson getDelivery(@RequestParam("start") String start,
                                  @RequestParam("end") String end) {
        List<Delivery> deliveries = deliveryService.findBetweenTime(start, end);
        return new ResultJson(200, "success", deliveries);
    }
}
