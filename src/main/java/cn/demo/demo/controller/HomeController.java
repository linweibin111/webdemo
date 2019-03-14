package cn.demo.demo.controller;

import cn.demo.demo.domain.User;
import cn.demo.demo.form.UserForm;
import cn.demo.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class HomeController {

    /**
     * DIsda
     * dependency inject
     * users
     */

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> sad() {
        return userService.allUsers();
    }

    @GetMapping("/{userId}")
    public User find(@PathVariable Long userId){
       return  userService.find(userId);

    }

    @PostMapping
    public User register(UserForm form) {
        //检查用户名是否合法
        //检查密码。。。
        return userService.register(form);
    }

    // users/{userId}
    @PutMapping("/{userId}")
    public User edit(@PathVariable Long userId, UserForm form){
        return userService.edit(userId, form);
    }

    @DeleteMapping("/{userId}")
    public void delete(@PathVariable Long userId){
        userService.deleteUser(userId);
    }


}

//get post

/**
 * RESTful 风格的API
 * <p>
 * get 获取数据
 * post 提交数据
 * put 修改数据
 * delete 删除数据
 */

