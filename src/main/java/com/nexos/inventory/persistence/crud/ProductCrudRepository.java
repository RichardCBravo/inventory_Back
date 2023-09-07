package com.nexos.inventory.persistence.crud;

import com.nexos.inventory.domain.ProductDto;
import com.nexos.inventory.persistence.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductCrudRepository extends CrudRepository<Product, Integer> {
    List<Product> findByNameOrderByNameAsc(String name);
    List<Product> findByNameContainingIgnoreCase(String name);

}
