package service.impl;

import Dao.impl.UserDaoImpl;
import entity.User;
import service.LoginService;

public class LoginServiceImpl implements LoginService {
    private UserDaoImpl userDao = new UserDaoImpl();
    @Override
    public User login(String username, String password) {
        return userDao.login(username, password);
    }

    @Override
    public User isValidEmail(String email) {
        return userDao.isValidEmail(email);
    }
}
