package spring.lab.service;

import spring.lab.domain.Ticket;
import spring.lab.dto.ticket.TicketRequestDto;
import spring.lab.dto.ticket.TicketRequestWithUserDto;

import java.util.List;

public interface TicketService {
    Ticket createTicket(long userId, TicketRequestDto ticketRequestDto);

    Ticket updateTicket(long ticketId, TicketRequestWithUserDto ticketRequestDto);

    String deleteTicket(long ticketId);

    List<Ticket> getAllTickets();

    Ticket getTicketById(long ticketId);

    List<Ticket> getTicketsByMovie(String movieTitle);

    List<Ticket> getTicketByUserEmail(String email);

    List<Ticket> getTicketByUsername(String username);

    List<Ticket> getTicketByUserId(Long userId);
}
