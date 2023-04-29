package com.hotelAlura.HotelAlura.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JSeparator;

public class LoginView extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtContrasena;
	private JPanel panelEntrar;
	private JLabel lblExit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the frame.
	 */
	public LoginView() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 831, 554);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setTitle("Hotel Alura");
		
		//quita los botones de minimiza, maximizar, cerrar
		this.setUndecorated(true);
		this.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel background = new JPanel();
		background.setBackground(new Color(255, 255, 255));
		background.setBounds(0, 0, 834, 554);
		contentPane.add(background);
		background.setLayout(null);
		
		panelEntrar = new JPanel();
		panelEntrar.setBackground(new Color(0, 128, 255));
		panelEntrar.setForeground(new Color(0, 128, 255));
		panelEntrar.setBounds(55, 433, 136, 53);
		background.add(panelEntrar);
		panelEntrar.setLayout(null);
		
		JLabel lblEntrar = new JLabel("Entrar");
		lblEntrar.setBounds(10, 10, 116, 33);
		panelEntrar.add(lblEntrar);
		lblEntrar.setForeground(new Color(255, 255, 255));
		lblEntrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEntrar.setFont(new Font("Arial", Font.PLAIN, 25));
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setIcon(new ImageIcon("F:\\escritorio\\lio\\github proyectos\\Alura-Hotel-Challenge-ONE-Java\\hotel-alura\\src\\main\\resources\\images\\lOGO-50PX.png"));
		lblLogo.setBounds(55, 52, 61, 53);
		background.add(lblLogo);
		
		JLabel lblIniciarSesion = new JLabel("INICIAR SESIÓN");
		lblIniciarSesion.setForeground(new Color(0, 128, 255));
		lblIniciarSesion.setFont(new Font("Arial", Font.BOLD, 28));
		lblIniciarSesion.setBounds(53, 115, 226, 53);
		background.add(lblIniciarSesion);
		
		JLabel lblUsuario = new JLabel("USUARIO");
		lblUsuario.setForeground(new Color(108, 108, 108));
		lblUsuario.setFont(new Font("Arial", Font.BOLD, 22));
		lblUsuario.setBounds(56, 206, 110, 43);
		background.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		txtUsuario.setBackground(new Color(255, 255, 255));
		txtUsuario.setForeground(new Color(192, 192, 192));
		txtUsuario.setFont(new Font("Arial", Font.PLAIN, 14));
		txtUsuario.setText("Ingrese su nombre de usuario");
		txtUsuario.setBorder(null);
		txtUsuario.setBounds(56, 248, 364, 31);
		background.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 128, 255));
		separator.setForeground(new Color(0, 128, 255));
		separator.setBounds(56, 289, 351, 2);
		background.add(separator);
		
		JPanel panelLogoDer = new JPanel();
		panelLogoDer.setBackground(new Color(0, 128, 192));
		panelLogoDer.setBounds(504, 0, 329, 554);
		background.add(panelLogoDer);
		panelLogoDer.setLayout(null);
		
		JLabel lblIconoDer = new JLabel("");
		lblIconoDer.setVerticalAlignment(SwingConstants.BOTTOM);
		lblIconoDer.setIcon(new ImageIcon("F:\\escritorio\\lio\\github proyectos\\Alura-Hotel-Challenge-ONE-Java\\hotel-alura\\src\\main\\resources\\images\\img-hotel-login-.png"));
		lblIconoDer.setBounds(27, 147, 280, 397);
		panelLogoDer.add(lblIconoDer);
		
		lblExit = new JLabel("X");
		lblExit.setForeground(new Color(230, 230, 230));
		lblExit.setBounds(284, 10, 23, 39);
		panelLogoDer.add(lblExit);
		lblExit.setFont(new Font("Arial", Font.BOLD, 26));
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(0, 128, 255));
		separator_1.setBackground(new Color(0, 128, 255));
		separator_1.setBounds(56, 394, 351, 2);
		background.add(separator_1);
		
		txtContrasena = new JTextField();
		txtContrasena.setText("Ingrese su contraseña");
		txtContrasena.setHorizontalAlignment(SwingConstants.LEFT);
		txtContrasena.setForeground(Color.LIGHT_GRAY);
		txtContrasena.setFont(new Font("Arial", Font.PLAIN, 14));
		txtContrasena.setColumns(10);
		txtContrasena.setBorder(null);
		txtContrasena.setBackground(Color.WHITE);
		txtContrasena.setBounds(56, 353, 364, 31);
		background.add(txtContrasena);
		
		JLabel lblContrasena = new JLabel("CONTRASEÑA");
		lblContrasena.setForeground(new Color(108, 108, 108));
		lblContrasena.setFont(new Font("Arial", Font.BOLD, 22));
		lblContrasena.setBounds(56, 311, 173, 43);
		background.add(lblContrasena);
		

		/*
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int confirm = JOptionPane.showOptionDialog(null, "¿Estás seguro que quieres salir?", "Advertencia",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
				if (confirm == 0) {
					System.exit(0);
				}
			}
		});
		*/

		
		this.setVisible(true);
	}

	
	public void closeWindow() {
		this.setVisible(false);
	}
	
	public JTextField getTxtUsuario() {
		return this.txtUsuario;
	}

	public void setTxtUsuario(JTextField txtUsuario) {
		this.txtUsuario = txtUsuario;
	}

	public JTextField getTxtContrasena() {
		return this.txtContrasena;
	}

	public void setTxtContrasena(JTextField txtContrasena) {
		this.txtContrasena = txtContrasena;
	}

	public JPanel getPanelEntrar() {
		return this.panelEntrar;
	}

	public JLabel getLblExit() {
		return this.lblExit;
	}
	
	public JFrame getWindow(){
		return this;
	}
}

