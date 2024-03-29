package com.naskete.manage.controller;

import com.naskete.manage.entity.Delivery;
import com.naskete.manage.entity.Product;
import com.naskete.manage.entity.Ware;
import com.naskete.manage.service.DeliveryService;
import com.naskete.manage.service.ProductService;
import com.naskete.manage.service.WareService;
import com.naskete.manage.util.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@CrossOrigin
public class StockController {
    @Autowired
    private ProductService productService;

    @Autowired
    private WareService wareService;

    @Autowired
    private DeliveryService deliveryService;

//    @Autowired
//    private RedisTemplate redisTemplate;

    // 物料登记
    @PostMapping("/prod/register")
    public ResultJson register(
//            @RequestParam("pid") Integer pid,
            @RequestParam("pname") String pname,
            @RequestParam("punit") String punit,
            @RequestParam("store") String store,
            @RequestParam("type") String type,
            @RequestParam("price") Double price,
            @RequestParam("num") Integer num) {
        Product product = productService.findByName(pname);
        if (product != null) {
            return new ResultJson(200, "already save");
        }
        // 第一次登记,直接保存
        product = new Product();
//        product.setPid(pid);
        product.setPname(pname);
        product.setPunit(punit);
        product.setStore(store);
        product.setType(type);
        product.setPrice(price);
        product.setIntime(new Date());
        product.setNum(num);
//        redisTemplate.opsForValue().setIfAbsent(pname, num);
        productService.saveProduct(product);
        return new ResultJson(200, "物料登记成功");
    }

    @PostMapping("/prod/ware")
    public ResultJson wareStore(
            @RequestParam("pname") String pname,
            @RequestParam("store") String store,
            @RequestParam("num") Integer num,
            @RequestParam("price") Double price,
            @RequestParam("username") String username) {
        // 入库
        // 入库单内容
        Product product = productService.findByName(pname);
        if (product == null) {
            return new ResultJson(400, "请对物料进行注册");
        }
        Ware ware = new Ware();
        ware.setPname(pname);
        ware.setStore(store);
        ware.setPtime(new Date());
        ware.setNum(num);
        ware.setPrice(price);
        ware.setUsername(username);
        // 保存入库单
        wareService.saveWare(ware);
        // 更新库存
        productService.updateNum(pname, store, num);
//        redisTemplate.opsForValue().set(pname, (Integer) redisTemplate.opsForValue().get(pname) + num);
        return new ResultJson(200, "提交成功");
    }

    @PostMapping("/prod/delivery")
    public ResultJson deliveryStore(
//            @RequestParam("id") Integer id,
            @RequestParam("pname") String pname,
            @RequestParam("store") String store,
            @RequestParam("num") Integer num,
            @RequestParam("price") Double price,
            @RequestParam("username") String username) {
        // 获取库存
        // 出库单
        Product p = productService.findByName(pname);
        if (p == null) {
            return new ResultJson(400, "未注册物料,无法进行出库");
        }
//        Integer count = (Integer) redisTemplate.opsForValue().get(pname);
//        int count = p.getNum();
//        int cur = 0;
//        if (count == 0) {
        Product product = productService.findByPnameAndStore(pname, store);
        int cur = product.getNum();
//        } else {
//            cur = count;
//        }
        Delivery delivery = new Delivery();
        delivery.setPname(pname);
        delivery.setStore(store);
        delivery.setPtime(new Date());
        delivery.setNum(num);
        delivery.setPrice(price);
        delivery.setUsername(username);
        if (cur < num) {
            return new ResultJson(400, "库存不足");
        }

        // 保存出库单
        deliveryService.saveDelivery(delivery);
        // 更新库存
        productService.updateNum(pname, store, num * (-1));
//        redisTemplate.opsForValue().set(pname, (Integer) redisTemplate.opsForValue().get(pname) - num);
        return new ResultJson(200, "提交成功");
    }
}
