package org.mediasoft.crud.db.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
@Data
public class ProductEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "article")
    private String article;

    @Column(name = "dictionary")
    private String dictionary;

    @Column(name = "category_id")
    private UUID categoryId;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "qty")
    private BigDecimal qty;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "modified_at")
    private LocalDate modifiedAt;
    @JsonIgnore
    private UUID getId() {
        return id;
    }

    private void setId(UUID id) {
        this.id = id;
    }

}

