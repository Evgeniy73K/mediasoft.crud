package org.mediasoft.crud.db.repository;

import org.mediasoft.crud.db.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductEntityRepository extends JpaRepository<ProductEntity, Integer> {
    ProductEntity findById(UUID uuid);
    void deleteById(UUID uuid);
}
