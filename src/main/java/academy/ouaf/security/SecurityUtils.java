package academy.ouaf.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

@Service
public class SecurityUtils implements ISecurityUtils {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Override
    public String getRole(AppUserDetails userDetails) {
        return userDetails.getAuthorities().stream()
                .map(r -> r.getAuthority())
                .findFirst()
                .orElse(null);
    }

    @Value("${jwt.expiration}")
    private long jwtExpiration;

    @Override
    public String generateToken(AppUserDetails userDetails) {
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .addClaims(Map.of(
                        "role", getRole(userDetails),
                        "id", userDetails.getUserId()
                ))
                .signWith(SignatureAlgorithm.HS256, jwtSecret)
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpiration))
                .compact();
    }

    @Override
    public String getSubjectFromJwt(String jwt) {
        try {
            return Jwts.parser()
                    .setSigningKey(jwtSecret)
                    .parseClaimsJws(jwt)
                    .getBody()
                    .getSubject();
        } catch (Exception e) {
            throw new RuntimeException("Invalid JWT token: " + e.getMessage(), e);
        }
    }
}
