package spring.lab.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.lab.dao.impl.TicketDaoImpl;
import spring.lab.domain.Ticket;
import spring.lab.dto.TicketRequestDto;
import spring.lab.service.TicketService;

import java.util.List;

@Service
@AllArgsConstructor
public class TicketServiceImpl implements TicketService {
    private final TicketDaoImpl ticketRepository;

    @Override
    @Transactional
    public Ticket createTicket(TicketRequestDto ticketRequestDto) {
        try {
            return ticketRepository.save(ticketRequestDto);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Ticket updateTicket(long ticketId, TicketRequestDto ticketRequestDto) {
        try {
            return ticketRepository.update(ticketId, ticketRequestDto);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public String deleteTicket(long ticketId) {
        try {
            ticketRepository.delete(ticketId);
            return String.format("Ticket with id: %d deleted", ticketId);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Ticket> getAllTickets(Long page, Long size) {
        return ticketRepository.findAll(page, size);
    }

    @Override
    @Transactional(readOnly = true)
    public Ticket getTicketById(long ticketId) {
        return ticketRepository.findById(ticketId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Ticket> getTicketsByMovie(String movieTitle) {
        return ticketRepository.findTicketsByMovieTitle(movieTitle);
    }
}
