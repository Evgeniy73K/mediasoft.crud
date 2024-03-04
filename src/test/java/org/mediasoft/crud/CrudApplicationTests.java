package org.mediasoft.crud;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mediasoft.crud.db.entity.CategoryEntity;
import org.mediasoft.crud.db.service.CategoryService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mediasoft.crud.controller.CrudController;
import org.mediasoft.crud.db.entity.ProductEntity;
import org.mediasoft.crud.db.service.ProductService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CrudApplicationTests {
    @Mock
    private ProductService productService;


    @InjectMocks
    private CrudController crudController;
    private final static EasyRandom GENERATOR = new EasyRandom();

    @Test
    void testCreateProduct() {
        var categoryEntity = GENERATOR.nextObject(CategoryEntity.class);
        var product = GENERATOR.nextObject(ProductEntity.class);
        product.setCategoryId(categoryEntity.getId());
        when(productService.createOrUpdateProduct(product)).thenReturn(product);
        ProductEntity createdProduct = crudController.createProduct(product);
        assertEquals(product, createdProduct);
    }
}
