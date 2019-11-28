package com.varnaTravelGuideWeb.service.daoServices;

import java.util.List;

import com.varnaTravelGuideWeb.domain.User;

public interface UserService {
	
    List<User> listAll();

    User getById(String id);

    User saveOrUpdate(User user);

    void delete(String id);

    User saveOrUpdateUserForm(User userForm);
}
