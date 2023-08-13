package com.rudy.ryanto.core.audit.listener;

import com.rudy.ryanto.core.audit.domain.AuditData;
import com.rudy.ryanto.core.audit.repository.AuditRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;

import javax.transaction.Transactional;

@Slf4j
public class AuditTrailListenerImpl implements AudittrailListener{

    private AuditRepository auditRepository;

    public AuditTrailListenerImpl(AuditRepository auditRepository) {
        this.auditRepository = auditRepository;
    }


    @KafkaListener(topics = "audit-topic")
    @Override
    public <T> void saveAudit(T data) {
        log.debug("receive messaging for transaction : {}",data);
        AuditData auditData = null;
        try{
            auditData = (AuditData) data;
        }catch (Exception e){
            log.error("error parsing message to dto, caused : ",e.getMessage());
        }


        try {
            log.debug("store audit data , {}",auditData.getId());
            doSave(auditData);
        }catch (Exception e){
            log.error("error store audit data, caused : ", e.getMessage());
        }

    }

    @Transactional
    private AuditData doSave(AuditData auditData) {
        return auditRepository.save(auditData);
    }

    @KafkaListener(topics = "audit-topic")
    @Override
    public <T> AuditData saveAuditWithCallBack(T data) {
        log.debug("receive messaging for transaction : {}",data);
        AuditData auditData = null;
        AuditData response = null;
        try{
            auditData = (AuditData) data;
        }catch (Exception e){
            log.error("error parsing message to dto, caused : ",e.getMessage());
        }
        try {
            log.debug("store audit data , {}",auditData.getId());
            response = doSave(auditData);
        }catch (Exception e){
            log.error("error store audit data, caused : ", e.getMessage());
        }
        return response;
    }
}
