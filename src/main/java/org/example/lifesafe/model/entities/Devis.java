package org.example.lifesafe.model.entities;

import jakarta.persistence.*;
import org.example.lifesafe.model.enums.InsuranceType;

import java.time.LocalDate;

@Entity
public class Devis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate requestDate;

    @Column(nullable = false)
    private double calculatedQuote;

    @Column(nullable = false)
    private String parameters;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "insurance_id")
    private Insurance insurance;

    public Devis() {}

    public Devis(User user, Insurance insurance, LocalDate requestDate, double calculatedQuote, String parameters) {
        this.user = user;
        this.insurance = insurance;
        this.requestDate = requestDate;
        this.calculatedQuote = calculatedQuote;
        this.parameters = parameters;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }

    public double getCalculatedQuote() {
        return calculatedQuote;
    }

    public void setCalculatedQuote(double calculatedQuote) {
        this.calculatedQuote = calculatedQuote;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }
}