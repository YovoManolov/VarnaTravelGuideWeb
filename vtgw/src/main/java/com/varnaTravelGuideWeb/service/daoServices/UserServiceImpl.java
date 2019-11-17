package com.varnaTravelGuideWeb.service.daoServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.varnaTravelGuideWeb.domain.User;
import com.varnaTravelGuideWeb.repository.UserRepository;

public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private UserFormToUser userFormToUser;
	
	@Autowired
    public UserServiceImpl(UserRepository UserRepository, UserFormToUser UserFormToUser) {
    	this.userRepository = userRepository;
    	this.userFormToUser = userFormToUser;
    }
	
	@Override
	public List<User> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User saveOrUpdate(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User saveOrUpdateUserForm(User userForm) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
