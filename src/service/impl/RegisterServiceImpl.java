package service.impl;

import Dao.UserDao;
import Dao.impl.UserDaoImpl;
import service.RegisterService;

public class RegisterServiceImpl implements RegisterService {
    UserDao userDao = new UserDaoImpl();
    @Override
    public void register(String username, String password, String email) {
        userDao.register(username, password, email);
    }
}
