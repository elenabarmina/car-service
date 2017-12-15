package com.company.carservice.web.carservicecenter;

import com.company.carservice.service.CityService;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.company.carservice.entity.CarServiceCenter;
import com.haulmont.cuba.gui.components.GroupBoxLayout;

import javax.inject.Inject;

public class CarServiceCenterEdit extends AbstractEditor<CarServiceCenter> {

    @Inject
    private CityService cityService;

    @Inject
    GroupBoxLayout customerBox;

    @Override
    protected void initNewItem(CarServiceCenter item) {
        item.setCity(cityService.getDefaultCity());
    }


}