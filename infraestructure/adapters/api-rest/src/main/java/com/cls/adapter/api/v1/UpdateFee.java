package com.cls.adapter.api.v1;

import com.cls.domain.ports.updatefee.in.UpdateFeeManagement;
import com.cls.model.request.updatefee.UpdateFeeRequest;
import com.cls.model.response.updatefee.UpdateFeeResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class UpdateFee {
   private UpdateFeeManagement updateFeeManagement;

    public UpdateFee(UpdateFeeManagement updateFeeManagement) {
        this.updateFeeManagement = updateFeeManagement;
    }
    @PutMapping(path = "/tarifa", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UpdateFeeResponse> getFeeUpdated(
            @Valid @RequestBody UpdateFeeRequest updateFeeRequest) {
        return ResponseEntity.ok(updateFeeManagement.updateFee(updateFeeRequest));
    }
}
