package com.aviaticket.backend.repos;

import com.aviaticket.backend.models.Plane;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaneRepository extends JpaRepository<Plane, Long> {
}
