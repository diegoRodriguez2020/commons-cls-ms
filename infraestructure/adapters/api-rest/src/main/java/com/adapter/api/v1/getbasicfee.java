package com.adapter.api.v1;


import com.cls.domain.ports.getbasicfee.in.ViewFeesManagement;
import com.cls.model.request.getbasicfee.FeeRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class getbasicfee {
    private ViewFeesManagement viewFeesManagement;

    /**
     * Constructor method for object instantiation
     */
    public getbasicfee(ViewFeesManagement viewFeesManagement) {
        this.viewFeesManagement = viewFeesManagement;
    }

    @PostMapping (path = "/tarifabasicas", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getFeeView(@RequestBody @Valid FeeRequest request) {
        //crear model request
        return ResponseEntity.ok(viewFeesManagement.getFee(request));
    }
}
