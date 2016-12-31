package dima.and.lesha.dao.api;

import dima.and.lesha.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao extends CrudRepository<Product, Long> {
    List<Product> findByName(String name);
}
