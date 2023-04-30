package com.hotelAlura.HotelAlura.controller;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import com.hotelAlura.HotelAlura.view.LoginView;

public class LoginController {

	public LoginView loginView;
	
	
	public LoginController() {
		this.loginView = new LoginView();
		
		iniciar();
	}


	private void iniciar() {

		handleExit();
		handleInputEvents();
	}


	private void handleInputEvents() {
//		this.loginView.getTxtUsuario().addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				loginView.getTxtUsuario().setText("");
//			}
//		});

		this.loginView.getTxtUsuario().addFocusListener(new FocusListener() {
		    public void focusGained(FocusEvent e) {
		    	loginView.getTxtUsuario().setText("");
		    }

		    public void focusLost(FocusEvent e) {
		        if (loginView.getTxtUsuario().getText().isEmpty()) {
		        	loginView.getTxtUsuario().setText("Escriba su nombre de usuario");
		        }
		    }
		});
		
		this.loginView.getTxtContrasena().addFocusListener(new FocusListener() {
		    public void focusGained(FocusEvent e) {
		    	loginView.getTxtContrasena().setText("");
		    }

		    public void focusLost(FocusEvent e) {
		        if (loginView.getTxtContrasena().getText().isEmpty()) {
		        	loginView.getTxtContrasena().setText("Escriba su contraseña");
		        }
		    }
		});
		
		
		this.loginView.getPanelEntrar().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				handleLogin();
			}


		});
		
	}


	private void handleExit() {
		this.loginView.getLblExit().addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        int confirm = JOptionPane.showOptionDialog(null, "¿Estás seguro que quieres salir?", "Advertencia",
		                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
		        if (confirm == 0) {
		            System.exit(0);
		        }
		    }
		});
	}
	
	
	private void handleLogin() {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(loginView, "Login not implemented yet", "Info", 0);
		
	}
	
}
