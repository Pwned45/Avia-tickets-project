package com.aviaticket.backend.repos;

import com.aviaticket.backend.models.Way;
import com.aviaticket.backend.repos.query.Utils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WayRepository extends JpaRepository<Way, Long> {
    @Query(
        value = Utils.FIND_WAYS_START,
        nativeQuery = true
    )
    List<Way> straightWay(@Param("cityS") String cityS, @Param("cityE") String cityE);
}
