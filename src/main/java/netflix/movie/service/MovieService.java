package netflix.movie.service;

import lombok.RequiredArgsConstructor;
import netflix.movie.client.tmdb.TmdbMovieApiClient;
import netflix.movie.client.tmdb.dto.TmdbPageableDto;
import netflix.movie.service.dto.tmdb.MovieResponse;
import netflix.movie.service.dto.tmdb.PageableMoviesResponse;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final TmdbMovieApiClient tmdbMovieApiClient;

    public PageableMoviesResponse fetchFromClient(int page) {
        TmdbPageableDto tmdbPageableDto = tmdbMovieApiClient.fetchMovies(page);
        return new PageableMoviesResponse(
                tmdbPageableDto.getTmdbMovies().stream()
                        .map(movie -> new MovieResponse(
                                movie.getMovieName(),
                                movie.isAdult(),
                                movie.getGenres(),
                                movie.getOverview(),
                                movie.getReleaseAt()
                        )).collect(Collectors.toList()),
                tmdbPageableDto.getPage(),
                tmdbPageableDto.isHasNext()
        );
    }
}

