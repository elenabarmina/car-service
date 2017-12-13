package com.company.carservice.service;

import org.springframework.stereotype.Component;
import com.haulmont.cuba.core.listener.BeforeInsertEntityListener;
import com.haulmont.cuba.core.EntityManager;
import com.company.carservice.entity.City;
import com.haulmont.cuba.core.listener.BeforeUpdateEntityListener;

@Component("carservice_CitySetDefaultListener")
public class CitySetDefaultListener implements BeforeInsertEntityListener<City>, BeforeUpdateEntityListener<City> {


    @Override
    public void onBeforeInsert(City entity, EntityManager entityManager) {

    }


    @Override
    public void onBeforeUpdate(City entity, EntityManager entityManager) {

    }


}