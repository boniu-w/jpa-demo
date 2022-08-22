package com.example.jpademo.dao;

import com.example.jpademo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/************************************************************************
 * @author: wg
 * @description:
 * @createTime: 14:44 2022/8/22
 * @updateTime: 14:44 2022/8/22
 ************************************************************************/
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
