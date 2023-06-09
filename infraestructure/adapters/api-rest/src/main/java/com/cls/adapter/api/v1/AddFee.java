package com.cls.adapter.api.v1;


import com.cls.domain.ports.addfee.in.AddFeeManagement;
import com.cls.model.request.addfee.AddFeeRequest;
import com.cls.model.response.addfee.AddFeeResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class AddFee {
    private AddFeeManagement addFeeManagement;

    /**
     * Constructor method for object instantiation
     */
    public AddFee(AddFeeManagement addFeeManagement) {
        this.addFeeManagement = addFeeManagement;
    }

    @PostMapping (path = "/tarifa", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AddFeeResponse> addFee(@RequestBody @Valid AddFeeRequest addFeeRequest) {
        return ResponseEntity.ok(addFeeManagement.calculateFee(addFeeRequest));
    }
}
