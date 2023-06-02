package com.bolivar.commons.actualizartarifaadicionales.services;

import com.bolivar.commons.actualizartarifaadicionales.models.ActualizarTarifaAdicionalesRequest;
import com.bolivar.commons.actualizartarifaadicionales.models.ActualizarTarifaAdicionalesResponse;

/**
 * <h3>This interface is an abstraction of methods for store files in a folder</h3>
 *
 * @author <a href='mailto:diego.rodriguez@insoftar.com'>Diego H. Rodriguez G.</a>
 * @version 1.0.0
 * @since 01/09/2022
 */
public interface ActualizarTarifaAdicionalesService {
    ActualizarTarifaAdicionalesResponse getTotalFee(ActualizarTarifaAdicionalesRequest actualizarTarifaAdicionalesRequest);

}
