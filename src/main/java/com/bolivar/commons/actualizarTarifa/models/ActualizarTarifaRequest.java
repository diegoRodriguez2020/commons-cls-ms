package com.bolivar.commons.actualizarTarifa.models;

import com.bolivar.commons.actualizarTarifa.dto.TarifaAdicional;
import lombok.*;

import java.util.List;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ActualizarTarifaRequest {

    private String basicFee;
    private List<TarifaAdicional> standardAdditional;
    private List<TarifaAdicional> operationalStandard;
}
