package com.ntuzy.mybatisplus;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ntuzy.mybatisplus.entity.Product;
import com.ntuzy.mybatisplus.entity.User;
import com.ntuzy.mybatisplus.mapper.ProductMapper;
import com.ntuzy.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class InterceptorTests {
    @Resource
    private UserMapper userMapper;
    @Resource
    private ProductMapper productMapper;

    @Test
    public void testSelectPage() {
        Page<User> pageParams = new Page<>(1, 5);
        userMapper.selectPage(pageParams, null);
        System.out.println(pageParams.getRecords());
    }

    @Test
    public void testSelectPageByPage(){
        Page<User> pageParam = new Page<>();
        List<User> users = userMapper.selectPageByPage(pageParam, 10).getRecords();
        users.forEach(System.out::println);
    }

    @Test
    public void testConcurrentUpdate(){
        //1、小李
        Product p1 = productMapper.selectById(1L);

        //2、小王
        Product p2 = productMapper.selectById(1L);

        //3、小李将价格加了50元，存入了数据库
        p1.setPrice(p1.getPrice() + 50);
        int result1 = productMapper.updateById(p1);
        System.out.println("小李修改结果：" + result1);

        //4、小王将商品减了30元，存入了数据库
        p2.setPrice(p2.getPrice() - 30);
        int result2 = productMapper.updateById(p2);
        System.out.println("小王修改结果：" + result2);

        if(result2 == 0) {
            p2 = productMapper.selectById(1L);
            p2.setPrice(p2.getPrice() - 30);
            productMapper.updateById(p2);
        }


        //最后的结果
        Product p3 = productMapper.selectById(1L);
        System.out.println("最后的结果：" + p3.getPrice());
    }

}
