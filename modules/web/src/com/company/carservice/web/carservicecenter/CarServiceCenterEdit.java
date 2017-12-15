package com.company.carservice.web.carservicecenter;

import com.company.carservice.service.CityService;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.company.carservice.entity.CarServiceCenter;
import com.haulmont.cuba.gui.components.GroupBoxLayout;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.haulmont.cuba.gui.data.impl.ValueCollectionDatasourceImpl;

import javax.inject.Inject;
import java.util.Map;

public class CarServiceCenterEdit extends AbstractEditor<CarServiceCenter> {

    @Inject
    private CityService cityService;

    @Inject
    GroupBoxLayout customerBox;

    @Inject
    CollectionDatasource customerDs;

    @Override
    protected void initNewItem(CarServiceCenter item) {
        item.setCity(cityService.getDefaultCity());
    }

    @Override
    public void init(Map<String, Object> params) {
        customerDs.addCollectionChangeListener(event -> {
            customerBox.setCaption("Customers (" + String.valueOf(customerDs.getItemIds().size()) + ")");
        });
    }
}