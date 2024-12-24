package spring.lab.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import spring.lab.dto.movie.MovieRequestDto;
import spring.lab.dto.movie.MovieResponseDto;
import spring.lab.mapper.MovieMapper;
import spring.lab.service.MovieService;

@RestController
@RequestMapping("/movies")
@AllArgsConstructor
@Validated
public class MovieController {
    private final MovieService movieService;
    private final MovieMapper movieMapper;

    @PostMapping
    public ResponseEntity<MovieResponseDto> createMovie(@RequestBody @Valid MovieRequestDto movieRequestDto) {
        return ResponseEntity.ok(movieMapper.toMovieResponseDto(movieService.createMovie(movieRequestDto)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieResponseDto> updateMovie(@PathVariable Long id,
                                                        @RequestBody @Valid MovieRequestDto movieRequestDto) {
        return ResponseEntity.ok(movieMapper.toMovieResponseDto(movieService.updateMovie(id, movieRequestDto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable Long id) {
        return ResponseEntity.ok(movieService.deleteMovie(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieResponseDto> getMovie(@PathVariable Long id) {
        return ResponseEntity.ok(movieMapper.toMovieResponseDto(movieService.getMovie(id)));
    }
}
