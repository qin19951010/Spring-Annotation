package com.jiangnanyidianyu.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    //事务注解
    @Transactional
    public void insertUser()
    {
        //默认没有事务特性
        userDao.insert();
        //otherDao.other();
        System.out.println("插入完成...");
        //遇到异常以后上面的插入语句还是执行了,
        //还是插入到了表中,没有进行回滚
        int i = 10/0;
    }
}
