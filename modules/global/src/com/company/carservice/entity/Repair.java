package com.company.carservice.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import com.haulmont.cuba.core.entity.StandardEntity;

@Table(name = "CARSERVICE_REPAIR")
@Entity(name = "carservice$Repair")
public class Repair extends StandardEntity {
    private static final long serialVersionUID = -3769674322649686549L;

    @Lob
    @Column(name = "DESCRIPTION", nullable = false)
    protected String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CENTER_ID")
    protected CarServiceCenter center;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMPLOYEE_ID")
    protected Employee employee;

    public void setCenter(CarServiceCenter center) {
        this.center = center;
    }

    public CarServiceCenter getCenter() {
        return center;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }


}