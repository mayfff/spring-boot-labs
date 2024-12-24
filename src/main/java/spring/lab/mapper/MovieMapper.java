package spring.lab.mapper;

import spring.lab.domain.Movie;
import spring.lab.dto.movie.MovieResponseDto;
import spring.lab.repository.entity.MovieEntity;

public interface MovieMapper {
    Movie toMovieFromEntity(MovieEntity movieEntity);

    MovieResponseDto toMovieResponseDto(Movie movie);

    MovieEntity toMovieEntity(Movie movie);
}
