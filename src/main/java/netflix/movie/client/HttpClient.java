package netflix.movie.client;

import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class HttpClient {

    private final RestTemplate restTemplate;

    public String request(String uri, HttpMethod method, HttpHeaders headers, Map<String, Object> params) {
        // exchange를 한다는게 통신할때 어떤 규칙으로 한다는 것
        return restTemplate.exchange(
                uri,
                method,
                new HttpEntity<>(headers),
                new ParameterizedTypeReference<String>() {}, // 어떠한 형식으로 받을지
                params
        ).getBody();
    }
}
