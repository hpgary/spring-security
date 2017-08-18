package com.permission.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

/**
 * Created by Administrator on 2017/3/8.
 */
@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private SecurityUserService securityUserService;
    @Autowired
    private MySecurityMetadataSource mySecurityMetadataSource;
    @Autowired
    private MyAccessDecisionManager myAccessDecisionManager;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	
    	http.authorizeRequests().anyRequest().authenticated().and().formLogin() ;
    	http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()) ;
    	
        //这里的定义为任何请求都要拦截，经过自定义的ObjectPostProcessor
        http.authorizeRequests().anyRequest().authenticated().withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
            public <O extends FilterSecurityInterceptor> O postProcess(O fsi) {
                fsi.setSecurityMetadataSource(mySecurityMetadataSource);
                fsi.setAccessDecisionManager(myAccessDecisionManager);
                return fsi;
            }
        });
        
        http.csrf().csrfTokenRepository( CookieCsrfTokenRepository.withHttpOnlyFalse() ) ;
    }

    @Bean(name = "authenticationProvider")
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(securityUserService);
        return daoAuthenticationProvider;
    }
}
