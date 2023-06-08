package com.cls.model.dto.addfee;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BasicFee {

    String ramoCodigoSiab;
    String productoCodigoSiab;
    Integer causaCodigoSiab;
    Integer originDestinationId;
    Integer codigoSiab;
    Integer totalKms;
}
