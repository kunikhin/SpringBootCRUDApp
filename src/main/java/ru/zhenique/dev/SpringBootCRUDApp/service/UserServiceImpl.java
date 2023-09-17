package ru.zhenique.dev.SpringBootCRUDApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.zhenique.dev.SpringBootCRUDApp.dao.UserDAO;
import ru.zhenique.dev.SpringBootCRUDApp.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public User getUserById(long id) {
        return userDAO.getUserById(id);
    }

    @Override
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Override
    public void delete(long id) {
        userDAO.delete(id);
    }

    @Override
    public void updateUser (long id, User updateUser) {
        userDAO.updateUser(id, updateUser);
    }
}