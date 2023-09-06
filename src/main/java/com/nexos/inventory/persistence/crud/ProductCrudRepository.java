package com.nexos.inventory.persistence.crud;

import com.nexos.inventory.persistence.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductCrudRepository extends CrudRepository<Product, Integer> {

}
