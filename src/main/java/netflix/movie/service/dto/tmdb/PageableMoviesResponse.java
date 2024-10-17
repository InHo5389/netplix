package netflix.movie.service.dto.tmdb;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import netflix.movie.service.dto.tmdb.MovieResponse;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class PageableMoviesResponse {
    private final List<MovieResponse> tmdbMovies;
    private final int page;
    private final boolean hasNext;
}
