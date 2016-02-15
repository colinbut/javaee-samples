/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.decorator.example1.service;

import com.mycompany.decorator.example1.model.Ticket;

public class TicketServiceImpl implements TicketService {

    @Override
    public Ticket orderTicket(String name) {
        return new Ticket();
    }

}

