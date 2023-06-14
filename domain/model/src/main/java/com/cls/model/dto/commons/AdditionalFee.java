package com.cls.model.dto.commons;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Schema(name = "BasicFee")
public class AdditionalFee {
    @Schema(name = "code", description = "Indica el código del servicio adicional que será consultado")
    Integer code;
    @Schema(name = "amount", description = "Indica la cantidad de veces que fue usado el servicio adicional que será consultado")
    Integer amount;
}
