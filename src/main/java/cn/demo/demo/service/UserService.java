package cn.demo.demo.service;

import cn.demo.demo.domain.User;
import cn.demo.demo.form.UserForm;

import java.util.List;

public interface UserService {

    User register(UserForm userForm);

    List<User> allUsers();

    User edit(Long userId, UserForm form);

    void deleteUser(Long id);

    User find(Long userId);
}
