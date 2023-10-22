package com.rudy.ryanto.core.audit.entity;

import com.rudy.ryanto.core.audit.domain.ActivityLog;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "AUDIT_DATA")
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuditPojo extends ActivityLog {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private Long id;

    @Column(name = "TRANSACTION_ID")
    private String transactionId;
    @Column(name = "TRANSACTION_TYPE",nullable = false)
    private String transactionType;
    @Column(name = "AMOUNT")
    private String amount;
    @Column(name = "CURRENCY")
    private String currency;
    @Column(name = "USER_ID")
    private String userId;
    @Column(name = "USER_NAME")
    private String userName;
    @Column(name = "REK_PENERIMA")
    private String rekPenerima;
    @Column(name = "REK_PENGIRIM")
    private String rekPengirim;
    @Column(name = "TRANSACTION_DATE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transactionDateTime;

    @Column(name = "OPTIONAL_DETAIL_DATA")
    private String optionalDetailsData;
    @Column(name = "OPTIONAL_DETAIL_DATA2")
    private String optionalDetailsData2;
    @Column(name = "STAGE")
    private String stage;
    @Column(name = "FLOW_NAME")
    private String flowName;

}
