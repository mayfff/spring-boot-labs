package spring.lab.items.repository;

import spring.lab.items.Ticket;

import java.util.List;

public interface TicketRepository {
    List<Ticket> findAllTickets();
    List<Ticket> findTicketsByMovie(String title);
}
