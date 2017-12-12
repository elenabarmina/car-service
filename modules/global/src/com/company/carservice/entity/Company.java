package com.company.carservice.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;

@Table(name = "CARSERVICE_COMPANY")
@Entity(name = "carservice$Company")
@PrimaryKeyJoinColumn(name="ID", referencedColumnName="ID")
public class Company extends Customer {
    private static final long serialVersionUID = 2939417081326575348L;

    @Column(name = "INN", nullable = false, length = 100)
    protected String inn;

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getInn() {
        return inn;
    }


}