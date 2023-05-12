package com.hotelAlura.core.view;

//import java.awt.EventQueue;

import com.hotelAlura.core.utils.ViewUtils;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
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
	JPanel panelTopMenu;
	
	private int topMenuX;
	private int topMenuY;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
					LoginView frame = new LoginView();
					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
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
		contentPane.setLocation(0, 0);
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
		lblEntrar.requestFocusInWindow();
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setIcon(new ImageIcon(".\\src\\main\\resources\\images\\lOGO-50PX.png"));
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
		txtUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				 if (txtUsuario.getText().equals("Ingrese su nombre de usuario")) {
					 txtUsuario.setText("");
					 txtUsuario.setForeground(Color.black);
			        }
			        if (String.valueOf(((JPasswordField) txtContrasena).getPassword()).isEmpty()) {
			        	txtContrasena.setText("********");
			        	txtContrasena.setForeground(Color.gray);
			        }
			}
		});
		txtUsuario.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtUsuario.setText("Ingrese su nombre de usuario");
		txtUsuario.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtUsuario.setForeground(SystemColor.activeCaptionBorder);
		txtUsuario.setBounds(65, 256, 342, 32);
		
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
		lblIconoDer.setIcon(new ImageIcon(".\\src\\main\\resources\\images\\img-hotel-login-.png"));
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
		
		txtContrasena = new JPasswordField();
		txtContrasena.setText("********");
		txtContrasena.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (String.valueOf(((JPasswordField) txtContrasena).getPassword()).equals("********")) {
					txtContrasena.setText("");
					txtContrasena.setForeground(Color.black);
		        }
		        if (txtUsuario.getText().isEmpty()) {
		        	txtUsuario.setText("Ingrese su nombre de usuario");
		        	txtUsuario.setForeground(Color.gray);
		        }
			}
		});
		txtContrasena.setForeground(SystemColor.activeCaptionBorder);
		txtContrasena.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtContrasena.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtContrasena.setBounds(65, 353, 342, 32);
		background.add(txtContrasena);
		
		JLabel lblContrasena = new JLabel("CONTRASEÑA");
		lblContrasena.setForeground(new Color(108, 108, 108));
		lblContrasena.setFont(new Font("Arial", Font.BOLD, 22));
		lblContrasena.setBounds(56, 311, 173, 43);
		background.add(lblContrasena);
		
		panelTopMenu = new JPanel();
		panelTopMenu.setBackground(new Color(240, 240, 240));
		panelTopMenu.setOpaque(false);
		panelTopMenu.setBounds(10, 0, 778, 42);
		background.add(panelTopMenu);
		
		handleTopMenu();
		ViewUtils.setHoverToButton(panelEntrar,new Color(0, 128, 255),new Color(4, 115, 224),lblEntrar,Color.WHITE,Color.WHITE);
		ViewUtils.handleExitHover(this.lblExit, new Color(230, 230, 230), new Color(140, 140, 140));
		ViewUtils.centerWindow(this);
		this.setVisible(true);
	}

	private void handleTopMenu() {
		panelTopMenu.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x-topMenuX, y-topMenuY);
			}
		});
		
		panelTopMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				topMenuX = e.getX();
				topMenuY = e.getY();
			}			
		}); 
		
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

