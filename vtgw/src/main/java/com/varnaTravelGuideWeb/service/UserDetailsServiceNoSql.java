package com.varnaTravelGuideWeb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.varnaTravelGuideWeb.entity.User;
import com.varnaTravelGuideWeb.model.Authorities;
import com.varnaTravelGuideWeb.repository.UserRepository;
import com.varnaTravelGuideWeb.userdetails.MFAUser;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceNoSql implements UserDetailsService {

	private final UserRepository userRepository;
	private static final boolean DEFAULT_ACC_NON_EXP = true;
	private static final boolean DEFAULT_CRED_NON_EXP = true;
	private static final boolean DEFAULT_ACC_NON_LOCKED = true;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		List<String> authorities = new ArrayList<>();
		if(user.isTotpEnabled()) {
			authorities.add(Authorities.TOTP_AUTH_AUTHORITY);
		} else {
			authorities.add(Authorities.ROLE_USER);
		}
	    MFAUser springUser = new MFAUser(user.getUsername(), 
                   user.getPassword(), 
                   user.isVerified(),
                   DEFAULT_ACC_NON_EXP, 
                   DEFAULT_CRED_NON_EXP, 
                   DEFAULT_ACC_NON_LOCKED,
                   buildAuthorities(authorities));
	    springUser.setSecurityPin(user.getSecurityPin());
	    springUser.setTotpEnabled(user.isTotpEnabled());
	    return springUser;
	}
	
	private List<GrantedAuthority> buildAuthorities(List<String> authorities) {
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(1);
		for(String authority : authorities) {
			authList.add(new SimpleGrantedAuthority(authority));
		}
		return authList;
	}
	
}