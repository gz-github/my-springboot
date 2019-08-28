package com.gz.springboot.javaconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        //通过java配置来实例化spring容器
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);
        //spring容器中获取bean对象
        UserService us = context.getBean(UserService.class);

        //调用对象的方法
        List<User> userList = us.queryUserList();
        for (User user: userList) {
            System.out.println(user);
        }

        //销毁该容器
        context.destroy();
    }
}
