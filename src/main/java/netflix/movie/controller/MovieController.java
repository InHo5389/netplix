package netflix.movie.controller;

import lombok.RequiredArgsConstructor;
import netflix.movie.service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @GetMapping("/api/v1/movie/client/{page}")
    public String fetchMoviePageable(@PathVariable int page) {
        movieService.fetchFromClient(page);
        return "";
    }
}
