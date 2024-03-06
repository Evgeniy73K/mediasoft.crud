package org.mediasoft.crud.db.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mediasoft.crud.db.entity.CategoryEntity;
import org.mediasoft.crud.db.repository.CategoryEntityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryService {
    private final CategoryEntityRepository categoryEntityRepository;

    public List<CategoryEntity> getAllCategories() {
        log.info("Getting all categories.");
        return categoryEntityRepository.findAll();
    }
}
