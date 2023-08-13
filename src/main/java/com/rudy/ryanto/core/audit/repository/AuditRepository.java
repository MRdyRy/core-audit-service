package com.rudy.ryanto.core.audit.repository;

import com.rudy.ryanto.core.audit.domain.AuditData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AuditRepository extends JpaRepository<AuditData,Long> {

    List<AuditData> findByUserIdAndTransactionDate(String userId, Date transactionDate);
}
