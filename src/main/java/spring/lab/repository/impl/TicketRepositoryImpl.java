package spring.lab.repository.impl;

import org.springframework.stereotype.Repository;
import spring.lab.domain.Ticket;
import spring.lab.dto.TicketRequestDto;
import spring.lab.repository.TicketRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class TicketRepositoryImpl implements TicketRepository {
    private final List<Ticket> tickets = new ArrayList<>(Arrays.asList(
            Ticket.builder()
                    .id(1L)
                    .date(LocalDate.now())
                    .startTime(LocalTime.now())
                    .seat(6)
                    .movieTitle("Home Alone 1")
                    .build(),
            Ticket.builder()
                    .id(2L)
                    .date(LocalDate.of(2024, 12, 28))
                    .startTime(LocalTime.of(18, 10))
                    .seat(10)
                    .movieTitle("Home Alone 2")
                    .build(),
            Ticket.builder()
                    .id(3L)
                    .date(LocalDate.of(2024, 12, 30))
                    .startTime(LocalTime.of(20, 10))
                    .seat(5)
                    .movieTitle("Home Alone 3")
                    .build()
    ));

    @Override
    public Ticket save(TicketRequestDto ticketRequestDto) {

        Ticket newTicket = Ticket.builder()
                .id(tickets.size() + 1)
                .date(LocalDate.of(ticketRequestDto.getDateYear(), ticketRequestDto.getDateMonth(), ticketRequestDto.getDateDay()))
                .startTime(LocalTime.of(ticketRequestDto.getStartTimeHours(), ticketRequestDto.getStartTimeMinutes()))
                .seat(ticketRequestDto.getSeat())
                .movieTitle(ticketRequestDto.getMovieTitle())
                .build();

        tickets.add(newTicket);

        return newTicket;
    }

    @Override
    public Ticket update(Long id, TicketRequestDto ticketRequestDto) {
        Ticket existTicket = findById(id);

        existTicket.setSeat(ticketRequestDto.getSeat());
        existTicket.setMovieTitle(ticketRequestDto.getMovieTitle());
        existTicket.setDate(LocalDate.of(ticketRequestDto.getDateYear(), ticketRequestDto.getDateMonth(), ticketRequestDto.getDateDay()));
        existTicket.setStartTime(LocalTime.of(ticketRequestDto.getStartTimeHours(), ticketRequestDto.getStartTimeMinutes()));

        return existTicket;
    }

    @Override
    public void delete(Long id) {
        Ticket existTicket = findById(id);

        tickets.remove(existTicket);
    }

    @Override
    public Ticket findById(Long id) {
        return tickets.stream().filter(ticket -> ticket.getId() == id).findFirst().orElseThrow(() -> new RuntimeException("Ticket not found"));
    }

    @Override
    public List<Ticket> findAll(long page, long size) {
        return tickets.stream().skip(page * size).limit(size).toList();
    }

    @Override
    public List<Ticket> findTicketsByMovieTitle(String movieTitle) {

        return tickets.stream()
                .filter(ticket -> ticket.getMovieTitle().toLowerCase().contains(movieTitle.toLowerCase()))
                .toList();
    }
}
