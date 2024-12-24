package spring.lab.dto.movie;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MovieResponseDto {
    long id;
    String title;
    String description;
}
