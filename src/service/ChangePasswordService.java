package service;

import entity.User;

public interface ChangePasswordService {
    public boolean changePassword(User user, String newPassword);
}
