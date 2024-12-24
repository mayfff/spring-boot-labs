package spring.lab.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Movie {
    long id;
    String title;
    String description;
}
