package org.example.lifesafe.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.example.lifesafe.model.enums.InsuranceType;

@Entity
@Table(name = "health_insurances")
public class Health  extends Insurance{

    @Column(nullable = false)
    private int age;

    @Column(name="health_state", nullable = false)
    private String healthState;

    @Column(name="medical_coverage_type", nullable = false)
    private String medicalCoverageType;

    public Health(){}

    public Health(double quoteAmount, InsuranceType type, int age, String healthState, String medicalCoverageType){
        super(quoteAmount,type);
        this.age=age;
        this.healthState=healthState;
        this.medicalCoverageType = medicalCoverageType;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHealthState() {
        return healthState;
    }

    public void setHealthState(String healthState) {
        this.healthState = healthState;
    }

    public String getMedicalCoverageType() {
        return medicalCoverageType;
    }

    public void setMedicalCoverageType(String medicalCoverageType) {
        this.medicalCoverageType = medicalCoverageType;
    }
}