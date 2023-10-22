package com.rudy.ryanto.core.audit.listener;

import com.rudy.ryanto.core.audit.domain.AuditData;
import com.rudy.ryanto.core.audit.entity.AuditPojo;
import com.rudy.ryanto.core.audit.repository.AuditRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;

import javax.transaction.Transactional;
import java.util.Date;

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
        AuditPojo auditPojo = null;
        try{
            AuditData auditData = (AuditData) data;
            auditPojo = doMapToPojo(auditData);
        }catch (Exception e){
            log.error("error parsing message to dto, caused : ",e.getMessage());
        }

        try {
            log.debug("store audit data , {}", auditPojo.getId());
            doSave(auditPojo);
        }catch (Exception e){
            log.error("error store audit data, caused : ", e.getMessage());
        }

    }

    private AuditPojo doMapToPojo(AuditData auditData) {
        return AuditPojo.builder()
                .amount(auditData.getAmount())
                .currency(auditData.getCurrency())
                .rekPengirim(auditData.getRekPengirim())
                .rekPenerima(auditData.getRekPenerima())
                .transactionId(auditData.getTransactionId())
                .optionalDetailsData(auditData.getOptionalDetailsData())
                .stage(auditData.getStage())
                .optionalDetailsData2(auditData.getOptionalDetailsData2())
                .createBy("SYSTEM")
                .createDate(new Date())
                .build();
    }

    @Transactional
    private AuditPojo doSave(AuditPojo auditPojo) {
        return auditRepository.save(auditPojo);
    }

    @KafkaListener(topics = "audit-topic")
    @Override
    public <T> AuditPojo saveAuditWithCallBack(T data) {
        log.debug("receive messaging for transaction : {}",data);
        AuditPojo auditPojo = null;
        AuditPojo response = null;
        try{
            auditPojo = (AuditPojo) data;
        }catch (Exception e){
            log.error("error parsing message to dto, caused : ",e.getMessage());
        }
        try {
            log.debug("store audit data , {}", auditPojo.getId());
            response = doSave(auditPojo);
        }catch (Exception e){
            log.error("error store audit data, caused : ", e.getMessage());
        }
        return response;
    }
}
