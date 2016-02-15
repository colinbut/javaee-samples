/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.decorator.example1.web;

import com.mycompany.decorator.example1.service.TicketService;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Singleton
@Startup
public class Controller {

    @Inject
    private TicketService ticketService;

    @PostConstruct
    public void init () {
        ticketService.orderTicket("1D Concert");
    }
}
