package com.aviaticket.backend.rest;
import com.aviaticket.backend.dto.WayDto;
import com.aviaticket.backend.service.WayServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/way")
public class WayRestComtroller {
    @Autowired
    private WayServise wayServise;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/all")
    public ResponseEntity<List<WayDto>> allUsers() {
        List<WayDto> wayDtos = wayServise.getAvailWay();
        if (wayDtos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(wayDtos, HttpStatus.OK);
    }

}
