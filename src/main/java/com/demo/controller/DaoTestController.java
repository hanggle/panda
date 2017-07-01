package com.demo.controller;

import com.demo.dao.UserDAO;
import com.demo.entity.User;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * description:
 * author: Smile
 * date: 2017/4/23
 */
@RestController
public class DaoTestController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserService userService;

    @GetMapping("/getAll")
    public List<User> getAll(User user){
        List<User> userList = userDAO.findAll();
        System.out.println("getAll");
        return userList;
    }

    @RequestMapping("/getById")
    public Object getById(User user){

        User user2 = userDAO.findOne(user.getId());
        System.out.println("{{{{ DaoTestController.getById( ): user2.getId()值 = " + user2.getId() + " }}}}");
        return user2;
    }

    @PostMapping ("/saveAndFlush")
    public User saveAndFlush(){

        //User user2 = userDAO.getOne("12313");
        //System.out.println("{{{{ DaoTestController.getById( ): user2.getId()值 = " + user2.getId() + " }}}}");
        User user= new User();

        //user.setId(CommonUtil.getUUID());
        user.setEmail("22erwsdfas");
        user.setUsername("usera");
        user.setPassword("asdfasdf");
        User reuser = userDAO.saveAndFlush(user);

        return reuser;
    }
    @PostMapping ("/update")
    public String update(){
        userDAO.delete("402881855b996c1c015b996d5c810000");

        return "";
    }
    @PostMapping ("/save")
    public String save(){
        userService.save();
        return "ok";
    }
}
