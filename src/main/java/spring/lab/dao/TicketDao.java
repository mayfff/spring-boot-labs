package spring.lab.dao;

import spring.lab.domain.Ticket;
import spring.lab.dto.TicketRequestDto;

import java.util.List;

public interface TicketDao {
    Ticket save(TicketRequestDto ticketRequestDto);

    Ticket update(Long id, TicketRequestDto ticketRequestDto);

    void delete(Long id);

    Ticket findById(Long id);

    List<Ticket> findAll(long page, long size);

    List<Ticket> findTicketsByMovieTitle(String movieTitle);
}
