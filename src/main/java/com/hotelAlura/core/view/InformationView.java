package com.hotelAlura.core.view;

//import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
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

public class InformationView extends JFrame {

	private JPanel contentPane;
	JPanel panelTopMenu;
	
	private int topMenuX;
	private int topMenuY;
	private JLabel lblMessage;
	private JPanel panelAceptar;
	private JLabel lblAceptar;
	private JLabel lblExit;
	
	/**
	 * Create the frame.
	 */
	public InformationView() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 394, 226);
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
		background.setBounds(0, 0, 394, 226);
		contentPane.add(background);
		background.setLayout(null);
		
		panelTopMenu = new JPanel();
		panelTopMenu.setBounds(0, 0, 365, 42);
		panelTopMenu.setBackground(new Color(240, 240, 240));
		panelTopMenu.setOpaque(false);
		background.add(panelTopMenu);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(150, 21, 100, 100);
		lblNewLabel.setIcon(new ImageIcon(".\\src\\main\\resources\\images\\Ha-100px.png"));
		background.add(lblNewLabel);
		
		lblMessage = new JLabel("Datos guardados satisfactoriamente");
		lblMessage.setBounds(27, 122, 367, 21);
		lblMessage.setForeground(new Color (12, 138, 199));
		lblMessage.setFont(new Font("Arial", Font.BOLD, 18));
		background.add(lblMessage);
		
		
		panelAceptar = new JPanel();
		panelAceptar.setBounds(150, 166, 100, 50);
		panelAceptar.setBackground(new Color(0, 128, 255));
		panelAceptar.setForeground(new Color(0, 128, 255));
		background.add(panelAceptar);
		panelAceptar.setLayout(null);
		
		lblAceptar = new JLabel("Aceptar");
		lblAceptar.setBounds(0, 0, 100, 50);
		panelAceptar.add(lblAceptar);
		lblAceptar.setForeground(new Color(255, 255, 255));
		lblAceptar.setHorizontalAlignment(SwingConstants.CENTER);
		lblAceptar.setFont(new Font("Arial", Font.PLAIN, 22));
		lblAceptar.requestFocusInWindow();
		
		lblExit = new JLabel("X");
		lblExit.setHorizontalAlignment(SwingConstants.CENTER);
		lblExit.setForeground(new Color(0, 0, 0));
		lblExit.setBounds(366, 0, 28, 42);
		background.add(lblExit);
		lblExit.setFont(new Font("Arial", Font.BOLD, 26));
		
		handleTopMenu();
		centerWindow();
		handleExitHover();
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
	private void handleExitHover() {
		this.lblExit.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseExited(MouseEvent e) {
				lblExit.setForeground(new Color(0,0,0));
				
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
	
	
	public JLabel getLblMessage() {
		return lblMessage;
	}


	public void setLblMessage(JLabel lblMessage) {
		this.lblMessage = lblMessage;
	}

	public void setTxtMessagge(String msg) {
		this.lblMessage.setText(msg);
	}

	public JPanel getPanelAceptar() {
		return panelAceptar;
	}


	public void setPanelAceptar(JPanel panelAceptar) {
		this.panelAceptar = panelAceptar;
	}
	
	public static void main(String[] args) {
		new InformationView();
	}
}

