package com.FSD.JPA;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class Productcontroller {
    @Autowired
    private Productrepositories repository;
    @GetMapping
    public List<Product> getAllProducts()
    {
        return repository.findAll();
    }
    @PostMapping
    public Product createProduct(@RequestBody Product product)
    {
        return repository.save(product);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable Long id,
            @RequestBody Product productDetails) {

        return repository.findById(id)
                .map(product -> {

                    product.setName(productDetails.getName());
                    product.setPrice(productDetails.getPrice());

                    Product updated = repository.save(product);

                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {

        return repository.findById(id)
                .map(product -> {
                    repository.delete(product);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
