package spring.lab.service;

import spring.lab.domain.Ticket;
import spring.lab.dto.TicketRequestDto;

import java.util.List;

public interface TicketService {
    Ticket createTicket(TicketRequestDto ticketRequestDto);

    Ticket updateTicket(long ticketId, TicketRequestDto ticketRequestDto);

    String deleteTicket(long ticketId);

    List<Ticket> getAllTickets(Long page, Long size);

    Ticket getTicketById(long ticketId);

    List<Ticket> getTicketsByMovie(String movieTitle);

}
