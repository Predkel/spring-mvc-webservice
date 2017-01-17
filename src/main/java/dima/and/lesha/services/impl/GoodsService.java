package dima.and.lesha.services.impl;

import dima.and.lesha.dao.api.GoodsDao;
import dima.and.lesha.model.Goods;
import dima.and.lesha.services.api.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsService extends dima.and.lesha.services.impl.Service<Goods,GoodsDao> implements IGoodsService {
    @Autowired
    public GoodsService(GoodsDao goodsDao) {
        super(goodsDao);
    }
}
