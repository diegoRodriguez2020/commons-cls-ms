package com.adapter.api.v1;

import com.cls.domain.ports.updatefee.in.UpdateFee;
import com.cls.model.request.updatefee.ActualizarTarifaAdicionalesRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class updateFee {
    private UpdateFee updateFee;

    /**
     * Constructor method for object instantiation
     */
    public updateFee(UpdateFee updateFee) {
        this.updateFee = updateFee;
    }
    @PostMapping(path = "/actualizartarifas", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getStandardView(
            @Valid @RequestBody ActualizarTarifaAdicionalesRequest actualizarTarifaAdicionalesRequest) {
        return ResponseEntity.ok(updateFee.getTotalFee(actualizarTarifaAdicionalesRequest));
    }
}
