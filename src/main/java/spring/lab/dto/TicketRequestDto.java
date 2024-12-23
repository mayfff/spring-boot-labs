package spring.lab.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TicketRequestDto {
    private int startTimeHours;

    private int startTimeMinutes;

    private int dateDay;

    private int dateMonth;

    private int dateYear;

    private int seat;

    private String movieTitle;
}
