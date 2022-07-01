package com.quranschool.configuration.security.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;

@Component
public class JwtUtils {

        private static final String secret = "z-quran-school";

        public String generateToken(UserDetails userDetails){
                HashMap<String, Object> claims = new HashMap<>();
                return createToken(claims, userDetails.getUsername());
        }

        public String generateToken1(UserDetails userDetails){
                HashMap<String, Object> claims = new HashMap<>();
                claims.put("mobile", "01099831838");
                return createToken(claims, userDetails.getUsername());
        }


        private String createToken(HashMap<String, Object> claims, String username) {
                return Jwts.builder().setClaims(claims).setSubject(username)
                        .setIssuedAt(new Date(System.currentTimeMillis()))
                        .setExpiration(new Date(System.currentTimeMillis() + 999999999 * 999999999 ))
                        .signWith(io.jsonwebtoken.SignatureAlgorithm.HS256, secret)
                        .compact();

        }

        private Claims extractAllClaims(String token){
               return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        }

        public <T> T extractClaim(String token, Function<Claims, T> claimsResolver){
                final Claims claims =extractAllClaims(token);
                return claimsResolver.apply(claims);
        }

        public String extractUserName(String token){
                return extractClaim(token, Claims::getSubject);
        }


        public Claims extractMobile(String token){
                final Claims claims =extractAllClaims(token);
                return claims;
        }

        public boolean validateToken(String token, UserDetails userDetails){
                String userName = extractUserName(token);
                return (userName.equals(userDetails.getUsername()));
        }

        private Date extractExpiration(String token){
                return extractClaim(token, Claims::getExpiration);
        }

        private boolean isTokenExpired(String token){
                Date expiration = extractExpiration(token);
                return expiration.before(new Date());
        }

}
