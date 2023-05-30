package com.bolivar.commons.obtenertarifas.services;

import com.bolivar.commons.obtenertarifas.dao.ObtenerTarifasDao;
import com.bolivar.commons.obtenertarifas.models.ObtenerTarifasRequest;

import java.util.List;

/**
 * <h3>This interface is an abstraction of methods for store files in a folder</h3>
 *
 * @author <a href='mailto:diego.rodriguez@insoftar.com'>Diego H. Rodriguez G.</a>
 * @version 1.0.0
 * @since 01/09/2022
 */
public interface ObtenerTarifasService {
    /**
     * method to store files in s3
     *
     * @param requestModel String contains the data of the file to be stored
     * @return a ResponseEntity with the request response
     */
    List<ObtenerTarifasDao> obtenerListadoTarifas(ObtenerTarifasRequest requestModel);
}
