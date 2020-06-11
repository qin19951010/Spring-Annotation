package com.jiangnanyidianyu.service;

import com.jiangnanyidianyu.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.inject.Inject;

@Service
public class BookService {
    //@Qualifier("bookDao")
    //@Autowired(required = false)//不是必须
    //@Autowired//不是必须
    //@Resource
    @Inject
    private BookDao bookDao;

    public void print()
    {
        System.out.println(bookDao);
    }

    @Override
    public String toString() {
        return "BookService{" +
                "bookDao=" + bookDao +
                '}';
    }
}
