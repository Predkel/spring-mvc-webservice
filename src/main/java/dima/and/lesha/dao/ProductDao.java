package dima.and.lesha.dao;

import dima.and.lesha.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductDao extends CrudRepository<Product, Long> {
}
