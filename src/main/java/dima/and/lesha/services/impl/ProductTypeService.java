package dima.and.lesha.services.impl;

import dima.and.lesha.dao.api.ProductTypeDao;
import dima.and.lesha.model.ProductType;
import dima.and.lesha.services.api.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
public class ProductTypeService extends dima.and.lesha.services.impl.Service<ProductType, ProductTypeDao> implements IProductTypeService {

    @Autowired
    public ProductTypeService(ProductTypeDao productTypeDao) {
        super(productTypeDao);
    }

    public List<ProductType> findByName(String name){
        return dao.findByName(name);
    }

}
