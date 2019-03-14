package cn.demo.demo.service;

import cn.demo.demo.domain.User;
import cn.demo.demo.form.UserForm;
import cn.demo.demo.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User register(UserForm userForm) {
        User user = new User();
        user.setId(System.currentTimeMillis());
        user.setEmail(userForm.getEmail());
        user.setName(userForm.getUsername());
        user.setPassword(userForm.getPassword());

        return userRepository.save(user);
    }

    @Override
    public List<User> allUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public User edit(Long userId, UserForm form) {
        Optional<User> opt = userRepository.findById(userId);
        if (opt.isPresent()) {
            User user = opt.get();
            user.setName(form.getUsername());
            user.setEmail(form.getEmail());
            return user;
        }
        return null;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User find(Long userId) {
        return userRepository.findById(userId).orElse(new User());
    }
}
