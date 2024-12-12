package spring.lab.items;

import lombok.Data;

@Data
public class Ticket {
    private final String title;
    private final String time;
    private final int row;
    private final int seat;
}
