package dima.and.lesha.web;

import dima.and.lesha.dao.api.ProductDao;
import dima.and.lesha.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductDao productDao;

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Product findById(@PathVariable Long id) {
        return productDao.findOne(id);
    }
}
