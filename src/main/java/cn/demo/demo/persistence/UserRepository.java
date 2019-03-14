package cn.demo.demo.persistence;

import cn.demo.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByName(String name);

    User findByNameAndEmail(String  name, String as);

    User findByNameAndPassword(String name,String pwd);


}
