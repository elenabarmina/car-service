package com.company.carservice.web.carservicecenter;

import com.company.carservice.entity.*;
import com.company.carservice.service.CityService;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.core.global.MessageTools;
import com.haulmont.cuba.core.global.Messages;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.haulmont.cuba.gui.data.impl.ValueCollectionDatasourceImpl;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;
import javafx.scene.control.Tab;

import javax.inject.Inject;
import java.util.Map;

public class CarServiceCenterEdit extends AbstractEditor<CarServiceCenter> {

    @Inject
    private CityService cityService;

    @Inject
    GroupBoxLayout customerBox;

    @Inject
    CollectionDatasource customerDs;

    @Inject
    Table customerTable;

    @Inject
    protected ComponentsFactory componentsFactory;

    @Inject
    MessageTools messageTools;

    @Override
    protected void initNewItem(CarServiceCenter item) {
        item.setCity(cityService.getDefaultCity());
    }

    @Override
    public void init(Map<String, Object> params) {
        customerDs.addCollectionChangeListener(event -> {
            customerBox.setCaption("Customers (" + String.valueOf(customerDs.getItemIds().size()) + ")");
        });
        customerTable.addGeneratedColumn("type", new Table.PrintableColumnGenerator<Customer, String>() {

            @Override
            public String getValue(Customer item) {
                return messageTools.getEntityCaption(item.getMetaClass());
            }

            @Override
            public Component generateCell(Customer entity) {
                return new Table.PlainTextCell(messageTools.getEntityCaption(entity.getMetaClass()));
            }
        });
    }
}