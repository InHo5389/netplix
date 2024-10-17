package netflix.movie.client.tmdb.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class TmdbMovie {
    private final String movieName;
    private final boolean isAdult;
    private final List<String> genres;
    private final String overview;
    private final String releaseAt;
}
