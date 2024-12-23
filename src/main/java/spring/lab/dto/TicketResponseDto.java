package spring.lab.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TicketResponseDto {
    long id;
    String date;
    String startTime;
    int seat;
    String movieTitle;
}
