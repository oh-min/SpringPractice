package org.ohm.service;

import org.ohm.mapper.LoginMapper;
import org.ohm.model.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	LoginMapper lm;
	
	public LoginVO login (LoginVO member) {
		System.out.println("service="+member);
		System.out.println("service return="+lm.login(member));
		return lm.login(member);
	}
	
	
	
	
}
