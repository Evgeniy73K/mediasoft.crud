package org.mediasoft.crud.db.repository;

import org.mediasoft.crud.db.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryEntityRepository  extends JpaRepository<CategoryEntity, Integer> {
}
