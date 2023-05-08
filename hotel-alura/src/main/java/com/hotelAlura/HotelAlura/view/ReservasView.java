package com.hotelAlura.HotelAlura.view;

//import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JComboBox;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JSeparator;

import java.awt.SystemColor;
import javax.swing.DefaultComboBoxModel;

public class ReservasView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JPanel panelTopMenu;
	
	private int topMenuX;
	private int topMenuY;
		
	
	public static JTextField txtValor;
	public static JDateChooser txtFechaEntrada;
	public static JDateChooser txtFechaSalida;
	public static JComboBox<String> txtFormaPago;
	
	private JLabel lblExit;
	private JLabel lblBack;
	private JPanel panelSiguiente;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
		ReservasView frame = new ReservasView();
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
	public ReservasView() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 560);
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
		background.setBounds(0, 0, 910, 560);
		contentPane.add(background);
		background.setLayout(null);
		
		panelTopMenu = new JPanel();
		panelTopMenu.setBounds(24, 0, 835, 42);
		panelTopMenu.setBackground(new Color(240, 240, 240));
		panelTopMenu.setOpaque(false);
		background.add(panelTopMenu);
		
		lblExit = new JLabel("X");
		lblExit.setBounds(869, 3, 31, 39);
		lblExit.setForeground(Color.BLACK);
		lblExit.setFont(new Font("Arial", Font.BOLD, 26));
		background.add(lblExit);
		
		lblBack = new JLabel("<");
		lblBack.setFont(new Font("Arial", Font.BOLD, 26));
		lblBack.setHorizontalAlignment(SwingConstants.CENTER);
		lblBack.setBounds(0, 0, 27, 42);
		background.add(lblBack);
		
		JPanel panelIzq = new JPanel();
		panelIzq.setBackground(new Color(255, 255, 255));
		panelIzq.setBounds(0, 0, 445, 560);
		background.add(panelIzq);
		panelIzq.setLayout(null);
		
		JLabel lblTitulo = new JLabel("SISTEMA DE RESERVAS");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(72, 59, 282, 42);
		lblTitulo.setForeground(new Color(12, 138, 199));
		lblTitulo.setFont(new Font("Roboto", Font.BOLD, 20));
		panelIzq.add(lblTitulo);
		
		panelSiguiente = new JPanel();
		panelSiguiente.setBounds(297, 502, 126, 42);
		panelIzq.add(panelSiguiente);
		panelSiguiente.setLayout(null);
		panelSiguiente.setBackground(new Color(0, 128, 255));
		
		JLabel lblSiguiente = new JLabel("SIGUIENTE");
		lblSiguiente.setHorizontalAlignment(SwingConstants.CENTER);
		lblSiguiente.setForeground(Color.WHITE);
		lblSiguiente.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblSiguiente.setBounds(0, 0, 126, 42);
		panelSiguiente.add(lblSiguiente);
		
		JPanel panelDer = new JPanel();
		panelDer.setBounds(444, 0, 466, 560);
		panelDer.setBackground(new Color(12, 138, 199));
		background.add(panelDer);
		panelDer.setLayout(null);
		
		JLabel lblTituloIcon = new JLabel("");
		lblTituloIcon.setBounds(197, 68, 104, 107);
		panelDer.add(lblTituloIcon);
		lblTituloIcon.setIcon(new ImageIcon(".\\src\\main\\resources\\images\\Ha-100px.png"));
		
		JLabel imagenFondo = new JLabel("");
		imagenFondo.setIcon(new ImageIcon(".\\src\\main\\resources\\images\\reservas-img-3.png"));
		imagenFondo.setBounds(0, 140, 466, 409);
		panelDer.add(imagenFondo);
		imagenFondo.setBackground(Color.WHITE);
		
		
		
		
		JLabel lblCheckIn = new JLabel("FECHA DE CHECK IN");
		lblCheckIn.setForeground(SystemColor.textInactiveText);
		lblCheckIn.setBounds(68, 136, 286, 14);
		lblCheckIn.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		panelIzq.add(lblCheckIn);
		
		JLabel lblCheckOut = new JLabel("FECHA DE CHECK OUT");
		lblCheckOut.setForeground(SystemColor.textInactiveText);
		lblCheckOut.setBounds(68, 221, 286, 14);
		lblCheckOut.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		panelIzq.add(lblCheckOut);
		
		JLabel lblFormaPago = new JLabel("FORMA DE PAGO");
		lblFormaPago.setForeground(SystemColor.textInactiveText);
		lblFormaPago.setBounds(68, 382, 187, 24);
		lblFormaPago.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		panelIzq.add(lblFormaPago);
		
		JLabel lblValor = new JLabel("VALOR DE LA RESERVA");
		lblValor.setForeground(SystemColor.textInactiveText);
		lblValor.setBounds(68, 305, 282, 14);
		lblValor.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		panelIzq.add(lblValor);
		
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setForeground(SystemColor.textHighlight);
		separator_1_2.setBounds(68, 195, 289, 2);
		separator_1_2.setBackground(SystemColor.textHighlight);
		panelIzq.add(separator_1_2);
		
		JSeparator separator_1_3 = new JSeparator();
		separator_1_3.setForeground(SystemColor.textHighlight);
		separator_1_3.setBackground(SystemColor.textHighlight);
		separator_1_3.setBounds(68, 453, 289, 2);
		panelIzq.add(separator_1_3);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setForeground(SystemColor.textHighlight);
		separator_1_1.setBounds(68, 281, 289, 11);
		separator_1_1.setBackground(SystemColor.textHighlight);
		panelIzq.add(separator_1_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(SystemColor.textHighlight);
		separator_1.setBounds(68, 362, 289, 2);
		separator_1.setBackground(SystemColor.textHighlight);
		panelIzq.add(separator_1);
		
		
		//Campos que guardaremos en la base de datos
		txtFechaEntrada = new JDateChooser();
		txtFechaEntrada.getCalendarButton().setBackground(SystemColor.textHighlight);
		txtFechaEntrada.getCalendarButton()
				.setIcon(new ImageIcon(".\\src\\main\\resources\\images\\icon-reservas.png"));
		txtFechaEntrada.getCalendarButton().setFont(new Font("Roboto", Font.PLAIN, 12));
		txtFechaEntrada.setBounds(68, 161, 289, 35);
		txtFechaEntrada.getCalendarButton().setBounds(268, 0, 21, 33);
		txtFechaEntrada.setBackground(Color.WHITE);
		txtFechaEntrada.setBorder(new LineBorder(SystemColor.window));
		txtFechaEntrada.setDateFormatString("yyyy-MM-dd");
		txtFechaEntrada.setFont(new Font("Roboto", Font.PLAIN, 18));
		panelIzq.add(txtFechaEntrada);
		
		txtFechaSalida = new JDateChooser();
		txtFechaSalida.getCalendarButton().setIcon(new ImageIcon(".\\src\\main\\resources\\images\\icon-reservas.png"));
		txtFechaSalida.getCalendarButton().setFont(new Font("Roboto", Font.PLAIN, 11));
		txtFechaSalida.setBounds(68, 246, 289, 35);
		txtFechaSalida.getCalendarButton().setBounds(267, 1, 21, 31);
		txtFechaSalida.setBackground(Color.WHITE);
		txtFechaSalida.setFont(new Font("Roboto", Font.PLAIN, 18));
		txtFechaSalida.addPropertyChangeListener((PropertyChangeListener) new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				//Activa el evento, después del usuario seleccionar las fechas se debe calcular el valor de la reserva
			}
		});
		txtFechaSalida.setDateFormatString("yyyy-MM-dd");
		txtFechaSalida.getCalendarButton().setBackground(SystemColor.textHighlight);
		txtFechaSalida.setBorder(new LineBorder(new Color(255, 255, 255), 0));
		panelIzq.add(txtFechaSalida);

		txtValor = new JTextField();
		txtValor.setBackground(SystemColor.text);
		txtValor.setHorizontalAlignment(SwingConstants.CENTER);
		txtValor.setForeground(Color.BLACK);
		txtValor.setBounds(78, 328, 79, 33);
		txtValor.setEditable(false);
		txtValor.setFont(new Font("Roboto Black", Font.BOLD, 17));
		txtValor.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panelIzq.add(txtValor);
		txtValor.setColumns(10);


		txtFormaPago = new JComboBox();
		txtFormaPago.setBounds(68, 417, 289, 38);
		txtFormaPago.setBackground(SystemColor.text);
		txtFormaPago.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		txtFormaPago.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtFormaPago.setModel(new DefaultComboBoxModel(new String[] {"Tarjeta de Crédito", "Tarjeta de Débito", "Dinero en efectivo"}));
		panelIzq.add(txtFormaPago);
		
		
		handleTopMenu();
		handleExitHover();
		centerWindow();
		handleBackBtn();
		
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


	public void handleBackBtn() {
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				MenuUsuario usuario = new MenuUsuario();
//				usuario.setVisible(true);
				dispose();				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
//				btnAtras.setBackground(new Color(12, 138, 199));
				lblBack.setForeground(new Color(140, 140, 140));
			}			
			@Override
			public void mouseExited(MouseEvent e) {
//				 btnAtras.setBackground(Color.white);
				 lblBack.setForeground(Color.black);
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


	public static JTextField getTxtValor() {
		return txtValor;
	}


	public static void setTxtValor(JTextField txtValor) {
		ReservasView.txtValor = txtValor;
	}


	public static JDateChooser getTxtFechaEntrada() {
		return txtFechaEntrada;
	}


	public static void setTxtFechaEntrada(JDateChooser txtFechaEntrada) {
		ReservasView.txtFechaEntrada = txtFechaEntrada;
	}


	public static JDateChooser getTxtFechaSalida() {
		return txtFechaSalida;
	}


	public static void setTxtFechaSalida(JDateChooser txtFechaSalida) {
		ReservasView.txtFechaSalida = txtFechaSalida;
	}


	public static JComboBox<String> getTxtFormaPago() {
		return txtFormaPago;
	}


	public static void setTxtFormaPago(JComboBox<String> txtFormaPago) {
		ReservasView.txtFormaPago = txtFormaPago;
	}


	public JLabel getLblExit() {
		return lblExit;
	}


	public void setLblExit(JLabel lblExit) {
		this.lblExit = lblExit;
	}


	public JLabel getLblBack() {
		return lblBack;
	}


	public void setLblBack(JLabel lblBack) {
		this.lblBack = lblBack;
	}


	public JPanel getPanelSiguiente() {
		return panelSiguiente;
	}


	public void setPanelSiguiente(JPanel panelSiguiente) {
		this.panelSiguiente = panelSiguiente;
	}
	
	
	
	
	
}

