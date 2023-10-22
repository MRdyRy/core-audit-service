package com.rudy.ryanto.core.audit.services;

import com.rudy.ryanto.core.audit.entity.AuditPojo;
import com.rudy.ryanto.core.audit.domain.AuditReq;
import com.rudy.ryanto.core.audit.repository.AuditRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AuditService {

    @Autowired
    private AuditRepository auditRepository;

    public List<AuditPojo> searchAudit(AuditReq auditReq, String browser){
        log.info("search data audit with parameter : {}",auditReq);
        List<AuditPojo> resultList = null;
        try {
            resultList = auditRepository.findByUserIdAndTransactionDate(auditReq.getUserId(),auditReq.getTransactionDate());
        }catch (Exception e){
            log.error("error search data audit, caused :  ",e.getMessage());
        }
        return resultList;
    }
}
