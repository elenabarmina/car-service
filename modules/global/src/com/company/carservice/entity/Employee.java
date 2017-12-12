package com.company.carservice.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@NamePattern("%s %s|firstName,lastName")
@Table(name = "CARSERVICE_EMPLOYEE")
@Entity(name = "carservice$Employee")
public class Employee extends StandardEntity {
    private static final long serialVersionUID = -712401042087780478L;

    @Column(name = "FIRST_NAME", nullable = false, length = 100)
    protected String firstName;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CENTER_ID")
    protected CarServiceCenter center;

    @Column(name = "LAST_NAME", nullable = false, length = 100)
    protected String lastName;

    @Column(name = "EMAIL", nullable = false, length = 100)
    protected String email;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_BIRTH", nullable = false)
    protected Date dateBirth;

    @Column(name = "SALARY", nullable = false)
    protected BigDecimal salary;


    public void setCenter(CarServiceCenter center) {
        this.center = center;
    }

    public CarServiceCenter getCenter() {
        return center;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public BigDecimal getSalary() {
        return salary;
    }


}