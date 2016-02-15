/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.decorator.example2;

import com.mycompany.decorator.example2.annotation.FeedProcessor;
import com.mycompany.decorator.example2.model.Feed;
import com.mycompany.decorator.example2.service.SocialFeedProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.decorator.Decorator;
import javax.decorator.Delegate;

@Decorator
public class FeedProcessorDecorator implements SocialFeedProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(FeedProcessorDecorator.class);

    @FeedProcessor
    @Delegate
    private SocialFeedProcessor socialFeedProcessor;


    @Override
    public Feed process(String feed) {
        LOGGER.info(String.format("%s processing feed", this.getClass().getName()));
        return new Feed();
    }
}
