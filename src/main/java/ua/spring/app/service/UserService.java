package ua.spring.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.spring.app.dao.UserDao;
import ua.spring.app.entity.User;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public User getUserById(String login){
        return userDao.getUserById(login);
    }

}


