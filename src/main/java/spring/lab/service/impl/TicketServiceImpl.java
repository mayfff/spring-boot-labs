package spring.lab.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.lab.domain.Ticket;
import spring.lab.dto.ticket.TicketRequestDto;
import spring.lab.dto.ticket.TicketRequestWithUserDto;
import spring.lab.mapper.MovieMapper;
import spring.lab.mapper.TicketMapper;
import spring.lab.mapper.UserMapper;
import spring.lab.repository.TicketRepository;
import spring.lab.repository.entity.MovieEntity;
import spring.lab.repository.entity.TicketEntity;
import spring.lab.repository.entity.UserEntity;
import spring.lab.service.MovieService;
import spring.lab.service.TicketService;
import spring.lab.service.UserService;

import java.util.List;

@Service
@AllArgsConstructor
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;
    private final TicketMapper ticketMapper;
    private final UserMapper userMapper;
    private final MovieMapper movieMapper;
    private final UserService userService;
    private final MovieService movieService;

    @Override
    @Transactional
    public Ticket createTicket(long userId, TicketRequestDto ticketRequestDto) {
        UserEntity user = userMapper.toUserEntity(userService.findUserById(userId));
        MovieEntity movie = movieMapper.toMovieEntity(movieService.getMovie(ticketRequestDto.getMovieId()));

        TicketEntity newTicket = TicketEntity.builder()
                .date(ticketRequestDto.getDate())
                .price(ticketRequestDto.getPrice())
                .seat(ticketRequestDto.getSeat())
                .movie(movie)
                .user(user)
                .startTime(ticketRequestDto.getTime())
                .build();

        try {
            return ticketMapper.toTicket(ticketRepository.save(newTicket));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Ticket updateTicket(long ticketId, TicketRequestWithUserDto ticketRequestDto) {
        UserEntity user = userMapper.toUserEntity(userService.findUserById(ticketRequestDto.getUserId()));
        MovieEntity movie = movieMapper.toMovieEntity(movieService.getMovie(ticketRequestDto.getMovieId()));
        TicketEntity ticket = ticketMapper.toTicketEntity(getTicketById(ticketId));

        ticket.setUser(user);
        ticket.setMovie(movie);
        ticket.setStartTime(ticketRequestDto.getTime());
        ticket.setDate(ticketRequestDto.getDate());
        ticket.setPrice(ticketRequestDto.getPrice());
        ticket.setSeat(ticketRequestDto.getSeat());

        try {
            return ticketMapper.toTicket(ticketRepository.save(ticket));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public String deleteTicket(long ticketId) {
        try {
            ticketRepository.deleteById(ticketId);
            return String.format("Ticket with id %s deleted", ticketId);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Ticket> getAllTickets() {
        return ticketMapper.toTickets(ticketRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Ticket getTicketById(long ticketId) {
        return ticketMapper.toTicket(ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found")));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Ticket> getTicketsByMovie(String movieTitle) {
        return ticketMapper.toTickets(ticketRepository.findByMovieTitleContainingIgnoreCase(movieTitle));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Ticket> getTicketByUserEmail(String email) {
        return ticketMapper.toTickets(ticketRepository.findTicketsByUserEmail(email));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Ticket> getTicketByUsername(String username) {
        return ticketMapper.toTickets(ticketRepository.findTicketsByUsername(username));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Ticket> getTicketByUserId(Long userId) {
        return ticketMapper.toTickets(ticketRepository.findTicketsByUserId(userId));
    }
}
