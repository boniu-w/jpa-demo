package com.example.jpademo.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/************************************************************************
 * @author: wg
 * @description:
 * @createTime: 11:37 2022/8/19
 * @updateTime: 11:37 2022/8/19
 ************************************************************************/
@Table(name = "sys_user")
@Entity
public class SysUser {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "myIdGeneratorConfig")
    @GenericGenerator(name = "myIdGeneratorConfig", strategy="com.example.jpademo.config.MyIdGeneratorConfig")
    private Long id;

    private String name;

    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public SysUser(Long id) {
        this.id = id;
    }

    public SysUser() {
    }
}
