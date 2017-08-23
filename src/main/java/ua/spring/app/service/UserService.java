package ua.spring.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.spring.app.dao.RoleDao;
import ua.spring.app.dao.UserDao;
import ua.spring.app.entity.Role;
import ua.spring.app.entity.User;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private UserDao userDao;

    @Transactional
    public User getUserById(String login) {
        return userDao.getUserById(login);
    }

    @Transactional
    public void saveUser(User user) {
        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.getRoleById(1));
        user.setRoles(roles);

        userDao.saveUser(user);
    }

}


