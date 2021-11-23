package com.nttdata.product.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data

public class ProductRule {
    private List<String> customerOwner;
    private boolean commission;
    private boolean movements;
    private Integer quantityMaximumMovementsMonthly;
    private Double maximumLimitCredit;
}
