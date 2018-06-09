package inisg.boot.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import inisg.boot.entity.AuthenticationRequest;
import inisg.boot.entity.AuthenticationToken;

@RestController
public class LoginController {
	@Autowired AuthenticationManager authMgr;
	
	@PostMapping(value="/login")
	public AuthenticationToken login(@RequestBody AuthenticationRequest authReq,
			HttpSession session) {
		String username = authReq.getUsername();
		String password = authReq.getPassword();
		
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
		Authentication auth = authMgr.authenticate(token);
		SecurityContextHolder.getContext().setAuthentication(auth);
		session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
				SecurityContextHolder.getContext());
		
		return new AuthenticationToken(username, session.getId());
	}
}
