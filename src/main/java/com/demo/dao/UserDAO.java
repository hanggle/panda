package com.demo.dao;

import com.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * description:
 * author: Smile
 * date: 2017/4/20
 */
//JpaRepository<User,String>   User 对应实体类，String 对应ID类型
public interface UserDAO extends JpaRepository<User,String>{


}
