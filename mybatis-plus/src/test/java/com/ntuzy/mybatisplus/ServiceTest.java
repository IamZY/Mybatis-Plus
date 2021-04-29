package com.ntuzy.mybatisplus;

import com.ntuzy.mybatisplus.entity.User;
import com.ntuzy.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ServiceTest {
    @Resource
    private UserService userService;

    @Test
    public void testCount() {
        System.out.println("total count " + userService.count());
    }

    @Test
    public void testSaveBatch() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setName("花花"+i);
            user.setAge(29 + i);
            users.add(user);
        }
        boolean result = userService.saveBatch(users);
        System.out.println(result);
    }
}
