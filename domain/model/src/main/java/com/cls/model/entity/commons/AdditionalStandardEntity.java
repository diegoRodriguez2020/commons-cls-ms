package com.cls.model.entity.commons;

import lombok.Data;
import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Immutable
@Table(name="additional_standard")
public class AdditionalStandardEntity {
    @Id()
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private Integer price;
    @Column(name = "operation_id")
    private Integer operationId;
    @Column(name = "variable")
    private String variable;
}
