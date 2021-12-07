package crud.dao;

import crud.model.User;

import java.util.List;

public interface UserDao {
    List<User> getUsers();

    void createUser(User user);

    User update(Integer id);

    void delete(Integer id);
}
