package com.example.jpademo.entity;

import javax.persistence.*;
import java.math.BigDecimal;

/************************************************************************
 * @author: wg
 * @description:
 * @createTime: 16:54 2022/8/19
 * @updateTime: 16:54 2022/8/19
 ************************************************************************/
@Entity
@Table(name= "user")
public class User {

    @Id
    private Long id;

    @Column(length = 127, name = "user_name")
    private String userName;

    @Column(length = 4, name = "age") // length 不管用
    private Integer age;

    @Column(length = 10, scale = 2, name = "count") // length 不管用, scale 管用
    private BigDecimal count;
}
