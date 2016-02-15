/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.decorator.example2.service;

import com.mycompany.decorator.example2.annotation.FeedProcessor;
import com.mycompany.decorator.example2.model.Feed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@FeedProcessor
public class GoogleFeedProcessor implements SocialFeedProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(GoogleFeedProcessor.class);

    @Override
    public Feed process(String feed) {
        LOGGER.info("Processing Google feed");
        return new Feed();
    }
}
