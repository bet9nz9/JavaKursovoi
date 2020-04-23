package Dao;

import Entity.User;

import java.util.List;

public interface UserDAO {
    void add(User user);

    User getByID(Long id);
    List<User> getAll();

    void update(User user);

    void remove(User user);
}
