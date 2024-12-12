package spring.lab.items.repository.impl;

import org.springframework.stereotype.Repository;
import spring.lab.items.Ticket;

import java.util.Arrays;
import java.util.List;

@Repository
public class TicketRepositoryImpl {
    private final List<Ticket> tickets = Arrays.asList(
            new Ticket("Home Alone", "12:30", 5, 10),
            new Ticket("Home Alone", "12:30", 5, 13),
            new Ticket("Deadpool 2", "14:30", 2, 4),
            new Ticket("Taxi 3", "10:20", 1, 1)
    );

    public List<Ticket> findAllTickets() {
        return tickets;
    }

    public List<Ticket> findTicketsByMovie(String title) {
        return tickets.stream().filter(ticket -> ticket.getTitle().equalsIgnoreCase(title)).toList();
    }
}
