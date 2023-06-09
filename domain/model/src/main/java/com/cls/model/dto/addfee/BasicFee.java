package com.cls.model.dto.addfee;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BasicFee {
    String branchCode;
    String productCode;
    Integer causeCode;
    Integer serviceCode;
    Integer originDestinationId;
    Integer totalKms;
    Integer cityCode;
}
