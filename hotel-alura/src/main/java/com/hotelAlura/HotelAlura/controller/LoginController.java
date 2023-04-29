package com.hotelAlura.HotelAlura.controller;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JOptionPane;

import com.hotelAlura.HotelAlura.view.LoginView;

public class LoginController {

	private LoginView loginView;
	
	
	public LoginController() {
		this.loginView = new LoginView();
		
		iniciar();
	}


	private void iniciar() {
		
		handleExit();
		
	}


	private void handleExit() {
		this.loginView.getLblExit().addMouseListener(new MouseListener() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        int confirm = JOptionPane.showOptionDialog(null, "¿Estás seguro que quieres salir?", "Advertencia",
		                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
		        if (confirm == 0) {
		            System.exit(0);
		        }
		    }
		    
		    @Override
		    public void mousePressed(MouseEvent e) {
		    }
		    
		    @Override
		    public void mouseReleased(MouseEvent e) {
		    }
		    
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    }
		    
		    @Override
		    public void mouseExited(MouseEvent e) {
		    }
		});
	}
	
	
}
