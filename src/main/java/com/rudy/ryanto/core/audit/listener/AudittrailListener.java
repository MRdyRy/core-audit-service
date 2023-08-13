package com.rudy.ryanto.core.audit.listener;

import com.rudy.ryanto.core.audit.domain.AuditData;
import org.springframework.kafka.annotation.KafkaListener;

public interface AudittrailListener {

    <T> void saveAudit(T data);
    <T> AuditData saveAuditWithCallBack(T data);

}
