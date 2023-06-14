package com.cls.model.request.updatefee;


import com.cls.model.dto.commons.AdditionalFee;
import lombok.*;

import java.util.List;

@Builder
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UpdateFeeRequest {

    private int authorizationNumber;
    private List<AdditionalFee> standardAdditional;
    private List<AdditionalFee> operativeAdditional;
}
