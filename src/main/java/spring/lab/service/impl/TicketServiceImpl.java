package spring.lab.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import spring.lab.domain.Ticket;
import spring.lab.dto.TicketRequestDto;
import spring.lab.repository.impl.TicketRepositoryImpl;
import spring.lab.service.TicketService;

import java.util.List;

@Service
@AllArgsConstructor
public class TicketServiceImpl implements TicketService {
    private final TicketRepositoryImpl ticketRepository;

    @Override
    public Ticket createTicket(TicketRequestDto ticketRequestDto) {
        return ticketRepository.save(ticketRequestDto);
    }

    @Override
    public Ticket updateTicket(long ticketId, TicketRequestDto ticketRequestDto) {
        return ticketRepository.update(ticketId, ticketRequestDto);
    }

    @Override
    public String deleteTicket(long ticketId) {
        ticketRepository.delete(ticketId);
        return String.format("Ticket with id: %d deleted", ticketId);
    }

    @Override
    public List<Ticket> getAllTickets(Long page, Long size) {
        return ticketRepository.findAll(page, size);
    }

    @Override
    public Ticket getTicketById(long ticketId) {
        return ticketRepository.findById(ticketId);
    }

    @Override
    public List<Ticket> getTicketsByMovie(String movieTitle) {
        return ticketRepository.findTicketsByMovieTitle(movieTitle);
    }
}
