package cg.wbd.grandemonstration.config;

import cg.wbd.grandemonstration.service.impl.SimpleCustomerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@PropertySource("classpath:application.properties")
@EnableTransactionManagement
@EnableWebMvc
@ComponentScan("cg.wbd.grandemonstration.controller")
public class Appconfig extends WebMvcConfigurerAdapter {


    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/templates/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Bean
    public SimpleCustomerServiceImpl customerService() {
        return new SimpleCustomerServiceImpl();
    }
}
