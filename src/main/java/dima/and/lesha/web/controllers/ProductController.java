package dima.and.lesha.web.controllers;

import dima.and.lesha.model.Product;
import dima.and.lesha.services.api.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final IProductService productService;

    @Autowired
    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Product findById(@PathVariable Long id) {
        return productService.findOne(id);
    }
}
