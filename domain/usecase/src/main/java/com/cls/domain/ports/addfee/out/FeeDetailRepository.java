package com.cls.domain.ports.addfee.out;


import com.cls.model.entity.addfee.FeeDetailEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface FeeDetailRepository {

   public boolean addFeeDetail(FeeDetailEntity feeDetailEntity);

   public FeeDetailEntity findFeeDetailByAuthorizationNumber(int authorizationNumber);

   public FeeDetailEntity updateFeeDetail(FeeDetailEntity feeDetailEntity);

}
