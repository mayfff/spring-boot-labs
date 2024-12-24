package spring.lab.mapper;

import spring.lab.domain.Ticket;
import spring.lab.dto.ticket.TicketResponseDto;
import spring.lab.repository.entity.TicketEntity;

import java.util.List;

public interface TicketMapper {
    Ticket toTicket(TicketEntity ticketEntity);

    TicketEntity toTicketEntity(Ticket ticket);

    List<Ticket> toTickets(List<TicketEntity> ticketEntities);

    TicketResponseDto toTicketResponseDto(Ticket ticket);

    List<TicketResponseDto> toTicketResponseDtos(List<Ticket> tickets);
}
