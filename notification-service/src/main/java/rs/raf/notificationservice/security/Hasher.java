package rs.raf.notificationservice.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Hasher {
    public static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    public static String hashPassword(String password) {
        return bCryptPasswordEncoder.encode(password);
    }
}