package com.aviaticket.backend.repos;

import com.aviaticket.backend.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location,Long> {
}
