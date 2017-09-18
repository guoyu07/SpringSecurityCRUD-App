package ua.spring.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class AutoLoginService {

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Autowired
    @Qualifier(value = "userDetailServiceImpl")
    private UserDetailsService userDetailsService;


    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(UserDetailServiceImpl userDetailsService) {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        return daoAuthenticationProvider;
    }

    public void autoLogin(String name, String password){
        UserDetails userDetails = userDetailsService.loadUserByUsername(name);
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(userDetails,password,userDetails.getAuthorities());
    AuthenticationManager authenticationManager = new ProviderManager(Arrays.asList(authenticationProvider));
        authenticationManager.authenticate(token);

        if (token.isAuthenticated()) SecurityContextHolder.getContext().setAuthentication(token);

    }
}
