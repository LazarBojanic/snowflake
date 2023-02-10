package rs.raf.userservice.security.service;

import io.jsonwebtoken.Claims;

import java.util.List;
import java.util.Map;

public interface TokenService {
    String generate(Claims claims);
    Claims parseToken(String jwt);
    boolean checkToken(String jwtToken, List<String> definedRoles, Long targetUserId);
    boolean checkSecurity(String bearerToken, List<String> definedRoles, Long targetUserId);
}
