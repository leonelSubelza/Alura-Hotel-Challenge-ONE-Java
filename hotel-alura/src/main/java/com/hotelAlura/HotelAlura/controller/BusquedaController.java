package com.hotelAlura.HotelAlura.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.hotelAlura.HotelAlura.view.BusquedaView;

public class BusquedaController {
	private BusquedaView busquedaView;
	private UserMenuController userMenuController;
	
	public BusquedaController() {
		this.busquedaView = new BusquedaView();
		iniciar();
	}

	private void iniciar() {
		this.busquedaView.getLblBack().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				busquedaView.closeWindow();
				userMenuController = new UserMenuController();
			}
		});
		
	}

	
}
