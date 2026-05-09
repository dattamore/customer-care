package com.customercare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customercare.entity.Ticket;

import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket,Long> {

    //Optional<Ticket> findById(Long ticketId);
    Optional<Ticket> findByEmail(String email);



}
