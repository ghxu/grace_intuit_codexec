package com.grace.expense.model;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * Created by Grace Xu on 8/23/17.
 */
@Entity
@Table(name="invoice")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    @NotNull(message = "error.invoice.name.notnull")
    @Size(min=1, max=256, message = "error.invoice.name.size")
    private String name;

    // Note:
    // in the real world, a regular expression pattern is a better validation option
    @Column
    @NotNull(message = "error.invoice.email.notnull")
    @Size(min=1, max=256, message = "error.invoice.email.size")
    private String email;

    // Note:
    // I've pondered about this for quite some time, the @Future constraint
    // excludes the past due case.
    @Column
    @NotNull(message = "error.invoice.duedate.notnull")
    @Future(message = "error.invoice.duedate.future")
    private Date dueDate;

    @OneToMany(
            mappedBy = "invoice",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Collection<LineItem> lineItems;

    public Invoice() {
        this.lineItems = new ArrayList();
    }

    public Invoice(final String name, final String email) {
        this.name = name;
        this.email = email;
        this.lineItems = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Collection<LineItem> getLineItems() {
        return lineItems;
    }

    public void addLineItem(final LineItem lineItem) {
        lineItem.setInvoice(this);
        lineItems.add(lineItem);
    }
}
