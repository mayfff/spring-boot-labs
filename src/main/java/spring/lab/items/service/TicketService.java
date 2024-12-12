package spring.lab.items.service;

import spring.lab.items.Ticket;

import java.util.List;

public interface TicketService {
    List<Ticket> findAllTickets();
    List<Ticket> findTicketsByMovie(String title);
}
