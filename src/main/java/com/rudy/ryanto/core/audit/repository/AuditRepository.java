package com.rudy.ryanto.core.audit.repository;

import com.rudy.ryanto.core.audit.entity.AuditPojo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AuditRepository extends JpaRepository<AuditPojo,Long> {

    List<AuditPojo> findByUserIdAndTransactionDate(String userId, Date transactionDate);
}
