package com.cls.domain.ports.updatefee.out;


import com.cls.model.entity.commons.AdditionalOperationEntity;
import com.cls.model.dto.commons.AdditionalFee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddtionalOperationsRepository {
    List<AdditionalOperationEntity> findOperationsList(List<AdditionalFee> additionalFee);
}
