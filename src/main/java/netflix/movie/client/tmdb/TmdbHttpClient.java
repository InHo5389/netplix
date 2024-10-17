package netflix.movie.client.tmdb;

import lombok.RequiredArgsConstructor;
import netflix.movie.client.HttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.server.Http2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Map;

/**
 * HttpClient를 감싸는 tmdb http client
 * 감싸는 이유는 tmdb api를 호출할때 항상 access token 보내야해서
 * 이 코드를 입히기 위해서
 */
@Component
@RequiredArgsConstructor
public class TmdbHttpClient {

    private final HttpClient httpClient;

    @Value("${tmdb.auth.access-token}")
    private String accessToken;

    public String request(String uri, HttpMethod method, MultiValueMap<String, String> headers, Map<String, Object> params) {
        MultiValueMap<String,String> multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.add(HttpHeaders.ACCEPT,"application/json");
        multiValueMap.add(HttpHeaders.AUTHORIZATION,"Bearer "+accessToken);
        multiValueMap.addAll(headers);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.addAll(multiValueMap);

        return httpClient.request(uri,method,httpHeaders,params);
    }
}
