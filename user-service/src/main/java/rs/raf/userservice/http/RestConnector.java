package rs.raf.userservice.http;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestConnector {
    public static final String USER_SERVICE_URL = "http://localhost:8083/userservice/api/";
    public static final String RESERVATION_SERVICE_URL = "http://localhost:8083/reservationservice/api/";
    public static final String NOTIFICATION_SERVICE_URL = "http://localhost:8083/notificationservice/api/";
    public static <T> ResponseEntity<T> sendGet(Class<T> responseType, String url, String token) {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer" + token);

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        return restTemplate.exchange(url, HttpMethod.GET, entity, responseType);
    }

    public static <T> ResponseEntity<T> sendPost(Class<T> responseType, String url, String token, Object body) {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer" + token);

        HttpEntity<Object> entity = new HttpEntity<Object>(body, headers);

        return restTemplate.exchange(url, HttpMethod.POST, entity, responseType);
    }
}
