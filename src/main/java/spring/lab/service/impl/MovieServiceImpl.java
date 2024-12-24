package spring.lab.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.lab.domain.Movie;
import spring.lab.dto.movie.MovieRequestDto;
import spring.lab.mapper.MovieMapper;
import spring.lab.repository.MovieRepository;
import spring.lab.repository.TicketRepository;
import spring.lab.repository.entity.MovieEntity;
import spring.lab.repository.entity.TicketEntity;
import spring.lab.service.MovieService;

import java.util.List;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;
    private final TicketRepository ticketRepository;

    @Transactional
    @Override
    public Movie createMovie(MovieRequestDto movieRequestDto) {
        MovieEntity newMovie = MovieEntity.builder()
                .title(movieRequestDto.getTitle())
                .description(movieRequestDto.getDescription())
                .build();

        try {
            return movieMapper.toMovieFromEntity(movieRepository.save(newMovie));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Transactional
    @Override
    public Movie updateMovie(Long id, MovieRequestDto movieRequestDto) {
        MovieEntity movie = movieMapper.toMovieEntity(getMovie(id));

        movie.setTitle(movieRequestDto.getTitle());
        movie.setDescription(movieRequestDto.getDescription());

        try {
            return movieMapper.toMovieFromEntity(movieRepository.save(movie));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Transactional
    @Override
    public String deleteMovie(Long id) {
        List<TicketEntity> tickets = ticketRepository.findByMovieTitleContainingIgnoreCase(getMovie(id).getTitle());

        ticketRepository.deleteAll(tickets);

        try {
            movieRepository.deleteById(id);
            return String.format("Movie with id: %d deleted", id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Transactional(readOnly = true)
    @Override
    public Movie getMovie(Long id) {
        return movieMapper.toMovieFromEntity(movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found")));
    }
}
