/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.decorator.example2.service;

import com.mycompany.decorator.example2.model.Feed;

public interface SocialFeedProcessor {

    Feed process(String feed);

}
