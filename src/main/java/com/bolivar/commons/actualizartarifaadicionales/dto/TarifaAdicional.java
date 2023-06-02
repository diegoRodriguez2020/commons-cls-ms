package com.bolivar.commons.actualizartarifaadicionales.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TarifaAdicional {

    String code;
    String amount;
    Integer value;
}
