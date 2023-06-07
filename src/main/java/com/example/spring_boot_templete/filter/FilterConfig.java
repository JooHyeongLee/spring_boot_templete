package com.example.spring_boot_templete.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<SampleFilter> sampleFilter() {
        FilterRegistrationBean<SampleFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new SampleFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        registrationBean.setName("SecurityFilter");

        return registrationBean;
    }
}
