package com.ntuzy.mybatisplus;

import com.ntuzy.mybatisplus.entity.User;
import com.ntuzy.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest  // 自动创建Spring上下文环境
class MybatisPlusApplicationTests {

//    @Autowired  //spring的 没有实现类会报错
    @Resource  // 名称装配 j2ee
    private UserMapper userMapper;

    @Test
    void testSelectList() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

}
