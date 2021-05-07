package com.aviaticket.backend.repos;

import com.aviaticket.backend.models.Point;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointRepository extends JpaRepository<Point,Long> {
}
