package com.aviaticket.backend.repos;

import com.aviaticket.backend.models.Bid;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BidRepository extends JpaRepository<Bid,Long> {
}
