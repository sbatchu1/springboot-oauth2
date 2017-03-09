package com.springboot.oauth2.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.oauth2.provider.expression.OAuth2MethodSecurityExpressionHandler;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, proxyTargetClass = true)
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration{
	
	@Autowired
	private MyOAuth2SecurityConfig securityConfig;
	
	 @Override
	    protected MethodSecurityExpressionHandler createExpressionHandler() {
		 System.out.println("MethodSecurityConfig :::::::::::");
	        return new OAuth2MethodSecurityExpressionHandler();
	    }

}