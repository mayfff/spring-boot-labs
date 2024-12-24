package spring.lab.dto.ticket;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TicketRequestWithUserDto {
    @NotBlank(message = "Data is required")
    private String date;

    @NotBlank(message = "Time is required")
    private String time;

    @NotNull(message = "Seat cannot be null")
    @Min(value = 1, message = "Seat must be greater than 0")
    private Integer seat;

    @NotNull(message = "Movie title is required")
    private Long movieId;

    @NotNull(message = "Price cannot be null")
    private Double price;

    @NotNull(message = "User cannot be null")
    private Long userId;
}
