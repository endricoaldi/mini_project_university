package id.co.indivara.jdt12.university.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
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
                .httpBasic()
                .and()
                .authorizeHttpRequests()
                .antMatchers(HttpMethod.GET,"/student/**").hasRole("USER")
                .antMatchers(HttpMethod.POST,"/student").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/student/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PATCH,"/student/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/student/**").hasRole("ADMIN")
                .and()
                .csrf().disable()
                .formLogin().disable();
    }
}
