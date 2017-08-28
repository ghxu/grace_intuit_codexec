package com.grace.expense.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * Created by Grace Xu on 8/23/17.
 */
@Entity
@Table(name="line_item")
public class LineItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    @NotNull(message = "error.lineitem.description.notnull")
    @Size(min=1, max=256, message = "error.lineitem.description.size")
    private String description;

    @Column
    @NotNull(message = "error.lineitem.amount.notnull")
    @DecimalMin(value = "0.01", message = "error.lineitem.amount.min")
    private BigDecimal amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "invoice_id")
    @JsonIgnore // don't remove this line. otherwise it would cause infinite loop during serialization to JSON.
    private Invoice invoice;

    public LineItem() {
    }

    public LineItem(final String description, final BigDecimal amount) {
        this.description = description;
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(final Invoice invoice) {
        this.invoice = invoice;
    }
}
