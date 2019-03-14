package cn.demo.demo;

import cn.demo.demo.domain.User;
import cn.demo.demo.persistence.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebdemoApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    UserRepository userRepository;

    @Test
    public void findAllByIds() {
        List<Long> ids = new ArrayList<>();
        ids.add(1552570370513L);
        ids.add(1552570371688L);
        List<User> users = userRepository.findAllById(ids);
        System.err.println(users);
    }

    @Test
    public void findByName() {

        List<User> users = userRepository.findByName("张三");
        System.err.println(users);
    }

    @Test
    public void findByNameaa() {

        User users = userRepository.findByNameAndEmail("张三", "aaa.asdsad.com");
        System.err.println(users);
    }

    @Test
    public  void findByPwd(){
        User user=userRepository.findByNameAndPassword("张三","aaa");
        System.err.println(user);
    }
}
