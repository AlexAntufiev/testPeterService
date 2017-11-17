package com.example.testtask.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import java.util.Arrays;

@Deprecated
public class Config {
    @Bean
    public Jaxb2RootElementHttpMessageConverter xmlMessageConverter() {
        return new Jaxb2RootElementHttpMessageConverter();
    }

    @Bean
    public MappingJackson2HttpMessageConverter jsonMessageConverter() {
        return new MappingJackson2HttpMessageConverter();
    }

    @Bean
    public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
        RequestMappingHandlerAdapter bean = new RequestMappingHandlerAdapter();
        bean.setMessageConverters(Arrays.asList(jsonMessageConverter(), xmlMessageConverter()));
        return bean;
    }
}
