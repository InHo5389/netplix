package netflix.movie.service.dto.tmdb;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class MovieResponse {
    private final String movieName;
    private final boolean isAdult;
    private final List<String> genre;
    private final String overview;
    private final String releaseAt;
}
