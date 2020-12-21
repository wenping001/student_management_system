package Dao;

import entity.User;

public interface UserDao {
    public User login(String username, String password);
    public void register(String username,String password,String email);
    public User isValidEmail(String email);
    public boolean resetPassword(User user,String newPassword);
}
