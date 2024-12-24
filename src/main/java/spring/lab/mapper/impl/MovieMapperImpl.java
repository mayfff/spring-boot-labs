package spring.lab.mapper.impl;

import org.springframework.stereotype.Component;
import spring.lab.domain.Movie;
import spring.lab.dto.movie.MovieResponseDto;
import spring.lab.mapper.MovieMapper;
import spring.lab.repository.entity.MovieEntity;

@Component
public class MovieMapperImpl implements MovieMapper {

    @Override
    public Movie toMovieFromEntity(MovieEntity movieEntity) {
        return Movie.builder()
                .id(movieEntity.getId())
                .title(movieEntity.getTitle())
                .description(movieEntity.getDescription())
                .build();
    }

    @Override
    public MovieResponseDto toMovieResponseDto(Movie movie) {
        return MovieResponseDto.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .description(movie.getDescription())
                .build();
    }

    @Override
    public MovieEntity toMovieEntity(Movie movie) {
        return MovieEntity.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .description(movie.getDescription())
                .build();
    }
}
