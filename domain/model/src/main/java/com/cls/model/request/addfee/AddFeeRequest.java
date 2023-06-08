package com.cls.model.request.addfee;

import com.cls.model.dto.addfee.BasicFee;
import com.cls.model.dto.commons.AdditionalFee;
import lombok.*;

import java.util.List;

@Builder
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AddFeeRequest {

    private int authorizationNumber;
    private BasicFee basicFee;
    private List<AdditionalFee> standardAdditional;
    private List<AdditionalFee> operativeAdditional;
}
