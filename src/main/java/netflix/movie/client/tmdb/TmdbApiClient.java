package netflix.movie.client.tmdb;

import lombok.RequiredArgsConstructor;
import netflix.common.util.ObjectMapperUtil;
import netflix.movie.client.tmdb.dto.TmdbMovie;
import netflix.movie.client.tmdb.dto.TmdbPageableDto;
import netflix.movie.service.dto.tmdb.TmdbResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class TmdbApiClient implements TmdbMovieApiClient {

    @Value("${tmdb.api.movie-lists.now-playing}")
    private String nowPlayingUrl;

    private final TmdbHttpClient tmdbHttpClient;

    @Override
    public TmdbPageableDto fetchMovies(int page) {
        String url = nowPlayingUrl + "?language=ko-KR&page" + page;
        String request = tmdbHttpClient.request(url, HttpMethod.GET, CollectionUtils.toMultiValueMap(Map.of()), Map.of());

        // 받아온 String 데이터를 객체형태로 변환하기
        TmdbResponse object = ObjectMapperUtil.toObject(request, TmdbResponse.class);
        return new TmdbPageableDto(
                object.getResults().stream().map(movie -> new TmdbMovie(movie.getTitle(), movie.getAdult(), movie.getGenreIds(), movie.getOverview(), movie.getReleaseDate())).toList(),
                page,
                Integer.valueOf(object.getTotal_pages()) - page != 0
        );
    }
}
