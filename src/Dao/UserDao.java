package Dao;

import entity.User;

public interface UserDao {
    public User login(String username, String password);
    public void register(String username,String password,String email);
}
