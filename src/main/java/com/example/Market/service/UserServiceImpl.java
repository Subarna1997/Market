package com.example.Market.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.example.Market.dao.UserDao;
import com.example.Market.dto.UserDto;
import com.example.Market.model.Product;
import com.example.Market.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userdao;

	@Override
	public User addUser(UserDto userdto) {
		User user = new User();
		BeanUtils.copyProperties(userdto, user);
		 
		return userdao.save(user);
		
		
	}
	
	 public User getUserById(Integer userid) {
	        Optional<User> optionalProduct = userdao.findById(userid);
	        if (!optionalProduct.isPresent())
	        {
	            return null;	
	        }
	        return optionalProduct.get();
	    }

	
	
}
