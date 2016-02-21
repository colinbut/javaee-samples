package com.mycompany.jsf.eventhandler;

import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

public class NormalActionListener implements ActionListener {

	public void processAction(ActionEvent arg0) throws AbortProcessingException {
		System.out.println("Any use case here?");
	}

}
