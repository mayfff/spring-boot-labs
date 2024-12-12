package spring.lab.items.service.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import spring.lab.items.Ticket;
import spring.lab.items.repository.impl.TicketRepositoryImpl;
import spring.lab.items.service.TicketService;

import java.util.List;

@Service
@Primary
public class FirstTicketService implements TicketService {
    private final TicketRepositoryImpl ticketRepository;

    public FirstTicketService(TicketRepositoryImpl ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public List<Ticket> findAllTickets() {
        return ticketRepository.findAllTickets();
    }

    @Override
    public List<Ticket> findTicketsByMovie(String title) {
        return ticketRepository.findTicketsByMovie(title);
    }
}
