package spring.lab.mapper.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import spring.lab.domain.Ticket;
import spring.lab.dto.ticket.TicketResponseDto;
import spring.lab.mapper.MovieMapper;
import spring.lab.mapper.TicketMapper;
import spring.lab.mapper.UserMapper;
import spring.lab.repository.entity.TicketEntity;

import java.util.List;

@Component
@AllArgsConstructor
public class TicketMapperImpl implements TicketMapper {
    private final UserMapper userMapper;
    private final MovieMapper movieMapper;

    @Override
    public Ticket toTicket(TicketEntity ticketEntity) {
        return Ticket.builder()
                .id(ticketEntity.getId())
                .movie(movieMapper.toMovieFromEntity(ticketEntity.getMovie()))
                .seat(ticketEntity.getSeat())
                .user(userMapper.toUser(ticketEntity.getUser()))
                .date(ticketEntity.getDate())
                .price(ticketEntity.getPrice())
                .startTime(ticketEntity.getStartTime())
                .build();
    }

    @Override
    public TicketEntity toTicketEntity(Ticket ticket) {
        return TicketEntity.builder()
                .id(ticket.getId())
                .startTime(ticket.getStartTime())
                .price(ticket.getPrice())
                .seat(ticket.getSeat())
                .user(userMapper.toUserEntity(ticket.getUser()))
                .date(ticket.getDate())
                .movie(movieMapper.toMovieEntity(ticket.getMovie()))
                .date(ticket.getDate())
                .build();
    }

    @Override
    public List<Ticket> toTickets(List<TicketEntity> ticketEntities) {
        return ticketEntities.stream().map(this::toTicket).toList();
    }

    @Override
    public TicketResponseDto toTicketResponseDto(Ticket ticket) {
        return TicketResponseDto.builder()
                .id(ticket.getId())
                .startTime(ticket.getStartTime())
                .price(ticket.getPrice())
                .seat(ticket.getSeat())
                .user(userMapper.toUserResponseDto(ticket.getUser()))
                .date(ticket.getDate())
                .movie(movieMapper.toMovieResponseDto(ticket.getMovie()))
                .build();
    }

    @Override
    public List<TicketResponseDto> toTicketResponseDtos(List<Ticket> tickets) {
        return tickets.stream().map(this::toTicketResponseDto).toList();
    }
}
