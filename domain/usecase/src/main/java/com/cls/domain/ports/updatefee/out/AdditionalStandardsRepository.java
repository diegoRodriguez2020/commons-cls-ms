package com.cls.domain.ports.updatefee.out;


import com.cls.model.dao.commons.AdditionalStandardsDao;
import com.cls.model.dto.commons.AdditionalFee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdditionalStandardsRepository {
    List<AdditionalStandardsDao> findStandardsList(List<AdditionalFee> additionalFee);
}
