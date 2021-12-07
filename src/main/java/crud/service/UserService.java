package crud.service;

import crud.model.User;

import java.util.List;

public interface UserService {

     List<User> getUsers();

     void createUser(User user);

     User update(Integer id);

     void delete(Integer id);
}
