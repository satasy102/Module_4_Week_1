package com.chanhtin.config;

import com.chanhtin.dao.BaseDAO;
import com.chanhtin.dao.CommentDAO;
import com.chanhtin.model.Comment;
import com.chanhtin.service.BaseService;
import com.chanhtin.service.CommentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@EnableTransactionManagement
@EnableWebMvc
@ComponentScan("com.chanhtin.controller")
public class Appconfig extends WebMvcConfigurerAdapter {

    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Bean
    public CommentDAO ICommentDao() {
        return new CommentDAO();
    }

    @Bean
    public BaseService<Comment> commentService() {
        return new CommentService();
    }
}
