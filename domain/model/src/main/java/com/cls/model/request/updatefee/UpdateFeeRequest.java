package com.cls.model.request.updatefee;


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
public class UpdateFeeRequest {
    @Schema(name = "authorizationNumber", description = "Identificador único de la autorización")
    private int authorizationNumber;
    @Schema(name = "standardAdditional", description = "Contiene la información para el cálculo de adicionales de tipo estándar")
    private List<AdditionalFee> standardAdditional;
    @Schema(name = "operativeAdditional", description = "Contiene la información para el cálculo de adicionales de tipo operacional")
    private List<AdditionalFee> operativeAdditional;
}
