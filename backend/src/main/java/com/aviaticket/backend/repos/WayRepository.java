package com.aviaticket.backend.repos;

import com.aviaticket.backend.models.Way;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WayRepository extends JpaRepository<Way,Long> {
}
