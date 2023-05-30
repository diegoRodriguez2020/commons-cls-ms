package com.bolivar.commons.obtenerresultado.services;

import com.bolivar.commons.obtenerresultado.models.ObtenerResultadoRequest;

/**
 * <h3>This interface is an abstraction of methods for store files in a folder</h3>
 *
 * @author <a href='mailto:diego.rodriguez@insoftar.com'>Diego H. Rodriguez G.</a>
 * @version 1.0.0
 * @since 01/09/2022
 */
public interface ObtenerResultadoService {
    /**
     * method to store files in s3
     *
     * @param requestModel String contains the data of the file to be stored
     * @return a ResponseEntity with the request response
     */
    String obtenerRespuesta(ObtenerResultadoRequest requestModel);
}
