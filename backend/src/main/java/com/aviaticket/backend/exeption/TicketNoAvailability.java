package com.aviaticket.backend.exeption;

import lombok.Data;

@Data
public class TicketNoAvailability extends Exception {

    public TicketNoAvailability() {
        super("All tickets for this flight are sold out");
    }
}

