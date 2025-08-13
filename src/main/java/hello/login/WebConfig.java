package hello.login;

import hello.login.web.filter.LogFilter;
import hello.login.web.filter.LoginCheckFilter;
import jakarta.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

    /**
     * 필터 등록
    */
    @Bean
    public FilterRegistrationBean logFilter() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new LogFilter());
        filterRegistrationBean.setOrder(1);     // 순서
        filterRegistrationBean.addUrlPatterns("/*");    // 적용할 URL 패턴

        return filterRegistrationBean;
    }


    @Bean
    public FilterRegistrationBean loginCheckFilter() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new LoginCheckFilter());
        filterRegistrationBean.setOrder(2);     // 순서
        filterRegistrationBean.addUrlPatterns("/*");    // 적용할 URL 패턴

        return filterRegistrationBean;
    }
}
