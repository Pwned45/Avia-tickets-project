package com.aviaticket.backend.repos;

import com.aviaticket.backend.models.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TicketRepository extends JpaRepository<Ticket,Long> {
    @Query(
        value = "select t.* from ticket t",
        countQuery = "select count(t.*) from ticket t",
        nativeQuery = true
    )
    Page<Ticket> getListAllTicketPage(Pageable pageable);

}
