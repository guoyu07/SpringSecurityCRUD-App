package ua.spring.app.dao;

import ua.spring.app.entity.User;

public interface UserDao {

    User getUserById(String login);
}
