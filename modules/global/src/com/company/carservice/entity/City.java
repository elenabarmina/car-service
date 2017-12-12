package com.company.carservice.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@NamePattern("%s|name")
@Table(name = "CARSERVICE_CITY")
@Entity(name = "carservice$City")
public class City extends StandardEntity {
    private static final long serialVersionUID = 976111835622871552L;

    @NotNull
    @Column(name = "NAME", nullable = false, length = 100)
    protected String name;

    @Column(name = "PHONE_CODE", nullable = false, length = 5)
    protected String phone_code;


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPhone_code(String phone_code) {
        this.phone_code = phone_code;
    }

    public String getPhone_code() {
        return phone_code;
    }


}