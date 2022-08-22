package com.example.jpademo.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.mapping.IdGenerator;

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
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "myIdGeneratorConfig")
    @GenericGenerator(name = "myIdGeneratorConfig", strategy="com.example.jpademo.config.MyIdGeneratorConfig")
    private Long id;

    @Column(length = 127, name = "user_name")
    private String userName;

    @Column(length = 4, name = "age") // length mysql8 不管用
    private Integer age;

    @Column(length = 10, scale = 2, name = "count") // length mysql8 不管用, scale 管用
    private BigDecimal count;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public BigDecimal getCount() {
        return count;
    }

    public void setCount(BigDecimal count) {
        this.count = count;
    }
}
