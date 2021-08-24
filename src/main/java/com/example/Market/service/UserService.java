package com.example.Market.service;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.Market.dto.UserDto;
import com.example.Market.model.Product;
import com.example.Market.model.User;



@Service
public interface UserService {

	
	public User addUser(@RequestBody UserDto userdto);
	
	public User getUserById(Integer userid);
}
