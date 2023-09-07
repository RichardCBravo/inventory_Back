package com.nexos.inventory.persistence.mapper;

import com.nexos.inventory.domain.ProductDto;
import com.nexos.inventory.persistence.entity.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = UserMapper.class)
public interface ProductMapper {

    ProductDto toProductDto(Product product);
    List<ProductDto> toProductsDto(List<Product> products);

    @InheritInverseConfiguration
    Product toProduct(ProductDto productDto);
}
