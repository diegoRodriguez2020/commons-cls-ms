package com.cls.model.response.updatefee;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Builder
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "AddFeeRequest")
public class UpdateFeeResponse {
    @Schema(name = "authorizationNumber", description = "Identificador único de la autorización", example = "5062730", type = "Integer")
    private int authorizationNumber;
    @Schema(name = "initialFee", description = "Valor de incial de la tarifa al momentod de la creación", example = "329500.00", type = "String")
    private String initialFee;
    @Schema(name = "additionalStandardFee", description = "Valor de los adicionales estándar", example = "12000.00", type = "String")
    private String additionalStandardFee;
    @Schema(name = "additionalOperationsFee", description = "Valor de los adicionales operacionales", example = "271000.00", type = "String")
    private String additionalOperationsFee;
    @Schema(name = "totalFee", description = "Valor total de la tarifa sumado a los adicionles estándares y operacionales", example = "612500.00", type = "String")
    private String totalFee;
}
