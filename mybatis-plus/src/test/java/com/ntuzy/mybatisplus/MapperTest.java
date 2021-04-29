package com.ntuzy.mybatisplus;

import com.ntuzy.mybatisplus.entity.User;
import com.ntuzy.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;

@SpringBootTest
public class MapperTest {
    @Resource
    private UserMapper userMapper;

    @Test
    public void testInsert(){
        User user = new User();
        user.setName("坚果");
        user.setAge(77);
        user.setEmail("jianguo@qq.com");
        System.out.println(LocalDateTime.now());
//        user.setCreateTime(LocalDateTime.now());
//        user.setUpdateTime(LocalDateTime.now());
        int result = userMapper.insert(user);
        System.out.println(result);
    }

    @Test
    public void testSelect() {
        System.out.println(userMapper.selectById(1));
        System.out.println(userMapper.selectBatchIds(Arrays.asList(1, 2, 3)));

        HashMap<String,Object> map = new HashMap<>();
        map.put("name","坚果");
        map.put("age",77);
        System.out.println(userMapper.selectByMap(map));
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(1386944958170210313L);
        user.setAge(55);
        int i = userMapper.updateById(user);
    }

    @Test
    public void testDelete(){
        int i = userMapper.deleteById(2L);
        System.out.println(i);
    }

//    @Test
//    public void testSelectAllByName(){
//        System.out.println(userMapper.selectAllByName("坚果"));
//    }
}
