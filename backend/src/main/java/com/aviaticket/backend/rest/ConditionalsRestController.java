package com.aviaticket.backend.rest;

import com.aviaticket.backend.dto.ConditionalsDto;
import com.aviaticket.backend.dto.LocationDto;
import com.aviaticket.backend.exeption.EntityNotFoundException;
import com.aviaticket.backend.service.ConditionalsService;
import com.aviaticket.backend.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/condit")
public class ConditionalsRestController {

    @Autowired
    private ConditionalsService conditionalsService;

    @GetMapping("/all")
    public ResponseEntity<List<ConditionalsDto>> allConditionals() {
        List<ConditionalsDto> list = conditionalsService.getAll();
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ConditionalsDto> getConditionalsByID(@PathVariable("id") Long id) throws EntityNotFoundException {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(conditionalsService.getById(id), HttpStatus.OK);
    }


}
