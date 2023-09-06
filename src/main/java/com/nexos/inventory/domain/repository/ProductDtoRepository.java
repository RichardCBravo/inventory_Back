package com.nexos.inventory.domain.repository;

import com.nexos.inventory.domain.ProductDto;

import java.util.List;
import java.util.Optional;

public interface ProductDtoRepository {
    List<ProductDto> getAll();

    Optional<ProductDto> getProduct(Integer productId);

    ProductDto save(ProductDto productDto);

    void delete(Integer productId);
}
