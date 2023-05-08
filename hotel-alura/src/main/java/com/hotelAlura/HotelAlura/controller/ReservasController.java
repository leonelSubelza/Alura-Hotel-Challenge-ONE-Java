package com.hotelAlura.HotelAlura.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Properties;

import javax.swing.JOptionPane;

import com.hotelAlura.HotelAlura.view.ReservasView;

public class ReservasController {

	private ReservasView reservasView;
	private UserMenuController userMenuController;
	
	public ReservasController() {
		System.out.println("se inicia controller de reservas");
		System.out.println();
		this.reservasView = new ReservasView();
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
			System.out.println("las fechas son nulas");
			return;
		}
		
		final LocalDate fechaEntrada = dateFechaEntrada.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		final LocalDate fechaSalida = dateFechaSalida.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		if(fechaSalida.compareTo(fechaEntrada)<0) {
			JOptionPane.showMessageDialog(reservasView, "Las fechas son incorrectas");
			return;
		}
		long cantDiasDif = ChronoUnit.DAYS.between(fechaEntrada, fechaSalida);
		double price = 0;
	      Properties prop;
		try {
			prop = readPropertiesFile(".\\src\\main\\resources\\config\\configuration.properties");
			price += Double.parseDouble(prop.getProperty("precio_estadia_por_dia")) * (double)cantDiasDif;
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
	
	public static void main(String[] args) {
		new ReservasController();
	}
}
