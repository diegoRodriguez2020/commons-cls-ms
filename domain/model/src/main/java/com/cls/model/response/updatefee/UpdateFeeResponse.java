package com.cls.model.response.updatefee;

import lombok.*;

@Builder
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UpdateFeeResponse {

    private int authorizationNumber;
    private String initialFee;
    private String additionalStandardFee;
    private String additionalOperationsFee;
    private String totalFee;
}
