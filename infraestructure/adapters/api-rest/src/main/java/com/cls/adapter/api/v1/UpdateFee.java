package com.cls.adapter.api.v1;

import com.cls.domain.ports.updatefee.in.UpdateFeeManagement;
import com.cls.model.request.updatefee.UpdateFeeRequest;
import com.cls.model.response.addfee.AddFeeResponse;
import com.cls.model.response.updatefee.UpdateFeeResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Actualizar tarifa", description = "Contiene operaciones para actualizar un registro existente en la tabla fee_detail")
public class UpdateFee {
   private UpdateFeeManagement updateFeeManagement;

    public UpdateFee(UpdateFeeManagement updateFeeManagement) {
        this.updateFeeManagement = updateFeeManagement;
    }
    @PutMapping(path = "/tarifa", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "Servicio que actualiza un registro en la tabla fee_detail de acuerdo a los parámetros correspondientes al objeto UpdateFeeRequest",
            summary = "Consulta un registro existente en la tabla fee_detail, calcula el valor de los servicios adicionales y se lo agrega al valor de tarifa existente, posteriormente actualiza el registro en la tabla")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se muestra cuando ha ocurrido una operación exitosa", content = @Content(schema = @Schema(implementation = UpdateFeeRequest.class))),
            @ApiResponse(responseCode = "400", description = "Se muestra cuando ha ocurrido un error relacionado a negocio", content = @Content(schema = @Schema(implementation = AddFeeResponse.class))),
            @ApiResponse(responseCode = "500", description = "Se muestra cuando ha ocurrido un error relacionado a infraestructura ", content = @Content(schema = @Schema(implementation = AddFeeResponse.class)))
    })
    public ResponseEntity<UpdateFeeResponse> getFeeUpdated(
            @Valid @RequestBody UpdateFeeRequest updateFeeRequest) {
        return ResponseEntity.ok(updateFeeManagement.updateFee(updateFeeRequest));
    }
}
