package com.aviaticket.backend.repos;

import com.aviaticket.backend.models.Point;
import com.aviaticket.backend.repos.query.Utils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PointRepository extends JpaRepository<Point,Long> {
    @Query(
        value = Utils.FIND_POINT_START,
        nativeQuery = true
    )
    List<Point> findPoint(@Param("cityS")String city,@Param("cityE")String cityE);
    @Query(
        value = Utils.FIND_POINTS_BY_ROUTE,
        nativeQuery = true
    )
    List<Point> findPointByRoute(@Param("route")Long route);

    @Query(
        value = Utils.FIND_POINT,
        nativeQuery = true
    )
    List<Point> findPoint(@Param("city")String route);

}
