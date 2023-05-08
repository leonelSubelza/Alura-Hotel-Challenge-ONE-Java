package com.hotelAlura.HotelAlura.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.ZoneId;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

import com.hotelAlura.HotelAlura.dao.HuespedDAO;
import com.hotelAlura.HotelAlura.model.Huesped;
import com.hotelAlura.HotelAlura.utils.JPAUtils;
import com.hotelAlura.HotelAlura.view.RegistrosHuespedesView;

public class RegistroHuespedesController {

	private RegistrosHuespedesView huespedesView;
	private InformationController informationController;
	private ReservasController reservasController;
	private EntityManager entityManager;
	private HuespedDAO huespedDAO;
	
	public RegistroHuespedesController() {
		this.huespedesView = new RegistrosHuespedesView();
		this.entityManager = JPAUtils.getEntityManager();
		this.huespedDAO = new HuespedDAO(entityManager);
		inicializar();
	}

	private void inicializar() {
		 this.huespedesView.getLblBack().addMouseListener(new MouseAdapter() {
			 @Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				huespedesView.closeWindow();
				reservasController = new ReservasController();
			}
		});
		
		this.huespedesView.getBtnguardar().addMouseListener(new MouseAdapter() {
			 @Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
		        int confirm = JOptionPane.showOptionDialog(null, "¿Estás seguro que desea guardar?", "Advertencia",
		                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
		        if (confirm == 0) {
		            saveHuesped();
		            
		        }
			}
		});
		 
	}
	
	private void saveHuesped() {
		String nombre = this.huespedesView.getTxtNombre().getText();
		String apellido = this.huespedesView.getTxtApellido().getText();
		Date fechaNac = this.huespedesView.getTxtFechaN().getDate();
		String nacionalidad = this.huespedesView.getTxtNacionalidad().getSelectedItem().toString();
		String telefono = this.huespedesView.getTxtTelefono().getText();
		System.out.println("fechanac: "+fechaNac);
		if(nombre.equals("") || apellido.equals("") || fechaNac == null || nacionalidad.equals("") || telefono.equals("")) {
			JOptionPane.showMessageDialog(huespedesView, "Los campos no son correctos");
			return;
		}
		Huesped huesped = new Huesped(nombre,apellido,fechaNac.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),nacionalidad,telefono);;
		
		//deberia estar en un try catch
		this.huespedDAO.guardar(huesped);
		huespedesView.closeWindow();
		this.informationController = new InformationController("Datos Guardados Satisfactoriamente");
		
	}
}
