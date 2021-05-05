package com.aviaticket.backend.repos;

import com.aviaticket.backend.models.Conditionals;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConditionalsRepository extends JpaRepository<Conditionals, Long> {
}
