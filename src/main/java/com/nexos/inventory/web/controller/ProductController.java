package com.nexos.inventory.web.controller;


import com.nexos.inventory.domain.ProductDto;
import com.nexos.inventory.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable("id") int productId) {
        return productService.getProduct(productId)
                .map(productDto -> new ResponseEntity<>(productDto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/new")
    public ResponseEntity<ProductDto> save(@RequestBody ProductDto productDto){
        return productService.save(productDto)
                .map(productDto1 -> new ResponseEntity<>(productDto1, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.CONFLICT));
    }

    @PutMapping("/update") ResponseEntity<ProductDto> update(@RequestBody ProductDto productDto) {
        return productService.update(productDto)
                .map(productDto1 -> new ResponseEntity<>(productDto1, HttpStatus.ACCEPTED))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int productId, @RequestParam("userid") int userId) {
        if(productService.delete(productId, userId)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/name")
    public ResponseEntity getName(@RequestParam("value") String name) {
        return productService.getByName(name)
                .map(productDtos -> new ResponseEntity<>(productDtos, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
