package com.naskete.manage.service.Imp;

import com.naskete.manage.dao.ProductDao;
import com.naskete.manage.entity.Product;
import com.naskete.manage.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductServiceImp implements ProductService {
    @Autowired
    private ProductDao productDao;
    @Override
    public void saveProduct(Product product) {
        productDao.save(product);
    }

    @Override
    public Product findByPnameAndStore(String pname, String store) {
        return productDao.findByPnameAndStore(pname, store);
    }

    @Override
    public void updateNum(String pname, String store, Integer num) {
        productDao.updateNum(pname, store, num);
    }

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public List<Product> findByStore(String store) {
        return productDao.findByStore(store);
    }

    @Override
    public Product findByName(String name) {
        return productDao.findByName(name);
    }

    @Override
    public Optional<Product> findById(Integer id) {
        return productDao.findById(id);
    }

    @Override
    public void deleteProd(Integer pid) {
        productDao.deleteById(pid);
    }
}
