package com.grace.expense.repository;

import com.grace.expense.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Grace Xu on 8/23/17.
 */
@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
