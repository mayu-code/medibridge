package com.main.medibridge.JwtSecurity;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.security.core.Authentication;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JwtProvider {
    public static SecretKey key = Keys.hmacShaKeyFor(JwtConstants.SECRETE_KEY.getBytes());

    public static String generateJwtToken(Authentication auth) {
        String jwt = Jwts.builder()
                .setIssuer("ok")
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + 1000 * 60 * 30)) // 30 min expiry
                .claim("email", auth.getName())
                .claim("role", auth.getAuthorities().toArray()[0].toString())
                .signWith(key)
                .compact();
        return jwt;
    }

    public static String getEmailFromJwt(String jwt) {
        jwt = jwt.substring(7);
        Claims claims = Jwts.parser()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(jwt)
                .getBody();
        return String.valueOf(claims.get("email"));
    }

    public static String getRoleFromJwt(String jwt) {
        jwt = jwt.substring(7);
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(jwt)
                    .getBody();
            return claims.get("role").toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "not ok";
        }
    }
}
