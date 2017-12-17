package com.company.carservice.core;

import com.google.common.base.Strings;
import com.haulmont.cuba.core.*;
import com.haulmont.cuba.core.app.EmailService;
import com.haulmont.cuba.core.global.EmailInfo;
import com.haulmont.cuba.core.global.Scripting;
import com.haulmont.cuba.core.global.TimeSource;
import com.haulmont.cuba.security.app.Authenticated;
import com.haulmont.cuba.security.app.Authentication;
import groovy.lang.Binding;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.*;

/**
 * Created by pechen on 17.12.2017.
 */
@Component("carservice_EmployeeMBean")
public class EmployeeWorker implements IEmployeeWorkerMBean {

    @Inject
    private TimeSource timeSource;

    @Inject
    private Persistence persistence;

    @Inject
    private Scripting scripting;

    @Inject
    private EmailSenderConfig emailSenderConfig;

    @Inject
    protected EmailService emailService;

    @Authenticated
    @Override
    public String sendGreetings() {
        List<String> resipients = new ArrayList<>();
        List list;
        try (Transaction tx = persistence.createTransaction()) {
            Query query = persistence.getEntityManager().createNativeQuery(
                    "select first_name, last_name, email, date_part('year', age(date_birth)) from carservice_employee\n" +
                            "where EXTRACT(day from date_birth) = EXTRACT(day FROM CURRENT_DATE) and\n" +
                            "EXTRACT(month from date_birth) = EXTRACT(month FROM CURRENT_DATE)");
            list = query.getResultList();
            tx.commit();
        }
        for (Iterator it = list.iterator(); it.hasNext(); ) {
                Object[] row = (Object[]) it.next();
                String firstName = (String) row[0];
                String lastName = (String) row[1];
                String email = (String) row[2];
                String year = Double.toString((Double) row[3]);


                Binding binding = new Binding();
                binding.setVariable("firstName", firstName);
                binding.setVariable("lastName", lastName);
                binding.setVariable("year", year);
                String mail = scripting.runGroovyScript("com/company/carservice/EmployeeMailGenerate.groovy", binding).toString();

                sendByEmail(email, mail);
                resipients.add(email);
            }

            return "grret has sended to: " + Arrays.toString(resipients.toArray());
    }

    private void sendByEmail(String email, String mail) {
        EmailInfo emailInfo = new EmailInfo(
                email,
                "Поздравление",
                emailSenderConfig.getEmailSender(),
                mail
        );
        emailService.sendEmailAsync(emailInfo);
    }
}
