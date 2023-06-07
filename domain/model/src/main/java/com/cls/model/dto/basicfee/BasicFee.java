package com.cls.model.dto.basicfee;

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
