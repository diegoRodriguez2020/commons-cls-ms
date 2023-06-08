package com.cls.domain.ports.addfee.in;

import com.cls.model.request.addfee.AddFeeRequest;
import com.cls.model.response.addfee.AddFeeResponse;
import org.springframework.stereotype.Component;

@Component
public interface AddFeeManagement {

    AddFeeResponse calculateFee(AddFeeRequest addFeeRequest);

}
