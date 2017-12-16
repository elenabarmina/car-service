package com.company.carservice.core;

import com.haulmont.cuba.core.sys.jmx.JmxRunAsync;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.jmx.export.annotation.ManagedOperationParameters;
import org.springframework.jmx.export.annotation.ManagedResource;

import javax.inject.Inject;

/**
 * Created by pechen on 17.12.2017.
 */
@ManagedResource()
public interface IEmployeeWorkerMBean {

    @Inject

    @ManagedOperation()
    @JmxRunAsync(timeout = 30000)
    @ManagedOperationParameters({@ManagedOperationParameter(name = "employeeId", description = "")})
    String sendGreetings(String employeeId);
}
