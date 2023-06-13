package com.cls.model.dto.addfee;

import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class FeeDetail {

    private Integer id;
    private Integer authorizationNumber;
    private Integer feeId;
    private BigDecimal feeBasicPrice;
    private BigDecimal feeAdditionalPrice;
    private BigDecimal feeTotal;
    private String feeLog;
    private Date createdAt;
    private Date updatedAt;

}
