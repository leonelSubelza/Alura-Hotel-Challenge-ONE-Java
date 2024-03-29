package com.hotelAlura.core.controller;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

import com.hotelAlura.core.dao.UsuarioDAO;
import com.hotelAlura.core.model.Usuario;
import com.hotelAlura.core.utils.JPAUtils;
import com.hotelAlura.core.view.LoginView;


public class LoginController {

	private LoginView loginView;
	private UsuarioDAO usuarioDAO;
	private UserMenuController userMenuController;
	
	public LoginController() {
		this.loginView = new LoginView();
		EntityManager em = JPAUtils.getEntityManager();
		this.usuarioDAO = new UsuarioDAO(em);
		iniciar();
	}


	private void iniciar() {

		handleExit();
		handleInputEvents();
	}


	private void handleInputEvents() {
		
		this.loginView.getTxtUsuario().addFocusListener(new FocusListener() {
		    public void focusGained(FocusEvent e) {
		    	if(loginView.getTxtUsuario().getText().equals("Ingrese su nombre de usuario")) {
		    		loginView.getTxtUsuario().setText("");
		    	}
		    }

		    public void focusLost(FocusEvent e) {
		        if (loginView.getTxtUsuario().getText().isEmpty()) {
		        	loginView.getTxtUsuario().setText("Ingrese su nombre de usuario");
		        }
		    }
		});
		
		this.loginView.getTxtContrasena().addFocusListener(new FocusListener() {
		    public void focusGained(FocusEvent e) {
		    	if(loginView.getTxtContrasena().getText().equals("********")) {
		    		loginView.getTxtContrasena().setText("");	
		    	}
		    	
		    }
		    public void focusLost(FocusEvent e) {

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
		            JPAUtils.closeEntityManagerFactory();
		            System.exit(0);
		        }
		    }
		});
	}
	
	
	private void handleLogin() {
		String user = this.loginView.getTxtUsuario().getText();
		String password = this.loginView.getTxtContrasena().getText();
		if(user.equals("") || password.equals("")) {
			JOptionPane.showMessageDialog(loginView, "Los campos no son correctos");
			return;
		}
		
		Usuario u = this.usuarioDAO.exist(user,password);
		
		if(u==null) {
			JOptionPane.showMessageDialog(loginView, "El usuario no existe");
		}else {
			JOptionPane.showMessageDialog(loginView, "Bienvenido");
			this.loginView.closeWindow();
			this.userMenuController = new UserMenuController();
		}
		
	}
	
}
