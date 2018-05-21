package com.pq.service.impl;


import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pq.dao.UserDao;
import com.pq.model.User;
import com.pq.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
	UserDao userDao;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED , readOnly = true , rollbackFor = RuntimeException.class)
	public User findByUserName(String username) {		
		return userDao.findByName(username);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED , readOnly = true , rollbackFor = RuntimeException.class)
	public User findByUsernameAndPassword(String username, String password) {
		
		return userDao.findByNameAndPassword(username, password);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED , readOnly = true , rollbackFor = RuntimeException.class)
	public List<User> findUserByIdcard(String idCard) {
		return userDao.findUserByIdcard(idCard);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED , readOnly = true , rollbackFor = RuntimeException.class)
	public Page<User> findAll(Integer page,Integer size) {
		
	    Sort sort = new Sort(Sort.Direction.DESC,"id");  //逆序
        Pageable pageable = new PageRequest(page,size,sort);  
        Page<User> pages =  userDao.findAll(pageable);  

		return pages;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED , rollbackFor = RuntimeException.class)
	public boolean save(User user) {	
		try {
			userDao.save(user);			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	
	
	public static void main(String[] args) {
	
		System.out.println(DigestUtils.sha1Hex("1"));
	}



}
