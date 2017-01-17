package dima.and.lesha.services.api;

import dima.and.lesha.model.ProductType;

import java.util.List;

public interface IProductTypeService extends IService<ProductType> {
    List<ProductType> findByName(String name);
}
