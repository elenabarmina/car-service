package com.company.carservice.web.repair;

import com.company.carservice.entity.CarServiceCenter;
import com.company.carservice.entity.Employee;
import com.haulmont.cuba.gui.components.*;
import com.company.carservice.entity.Repair;
import com.haulmont.cuba.gui.data.CollectionDatasource;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Map;
import java.util.UUID;

public class RepairEdit extends AbstractEditor<Repair> {

    @Inject
    CollectionDatasource<Employee, UUID> employeesDs;

    @Inject
    CollectionDatasource<CarServiceCenter, UUID> centersDs;

    @Named("fieldGroup.employeeField")
    Field employeeField;

    public void init(Map<String, Object> params){

        centersDs.addItemChangeListener(event -> {
            employeeField.setValue(null);
            employeesDs.refresh();
        });
    }
}