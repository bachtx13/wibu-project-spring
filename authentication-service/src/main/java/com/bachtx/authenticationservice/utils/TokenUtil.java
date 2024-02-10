package com.bachtx.authenticationservice.utils;

import com.bachtx.authenticationservice.constants.TokenConstants;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;

@Getter
@Component
@Slf4j
public class TokenUtil {
    private static final Logger logger = LoggerFactory.getLogger(TokenUtil.class);
    private final SecretKey key;

    public TokenUtil() {
        byte[] keyBytes = Base64.getDecoder().decode(TokenConstants.HASH_SECRET);
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().verifyWith(key).build().parseEncryptedClaims(token).getPayload();
    }

    private <T> T getClaimFromToken(String token, Function<Claims, T> claimsTFunction) {
        return claimsTFunction.apply(getAllClaimsFromToken(token));
    }

    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().verifyWith(key).build().parse(token);
            return true;
        } catch (MalformedJwtException ex) {
            logger.error("Token invalid");
        } catch (ExpiredJwtException ex) {
            logger.error("Token expired");
        } catch (UnsupportedJwtException ex) {
            logger.error("Token unsupported");
        } catch (IllegalArgumentException ex) {
            logger.error("Token's claim is empty");
        }
        return false;
    }

    public String generateToken(String username) {
        HashMap<String, Object> claims = new HashMap<>();
        return handleGenerateToken(claims, username);
    }

    private String handleGenerateToken(HashMap<String, Object> claims, String username) {
        return Jwts.builder()
                .claims(claims)
                .subject(username)
                .issuedAt(new Date())
                .expiration((new Date(System.currentTimeMillis() + TokenConstants.TOKEN_VALIDITY * 1000)))
                .signWith(key)
                .compact();
    }
}
