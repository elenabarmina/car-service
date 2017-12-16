package com.company.carservice.core;

import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Query;
import com.haulmont.cuba.core.global.Scripting;
import groovy.lang.Binding;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.Iterator;
import java.util.List;

/**
 * Created by pechen on 17.12.2017.
 */
@Component("carservice_EmployeeMBean")
public class EmployeeWorker implements IEmployeeWorkerMBean {

    @Inject
    private Persistence persistence;

    @Inject
    protected Scripting scripting;

    @Override
    public String sendGreetings(String employeeId) {
        Query query = persistence.getEntityManager().createNativeQuery(
                    "select first_name, last_name, date_part('year', age(date_birth)) from carservice_employee\n" +
                            "where EXTRACT(day from date_birth) = EXTRACT(day FROM CURRENT_DATE) and\n" +
                            "EXTRACT(month from date_birth) = EXTRACT(month FROM CURRENT_DATE)");
            List list = query.getResultList();
            for (Iterator it = list.iterator(); it.hasNext(); ) {
                Object[] row = (Object[]) it.next();
                String firstName = (String) row[0];
                String lastName = (String) row[1];
                String year = (String) row[2];

                Binding binding = new Binding();
                binding.setVariable("firstName", firstName);
                binding.setVariable("lastName", lastName);
                binding.setVariable("year", year);
                String template = scripting.runGroovyScript("com/abc/sales/CalculatePrice.groovy", binding);


            }





            return "Done";
    }
}
