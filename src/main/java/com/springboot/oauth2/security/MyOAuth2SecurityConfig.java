package com.springboot.oauth2.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.approval.ApprovalStore;
import org.springframework.security.oauth2.provider.approval.TokenApprovalStore;
import org.springframework.security.oauth2.provider.approval.TokenStoreUserApprovalHandler;
import org.springframework.security.oauth2.provider.request.DefaultOAuth2RequestFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

@Configuration
@EnableWebSecurity
public class MyOAuth2SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private ClientDetailsService clientDetailsService;

	@Autowired
	public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println("MyOAuth2SecurityConfig ::::::::::: globalUserDetails() :: ");
		auth.inMemoryAuthentication().withUser("bill").password("abc123").roles("ADMIN").and().withUser("bob")
				.password("abc123").roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("MyOAuth2SecurityConfig ::::::::::: configure() :: ");
		http.csrf().disable().anonymous().disable().authorizeRequests().antMatchers("/oauth/token").permitAll();
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		System.out.println("MyOAuth2SecurityConfig ::::::::::: authenticationManagerBean() :: ");
		return super.authenticationManagerBean();
	}

	@Bean
	public TokenStore tokenStore() {
		System.out.println("MyOAuth2SecurityConfig ::::::::::: tokenStore() :: ");
		return new InMemoryTokenStore();
	}

	@Bean
	@Autowired
	public TokenStoreUserApprovalHandler userApprovalHandler(TokenStore tokenStore) {
		System.out.println("MyOAuth2SecurityConfig ::::::::::: userApprovalHandler() :: ");
		TokenStoreUserApprovalHandler handler = new TokenStoreUserApprovalHandler();
		handler.setTokenStore(tokenStore);
		handler.setRequestFactory(new DefaultOAuth2RequestFactory(clientDetailsService));
		handler.setClientDetailsService(clientDetailsService);
		return handler;
	}

	@Bean
	@Autowired
	public ApprovalStore approvalStore(TokenStore tokenStore) throws Exception {
		System.out.println("MyOAuth2SecurityConfig ::::::::::: approvalStore() :: ");
		TokenApprovalStore store = new TokenApprovalStore();
		store.setTokenStore(tokenStore);
		return store;
	}

}
