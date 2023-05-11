package com.hotelAlura.core.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.ZoneId;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

import com.hotelAlura.core.dao.HuespedDAO;
import com.hotelAlura.core.model.Huesped;
import com.hotelAlura.core.model.Reserva;
import com.hotelAlura.core.utils.JPAUtils;
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
//		String nroReserva = this.huespedesView.getTxtNreserva().getText();
		System.out.println("fechanac: "+fechaNac);
		if(nombre.equals("") || apellido.equals("") || fechaNac == null || nacionalidad.equals("") || telefono.equals("")) {
			JOptionPane.showMessageDialog(huespedesView, "Los campos no son correctos");
			return;
		}
		Huesped huesped = new Huesped(nombre,apellido,fechaNac.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),nacionalidad,telefono,this.reserva);;
		
		//deberia estar en un try catch
		this.huespedDAO.guardar(huesped);
		huespedesView.closeWindow();
		this.informationController = new InformationController("Datos Guardados Satisfactoriamente");
		
	}
}
