package com.company.carservice.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import javax.validation.constraints.NotNull;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;
import java.util.List;
import javax.persistence.OneToMany;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import com.haulmont.cuba.security.entity.User;

@NamePattern("%s|name")
@Table(name = "CARSERVICE_CAR_SERVICE_CENTER")
@Entity(name = "carservice$CarServiceCenter")
public class CarServiceCenter extends StandardEntity {
    private static final long serialVersionUID = -1579435088495901774L;

    @Column(name = "NAME", nullable = false, length = 100)
    protected String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CREATOR_ID")
    protected User creator;

    @JoinTable(name = "CARSERVICE_CAR_SERVICE_CENTER_CUSTOMER_LINK",
        joinColumns = @JoinColumn(name = "CAR_SERVICE_CENTER_ID"),
        inverseJoinColumns = @JoinColumn(name = "CUSTOMER_ID"))
    @ManyToMany
    protected List<Customer> customer;

    @Composition
    @OnDelete(DeletePolicy.DENY)
    @OneToMany(mappedBy = "center")
    protected List<Employee> employesList;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CITY_ID")
    protected City city;

    @Column(name = "PHONE", nullable = false, length = 15)
    protected String phone;

    @Column(name = "ADDRESS", nullable = false)
    protected String address;

    @Composition
    @OneToMany(mappedBy = "center")
    protected List<Repair> repair;

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public User getCreator() {
        return creator;
    }


    public void setRepair(List<Repair> repair) {
        this.repair = repair;
    }

    public List<Repair> getRepair() {
        return repair;
    }


    public void setCustomer(List<Customer> customer) {
        this.customer = customer;
    }

    public List<Customer> getCustomer() {
        return customer;
    }


    public void setEmployesList(List<Employee> employesList) {
        this.employesList = employesList;
    }

    public List<Employee> getEmployesList() {
        return employesList;
    }


    public void setCity(City city) {
        this.city = city;
    }

    public City getCity() {
        return city;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }


}