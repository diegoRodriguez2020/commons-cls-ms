package com.cls.model.dto.addfee;

import lombok.Data;
import org.hibernate.annotations.Immutable;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
public class FeeDetail {

    private Integer id;
    private Integer authorizationNumber;
    private Integer feeId;
    private Integer feeBasicPrice;
    private Integer feeAdditionalPrice;
    private Integer feeTotal;
    private String feeLog;
    private Date createdAt;
    private Date updatedAt;

}
