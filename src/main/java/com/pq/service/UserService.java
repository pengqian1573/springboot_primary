package com.pq.service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.pq.model.User;

public interface UserService {

    User findByUserName(String username);      

    User findByUsernameAndPassword(String username, String password);

    List<User> findUserByIdcard(String idCard);
    
    Page<User> findAll(Integer page,Integer size);
    
    
    boolean  save(User user);
 }
