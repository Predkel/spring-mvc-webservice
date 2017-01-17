package dima.and.lesha.dao.api;

import dima.and.lesha.model.Basket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketDao extends CrudRepository<Basket, Long> {

}
