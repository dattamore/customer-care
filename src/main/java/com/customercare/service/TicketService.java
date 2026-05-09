package com.customercare.service;

import com.customercare.entity.Ticket;
import com.customercare.repository.TicketRepository;

import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class TicketService {


	@Autowired
    private  TicketRepository ticketRepository;

    //create ticket

    @Transactional
    public Ticket createTicket(Ticket ticket) {
    	
        ticket.setId(null);
        return ticketRepository.save(ticket);
    }

    //update ticket

    @Transactional
    public Ticket updateTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    // get ticket logic
    public Ticket getTicket(Long ticketId) {
        return ticketRepository.findById(ticketId).orElse(null);
    }


    //get ticket by username
    public Ticket getTicketByEmailId(String username) {
        return ticketRepository.findByEmail(username).orElse(null);
    }

}
