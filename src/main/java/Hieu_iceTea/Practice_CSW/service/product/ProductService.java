package Hieu_iceTea.Practice_CSW.service.product;



import Hieu_iceTea.Practice_CSW.model.Product;
import Hieu_iceTea.Practice_CSW.service.base.BaseService;

import java.util.List;


public interface ProductService extends BaseService<Product, Integer> {

    List<Product> getAll(String KeywordSearch);

}
