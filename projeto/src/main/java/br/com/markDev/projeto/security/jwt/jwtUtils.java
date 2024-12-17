package br.com.markDev.projeto.security.jwt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class jwtUtils {

	@Value("${projeto.jwtSecret}")
	private String jwtSecret;
	
	@Value("${projeto.jwtExpirationMS}")
	private int jwtExpirationMS;
	
	
	public String generateTokenFromUserDetailsImpl(UserDetailsImpl userDAta) {
		
	}
}
