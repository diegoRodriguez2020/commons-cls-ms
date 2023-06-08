package com.cls.domain.ports.updatefee.out;


import com.cls.model.dao.commons.AdditionalOperationsDao;
import com.cls.model.dto.commons.AdditionalFee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddtionalOperationsRepository {
    List<AdditionalOperationsDao> findOperationsList(List<AdditionalFee> additionalFee);
}
