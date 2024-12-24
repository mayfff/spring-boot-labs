package spring.lab.dto.movie;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MovieRequestDto {
    @NotBlank(message = "Movie title is required")
    String title;

    @NotBlank(message = "Movie description is required")
    String description;
}
