package com.hotelAlura.HotelAlura.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.hotelAlura.HotelAlura.view.MenuView;

public class MenuController {

	private MenuView menuView;
	private LoginController loginController;
	
	public MenuController() {
		this.menuView = new MenuView();
//		this.menuView.show();
		iniciar();
	}

	private void iniciar() {
		this.menuView.getLblLogin().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("se hizo click");
//				super.mouseClicked(e);
				menuView.close();
				loginController = new LoginController();
			}
		});
	}

	
	
}
