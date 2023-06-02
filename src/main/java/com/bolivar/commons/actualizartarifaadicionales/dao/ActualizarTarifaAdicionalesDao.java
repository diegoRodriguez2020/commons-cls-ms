package com.bolivar.commons.actualizartarifaadicionales.dao;

import lombok.Data;
import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Immutable
@Table(name="view_fee_additional_standards")
public class ActualizarTarifaAdicionalesDao {
    @Id()
    @Column(name = "fee_additional_id")
    private Integer feeAdditionalId;
    @Column(name = "fee_id")
    private Integer feeId;
    @Column(name = "additional_id")
    private Integer additionalId;
    @Column(name = "additional_name")
    private String additionalName;
    @Column(name = "additional_price")
    private Integer additionalPrice;
    @Column(name = "operation_id")
    private Integer operationId;
    @Column(name = "operation_name")
    private String operationName;
    @Column(name = "additional_variable")
    private String additionalVariable;
}
