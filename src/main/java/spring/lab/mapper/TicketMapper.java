package spring.lab.mapper;

import spring.lab.domain.Ticket;
import spring.lab.dto.TicketResponseDto;

import java.util.List;

public interface TicketMapper {
    TicketResponseDto toTicketResponseDto(Ticket ticket);

    List<TicketResponseDto> toTicketResponseDtoList(List<Ticket> tickets);
}
