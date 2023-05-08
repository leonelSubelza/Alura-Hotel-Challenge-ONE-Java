package com.hotelAlura.HotelAlura.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.hotelAlura.HotelAlura.view.InformationView;

public class InformationController {

	private InformationView informationView;
	private UserMenuController userMenuController;
	
	public InformationController(String messagge) {
		this.informationView = new InformationView();
		inicializar(messagge);
	}

	private void inicializar(String messagge) {
		this.informationView.setTxtMessagge(messagge);
		this.informationView.getPanelAceptar().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				informationView.closeWindow();
				userMenuController = new UserMenuController();
			}
		});
	}
}
