package com.hendisantika.springboothibernate.config;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-hibernate
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-01-11
 * Time: 05:43
 * To change this template use File | Settings | File Templates.
 */
@Configuration
public class HibernateJacksonConfig {

    @Bean
    public Module hibernateModule() {
        return new Hibernate5Module();
    }
}