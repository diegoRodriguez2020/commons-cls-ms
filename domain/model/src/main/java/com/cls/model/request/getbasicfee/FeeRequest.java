package com.cls.model.request.getbasicfee;

import com.cls.model.dto.basicfee.BasicFee;
import com.cls.model.dto.commons.AdditionalFee;
import lombok.*;

import java.util.List;

@Builder
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FeeRequest {

    private int authorizationNumber;
    private BasicFee basicFee;
    private List<AdditionalFee> standardAdditional;
    private List<AdditionalFee> operativeAdditional;
}
