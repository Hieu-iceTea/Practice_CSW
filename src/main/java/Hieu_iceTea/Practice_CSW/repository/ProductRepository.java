package Hieu_iceTea.Practice_CSW.repository;



import Hieu_iceTea.Practice_CSW.model.Product;

import java.util.List;


public interface ProductRepository extends BaseRepository<Product, Integer> {

    List<Product> findAllByNameContainsOrderByIdDesc(String name);

}