package spring.lab.items.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.lab.items.Ticket;
import spring.lab.items.repository.impl.TicketRepositoryImpl;
import spring.lab.items.service.TicketService;

import java.util.List;

@Service
public class SecondTicketService implements TicketService {
    @Autowired
    private TicketRepositoryImpl ticketRepository;

    @Override
    public List<Ticket> findAllTickets() {
        return ticketRepository.findAllTickets();
    }

    @Override
    public List<Ticket> findTicketsByMovie(String title) {
        return ticketRepository.findTicketsByMovie(title);
    }
}
