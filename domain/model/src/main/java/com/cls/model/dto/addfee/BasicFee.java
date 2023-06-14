package com.cls.model.dto.addfee;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Schema(name = "BasicFee")
public class BasicFee {
    @Schema(name = "branchCode", description = "Indica el código ramo")
    String branchCode;
    @Schema(name = "productCode", description = "Indica el código del producto")
    String productCode;
    @Schema(name = "causeCode", description = "Indica el código de causa")
    Integer causeCode;
    @Schema(name = "serviceCode", description = "Indica el código del servicio")
    Integer serviceCode;
    @Schema(name = "originDestinationId", description = "Indica si el recorrido es urbano (1) o interurbano (2)")
    Integer originDestinationId;
    @Schema(name = "totalKms", description = "Indica la cantidad de KMs adicionales")
    Integer totalKms;
    @Schema(name = "cityCode", description = "Indica el código de la ciudad")
    Integer cityCode;
}
