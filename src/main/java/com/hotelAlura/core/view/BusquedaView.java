package com.hotelAlura.core.view;

//import java.awt.EventQueue;
import com.hotelAlura.core.utils.ViewUtils;

import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

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
import javax.swing.ListSelectionModel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BusquedaView extends JFrame {

	private JPanel contentPane;
	JPanel panelTopMenu;
	
	private int topMenuX;
	private int topMenuY;
	
	private DefaultTableModel modelo;
	private DefaultTableModel modeloHuesped;
	private JTable tbHuespedes;
	private JTable tbReservas;
	
	private JTabbedPane panel;

	private JLabel lblExit;
	private JLabel lblBack;
	private JTextField txtBusqueda;
	private JPanel panelBuscar;
	private JPanel panelEditar;
	private JPanel panelEliminar;

	List<Object> colReservas = Arrays.asList("Numero de Reserva","Fecha Check In","Fecha Check Out","Valor","Forma de Pago");
	List<Object> colHuespedes = Arrays.asList("Número de Huesped","Nombre","Apellido","Fecha de Nacimiento","Nacionalidad","Telefono","Número de Reserva");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		BusquedaView frame = new BusquedaView();
					frame.setVisible(true);
	}

	public BusquedaView() {
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
		background.setBackground(new Color(255, 255, 255));
		background.setBounds(0, 0, 970, 554);
		contentPane.add(background);
		background.setLayout(null);
		
		panelTopMenu = new JPanel();
		panelTopMenu.setBounds(24, 0, 918, 42);
		panelTopMenu.setBackground(new Color(240, 240, 240));
		panelTopMenu.setOpaque(false);
		background.add(panelTopMenu);
		
		lblExit = new JLabel("X");
		lblExit.setHorizontalAlignment(SwingConstants.CENTER);
		lblExit.setBounds(943, 0, 27, 39);
		lblExit.setForeground(Color.BLACK);
		lblExit.setFont(new Font("Arial", Font.BOLD, 26));
		background.add(lblExit);
		
		lblBack = new JLabel("<");
		lblBack.setFont(new Font("Arial", Font.BOLD, 26));
		lblBack.setHorizontalAlignment(SwingConstants.CENTER);
		lblBack.setBounds(0, 0, 27, 42);
		background.add(lblBack);
		
		JLabel lblTitulo = new JLabel("SISTEMA DE BÚSQUEDA");
		lblTitulo.setForeground(new Color(0, 128, 255));
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 28));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(256, 71, 521, 42);
		background.add(lblTitulo);
		
		JLabel lblTituloIcon = new JLabel("");
		lblTituloIcon.setIcon(new ImageIcon(".\\src\\main\\resources\\images\\Ha-100px.png"));
		lblTituloIcon.setBounds(96, 52, 100, 106);
		background.add(lblTituloIcon);
		
		panelBuscar = new JPanel();
		panelBuscar.setBackground(new Color(0, 128, 255));
		panelBuscar.setBounds(822, 131, 138, 42);
		background.add(panelBuscar);
		panelBuscar.setLayout(null);
		
		JLabel lblBuscar = new JLabel("BUSCAR");
		lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscar.setForeground(new Color(255, 255, 255));
		lblBuscar.setFont(new Font("Arial", Font.PLAIN, 22));
		lblBuscar.setBounds(0, 0, 138, 42);
		panelBuscar.add(lblBuscar);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 128, 255));
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(562, 171, 250, 9);
		background.add(separator);
		
		txtBusqueda = new JTextField();
		txtBusqueda.setFont(new Font("Arial", Font.PLAIN, 16));
		txtBusqueda.setHorizontalAlignment(SwingConstants.LEFT);
		txtBusqueda.setBounds(562, 141, 250, 29);
		txtBusqueda.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		background.add(txtBusqueda);
		txtBusqueda.setColumns(10);

		panel = new JTabbedPane(JTabbedPane.TOP);
		panel.setBounds(24, 182, 936, 297);
		background.add(panel);
		panel.setBackground(new Color(12, 138, 199));
		panel.setFont(new Font("Roboto", Font.PLAIN, 16));

		tbReservas = new JTable();
		tbReservas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbReservas.setFont(new Font("Roboto", Font.PLAIN, 16));
		modelo = (DefaultTableModel) tbReservas.getModel();
		
		JScrollPane scroll_table = new JScrollPane(tbReservas);
		panel.addTab("Reservas", new ImageIcon(".\\src\\main\\resources\\images\\reservado.png"), scroll_table, null);
		panel.setBackgroundAt(0, new Color(0, 128, 255));
		scroll_table.setVisible(true);

		tbHuespedes = new JTable();
		tbHuespedes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbHuespedes.setFont(new Font("Roboto", Font.PLAIN, 16));
		modeloHuesped = (DefaultTableModel) tbHuespedes.getModel();
		JScrollPane scroll_tableHuespedes = new JScrollPane(tbHuespedes);
		panel.addTab("Huéspedes", new ImageIcon(".\\src\\main\\resources\\images\\pessoas.png"), scroll_tableHuespedes, null);
		panel.setBackgroundAt(1, new Color(0, 128, 255));
		
		panelEliminar = new JPanel();
		panelEliminar.setLayout(null);
		panelEliminar.setBackground(new Color(0, 128, 255));
		panelEliminar.setBounds(822, 489, 138, 42);
		background.add(panelEliminar);
		
		JLabel lblEliminar = new JLabel("ELIMINAR");
		lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminar.setForeground(Color.WHITE);
		lblEliminar.setFont(new Font("Arial", Font.PLAIN, 22));
		lblEliminar.setBounds(0, 0, 138, 42);
		panelEliminar.add(lblEliminar);
		
		panelEditar = new JPanel();
		panelEditar.setLayout(null);
		panelEditar.setBackground(new Color(0, 128, 255));
		panelEditar.setBounds(661, 489, 138, 42);
		background.add(panelEditar);
		
		JLabel lblEditar = new JLabel("EDITAR");
		lblEditar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditar.setForeground(Color.WHITE);
		lblEditar.setFont(new Font("Arial", Font.PLAIN, 22));
		lblEditar.setBounds(0, 0, 138, 42);
		panelEditar.add(lblEditar);
		scroll_tableHuespedes.setVisible(true);

		colReservas.forEach(e ->modelo.addColumn(e));
		colHuespedes.forEach(e -> modeloHuesped.addColumn(e));

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(".\\src\\main\\resources\\images\\Ha-100px.png"));
		lblNewLabel_2.setBounds(56, 51, 104, 107);
		contentPane.add(lblNewLabel_2);

		handleTopMenu();
		ViewUtils.setHoverToButton(this.panelBuscar, new Color(0, 128, 255), new Color(2, 114, 224),lblBuscar, Color.WHITE, Color.WHITE);
		ViewUtils.setHoverToButton(this.panelEditar, new Color(0, 128, 255), new Color(2, 114, 224),lblEditar, Color.WHITE, Color.WHITE);
		ViewUtils.setHoverToButton(this.panelEliminar, new Color(0, 128, 255), new Color(2, 114, 224),lblEliminar, Color.WHITE, Color.WHITE);
		ViewUtils.handleBackBtn(this,lblBack);
		ViewUtils.handleExitHover(this.lblExit,new Color(0, 0, 0),new Color(140, 140, 140));
		ViewUtils.centerWindow(this);

		this.setVisible(true);
	}

	public void closeWindow() {
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

	public DefaultTableModel getModelo() {
		return modelo;
	}

	public void setModelo(DefaultTableModel modelo) {
		this.modelo = modelo;
	}

	public DefaultTableModel getModeloHuesped() {
		return modeloHuesped;
	}

	public void setModeloHuesped(DefaultTableModel modeloHuesped) {
		this.modeloHuesped = modeloHuesped;
	}

	public JTable getTbHuespedes() {
		return tbHuespedes;
	}

	public void setTbHuespedes(JTable tbHuespedes) {
		this.tbHuespedes = tbHuespedes;
	}

	public JTable getTbReservas() {
		return tbReservas;
	}

	public void setTbReservas(JTable tbReservas) {
		this.tbReservas = tbReservas;
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

	public JTextField getTxtBusqueda() {
		return txtBusqueda;
	}

	public void setTxtBusqueda(JTextField txtBusqueda) {
		this.txtBusqueda = txtBusqueda;
	}

	public JPanel getPanelBuscar() {
		return panelBuscar;
	}

	public void setPanelBuscar(JPanel panelBuscar) {
		this.panelBuscar = panelBuscar;
	}

	public JPanel getPanelEditar() {
		return panelEditar;
	}

	public void setPanelEditar(JPanel panelEditar) {
		this.panelEditar = panelEditar;
	}

	public JPanel getPanelEliminar() {
		return panelEliminar;
	}

	public void setPanelEliminar(JPanel panelEliminar) {
		this.panelEliminar = panelEliminar;
	}

	public JTabbedPane getPanel() {
		return panel;
	}

	public void setPanel(JTabbedPane panel) {
		this.panel = panel;
	}

	public JPanel getPanelTopMenu() {
		return panelTopMenu;
	}

	public void setPanelTopMenu(JPanel panelTopMenu) {
		this.panelTopMenu = panelTopMenu;
	}

	public int getTopMenuX() {
		return this.topMenuX;
	}

	public void setTopMenuX(int topMenuX) {
		this.topMenuX = topMenuX;
	}

	public int getTopMenuY() {
		return this.topMenuY;
	}

	public void setTopMenuY(int topMenuY) {
		this.topMenuY = topMenuY;
	}

	public List<Object> getColReservas() {
		return colReservas;
	}

	public List<Object> getColHuespedes() {
		return colHuespedes;
	}

}

