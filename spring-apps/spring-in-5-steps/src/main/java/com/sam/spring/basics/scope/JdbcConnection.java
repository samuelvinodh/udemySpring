package com.sam.spring.basics.scope;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE,
        proxyMode = ScopedProxyMode.TARGET_CLASS) //proxyMode is mandatory if calling bean is not prototype
public class JdbcConnection {
    public JdbcConnection() {
        System.out.println("JDBC Connection Established");
    }
}
