package spring.lab.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TicketRequestDto {
    @NotBlank(message = "Data is required")
    private String date;

    @NotBlank(message = "Time is required")
    private String time;

    @NotNull(message = "Seat cannot be null")
    @Min(value = 1, message = "Seat must be greater than 0")
    private Integer seat;

    @NotBlank(message = "Movie title is required")
    private String movieTitle;

    @NotNull(message = "Price cannot be null")
    private Double price;
}
