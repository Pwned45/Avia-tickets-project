package com.aviaticket.backend.repos;

import com.aviaticket.backend.models.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Long> {
}
