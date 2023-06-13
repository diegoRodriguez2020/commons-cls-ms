package com.cls.model.entity.addfee;

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
@Table(name="view_fee")
public class ViewFeeEntity {
    @Id()
    @Column(name = "service_id")
    private Integer serviceId;
    @Column(name = "service_name")
    private String serviceName;
    @Column(name = "branch_code")
    private Integer branchCode;
    @Column(name = "product_code")
    private Integer productCode;
    @Column(name = "cause_code")
    private Integer causeCode;
    @Column(name = "service_code")
    private Integer serviceCode;
    @Column(name = "city_id")
    private Integer cityId;
    @Column(name = "city_code")
    private Integer cityCode;
    @Column(name = "origin_destination_id")
    private Integer originDestinationId;
    @Column(name = "origin_destination_code")
    private String originDestinationCode;
    @Column(name = "fee_id")
    private Integer feeId;
    @Column(name = "fee_price")
    private BigDecimal feePrice;
    @Column(name = "city_name")
    private String cityName;
    @Column(name = "origin_destination_name")
    private String originDestinationName;
    @Column(name = "fee_pricexkm")
    private Integer feePriceXKm;
}
