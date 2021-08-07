package Hieu_iceTea.Practice_CSW.service.product;


import Hieu_iceTea.Practice_CSW.model.Product;
import Hieu_iceTea.Practice_CSW.repository.ProductRepository;
import Hieu_iceTea.Practice_CSW.service.base.BaseServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImplement extends BaseServiceImplement<Product, Integer> implements ProductService {

    //region Initialization - Autowired
    @Autowired
    private ProductRepository productRepository;

    public ProductServiceImplement(ProductRepository repository) {
        super(repository);
    }
    //endregion


    //region Method
    @Override
    public List<Product> getAll(String KeywordSearch) {
        List<Product> products;
        if (KeywordSearch == null) {
            products = productRepository.findAllByOrderByIdDesc();
        } else {
            products = productRepository.findAllByNameContainsOrderByIdDesc(KeywordSearch);
        }

        return products;
    }
    //endregion

}
