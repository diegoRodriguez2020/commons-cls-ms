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
    @Schema(name = "branchCode", description = "Indica el código ramo", example = "150", type = "String")
    String branchCode;
    @Schema(name = "productCode", description = "Indica el código del producto", example = "1", type = "String")
    String productCode;
    @Schema(name = "causeCode", description = "Indica el código de causa", example = "70", type = "Integer")
    Integer causeCode;
    @Schema(name = "serviceCode", description = "Indica el código del servicio", example = "50", type = "Integer")
    Integer serviceCode;
    @Schema(name = "originDestinationId", description = "Indica si el recorrido es urbano (1) o interurbano (2)", example = "1", type = "Integer")
    Integer originDestinationId;
    @Schema(name = "totalKms", description = "Indica la cantidad de KMs adicionales", example = "10", type = "Integer")
    Integer totalKms;
    @Schema(name = "cityCode", description = "Indica el código de la ciudad", example = "217", type = "Integer")
    Integer cityCode;
}
