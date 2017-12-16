package com.company.carservice.web.city;

import com.haulmont.cuba.gui.components.AbstractLookup;
import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.components.Window;
import com.haulmont.cuba.gui.components.actions.CreateAction;
import com.haulmont.cuba.gui.components.actions.EditAction;
import com.haulmont.cuba.gui.data.GroupDatasource;

import javax.inject.Inject;
import java.util.Map;

public class CityBrowse extends AbstractLookup {

    @Inject
    GroupDatasource citiesDs;

    @Inject
    GroupTable citiesTable;

    @Override
    public void init(Map<String, Object> params) {

        citiesTable.addAction(new EditAction(citiesTable) {
            @Override
            protected void afterWindowClosed(Window window) {
                citiesDs.refresh();
            }
        });

        citiesTable.addAction(new CreateAction(citiesTable) {
            @Override
            protected void afterWindowClosed(Window window) {
                citiesDs.refresh();
            }
        });
    }
}