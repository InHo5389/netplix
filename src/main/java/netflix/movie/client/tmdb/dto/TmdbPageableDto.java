package netflix.movie.client.tmdb.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class TmdbPageableDto {
    private final List<TmdbMovie> tmdbMovies;
    private final int page;
    private final boolean hasNext;
}
