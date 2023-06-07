package com.adapter.api.v1;


import com.cls.domain.ports.getbasicfee.in.ViewFeesManagement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(path = "/tarifabasicas")
    public ResponseEntity<?> getFeeView(
            @RequestParam String ramoCodigoSiab,
            @RequestParam String productoCodigoSiab,
            @RequestParam Integer causaCodigoSiab,
            @RequestParam Integer originDestinationId,
            @RequestParam Integer codigoSiab,
            @RequestParam Integer totalKms) {
        //crear model request
        return ResponseEntity.ok(viewFeesManagement.getFee(ramoCodigoSiab, productoCodigoSiab, causaCodigoSiab, originDestinationId, codigoSiab, totalKms));
    }
}
