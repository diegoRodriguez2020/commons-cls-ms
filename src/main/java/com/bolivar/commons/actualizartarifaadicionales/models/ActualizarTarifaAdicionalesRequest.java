package com.bolivar.commons.actualizartarifaadicionales.models;

import com.bolivar.commons.actualizartarifaadicionales.dto.TarifaAdicional;
import lombok.*;

import java.util.List;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ActualizarTarifaAdicionalesRequest {

    private String basicFee;
    private List<TarifaAdicional> standardAdditional;
    private List<TarifaAdicional> operationalStandard;
}
