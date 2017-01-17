package dima.and.lesha.dao.api;

import dima.and.lesha.model.Goods;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsDao extends CrudRepository<Goods, Long> {
}
