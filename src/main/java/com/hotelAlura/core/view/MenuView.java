package com.hotelAlura.core.view;

//import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.hotelAlura.core.utils.ViewUtils;

import java.awt.Color;
import java.awt.Dimension;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class MenuView extends JFrame {

	private JPanel contentPane;
	private JLabel lblExit;
	JPanel panelTopMenu;
	
	private int topMenuX;
	private int topMenuY;
	
	private JLabel lblLogin;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		MenuView frame = new MenuView();
	}

	public MenuView() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 970, 554);
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
		background.setBackground(new Color(192, 192, 192));
		background.setBounds(0, 0, 970, 554);
		contentPane.add(background);
		background.setLayout(null);
		
		JPanel panelLogoDer = new JPanel();
		panelLogoDer.setBackground(new Color(255, 255, 255));
		panelLogoDer.setBounds(723, 0, 247, 517);
		background.add(panelLogoDer);
		panelLogoDer.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(".\\src\\main\\resources\\images\\aH-150px.png"));
		lblLogo.setBounds(49, 82, 150, 166);
		panelLogoDer.add(lblLogo);
		
		lblLogin = new JLabel("LOGIN");
		lblLogin.setForeground(new Color(0, 128, 255));
		lblLogin.setFont(new Font("Arial", Font.PLAIN, 27));
		lblLogin.setBounds(81, 281, 96, 39);
		lblLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lblLogin.setForeground(new Color(0, 128, 255));
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				lblLogin.setForeground(new Color(49,152,255));
			}
		});
		panelLogoDer.add(lblLogin);
		
		JLabel lblLoginIcon = new JLabel("");
		lblLoginIcon.setIcon(new ImageIcon(".\\src\\main\\resources\\images\\login.png"));
		lblLoginIcon.setBounds(91, 336, 64, 70);
		panelLogoDer.add(lblLoginIcon);
		
		lblExit = new JLabel("X");
		lblExit.setBounds(219, 0, 18, 39);
		panelLogoDer.add(lblExit);
		lblExit.setForeground(new Color(0, 0, 0));
		lblExit.setFont(new Font("Arial", Font.BOLD, 26));
		
		panelTopMenu = new JPanel();
		panelTopMenu.setBackground(new Color(240, 240, 240));
		panelTopMenu.setOpaque(false);
		panelTopMenu.setBounds(10, 0, 932, 42);
		background.add(panelTopMenu);
		
		JPanel panelContact = new JPanel();
		panelContact.setBackground(new Color(0, 128, 192));
		panelContact.setBounds(0, 517, 970, 37);
		background.add(panelContact);
		panelContact.setLayout(null);
		 
		JLabel lblNewLabel = new JLabel("Desarrollado por tu mama @2023");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 19));
		lblNewLabel.setBounds(137, 10, 589, 27);
		panelContact.add(lblNewLabel);
		
		JLabel lblMainIcon = new JLabel("");
		lblMainIcon.setIcon(new ImageIcon(".\\src\\main\\resources\\images\\menu-img.png"));
		lblMainIcon.setBounds(-12, 0, 736, 517);
		background.add(lblMainIcon);

		handleTopMenu();
		ViewUtils.handleExitHover(this.lblExit, new Color(0, 0, 0), new Color(140, 140, 140));
		ViewUtils.centerWindow(this);
		this.setVisible(true);
	}

	public void close() {
		this.setVisible(false);
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

	public JLabel getLblExit() {
		return this.lblExit;
	}

	public void setLblExit(JLabel lblExit) {
		this.lblExit = lblExit;
	}

	public JLabel getLblLogin() {
		return this.lblLogin;
	}

	public void setLblLogin(JLabel lblLogin) {
		this.lblLogin = lblLogin;
	}
	
}

