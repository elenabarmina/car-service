package com.company.carservice.core;

import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.app.EmailService;
import com.haulmont.cuba.core.global.Scripting;
import com.haulmont.cuba.core.global.TimeSource;
import com.haulmont.cuba.core.sys.jmx.JmxRunAsync;
import com.haulmont.cuba.security.app.Authentication;
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



    @ManagedOperation()
    @JmxRunAsync(timeout = 30000)
    String sendGreetings();
}
