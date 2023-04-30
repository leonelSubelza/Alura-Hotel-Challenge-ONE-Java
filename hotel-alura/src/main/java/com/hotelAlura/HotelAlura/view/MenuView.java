package com.hotelAlura.HotelAlura.view;

//import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.Font;
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
import java.awt.SystemColor;

public class MenuView extends JFrame {

	private JPanel contentPane;
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
		MenuView frame = new MenuView();
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
		lblLogo.setIcon(new ImageIcon("F:\\escritorio\\lio\\github proyectos\\Alura-Hotel-Challenge-ONE-Java\\hotel-alura\\src\\main\\resources\\images\\aH-150px.png"));
		lblLogo.setBounds(49, 82, 150, 166);
		panelLogoDer.add(lblLogo);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setForeground(new Color(0, 128, 255));
		lblLogin.setFont(new Font("Arial", Font.PLAIN, 27));
		lblLogin.setBounds(81, 281, 96, 39);
		panelLogoDer.add(lblLogin);
		
		JLabel lblLoginIcon = new JLabel("");
		lblLoginIcon.setIcon(new ImageIcon("F:\\escritorio\\lio\\github proyectos\\Alura-Hotel-Challenge-ONE-Java\\hotel-alura\\src\\main\\resources\\images\\login.png"));
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
		lblMainIcon.setIcon(new ImageIcon("F:\\escritorio\\lio\\github proyectos\\Alura-Hotel-Challenge-ONE-Java\\hotel-alura\\src\\main\\resources\\images\\menu-img.png"));
		lblMainIcon.setBounds(-12, 0, 736, 517);
		background.add(lblMainIcon);
		
		handleTopMenu();
		handleExitHover();
		centerWindow();
		
		
		this.setVisible(true);
	}


	private void centerWindow() {
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
	    this.setLocation(x, y);
		
	}


	private void handleExitHover() {
		this.lblExit.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseExited(MouseEvent e) {
				lblExit.setForeground(new Color(0, 0, 0));
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				lblExit.setForeground(new Color(140, 140, 140));
			}
			
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

}

