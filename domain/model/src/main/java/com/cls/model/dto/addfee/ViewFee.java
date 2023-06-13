package com.cls.model.dto.addfee;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ViewFee {

    private Integer serviceId;
    private String serviceName;
    private Integer branchCode;
    private Integer productCode;
    private Integer causeCode;
    private Integer serviceCode;
    private Integer cityId;
    private Integer cityCode;
    private Integer originDestinationId;
    private String originDestinationCode;
    private Integer feeId;
    private BigDecimal feePrice;
    private String cityName;
    private String originDestinationName;
    private Integer feePriceXKm;
}
