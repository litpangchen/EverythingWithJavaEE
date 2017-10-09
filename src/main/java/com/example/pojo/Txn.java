package com.example.pojo;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;

import java.util.Date;

@Entity
@Table(name = "TRANSACTION")
public class Txn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="txn_id")
    private long id;

    @Column(name="txn_date")
    private Date date;

    @Column(name="txn_total")
    private double total;

    @OneToOne(mappedBy = "txn")
    @Cascade(value= CascadeType.ALL)
    private Customer customer;

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(final Date date) {
        this.date = date;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(final double total) {
        this.total = total;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(final Customer customer) {
        this.customer = customer;
    }
}
