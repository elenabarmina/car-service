package com.company.carservice.core;

import com.haulmont.cuba.core.config.Config;
import com.haulmont.cuba.core.config.Property;
import com.haulmont.cuba.core.config.Source;
import com.haulmont.cuba.core.config.SourceType;
import com.haulmont.cuba.core.config.defaults.Default;

/**
 * Created by pechen on 17.12.2017.
 */
@Source(type = SourceType.DATABASE)
public interface EmailSenderConfig extends Config {
    @Property("carservice.emailSender")
    @Default("elenabarmina@yandex.ru")
    String getEmailSender();


    void setEmailSender(String emailSender);
}
