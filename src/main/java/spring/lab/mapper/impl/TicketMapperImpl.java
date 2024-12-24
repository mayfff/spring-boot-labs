package spring.lab.mapper.impl;

import org.springframework.stereotype.Component;
import spring.lab.domain.Ticket;
import spring.lab.dto.TicketResponseDto;
import spring.lab.mapper.TicketMapper;

import java.util.List;

@Component
public class TicketMapperImpl implements TicketMapper {
    @Override
    public TicketResponseDto toTicketResponseDto(Ticket ticket) {
        return TicketResponseDto.builder()
                .date(ticket.getDate())
                .startTime(ticket.getStartTime())
                .seat(ticket.getSeat())
                .movieTitle(ticket.getMovieTitle())
                .id(ticket.getId())
                .price(ticket.getPrice())
                .build();
    }

    @Override
    public List<TicketResponseDto> toTicketResponseDtoList(List<Ticket> tickets) {
        return tickets.stream().map(this::toTicketResponseDto).toList();
    }
}
