package com.ntuzy.mybatisplus.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("填充......");
        this.strictInsertFill(metaObject, "createTime", LocalDateTime.class,LocalDateTime.now());
        this.strictInsertFill(metaObject, "updateTime", LocalDateTime.class,LocalDateTime.now());

        Object age = this.getFieldValByName("age", metaObject);
        if (age == null) {
            this.strictInsertFill(metaObject,"age",Integer.class,0);
        }

        boolean hasAuthor = metaObject.hasSetter("author");
        if (hasAuthor) {
            this.strictInsertFill(metaObject,"author",String.class,"石头");
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("修改......");
        this.strictUpdateFill(metaObject, "updateTime", LocalDateTime.class,LocalDateTime.now());
    }
}
