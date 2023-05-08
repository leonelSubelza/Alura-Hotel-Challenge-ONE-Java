package com.hotelAlura.HotelAlura.view;

//import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
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
import javax.swing.border.LineBorder;

public class UserMenuView extends JFrame {

	private JPanel contentPane;
	private JLabel lblExit;
	JPanel panelTopMenu;
	
	private JPanel panelRegistroReservas;
	private JPanel panelBusqueda;
	private JLabel lblFecha;
	
	private int topMenuX;
	private int topMenuY;
	private JPanel panelSalir;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
		UserMenuView frame = new UserMenuView();
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
	public UserMenuView() {
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
		
		JPanel panelLeft = new JPanel();
		panelLeft.setBackground(new Color(12, 138, 199));
		panelLeft.setBounds(0, 0, 247, 554);
		background.add(panelLeft);
		panelLeft.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(".\\src\\main\\resources\\images\\aH-150px.png"));
		lblLogo.setBounds(49, 42, 150, 166);
		panelLeft.add(lblLogo);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(255, 255, 255));
		separator.setBounds(24, 214, 213, 9);
		panelLeft.add(separator);
		
		panelRegistroReservas = new JPanel();
		panelRegistroReservas.setBounds(28, 243, 209, 32);
		panelRegistroReservas.setOpaque(false);
		panelLeft.add(panelRegistroReservas);
		panelRegistroReservas.setLayout(null);
		
		JLabel lblReservasIcon = new JLabel("");
		lblReservasIcon.setIcon(new ImageIcon(".\\src\\main\\resources\\images\\icon-reservas.png"));
		lblReservasIcon.setBounds(0, 0, 39, 32);
		panelRegistroReservas.add(lblReservasIcon);
		
		JLabel lblNewLabel = new JLabel("Registro de reservas");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(42, 0, 167, 32);
		panelRegistroReservas.add(lblNewLabel);
		
		panelBusqueda = new JPanel();
		panelBusqueda.setLayout(null);
		panelBusqueda.setOpaque(false);
		panelBusqueda.setBounds(28, 294, 209, 32);
		panelLeft.add(panelBusqueda);
		
		JLabel lblBusquedaIcon = new JLabel("");
		lblBusquedaIcon.setIcon(new ImageIcon(".\\src\\main\\resources\\images\\icon-buscar.png"));
		lblBusquedaIcon.setBounds(8, 0, 24, 32);
		panelBusqueda.add(lblBusquedaIcon);
		
		JLabel lblBsqueda = new JLabel("Búsqueda");
		lblBsqueda.setForeground(Color.WHITE);
		lblBsqueda.setFont(new Font("Arial", Font.PLAIN, 17));
		lblBsqueda.setBounds(42, 0, 167, 32);
		panelBusqueda.add(lblBsqueda);
		
		panelSalir = new JPanel();
		panelSalir.setBounds(83, 409, 60, 76);
		panelSalir.setOpaque(false);
		panelLeft.add(panelSalir);
		panelSalir.setLayout(null);
		
		JLabel lblIconSalir = new JLabel("");
		lblIconSalir.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconSalir.setIcon(new ImageIcon(".\\src\\main\\resources\\images\\cerrar-sesion 32-px.png"));
		lblIconSalir.setBounds(0, 0, 60, 48);
		panelSalir.add(lblIconSalir);
		
		JLabel lblSalir = new JLabel("SALIR");
		lblSalir.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalir.setBounds(0, 49, 60, 27);
		lblSalir.setForeground(Color.WHITE);
		lblSalir.setFont(new Font("Arial", Font.PLAIN, 17));
		panelSalir.add(lblSalir);
		
		panelTopMenu = new JPanel();
		panelTopMenu.setBackground(new Color(240, 240, 240));
		panelTopMenu.setOpaque(false);
		panelTopMenu.setBounds(10, 0, 932, 42);
		background.add(panelTopMenu);
		
		JPanel panelDer = new JPanel();
		panelDer.setBackground(new Color(255, 255, 255));
		panelDer.setBounds(244, 0, 726, 554);
		background.add(panelDer);
		panelDer.setLayout(null);
		
		lblExit = new JLabel("X");
		lblExit.setBounds(698, 10, 18, 39);
		panelDer.add(lblExit);
		lblExit.setForeground(new Color(0, 0, 0));
		lblExit.setFont(new Font("Arial", Font.BOLD, 26));
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setBackground(new Color(118, 187, 223));
		panelTitulo.setBounds(0, 77, 726, 107);
		panelDer.add(panelTitulo);
		panelTitulo.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Sistema de reservas Hotel Alura");
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Arial", Font.PLAIN, 23));
		lblTitulo.setBounds(47, 10, 584, 24);
		panelTitulo.add(lblTitulo);
		
		JLabel lblNewLabel_1 = new JLabel("Hoy es");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 34));
		lblNewLabel_1.setBounds(21, 47, 141, 50);
		panelTitulo.add(lblNewLabel_1);
		
		lblFecha = new JLabel("");
		lblFecha.setForeground(new Color(255, 255, 255));
		lblFecha.setFont(new Font("Arial", Font.PLAIN, 34));
		lblFecha.setBounds(165, 44, 551, 53);
		panelTitulo.add(lblFecha);
		
		JLabel lblBienvenido = new JLabel("Bienvenido");
		lblBienvenido.setForeground(new Color(0, 0, 0));
		lblBienvenido.setFont(new Font("Arial", Font.BOLD, 24));
		lblBienvenido.setBounds(36, 209, 167, 39);
		panelDer.add(lblBienvenido);
		
		JLabel lblInfo = new JLabel(
				"<html>"
				+ "Sistema de reservas de hotel. Controle y administre de forma óptima y fácil <br/>"
				+ "el flujo de reservas y de huéspedes del hotel <br/>"
				+ "<br/>"
				+ "Esta herramienta le permitirá llevar un control completo y detallado de sus <br/>"
				+ "reservas y huéspedes, tendrá acceso a herramientas especiales para tareas <br/>"
				+ "específicas como lo son:<br/>"
				+ "<br/>"
				+ "- Registro de Reservas y Huéspedes<br/>"
				+ "<br/>"
				+ "- Edición de Reservas y Huéspedes existentes<br/>"
				+ "<br/>"
				+ "- Eliminar todo tipo de registros"
				+ "</html>");
		lblInfo.setFont(new Font("Arial", Font.PLAIN, 19));
		lblInfo.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfo.setBounds(36, 259, 680, 285);
		panelDer.add(lblInfo);
		
		handleInputHover();
		handleTopMenu();
		handleExitHover();
		centerWindow();
		
		
		this.setVisible(true);
	}

	public void closeWindow() {
		this.setVisible(false);
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

	public void handleInputHover() {
		this.panelRegistroReservas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				panelRegistroReservas.setBorder(null);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				panelRegistroReservas.setBorder(new LineBorder(new Color(255, 255, 255)));
			}
		});
		
		this.panelBusqueda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				panelBusqueda.setBorder(null);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				panelBusqueda.setBorder(new LineBorder(new Color(255, 255, 255)));
			}
		});
		this.panelSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				panelSalir.setBorder(null);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				panelSalir.setBorder(new LineBorder(new Color(255, 255, 255)));
			}
		});
	}
	

	public JPanel getPanelRegistroReservas() {
		return panelRegistroReservas;
	}


	public void setPanelRegistroReservas(JPanel panelRegistroReservas) {
		this.panelRegistroReservas = panelRegistroReservas;
	}


	public JPanel getPanelBusqueda() {
		return panelBusqueda;
	}


	public void setPanelBusqueda(JPanel panelBusqueda) {
		this.panelBusqueda = panelBusqueda;
	}


	public JLabel getLblFecha() {
		return lblFecha;
	}


	public void setLblFecha(JLabel lblFecha) {
		this.lblFecha = lblFecha;
	}


	public JLabel getLblExit() {
		return lblExit;
	}


	public void setLblExit(JLabel lblExit) {
		this.lblExit = lblExit;
	}


	public JPanel getPanelSalir() {
		return panelSalir;
	}


	public void setPanelSalir(JPanel panelSalir) {
		this.panelSalir = panelSalir;
	}
	
	
}

