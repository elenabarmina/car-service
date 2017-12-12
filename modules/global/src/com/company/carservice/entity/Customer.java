package com.company.carservice.entity;

import javax.persistence.*;

import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import java.util.List;

@NamePattern("%s|name")
@Table(name = "CARSERVICE_CUSTOMER")
@Entity(name = "carservice$Customer")
@Inheritance(strategy= InheritanceType.JOINED)
public class Customer extends StandardEntity {
    private static final long serialVersionUID = -4620042229111893697L;

    @Column(name = "NAME", nullable = false, length = 200)
    protected String name;

    @Column(name = "EMAIL", nullable = false, length = 100)
    protected String email;

    @Column(name = "PHONE", nullable = false, length = 50)
    protected String phone;

    @JoinTable(name = "CARSERVICE_CAR_SERVICE_CENTER_CUSTOMER_LINK",
        joinColumns = @JoinColumn(name = "CUSTOMER_ID"),
        inverseJoinColumns = @JoinColumn(name = "CAR_SERVICE_CENTER_ID"))
    @ManyToMany
    protected List<CarServiceCenter> center;

    public void setCenter(List<CarServiceCenter> center) {
        this.center = center;
    }

    public List<CarServiceCenter> getCenter() {
        return center;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }


}