package com.cls.domain.ports.addfee;

import com.cls.domain.ports.addfee.out.FeeDetailRepository;
import com.cls.model.entity.addfee.FeeDetailEntity;
import org.springframework.stereotype.Repository;

@Repository
public class FeeDetailRepositoryImpl implements FeeDetailRepository {

    @Override
    public FeeDetailEntity addFeeDetail(FeeDetailEntity feeDetailEntity) {
        return null;
    }
}
