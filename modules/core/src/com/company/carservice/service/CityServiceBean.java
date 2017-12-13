package com.company.carservice.service;

import com.company.carservice.entity.City;
import com.haulmont.cuba.core.*;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Service(CityService.NAME)
public class CityServiceBean implements CityService {

    @Inject
    private Persistence persistence;

    @Override
    public City getDefaultCity() {
        List<City> list = new ArrayList<>();
        try (Transaction tx = persistence.createTransaction()) {
            EntityManager em = persistence.getEntityManager();
            TypedQuery<City> query = em.createNativeQuery(
                    "select * from carservice_city where carservice_city.is_default = true",
                    City.class);
            list = query.getResultList();
            tx.commit();
        }
        return list.size() > 0 ? list.get(0) : null;
    }
}