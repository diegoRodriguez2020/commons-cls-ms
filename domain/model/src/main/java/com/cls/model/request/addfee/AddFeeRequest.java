package com.cls.model.request.addfee;

import com.cls.model.dto.addfee.BasicFee;
import com.cls.model.dto.commons.AdditionalFee;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@Builder
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "AddFeeRequest")
public class AddFeeRequest {
    @Schema(name = "authorizationNumber", description = "Identificador único de la autorización", example = "5062730", type = "Integer")
    private int authorizationNumber;
    @Schema(name = "basicFee", description = "Contiene la información básica para generar la consulta de la tafifa base", example = "{}", type = "BasicFee")
    private BasicFee basicFee;
    @Schema(name = "standardAdditional", description = "Contiene la información para el cálculo de adicionales de tipo estándar", example = "[]", type = "List<AdditionalFee>")
    private List<AdditionalFee> standardAdditional;
    @Schema(name = "operativeAdditional", description = "Contiene la información para el cálculo de adicionales de tipo operacional", example = "[]", type = "List<AdditionalFee>")
    private List<AdditionalFee> operativeAdditional;
}
