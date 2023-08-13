package com.rudy.ryanto.core.audit.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ActivityLog {
    @Column
    private String createBy;
    @Column
    private String updateBy;
    @Column
    private String activityDetail;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
}
