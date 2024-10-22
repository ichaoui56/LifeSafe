package org.example.lifesafe.model.entities;

import jakarta.persistence.*;
import org.example.lifesafe.model.enums.InsuranceType;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "insurances")
public abstract class Insurance {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private double quoteAmount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private InsuranceType type;

    @OneToMany(mappedBy = "insurance", cascade = CascadeType.ALL)
    private List<Devis> devisList;

    @OneToMany(mappedBy = "insurance", cascade = CascadeType.ALL)
    private List<Contract> contracts;


    public Insurance(){}

    public Insurance( double quoteAmount, InsuranceType type){
        this.quoteAmount = quoteAmount;
        this.type = type;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public double getQuoteAmount() {
        return quoteAmount;
    }

    public void setQuoteAmount(double quoteAmount) {
        this.quoteAmount = quoteAmount;
    }

    public InsuranceType getType() {
        return type;
    }

    public void setType(InsuranceType type) {
        this.type = type;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    public List<Devis> getDevisList() {
        return devisList;
    }

    public void setDevisList(List<Devis> devisList) {
        this.devisList = devisList;
    }
}
