package com.nttdata.customer.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("customer")
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    private String id;
    private String customerIdType;
    private String customerIdNumber;
    private String customerType;
    private String name;
    private String email;
    private String phone;
    private String address;
}
