package com.hotelAlura.core.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.hotelAlura.core.view.MenuView;

public class MenuController {

	private MenuView menuView;
	private LoginController loginController;
	
	public MenuController() {
		this.menuView = new MenuView();
		iniciar();
	}

	private void iniciar() {
		this.menuView.getLblLogin().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuView.close();
				loginController = new LoginController();
			}
		});
	}
}
