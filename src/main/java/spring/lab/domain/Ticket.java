package spring.lab.domain;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class Ticket {
    long id;
    String date;
    String startTime;
    int seat;
    Movie movie;
    User user;
    double price;
}
