package com.company.carservice.web.carservicecenter;

import com.company.carservice.entity.CarServiceCenter;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.LoadContext;
import com.haulmont.cuba.gui.components.AbstractLookup;
import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.components.actions.CreateAction;
import com.haulmont.cuba.security.global.UserSession;

import javax.inject.Inject;
import java.util.Map;

public class CarServiceCenterBrowse extends AbstractLookup {

    @Inject
    GroupTable carServiceCentersTable;

    @Inject
    DataManager dataManager;

    @Inject
    UserSession userSession;

    @Override
    public void init(Map<String, Object> params) {
        carServiceCentersTable.addAction(new CreateAction(carServiceCentersTable) {
            @Override
            protected void afterCommit(Entity entity) {
                super.afterCommit(entity);
                CarServiceCenter center = (CarServiceCenter) entity;
                center.setCreator(userSession.getUser());

                dataManager.commit(center);
            }
        });
    }

}