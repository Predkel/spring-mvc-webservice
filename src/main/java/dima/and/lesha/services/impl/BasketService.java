package dima.and.lesha.services.impl;

import dima.and.lesha.dao.api.BasketDao;
import dima.and.lesha.model.Basket;
import dima.and.lesha.services.api.IBasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasketService extends dima.and.lesha.services.impl.Service<Basket,BasketDao> implements IBasketService {

    @Autowired
    protected BasketService(BasketDao basketDao) {
        super(basketDao);
    }
}
