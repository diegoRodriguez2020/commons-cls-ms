package com.cls.model.entity.addfee;

import lombok.Data;
import org.hibernate.annotations.Immutable;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name="fee_detail")
public class FeeDetailEntity {
    @Id()
    @Column(name = "id")
    private Integer id;
    @Column(name = "authorization_number")
    private Integer authorizationNumber;
    @Column(name = "fee_id")
    private Integer feeId;
    @Column(name = "fee_basic_price")
    private Integer feeBasicPrice;
    @Column(name = "fee_additional_price")
    private Integer feeAdditionalPrice;
    @Column(name = "fee_total")
    private Integer feeTotal;
    @Column(name = "fee_log")
    private String feeLog;
    @Column(name = "created_at", columnDefinition = "DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createdAt;
    @Column(name = "updated_at", columnDefinition = "DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date updatedAt;

}
