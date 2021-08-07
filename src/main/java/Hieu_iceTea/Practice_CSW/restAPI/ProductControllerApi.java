package Hieu_iceTea.Practice_CSW.restAPI;


import Hieu_iceTea.Practice_CSW.restAPI.exception.ProductNotFoundException;
import Hieu_iceTea.Practice_CSW.model.Product;
import Hieu_iceTea.Practice_CSW.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/api/products")
public class ProductControllerApi {

    //Video hướng dẫn của cô ThiDK: http://youtube.com/watch?v=pMxgLOPe_OE
    //Video hướng dẫn của cô ThiDK - video 2: https://www.youtube.com/watch?v=nimev8Djyd8

    //region - Autowired Service -
    @Autowired
    private ProductService productService;
    //endregion


    //region - Display -
    @GetMapping(path = {"", "/", "/index"})
    public List<Product> index(@RequestParam(required = false) String search) {

        return productService.getAll(search);

    }

    @GetMapping(path = {"/{id}", "/{id}/"})
    public Product show(@PathVariable int id) {

        Product product = productService.findById(id);

        if (product == null) {
            throw new ProductNotFoundException("Product id not found - " + id);
        }

        return product;

    }
    //endregion


    //region - Create -
    @PostMapping(path = {"", "/"})
    public Product store(@RequestBody Product product) {

        product.setId(0);

        return productService.save(product);

    }
    //endregion


    //region - Edit -
    @PostMapping(path = {"/{id}", "/{id}/"})
    public Product update(@RequestBody Product product) {

        return productService.save(product);

    }
    //endregion


    //region - Delete -
    @DeleteMapping(path = {"/{id}", "/{id}/"})
    public String delete(@PathVariable int id) {

        if (productService.findById(id) == null) {
            throw new ProductNotFoundException("Product id not found - " + id);
        }

        // 02. Xóa bản ghi database
        productService.deleteById(id);

        return "Deleted Product id - " + id;

    }
    //endregion

}
