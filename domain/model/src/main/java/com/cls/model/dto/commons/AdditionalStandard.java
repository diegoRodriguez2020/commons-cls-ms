package com.cls.model.dto.commons;

import lombok.Data;
import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
public class AdditionalStandard {
    private Integer id;
    private String name;
    private Integer price;
    private Integer operationId;
    private String variable;
}
