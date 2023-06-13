package com.cls.model.entity.commons;

import lombok.Data;
import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Entity
@Immutable
@Table(name="additional_operation")
public class AdditionalOperationEntity {
    @Id()
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "operation_id")
    private Integer operationId;
    @Column(name = "variable")
    private String variable;
}
