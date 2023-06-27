//package id.co.indivara.jdt12.university.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user").password("{noop}password").roles("USER")
//                .and()
//                .withUser("admin").password("{noop}password").roles("USER", "ADMIN");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .httpBasic()
//                .and()
//                .authorizeHttpRequests()
//                .antMatchers(HttpMethod.GET,"/student/**").hasRole("USER")
//                .antMatchers(HttpMethod.POST,"/student").hasRole("ADMIN")
//                .antMatchers(HttpMethod.PUT,"/student/**").hasRole("ADMIN")
//                .antMatchers(HttpMethod.DELETE,"/student/**").hasRole("ADMIN")
//
//                .antMatchers(HttpMethod.GET,"/lecturer/**").hasRole("USER")
//                .antMatchers(HttpMethod.POST,"/lecturer").hasRole("ADMIN")
//                .antMatchers(HttpMethod.PUT,"/lecturer/**").hasRole("ADMIN")
//                .antMatchers(HttpMethod.DELETE,"/lecturer/**").hasRole("ADMIN")
//
//                .antMatchers(HttpMethod.GET,"/subject/**").hasRole("USER")
//                .antMatchers(HttpMethod.POST,"/subject").hasRole("ADMIN")
//                .antMatchers(HttpMethod.PUT,"/subject/**").hasRole("ADMIN")
//                .antMatchers(HttpMethod.DELETE,"/subject/**").hasRole("ADMIN")
//
//                .antMatchers(HttpMethod.GET,"/record/**").hasRole("USER")
//                .antMatchers(HttpMethod.POST,"/record").hasRole("ADMIN")
//                .antMatchers(HttpMethod.PUT,"/record/**").hasRole("ADMIN")
//                .antMatchers(HttpMethod.DELETE,"/record/**").hasRole("ADMIN")
//
//                .antMatchers(HttpMethod.GET,"/class/**").hasRole("USER")
//                .antMatchers(HttpMethod.POST,"/class").hasRole("ADMIN")
//                .antMatchers(HttpMethod.PUT,"/class/**").hasRole("ADMIN")
//                .antMatchers(HttpMethod.DELETE,"/class/**").hasRole("ADMIN")
//                .and()
//                .csrf().disable()
//                .formLogin().disable();
//    }
//}
