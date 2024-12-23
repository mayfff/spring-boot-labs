package spring.lab.repository;

import spring.lab.dto.TicketRequestDto;
import spring.lab.domain.Ticket;

import java.util.List;

public interface TicketRepository {
    Ticket save(TicketRequestDto ticketRequestDto);

    Ticket update(Long id, TicketRequestDto ticketRequestDto);

    void delete(Long id);

    Ticket findById(Long id);

    List<Ticket> findAll(long page, long size);

    List<Ticket> findTicketsByMovieTitle(String movieTitle);
}
