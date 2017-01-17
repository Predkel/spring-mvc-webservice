package dima.and.lesha.dao.api;

import dima.and.lesha.model.ProductType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductTypeDao extends CrudRepository<ProductType, Long> {
    List<ProductType> findByName(String name);
}
