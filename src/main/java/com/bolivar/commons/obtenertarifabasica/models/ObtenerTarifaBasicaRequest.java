package com.bolivar.commons.obtenertarifabasica.models;

import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ObtenerTarifaBasicaRequest {

    private String ramoCodigoSiab;
    private String productoCodigoSiab;
    private Integer causaCodigoSiab;
    private Integer originDestinationId;
    private Integer ciudadCodigoSiab;
    private Integer totalKms;
}
