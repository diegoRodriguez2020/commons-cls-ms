package com.cls.model.response.addfee;

import lombok.*;

@Builder
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AddFeeResponse {

    private int authorizationNumber;
    private String basicFee;
    private String additionalStandardFee;
    private String additionalOperationsFee;
    private String totalFee;
}
