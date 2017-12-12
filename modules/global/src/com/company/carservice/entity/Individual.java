package com.company.carservice.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;

@Table(name = "CARSERVICE_INDIVIDUAL")
@Entity(name = "carservice$Individual")
@PrimaryKeyJoinColumn(name="ID", referencedColumnName="ID")
public class Individual extends Customer {
    private static final long serialVersionUID = 9107855647213292306L;

    @Column(name = "PASSPORT_NO", nullable = false, length = 20)
    protected String passportNo;

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public String getPassportNo() {
        return passportNo;
    }


}