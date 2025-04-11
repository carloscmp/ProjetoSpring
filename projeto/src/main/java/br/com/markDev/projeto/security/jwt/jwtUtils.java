package br.com.markDev.projeto.security.jwt;

import java.security.Key;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import br.com.markDev.projeto.service.UserDetailsImpl;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class jwtUtils {

	@Value("${projeto.jwtSecret}")
	private String jwtSercret;

	@Value("${projeto.jwtExpirationMs}")
	private int jwtExpirationMs;

	public String generateTokenFromUserDetailsImpl(UserDetailsImpl userDetail) {
		return Jwts.builder().setSubject(userDetail.getUsername()).setIssuedAt(new Date())
				.setExpiration(new Date(new Date().getTime() + jwtExpirationMs))
				.signWith(getSingninKey(), SignatureAlgorithm.ES512).compact();
	}

	public Key getSingninKey() {
		SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSercret));
		return key;
	}

	public boolean validateJwtTokens(String AuthToken) {
		try {
			Jwts.parser().setSigningKey(getSingninKey()).build().parseClaimsJws(AuthToken);
		} catch (MalformedJwtException e) {
			System.out.println("Token Inválido" + e.getMessage());
		} catch (ExpiredJwtException e) {
			System.out.println("Token Expirado" + e.getMessage());
		} catch (UnsupportedJwtException e) {
			System.out.println("Token Não Suportado" + e.getMessage());
		} catch (IllegalArgumentException e) {
			System.out.println("Token Argumento Inválido" + e.getMessage());
		}
		return false;
	}
}