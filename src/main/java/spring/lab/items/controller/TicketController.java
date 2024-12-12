package spring.lab.items.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.lab.items.service.TicketService;

@Controller
@RequestMapping("/tickets")
public class TicketController {
    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/all")
    public String getAllTickets(Model model) {
        model.addAttribute("tickets", ticketService.findAllTickets());
        return "tickets";
    }

    @GetMapping
    public String findTicketByMovie(Model model, String title) {
        model.addAttribute("tickets", ticketService.findTicketsByMovie(title));
        return "tickets";
    }
}
