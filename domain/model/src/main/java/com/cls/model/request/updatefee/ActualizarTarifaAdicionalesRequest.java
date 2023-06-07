package com.cls.model.request.updatefee;


import com.cls.model.dto.updatefee.TarifaAdicional;
import lombok.*;

import java.util.List;

@Builder
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ActualizarTarifaAdicionalesRequest {
    private String ramoCodigoSiab;
    private String productoCodigoSiab;
    private Integer causaCodigoSiab;
    private Integer originDestinationId;
    private Integer ciudadCodigoSiab;
    private Integer totalKms;
    private Integer feeId;
    private List<TarifaAdicional> standardAdditional;
    private List<TarifaAdicional> operativeAdditional;
}
