package spring.lab.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;


@Builder
@Data
public class Ticket {
    long id;
    LocalDate date;
    LocalTime startTime;
    int seat;
    String movieTitle;
}
