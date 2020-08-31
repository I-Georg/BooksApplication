package com.example.demo;

//import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.config.core.GrantedAuthorityDefaults;

//@EnableOAuth2Sso  
@Configuration 
@EnableGlobalMethodSecurity(prePostEnabled = true) 


public class SpringSecurityWebAppConfig extends WebSecurityConfigurerAdapter {
	
	/*@Bean  
    GrantedAuthorityDefaults grantedAuthorityDefaults() { 
        return new GrantedAuthorityDefaults(""); // Remove the ROLE_ prefix  
    }  */
	 @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

	        auth.inMemoryAuthentication()
	                .withUser("user").password("{noop}password").roles("USER")
	                .and()
	                .withUser("admin").password("{noop}password").roles("USER", "ADMIN");

	    }
	 @Override
	    protected void configure(HttpSecurity http) throws Exception {

	        http
	                //HTTP Basic authentication
	                .httpBasic()
	               
	                .and()
	                .authorizeRequests()
	                .antMatchers(HttpMethod.GET, "/**").hasRole("USER")
	              
	                .and()
	                .csrf().disable()
	                .formLogin().disable();
	    }

	/* @Override  
	  protected void configure(HttpSecurity http) throws Exception { 
		    http.antMatcher("/protected")  
            .authorizeRequests()  
            .antMatchers("/protected", "/login").permitAll()  
            .anyRequest().authenticated()  
            .and()  
            .oauth2Login();  */
	       /* http.authorizeRequests()  
	                .antMatchers("/book").permitAll()  
	                .anyRequest().authenticated()  
	                .and()  
	                .formLogin()  
	                .loginPage("/login.html")  
	                .failureUrl("/login-error.html")  
	                .permitAll();  
	               // .anyRequest().authenticated();  */
	    //}   
	    

	/*@Override  
    public void configure(HttpSecurity http) throws Exception {  
        http  
            .authorizeRequests()  
            .anyRequest().authenticated()  
            .and()  
            .httpBasic();  
    }  okta.oauth2.issuer=https://dev-886425.okta.com/oauth2/default
okta.oauth2.client-id=0oaso02frzo5NHUo14x6
okta.oauth2.client-secret=gxD0ExG6WzlIAn3sFReuoQpXABxqZzWUEo7jTQMq
user.oauth.user.username=Andrew
user.oauth.user.password=abcd
      */
 
}
