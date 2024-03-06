package org.mediasoft.crud.db.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mediasoft.crud.db.entity.ProductEntity;
import org.mediasoft.crud.db.repository.ProductEntityRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductEntityRepository productEntityRepository;

    public List<ProductEntity> getAllProducts() {
        log.info("Getting all products.");
        return productEntityRepository.findAll();
    }

    public ProductEntity getProductById(UUID id) {
        log.info("Getting product with id: {}", id);
        return productEntityRepository.findById(id);
    }

    public ProductEntity createOrUpdateProduct(ProductEntity product) {
        log.info("Creating or updating product with article: {}", product.getArticle());
        return productEntityRepository.save(product);
    }

    @Transactional
    public void deleteProduct(UUID id) {
        log.info("Deleting product with id: {}", id);
        productEntityRepository.deleteById(id);
    }
}