package dima.and.lesha.services.impl;

import dima.and.lesha.dao.api.ProductDao;
import dima.and.lesha.model.Product;
import dima.and.lesha.services.api.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
public class ProductService implements IProductService {

    private final ProductDao productDao;

    @Autowired
    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public List<Product> findByName(String name){
        return productDao.findByName(name);
    }

    public Product findOne(Long id) {
        return productDao.findOne(id);
    }
}