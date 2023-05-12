package com.hotelAlura.core.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Properties;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

import com.hotelAlura.core.dao.ReservaDAO;
import com.hotelAlura.core.model.Reserva;
import com.hotelAlura.core.utils.JPAUtils;
import com.hotelAlura.core.view.ReservasView;

public class ReservasController {

	private ReservasView reservasView;
	private UserMenuController userMenuController;
	
	private Reserva reserva;
	private EntityManager em;
	private ReservaDAO reservaDAO;
	private RegistroHuespedesController registroHuespedesController;
	
	private LocalDate fechaEntrada;
	private LocalDate fechaSalida;
	private double price;
	
	public ReservasController() {
		System.out.println("se inicia controller de reservas");
		System.out.println();
		this.reserva = new Reserva();
		this.reservasView = new ReservasView();	
		em = JPAUtils.getEntityManager();
		reservaDAO = new ReservaDAO(em);
		iniciar();
	}

	private void iniciar() {
		this.reservasView.getLblBack().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				reservasView.closeWindow();
				userMenuController = new UserMenuController();
			}
		});
		handleInputs();
	}

	private void handleInputs() {
		setPriceDates();
		this.reservasView.getPanelSiguiente().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				if(fieldsAreCorrect()) {
					try{
						saveEntity();
						reservasView.closeWindow();
						registroHuespedesController = new RegistroHuespedesController(reserva);
					}catch (Exception exception){
						JOptionPane.showMessageDialog(reservasView,"Ha ocurrido un error al guardar la reserva");
						exception.printStackTrace();
					}
				}
			}
		});
	}

	private void setPriceDates() {		
		this.reservasView.getTxtFechaEntrada().addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				establecerValorDeEstadia();				
			}
		});
		this.reservasView.getTxtFechaSalida().addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				establecerValorDeEstadia();				
			}
		});
	}

	private void establecerValorDeEstadia() {
		Date dateFechaEntrada = reservasView.getTxtFechaEntrada().getDate();
		Date dateFechaSalida = reservasView.getTxtFechaSalida().getDate();
		if(dateFechaEntrada==null || dateFechaSalida==null) {
			return;
		}
		this.fechaEntrada = dateFechaEntrada.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		this.fechaSalida = dateFechaSalida.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		
		long cantDiasDif = ChronoUnit.DAYS.between(fechaEntrada, fechaSalida);
	    Properties prop;
		try {
			prop = readPropertiesFile(".\\src\\main\\resources\\config\\configuration.properties");
			double basePrice = Double.parseDouble(prop.getProperty("precio_estadia_por_dia"));
			price = basePrice + (basePrice * (double)cantDiasDif);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    this.reservasView.getTxtValor().setText(price+"");
	}

	public static Properties readPropertiesFile(String fileName) throws IOException {
	      FileInputStream fis = null;
	      Properties prop = null;
	      try {
	         fis = new FileInputStream(fileName);
	         prop = new Properties();
	         prop.load(fis);
	      } catch(FileNotFoundException fnfe) {
	         fnfe.printStackTrace();
	      } catch(IOException ioe) {
	         ioe.printStackTrace();
	      } finally {
	         fis.close();
	      }
	      return prop;
	   }

	private boolean fieldsAreCorrect() {
		String formaPago = reservasView.getTxtFormaPago().getSelectedItem().toString();
		if(formaPago == null) {
			JOptionPane.showMessageDialog(reservasView, "La forma de pago es incorrecta");	
			return false;
		}
		if(fechaEntrada == null || fechaSalida==null){
			JOptionPane.showMessageDialog(reservasView, "Las fechas no pueden estar vacías");
			return false;
		}

		if(fechaEntrada.isBefore(LocalDate.now())) {
			JOptionPane.showMessageDialog(reservasView, "Las fecha de entrada es menor a la fecha actual");
			return false;
		}
		if(fechaSalida.compareTo(fechaEntrada)<0) {
			JOptionPane.showMessageDialog(reservasView, "Las fechas son incorrectas");
			return false;
		}
		
		return true;
	}
	
	public void saveEntity() throws Exception{
		String formaPago = reservasView.getTxtFormaPago().getSelectedItem().toString();
		reserva.setFormaPago(formaPago);
		this.reserva.setFechaEntrada(fechaEntrada);
		this.reserva.setFechaSalida(fechaSalida);
		this.reserva.setValor(price);
		Reserva existRe = this.reservaDAO.existEntity(reserva);
		if(existRe==null){
			reservaDAO.guardar(reserva);
		}else{
			this.reserva = existRe;
		}

	}
	


	public static void main(String[] args) {
		new ReservasController();
	}
}
