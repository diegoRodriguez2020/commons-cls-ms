package com.cls.model.dto.commons;

import com.cls.model.request.addfee.AddFeeRequest;
import com.cls.model.request.updatefee.UpdateFeeRequest;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class LogsRequest {
    AddFeeRequest addFeeRequest;

    UpdateFeeRequest updateFeeRequest;
}
