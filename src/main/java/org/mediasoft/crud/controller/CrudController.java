package org.mediasoft.crud.controller;

import jakarta.validation.Valid;
import org.mediasoft.crud.db.entity.ProductEntity;
import org.mediasoft.crud.db.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
@EnableJpaRepositories
@Validated
public class CrudController {
    @Autowired
    ProductService productService;

    @PostMapping("/create")
    public ProductEntity createProduct(@Valid @RequestBody ProductEntity product) {
        return productService.createOrUpdateProduct(product);
    }

    @GetMapping("/products")
    public List<ProductEntity> all() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public ProductEntity one(@PathVariable UUID id) {
        return productService.getProductById(id);
    }

    @DeleteMapping("/products/{id}")
    public void deleteEmployee(@PathVariable UUID id) {
        productService.deleteProduct(id);
    }

    @PutMapping("/products/{id}")
    public ProductEntity replaceProduct(@Valid @RequestBody ProductEntity newProduct, @PathVariable UUID id) {
        var currentProduct = productService.getProductById(id);

        currentProduct.setName(newProduct.getName());
        currentProduct.setArticle(newProduct.getArticle());
        currentProduct.setPrice(newProduct.getPrice());
        currentProduct.setDictionary(newProduct.getDictionary());
        currentProduct.setQty(newProduct.getQty());
        currentProduct.setModifiedAt(LocalDate.now());

        return productService.createOrUpdateProduct(currentProduct);
    }

}