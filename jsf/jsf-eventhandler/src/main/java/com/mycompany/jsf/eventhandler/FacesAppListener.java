package com.mycompany.jsf.eventhandler;

import javax.faces.application.Application;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.PostConstructApplicationEvent;
import javax.faces.event.PreDestroyApplicationEvent;
import javax.faces.event.SystemEvent;
import javax.faces.event.SystemEventListener;

public class FacesAppListener implements SystemEventListener {

	public boolean isListenerForSource(Object source) {
		return source instanceof Application;
	}

	public void processEvent(SystemEvent event) throws AbortProcessingException {
		if(event instanceof PostConstructApplicationEvent) {
			System.out.println("PostConstructApplicationEvent is called");
		}
		
		if(event instanceof PreDestroyApplicationEvent) {
			System.out.println("PreDestroyApplicationEvent is called");
		}
	}

}
