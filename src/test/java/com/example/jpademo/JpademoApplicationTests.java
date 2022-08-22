package com.example.jpademo;

import com.example.jpademo.dao.SysUserRepository;
import com.example.jpademo.dao.UserRepository;
import com.example.jpademo.entity.SysUser;
import com.example.jpademo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class JpademoApplicationTests {

    @Autowired
    SysUserRepository sysUserRepository;

    @Autowired
    UserRepository userRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void query() {
        List<SysUser> allUser = sysUserRepository.findAll();
        System.out.println(allUser);

        String name = "admin";
        List<SysUser> allByName = sysUserRepository.findAllByName(name);
        System.out.println("allByName: " + allByName);

        List<SysUser> allByNameLike = sysUserRepository.findAllByNameLike("%ad%");
        System.out.println("allByNameLike: " + allByNameLike);

        List<SysUser> adm = sysUserRepository.findAllByNameStartingWith("adm%");
        // 错误示范 不应该加 `%` 符号
        // List<SysUser> adm = sysUserRepository.findAllByNameStartingWith("adm%");
        System.out.println("adm: " + adm);

        List<SysUser> sysUserList = sysUserRepository.selectAllSysUser();
        System.out.println("sysUserList: " + sysUserList);

        List<SysUser> sysUsers = sysUserRepository.selectSysUserWhere("admin", 1L);
        System.out.println("selectSysUserWhere: " + sysUsers);

        List<SysUser> selectAllSysUsersId = sysUserRepository.selectAllSysUsersId();
        System.out.println("selectAllSysUsersId: " + selectAllSysUsersId);

        int wg = sysUserRepository.updateSysUserName("wg");
        System.out.println(wg);

        List<Long> sysUsers1 = sysUserRepository.selectAllSysUser1();
        System.out.println("sysUsers1: " + sysUsers1);
    }

    @Test
    public void testInsert() {
        User user = new User();
        user.setUserName("www");
        user.setAge(21);

        User save = userRepository.save(user);
        System.out.println(save);
    }

}
