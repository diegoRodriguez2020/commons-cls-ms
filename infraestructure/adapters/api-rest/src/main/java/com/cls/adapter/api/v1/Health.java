package com.cls.adapter.api.v1;

import com.bolivar.error.handling.model.ExceptionModel;
import com.cls.model.response.addfee.AddFeeResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/health")
@Tag(name = "Health", description = "Contiene operaciones para validar el estado del microservicio")
public class Health {
    @GetMapping(path = "/ready",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "Valida la disponibilidad del microservicio",
            summary = "Valida si el microservicio está listo o no para procesar solicitudes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se muestra cuando ha ocurrido una operación exitosa", content = @Content(schema = @Schema(implementation = AddFeeResponse.class))),
            @ApiResponse(responseCode = "500", description = "Se muestra cuando ha ocurrido un error relacionado a infraestructura ", content = @Content(schema = @Schema(implementation = ExceptionModel.class)))
    })
    public ResponseEntity<?> health() {
        return new ResponseEntity<>(
                "Health ok",
                HttpStatus.OK
        );
    }
}
