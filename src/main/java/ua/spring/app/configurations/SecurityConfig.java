package ua.spring.app.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import ua.spring.app.service.UserDetailService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailService();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/welcome", "/", "/registration").permitAll()
                .anyRequest().authenticated();

        http.authorizeRequests()
                .antMatchers("/registration").not().authenticated()
                .antMatchers("/products").hasAnyRole("ADMIN", "USER")
                .anyRequest().authenticated()
                .and().formLogin().defaultSuccessUrl("/products", true)
                .and().logout().logoutSuccessUrl("/welcome")
                .and().csrf().disable();
    }


}
