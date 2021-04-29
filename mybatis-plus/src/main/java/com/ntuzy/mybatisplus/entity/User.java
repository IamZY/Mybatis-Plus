package com.ntuzy.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("user")
public class User {
    // 雪花算法 默认值
//    @TableId(type = IdType.ASSIGN_ID)
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String email;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

//    @TableField(fill = FieldFill.INSERT)
//    private Date createTime;
//    @TableField(fill = FieldFill.INSERT_UPDATE)
//    private Date updateTime;

    @TableLogic
    @TableField(value = "is_deleted")
    private Boolean deleted;
}
