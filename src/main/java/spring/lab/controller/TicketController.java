package spring.lab.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import spring.lab.dto.TicketRequestDto;
import spring.lab.dto.TicketResponseDto;
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

    @PostMapping
    public ResponseEntity<TicketResponseDto> createTicket(@RequestBody @Valid TicketRequestDto ticketRequestDto) {
        return ResponseEntity.ok(ticketMapper.toTicketResponseDto(ticketService.createTicket(ticketRequestDto)));
    }

    @PutMapping("/{ticketId}")
    public ResponseEntity<TicketResponseDto> updateTicket(@PathVariable Long ticketId, @RequestBody @Valid TicketRequestDto ticketRequestDto) {
        return ResponseEntity.ok(ticketMapper.toTicketResponseDto(ticketService.updateTicket(ticketId, ticketRequestDto)));
    }

    @DeleteMapping("/{ticketId}")
    public String deleteTicket(@PathVariable Long ticketId) {
        return ticketService.deleteTicket(ticketId);
    }

    @GetMapping("/all")
    public ResponseEntity<List<TicketResponseDto>> getAllTickets(@RequestParam(name = "page", defaultValue = "0") Long page,
                                                                 @RequestParam(name = "size", defaultValue = "10") Long size) {
        return ResponseEntity.ok(ticketMapper.toTicketResponseDtoList(ticketService.getAllTickets(page, size)));
    }

    @GetMapping("/{ticketId}")
    public ResponseEntity<TicketResponseDto> getTicketById(@PathVariable Long ticketId) {
        return ResponseEntity.ok(ticketMapper.toTicketResponseDto(ticketService.getTicketById(ticketId)));
    }

    @GetMapping("/filter/{movieTitle}")
    public ResponseEntity<List<TicketResponseDto>> findTicketByMovie(@PathVariable String movieTitle) {
        return ResponseEntity.ok(ticketMapper.toTicketResponseDtoList(ticketService.getTicketsByMovie(movieTitle)));
    }
}
