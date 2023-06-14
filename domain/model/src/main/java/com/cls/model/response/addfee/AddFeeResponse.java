package com.cls.model.response.addfee;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Builder
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "AddFeeResponse")
public class AddFeeResponse {
    @Schema(name = "authorizationNumber", description = "Identificador único de la autorización")
    private int authorizationNumber;
    @Schema(name = "basicFee", description = "Valor de la tarifa sumado con el adicional de KMs adicionales")
    private String basicFee;
    @Schema(name = "additionalStandardFee", description = "Valor de los adicionales estándar")
    private String additionalStandardFee;
    @Schema(name = "additionalOperationsFee", description = "Valor de los adicionales operacionales")
    private String additionalOperationsFee;
    @Schema(name = "totalFee", description = "Valor total de la tarifa sumado a los adicionles estándares y operacionales")
    private String totalFee;
}
