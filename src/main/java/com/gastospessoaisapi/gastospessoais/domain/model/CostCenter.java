package com.gastospessoaisapi.gastospessoais.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "costcenter")
public class CostCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCostCenter")
    private Long id;

    @Column(nullable = false)
    private String description;

    @Column(columnDefinition = "TEXT")
    private String observation;

    @ManyToOne
    @JoinColumn(name = "idUserAccount", nullable = false)
    private UserAccount userAccount;

//    @ManyToMany(mappedBy = "costcenter")
//    @JsonBackReference
//    private List<FinancialTitle> titles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

//    public List<FinancialTitle> getTitles() {
//        return titles;
//    }

//    public void setTitles(List<FinancialTitle> titles) {
//        this.titles = titles;
//    }
}
