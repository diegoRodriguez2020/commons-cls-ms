package com.bolivar.commons.obtenerresultado.services;

import com.bolivar.commons.obtenerresultado.models.ObtenerResultadoRequest;
import org.springframework.stereotype.Service;

/**
 * <h3>This class contains methods for file storage in s3</h3>
 *
 * @author <a href='mailto:diego.rodriguez@insoftar.com'>Diego H. Rodriguez G.</a>
 * @version 1.0.0
 * @since 01/09/2022
 */
@Service
public class ObtenerResultadoServiceImpl implements ObtenerResultadoService {


    /**
     * <h2>log</h2>
     * log type Logger
     */
    private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger("AlmacenarArchivosAWSS3ServiceImpl");

    /**
     * Constructor method for object instantiation
     */
    public ObtenerResultadoServiceImpl() {

    }

    /**
     * @see ObtenerResultadoService#obtenerRespuesta(ObtenerResultadoRequest)
     */

    @Override
    public String obtenerRespuesta(ObtenerResultadoRequest requestModel) {
        String hola = "hola ";
        return hola.concat(requestModel.getVar());
    }
}
