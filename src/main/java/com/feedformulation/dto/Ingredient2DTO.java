package com.feedformulation.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Ingredient2DTO {
    private String name;
    private double crudeProtein;
    private double quantityKg;
}

