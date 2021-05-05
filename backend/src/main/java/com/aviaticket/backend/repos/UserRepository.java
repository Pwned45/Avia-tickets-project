package com.aviaticket.backend.repos;

import com.aviaticket.backend.models.User;
import com.aviaticket.backend.repos.query.Utils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(
        value = Utils.FIND_CLIENT_BY_LOGIN,
        nativeQuery = true
    )
    User getByLogin(@Param("login") String login);

    @Query(
        value = Utils.CHECK_EXIST_LOGIN,
        nativeQuery = true
    )
    Integer existsByLoginIs(@Param("login") String login);

    @Query(
        value = Utils.CHECK_EXIST_EMALE,
        nativeQuery = true
    )
    Integer existsByEmaleIs(@Param("emale") String emale);
}
