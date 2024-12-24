package spring.lab.dto.ticket;

import lombok.Builder;
import lombok.Data;
import spring.lab.dto.movie.MovieResponseDto;
import spring.lab.dto.user.UserResponseDto;

@Builder
@Data
public class TicketResponseDto {
    long id;
    String date;
    String startTime;
    int seat;
    MovieResponseDto movie;
    UserResponseDto user;
    double price;
}
