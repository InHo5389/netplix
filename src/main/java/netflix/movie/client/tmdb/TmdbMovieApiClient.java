package netflix.movie.client.tmdb;

import netflix.movie.client.tmdb.dto.TmdbPageableDto;

public interface TmdbMovieApiClient{
    TmdbPageableDto fetchMovies(int page);
}
