package com.example.jpademo.dao;

import com.example.jpademo.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface SysUserRepository extends JpaRepository<SysUser, Long> {

    List<SysUser> findAllByName(String name);

    List<SysUser> findAllByNameLike(String name);

    List<SysUser> findAllByNameStartingWith(String name);

    @Query("select u from SysUser u")
    List<SysUser> selectAllSysUser();

    @Query("select new com.example.jpademo.entity.SysUser(u.id)  from SysUser u") // 必须有 相应的构造器
    // @Query("select u.id from SysUser u") // 报错: No converter found capable of converting from type [java.lang.Long] to type [@org.springframework.data.jpa.repository.Query com.example.jpademo.entity.SysUser]
    List<SysUser> selectAllSysUsersId();

    @Query("select u from SysUser u where u.id= ?2 or u.name like CONCAT('%', ?1,'%') ")
    List<SysUser> selectSysUserWhere(String name, Long id);

    @Transactional
    @Modifying
    @Query("update SysUser u set u.name= ?1 where u.id=11111111111111")
    int updateSysUserName(String toBeModifiedName);

    /**
     * 使用 原生 sql 加 nativeQuery = true
     */
    @Query(value = "select id from sys_user", nativeQuery = true)
    List<Long> selectAllSysUser1();
}
