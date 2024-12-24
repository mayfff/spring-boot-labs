package spring.lab.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import spring.lab.dto.ticket.TicketRequestDto;
import spring.lab.dto.ticket.TicketRequestWithUserDto;
import spring.lab.dto.ticket.TicketResponseDto;
import spring.lab.mapper.TicketMapper;
import spring.lab.service.TicketService;

import java.util.List;

@RestController
@RequestMapping("/tickets")
@AllArgsConstructor
@Validated
public class TicketController {
    private final TicketService ticketService;
    private final TicketMapper ticketMapper;

    @PostMapping("/{userId}")
    public ResponseEntity<TicketResponseDto> createTicket(@PathVariable Long userId, @RequestBody @Valid TicketRequestDto ticketRequestDto) {
        return ResponseEntity.ok(ticketMapper.toTicketResponseDto(ticketService.createTicket(userId, ticketRequestDto)));
    }

    @PutMapping("/{ticketId}")
    public ResponseEntity<TicketResponseDto> updateTicket(@PathVariable Long ticketId, @RequestBody @Valid TicketRequestWithUserDto ticketRequestDto) {
        return ResponseEntity.ok(ticketMapper.toTicketResponseDto(ticketService.updateTicket(ticketId, ticketRequestDto)));
    }

    @DeleteMapping("/{ticketId}")
    public String deleteTicket(@PathVariable Long ticketId) {
        return ticketService.deleteTicket(ticketId);
    }

    @GetMapping("/all")
    public ResponseEntity<List<TicketResponseDto>> getAllTickets() {
        return ResponseEntity.ok(ticketMapper.toTicketResponseDtos(ticketService.getAllTickets()));
    }

    @GetMapping("/{ticketId}")
    public ResponseEntity<TicketResponseDto> getTicketById(@PathVariable Long ticketId) {
        return ResponseEntity.ok(ticketMapper.toTicketResponseDto(ticketService.getTicketById(ticketId)));
    }

    @GetMapping("/filter/{movieTitle}")
    public ResponseEntity<List<TicketResponseDto>> findTicketByMovie(@PathVariable String movieTitle) {
        return ResponseEntity.ok(ticketMapper.toTicketResponseDtos(ticketService.getTicketsByMovie(movieTitle)));
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<List<TicketResponseDto>> getAllTicketsByUsername(@PathVariable String username) {
        return ResponseEntity.ok(ticketMapper.toTicketResponseDtos(ticketService.getTicketByUsername(username)));
    }

    @GetMapping("/user-email/{userEmail}")
    public ResponseEntity<List<TicketResponseDto>> getAllTicketsByUserEmail(@PathVariable String userEmail) {
        return ResponseEntity.ok(ticketMapper.toTicketResponseDtos(ticketService.getTicketByUserEmail(userEmail)));
    }
}
