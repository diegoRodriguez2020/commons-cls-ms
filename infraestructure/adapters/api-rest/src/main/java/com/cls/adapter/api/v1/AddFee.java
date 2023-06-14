package com.cls.adapter.api.v1;


import com.cls.domain.ports.addfee.in.AddFeeManagement;
import com.cls.model.request.addfee.AddFeeRequest;
import com.cls.model.response.addfee.AddFeeResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Crear tarifa", description = "Contiene operaciones para agregar un nuevo registro a la tabla fee_detail")
public class AddFee {
    private AddFeeManagement addFeeManagement;

    public AddFee(AddFeeManagement addFeeManagement) {
        this.addFeeManagement = addFeeManagement;
    }

    @PostMapping(path = "/tarifa", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "Servicio que crea un nuevo registro en la tabla fee_detail a partir del envío de parámetros correspondientes al objeto AddFeeRequest",
            summary = "Realiza el cáculo de la tarifa inicial del servicio y lo almacena en la tabla fee_detail")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se muestra cuando ha ocurrido una operación exitosa", content = @Content(schema = @Schema(implementation = AddFeeResponse.class))),
            @ApiResponse(responseCode = "400", description = "Se muestra cuando ha ocurrido un error relacionado a negocio", content = @Content(schema = @Schema(implementation = AddFeeResponse.class))),
            @ApiResponse(responseCode = "500", description = "Se muestra cuando ha ocurrido un error relacionado a infraestructura ", content = @Content(schema = @Schema(implementation = AddFeeResponse.class)))
    })
    public ResponseEntity<AddFeeResponse> getFeeAdded(@RequestBody @Valid AddFeeRequest addFeeRequest) {
        return ResponseEntity.ok(addFeeManagement.calculateFee(addFeeRequest));
    }
}
