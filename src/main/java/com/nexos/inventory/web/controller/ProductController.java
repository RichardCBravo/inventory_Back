package com.nexos.inventory.web.controller;


import com.nexos.inventory.domain.ProductDto;
import com.nexos.inventory.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<List<ProductDto>>  getAll() {
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

}
