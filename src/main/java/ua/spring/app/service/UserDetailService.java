package ua.spring.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ua.spring.app.entity.Role;
import ua.spring.app.entity.User;

public class UserDetailService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User userById = userService.getUserById(s);
        if (userById == null) throw new UsernameNotFoundException("User not exist");

        String[] roles = userById.getRoles().stream().map(Role::getName).toArray(String[]::new);

        return org.springframework.security.core.userdetails.User.withUsername(userById.getLogin())
                .password(userById.getPassword())
                .roles(roles)
                .build();
    }
}
