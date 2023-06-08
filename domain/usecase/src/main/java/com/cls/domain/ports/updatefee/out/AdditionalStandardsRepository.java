package com.cls.domain.ports.updatefee.out;


import com.cls.model.entity.commons.AdditionalStandardEntity;
import com.cls.model.dto.commons.AdditionalFee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdditionalStandardsRepository {
    List<AdditionalStandardEntity> findStandardsList(List<AdditionalFee> additionalFee);
}
