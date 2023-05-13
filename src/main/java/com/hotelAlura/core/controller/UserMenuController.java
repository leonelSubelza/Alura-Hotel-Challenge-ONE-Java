package com.hotelAlura.core.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

import com.hotelAlura.core.view.UserMenuView;

public class UserMenuController {

	private UserMenuView userMenuView;
	private LoginController loginController;
	private ReservasController reservasController;
	private BusquedaController busquedaController;
	
	public UserMenuController() {
		this.userMenuView = new UserMenuView();
		iniciar();
	}

	private void iniciar() {
		setTodayDate();
		this.userMenuView.getPanelSalir().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
		        int confirm = JOptionPane.showOptionDialog(null, "¿Estás seguro que deseas cerrar sesión?", "Advertencia",
		                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
		        if (confirm == 0) {
		        	userMenuView.closeWindow();
					loginController = new LoginController();
		        }
			}
		});
		
		this.userMenuView.getPanelRegistroReservas().addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			userMenuView.closeWindow();
			reservasController = new ReservasController();
		}
		
		});
		
		this.userMenuView.getPanelBusqueda().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				userMenuView.closeWindow();
				busquedaController = new BusquedaController();
			}
			
			});
		
	}

	private void setTodayDate() {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		LocalDate today = LocalDate.now();

		String dateString = today.format(formatter);
//		this.userMenuView.getLblFecha().setText(today.getDayOfWeek()+" "+today.getDayOfMonth()+" de "+today.getMonth()+" del "+today.getYear());
		this.userMenuView.getLblFecha().setText(dateString);		
	}
	
	public static void main(String[] args) {
		new UserMenuController();
	}
}
