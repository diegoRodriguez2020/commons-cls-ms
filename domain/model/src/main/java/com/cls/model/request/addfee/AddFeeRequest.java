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
    @Schema(name = "authorizationNumber", description = "Identificador único de la autorización")
    private int authorizationNumber;
    @Schema(name = "basicFee", description = "Contiene la información básica para generar la consulta de la tafifa base")
    private BasicFee basicFee;
    @Schema(name = "standardAdditional", description = "Contiene la información para el cálculo de adicionales de tipo estándar")
    private List<AdditionalFee> standardAdditional;
    @Schema(name = "operativeAdditional", description = "Contiene la información para el cálculo de adicionales de tipo operacional")
    private List<AdditionalFee> operativeAdditional;
}
