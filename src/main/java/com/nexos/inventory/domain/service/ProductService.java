package com.nexos.inventory.domain.service;

import com.nexos.inventory.domain.ProductDto;
import com.nexos.inventory.domain.repository.ProductDtoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {


    @Autowired
    private ProductDtoRepository productDtoRepository;

    public List<ProductDto> getAll() {
        return productDtoRepository.getAll();
    }

    public Optional<ProductDto> getProduct(Integer productId) {
        return productDtoRepository.getProduct(productId);
    }

    public ProductDto save(ProductDto productDto) {
        return productDtoRepository.save(productDto);
    }

    public boolean delete(int productId) {
        return getProduct(productId).map(productDto -> {
            productDtoRepository.delete(productId);
            return true;
        }).orElse(false);
    }

}
