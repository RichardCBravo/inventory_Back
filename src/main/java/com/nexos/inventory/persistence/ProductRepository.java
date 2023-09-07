package com.nexos.inventory.persistence;

import com.nexos.inventory.domain.ProductDto;
import com.nexos.inventory.domain.repository.ProductDtoRepository;
import com.nexos.inventory.persistence.crud.ProductCrudRepository;
import com.nexos.inventory.persistence.entity.Product;
import com.nexos.inventory.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository implements ProductDtoRepository {

    @Autowired
    private ProductCrudRepository productCrudRepository;

    @Autowired
    private ProductMapper mapper;

    @Override
    public List<ProductDto> getAll() {
        List<Product> products = (List<Product>) productCrudRepository.findAll();
        return mapper.toProductsDto(products);
    }

    @Override
    public Optional<ProductDto> getProduct(Integer productId) {
        return productCrudRepository.findById(productId).map(product -> mapper.toProductDto(product));
    }

    @Override
    public Optional<ProductDto> update(ProductDto productDto) {
        Product product = mapper.toProduct(productDto);
        return Optional.of(mapper.toProductDto(productCrudRepository.save(product)));
    }

    @Override
    public Optional<List<ProductDto>> getByName(String name) {
        List<Product> products = productCrudRepository.findByNameContainingIgnoreCase(name);
        return Optional.of(mapper.toProductsDto(products));
    }

    @Override
    public Optional<ProductDto> save(ProductDto productDto) {
        Date dateCurrent = new Date();

        Date productDate = productDto.getRegistrationDate();

        if (productDate.equals(dateCurrent) || productDate.before(dateCurrent)){
            Product product = mapper.toProduct(productDto);
            try {
                return Optional.of(mapper.toProductDto(productCrudRepository.save(product)));
            }
            catch(Exception e) {
                return Optional.empty();
            }
        }
        return Optional.empty();
    }

    @Override
    public void delete(Integer productId) {
        productCrudRepository.deleteById(productId);
    }
}
