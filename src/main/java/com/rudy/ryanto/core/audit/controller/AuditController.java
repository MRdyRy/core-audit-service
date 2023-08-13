package com.rudy.ryanto.core.audit.controller;

import com.rudy.ryanto.core.audit.domain.AuditData;
import com.rudy.ryanto.core.audit.domain.AuditReq;
import com.rudy.ryanto.core.audit.services.AuditService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/audit")
@Slf4j
public class AuditController {

    @Autowired
    private AuditService auditService;

    @ResponseBody
    @GetMapping("/filterByUserIdAndDate")
    public List<AuditData> doSearchWithFilterUserIdAndDate(@RequestBody AuditReq auditReq, HttpServletRequest httpServletRequest) {
        log.info("doSearchWithFilterUserIdAndDate : {}", auditReq);
        String browser = httpServletRequest.getHeader("User-Agent");
        return auditService.searchAudit(auditReq, browser);
    }
}
