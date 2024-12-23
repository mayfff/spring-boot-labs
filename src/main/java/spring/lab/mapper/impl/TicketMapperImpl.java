package spring.lab.mapper.impl;

import org.springframework.stereotype.Component;
import spring.lab.domain.Ticket;
import spring.lab.dto.TicketResponseDto;
import spring.lab.mapper.TicketMapper;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class TicketMapperImpl implements TicketMapper {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    @Override
    public TicketResponseDto toTicketResponseDto(Ticket ticket) {
        return TicketResponseDto.builder()
                .id(ticket.getId())
                .date(ticket.getDate().format(DATE_FORMATTER))
                .startTime(ticket.getStartTime().format(TIME_FORMATTER))
                .seat(ticket.getSeat())
                .movieTitle(ticket.getMovieTitle())
                .build();
    }

    @Override
    public List<TicketResponseDto> toTicketResponseDtoList(List<Ticket> tickets) {
        return tickets.stream().map(this::toTicketResponseDto).toList();
    }
}
