package rs.raf.reservationservice.security.service.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import rs.raf.reservationservice.security.service.TokenService;
import java.util.List;
import java.util.Map;

@Service
public class TokenServiceImpl implements TokenService {
    public static String MASTER_TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjAiLCJyb2xlX2lkIjoiMCJ9.b4FxCueRVzuaJBUIQAwgcLyfkXwb8ZUfbYys34ZUD8I";
    @Value("${oauth.jwt.secret}")
    private String jwtSecret;
    @Override
    public String generate(Claims claims) {
        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    @Override
    public Claims parseToken(String jwt) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(jwtSecret)
                    .parseClaimsJws(jwt)
                    .getBody();
        } catch (Exception e) {
            return null;
        }
        return claims;
    }
    @Override
    public boolean checkToken(String jwtToken, List<String> definedRoles, Long targetUserId){
        if (jwtToken == null) {
            return false;
        }
        Claims claims = parseToken(jwtToken);
        if (claims == null) {
            return false;
        }
        Long parsedUserId = claims.get("id", Long.class);
        String parsedRoleId = claims.get("role_id", String.class);
        String enabled = claims.get("enabled", String.class);
        if(enabled.equals("no")){
            return false;
        }
        for(String definedRoleId : definedRoles){
            if(parsedRoleId.equals(definedRoleId)){
                if(targetUserId != null){
                    return targetUserId.equals(parsedUserId);
                }
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean checkSecurity(String bearerToken, List<String> definedRoles, Long targetUserId) {
        String jwtToken = "";
        if(bearerToken.contains("Bearer")){
            jwtToken = bearerToken.split(" ")[1];
            if(jwtToken.equals(MASTER_TOKEN)){
                return true;
            }
        }
        else{
            return false;
        }
        return checkToken(jwtToken, definedRoles, targetUserId);
    }
}