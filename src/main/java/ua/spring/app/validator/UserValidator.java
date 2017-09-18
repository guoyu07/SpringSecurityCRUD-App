package ua.spring.app.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ua.spring.app.entity.User;

/**
 * Created by serhii on 16.09.2017.
 */
@Component
public class UserValidator implements Validator{
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = ((User) o);

        if (user.getLogin().length() < 4 || user.getLogin().length() > 15) {
            errors.rejectValue("login", "Size.userForm.username","Your login must have length between 4-15 characters!");
        }
        if (user.getPassword().length() < 4 || user.getPassword().length() > 10) {
            errors.rejectValue("password", "Size.userForm.password","Your password must have length between 4-10 characters!");
        }
    }
}
