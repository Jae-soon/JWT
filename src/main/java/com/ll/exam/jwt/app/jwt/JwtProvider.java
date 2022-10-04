package com.ll.exam.jwt.app.jwt;

import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Base64;

@Component
@EnableCaching
public class JwtProvider {
    private SecretKey cachedSecretKey;
    @Value("${custom.jwt.secretKey}")
    private String secretKeyPlain;

    public SecretKey _getSecretKey() {
        String keyBase64Encoded = Base64.getEncoder().encodeToString(secretKeyPlain.getBytes());
        return Keys.hmacShaKeyFor(keyBase64Encoded.getBytes());
    }

    public SecretKey getSecretKey() {
        if(cachedSecretKey == null) {
            cachedSecretKey = _getSecretKey();
        }

        return cachedSecretKey;
    }
}
