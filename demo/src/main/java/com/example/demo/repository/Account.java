package com.example.demo.repository;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Oliver Gierke
 */
@Entity
public class Account {

    @Id @GeneratedValue(strategy = GenerationType.AUTO) private Long id;

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    @ManyToOne private Customer customer;

    @Temporal(TemporalType.TIMESTAMP) private LocalDate expiryDate;

    public Long getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }
}