package dima.and.lesha.web.controllers;

import dima.and.lesha.model.ProductType;
import dima.and.lesha.services.api.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductTypeController {

    private final IProductTypeService productService;

    @Autowired
    public ProductTypeController(IProductTypeService productService) {
        this.productService = productService;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ProductType findById(@PathVariable Long id) {
        return productService.findOne(id);
    }
}
