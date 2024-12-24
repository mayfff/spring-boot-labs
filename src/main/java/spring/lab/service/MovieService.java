package spring.lab.service;

import spring.lab.domain.Movie;
import spring.lab.dto.movie.MovieRequestDto;

public interface MovieService {
    Movie createMovie(MovieRequestDto movieRequestDto);

    Movie updateMovie(Long id, MovieRequestDto movieRequestDto);

    Movie getMovie(Long id);

    String deleteMovie(Long id);
}
