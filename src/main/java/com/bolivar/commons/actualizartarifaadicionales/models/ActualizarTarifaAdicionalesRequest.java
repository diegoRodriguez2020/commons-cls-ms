package com.bolivar.commons.actualizartarifaadicionales.models;

import com.bolivar.commons.actualizartarifaadicionales.dto.TarifaAdicional;
import lombok.*;

import java.util.List;

@Builder
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ActualizarTarifaAdicionalesRequest {

    private Integer feeId;
    private List<TarifaAdicional> standardAdditional;
    private List<TarifaAdicional> operativeAdditional;
}