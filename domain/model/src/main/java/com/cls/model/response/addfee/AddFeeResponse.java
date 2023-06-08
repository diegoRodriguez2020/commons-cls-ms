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
    private Integer basicFee;
    private Integer additionalStandardFee;
    private Integer additionalOperationsFee;
    private Integer totalFee;
}
