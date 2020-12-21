package service.impl;

import Dao.UserDao;
import Dao.impl.UserDaoImpl;
import entity.User;
import service.ChangePasswordService;

public class ChangePasswordServiceImpl implements ChangePasswordService {
    UserDao userDao = new UserDaoImpl();
    @Override
    public boolean changePassword(User user, String newPassword) {
        return userDao.resetPassword(user,newPassword);
    }
}
