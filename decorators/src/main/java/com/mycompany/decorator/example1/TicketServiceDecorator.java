/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.decorator.example1;

import com.mycompany.decorator.example1.model.Ticket;
import com.mycompany.decorator.example1.service.CateringService;
import com.mycompany.decorator.example1.service.TicketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

@Decorator
public class TicketServiceDecorator implements TicketService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TicketServiceDecorator.class);

    @Inject
    @Delegate
    private TicketService ticketService;

    @Inject
    private CateringService cateringService;

    @Override
    public Ticket orderTicket(String name) {
        LOGGER.info(String.format("%s ordering ticket", this.getClass().getName()));
        cateringService.cater();
        return new Ticket();
    }
}