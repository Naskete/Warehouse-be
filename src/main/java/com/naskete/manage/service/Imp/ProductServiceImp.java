package com.naskete.manage.service.Imp;

import com.naskete.manage.dao.ProductDao;
import com.naskete.manage.entity.Product;
import com.naskete.manage.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
}
