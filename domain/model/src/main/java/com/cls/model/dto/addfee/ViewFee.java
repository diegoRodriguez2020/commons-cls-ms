package com.cls.model.dto.addfee;

import lombok.Data;

@Data
public class ViewFee {
    private Integer productId;
    private String productName;
    private String ramoCodigoSiab;
    private String productoCodigoSiab;
    private Integer causaCodigoSiab;
    private Integer cityId;
    private Integer ciudadCodigoSiab;
    private Integer originDestinationId;
    private Integer feeId;
    private Integer feePrice;
    private String cityName;
    private String originDestinationName;
    private Integer feePriceXKm;
}
