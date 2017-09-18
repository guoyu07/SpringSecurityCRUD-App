package ua.spring.app.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers( "/", "/registration").permitAll()
                .anyRequest().authenticated();

        http.authorizeRequests()
                .antMatchers("/registration").not().authenticated()
                .antMatchers("/products").hasAnyRole("ADMIN", "USER")
                .anyRequest().authenticated()
                .and().formLogin()

                .loginPage("/login")
                .loginProcessingUrl("/loginin")
                .defaultSuccessUrl("/products", true)
                .failureUrl("/login?error")
                .usernameParameter("username")
                .passwordParameter("password").permitAll()

                .and().logout().permitAll()
                .and().csrf().disable();
    }


}
