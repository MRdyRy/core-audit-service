package com.rudy.ryanto.core.audit.listener;

import com.rudy.ryanto.core.audit.entity.AuditPojo;

public interface AudittrailListener {

    <T> void saveAudit(T data);
    <T> AuditPojo saveAuditWithCallBack(T data);

}
