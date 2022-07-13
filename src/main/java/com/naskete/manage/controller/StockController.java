package com.naskete.manage.controller;

import com.naskete.manage.entity.Delivery;
import com.naskete.manage.entity.Product;
import com.naskete.manage.entity.Ware;
import com.naskete.manage.service.ProductService;
import com.naskete.manage.util.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class StockController {
    @Autowired
    private ProductService productService;

    @PostMapping("/prod/register")
    public ResultJson register(@RequestParam("pname") String pname,
                               @RequestParam("punit") String punit,
                               @RequestParam("store") String store,
                               @RequestParam("type") Integer type,
                               @RequestParam("price") Double price,
                               @RequestParam("num") Double num) {
        Product product = new Product();
        product.setPname(pname);
        product.setPunit(punit);
        product.setStore(store);
        product.setType(type);
        product.setPrice(price);
        product.setNum(num);
        productService.saveProduct(product);
        return new ResultJson(200, "物料登记成功");
    }

    @PostMapping("/prod/wave")
    public ResultJson waveStore(@RequestParam("pname") String pname,
                                @RequestParam("store") String store,
                                @RequestParam("ptime") Date ptime,
                                @RequestParam("num") Integer num,
                                @RequestParam("price") Double price,
                                @RequestParam("username") String username) {
        Ware ware = new Ware();
        ware.setPname(pname);
        ware.setStore(store);
        ware.setPtime(ptime);
        ware.setNum(num);
        ware.setPrice(price);
        ware.setUsername(username);
        return new ResultJson(200, "提交成功");
    }

    @PostMapping("/prod/delivery")
    public ResultJson deliveryStore(@RequestParam("pname") String pname,
                                    @RequestParam("store") String store,
                                    @RequestParam("ptime") Date ptime,
                                    @RequestParam("num") Integer num,
                                    @RequestParam("price") Double price,
                                    @RequestParam("username") String username) {
        Delivery delivery = new Delivery();
        delivery.setPname(pname);
        delivery.setStore(store);
        delivery.setPtime(ptime);
        delivery.setNum(num);
        delivery.setPrice(price);
        delivery.setUsername(username);
        return new ResultJson(200, "提交成功");
    }
}
