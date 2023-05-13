package com.hotelAlura.core.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.hotelAlura.core.dao.HuespedDAO;
import com.hotelAlura.core.model.Huesped;
import com.hotelAlura.core.model.Reserva;
import com.hotelAlura.core.utils.JPAUtils;
import com.hotelAlura.core.utils.ValidFieldUtils;
import com.hotelAlura.core.view.RegistrosHuespedesView;

public class RegistroHuespedesController {

	private RegistrosHuespedesView huespedesView;
	private InformationController informationController;
	private ReservasController reservasController;
	private EntityManager entityManager;
	private HuespedDAO huespedDAO;
	private Reserva reserva;
	
	public RegistroHuespedesController(Reserva reserva) {
		this.huespedesView = new RegistrosHuespedesView();
		this.entityManager = JPAUtils.getEntityManager();
		this.huespedDAO = new HuespedDAO(entityManager);
		this.reserva = reserva;
		inicializar();
	}

	private void inicializar() {
		this.huespedesView.getTxtNreserva().setText(this.reserva.getNroReserva());
		
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
				 System.out.println("se hizo click");
				 if(fieldsAreValid()){
		        	int confirm = JOptionPane.showOptionDialog(null, "¿Estás seguro que desea guardar?", "Advertencia",
		                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
		        	if (confirm == 0) {
						try{
							saveHuesped();
							huespedesView.closeWindow();
							informationController = new InformationController("Datos Guardados Satisfactoriamente");
						}catch (Exception exception){
							JOptionPane.showMessageDialog(huespedesView, "Error al guardar Huesped en la bd", "Error Interno", JOptionPane.ERROR_MESSAGE);
						}
					}
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
		if(nombre.equals("") || apellido.equals("") || fechaNac == null || nacionalidad.equals("") || telefono.equals("")) {
			JOptionPane.showMessageDialog(huespedesView, "Los campos no son correctos");
			return;
		}
		Huesped huesped = new Huesped(nombre,apellido,fechaNac.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),nacionalidad,telefono,this.reserva);;
		this.huespedDAO.guardar(huesped);
	}

	public boolean fieldsAreValid(){
		String nombre = this.huespedesView.getTxtNombre().getText();
		if(!ValidFieldUtils.notNullOnlyLetters(nombre,"Nombre",this.huespedesView)) {
			return false;
		}
		String apellido = this.huespedesView.getTxtApellido().getText();
		if(!ValidFieldUtils.notNullOnlyLetters(apellido,"Apellido",this.huespedesView)){
			return false;
		}
		Date fechaN = this.huespedesView.getTxtFechaN().getDate();
		if(fechaN==null){
			JOptionPane.showMessageDialog(this.huespedesView, "El campo Fecha de nacimiento es incorrecto", "Campo Incorrecto", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		LocalDate fechaNac = fechaN.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		if(fechaNac==null || fechaNac.isAfter(LocalDate.now())){
			JOptionPane.showMessageDialog(this.huespedesView, "El campo Fecha de nacimiento es incorrecto", "Campo Incorrecto", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		String nacionalidad = this.huespedesView.getTxtNacionalidad().getSelectedItem().toString();
		if(!ValidFieldUtils.notNullOnlyLetters(nacionalidad,"Nacionalidad",this.huespedesView)){
			return false;
		}
		String telefono = this.huespedesView.getTxtTelefono().getText();
		if(!ValidFieldUtils.notNullOnlyNumbers(telefono,"Telefono",this.huespedesView)){
			System.out.println("el campo tel es una mierda");
			return false;
		}
		return true;
	}
}
