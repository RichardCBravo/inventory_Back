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

    public Optional<List<ProductDto>> getByName(String name) {
        return productDtoRepository.getByName(name);
    }

    public Optional<ProductDto> update(ProductDto productDto) {
        boolean isProduct = Boolean.TRUE.equals(productDtoRepository.getProduct(productDto.getProductId())
                .map(productDto1 -> true)
                .orElse(null));

        if (isProduct) {
            return productDtoRepository.update(productDto);
        }
        return Optional.empty();

    }

    public Optional<ProductDto> save(ProductDto productDto) {
        return productDtoRepository.save(productDto);
    }

    public boolean delete(int productId, int userId) {
        return getProduct(productId).map(productDto -> {
            if (productDto.getUserId() == userId) {
                productDtoRepository.delete(productId);
                return true;
            }
            return false;
        }).orElse(false);
    }

}
