package com.nttdata.product.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("document")
public class Product {

    @Id
    private String id;
    private String productName;
    private String productType;
    private ProductRule productRule;
}
