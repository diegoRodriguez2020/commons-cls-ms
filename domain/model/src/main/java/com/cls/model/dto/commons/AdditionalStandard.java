package com.cls.model.dto.commons;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AdditionalStandard {
    private Integer id;
    private String name;
    private BigDecimal price;
    private Integer operationId;
    private String variable;
}
