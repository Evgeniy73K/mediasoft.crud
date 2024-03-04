package org.mediasoft.crud.db.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mediasoft.crud.db.repository.CategoryEntityRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryService {
    private final CategoryEntityRepository categoryEntityRepository;
}
