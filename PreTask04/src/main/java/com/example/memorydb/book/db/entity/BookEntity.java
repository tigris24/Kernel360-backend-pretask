package com.example.memorydb.book.db.entity;

import com.example.memorydb.entity.Entity;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookEntity extends Entity {
    private String title;
    private String category;
    private BigDecimal amout;
}
