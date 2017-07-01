package com.demo.service;

import com.demo.dao.UserDAO;
import com.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * description:
 * author: Smile
 * date: 2017/4/23
 */
@Service
public class UserService  {

    @Autowired
    private UserDAO userDAO;

    @Transactional
    public void save(){
        User user = new User("A","B","C");

        userDAO.save(user);

        User user2 = new User("A2","B2","C2");
        int i=0;
        if(i==0)
        throw new NullPointerException();
        userDAO.save(user2);

    }
}
