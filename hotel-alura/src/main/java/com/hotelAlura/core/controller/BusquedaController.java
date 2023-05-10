package com.hotelAlura.core.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.hotelAlura.core.dao.HuespedDAO;
import com.hotelAlura.core.dao.ReservaDAO;
import com.hotelAlura.core.model.Huesped;
import com.hotelAlura.core.model.Reserva;
import com.hotelAlura.core.utils.JPAUtils;
import com.hotelAlura.core.view.BusquedaView;

import javax.persistence.EntityManager;
import javax.swing.*;

public class BusquedaController {
	private BusquedaView busquedaView;
	private UserMenuController userMenuController;
	private HuespedDAO huespedDAO;
	private ReservaDAO reservaDAO;
	private List<Huesped> listaHuespedes;
	private List<Reserva> listaReserva;

	public BusquedaController() {
		this.busquedaView = new BusquedaView();
		EntityManager em = JPAUtils.getEntityManager();
		this.reservaDAO = new ReservaDAO(em);
		this.huespedDAO = new HuespedDAO(em);
		iniciar();
	}

	private void iniciar() {
		fillTables();
		this.busquedaView.getLblBack().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				busquedaView.closeWindow();
				userMenuController = new UserMenuController();
			}
		});
		this.busquedaView.getPanelEditar().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				int tabSelected = busquedaView.getPanel().getSelectedIndex();
//				System.out.println("Tabla huespedes fila selec: "+busquedaView.getTbHuespedes().getSelectedRow());
//				System.out.println("Tabla reservas fila selec: "+busquedaView.getTbReservas().getSelectedRow());
				if(tabSelected==0){
					updateTableReservas();
				}else{
					updateTableHuespedes();
				}
			}
		});
	}

	private void fillTables() {
		fillTableHuespedes();
		fillTableReservas();
	}

	private void fillTableHuespedes(){
		this.listaHuespedes = this.huespedDAO.consultarTodos();
		this.listaReserva = this.reservaDAO.consultarTodos();
		this.listaReserva.forEach( r -> {
			String nroReserva = r.getNroReserva();
			String fechaI = r.getFechaEntrada().toString();
			String fechaS = r.getFechaSalida().toString();
			String valor = r.getValor()+"";
			String formaPago = r.getFormaPago();
			Object[] fila = { nroReserva, fechaI, fechaS, valor, formaPago};
			this.busquedaView.getModelo().addRow(fila);
		});
	}

	private void fillTableReservas(){
		this.listaHuespedes.forEach( h -> {
			String nroHuesped = h.getId().toString();
			String nombre = h.getNombre();
			String apellido = h.getApellido();
			String fechaNac = h.getFechaNacimiento().toString();
			String nacionalidad = h.getNacionalidad();
			String tel = h.getTelefono();
			String numRes = h.getReserva().getNroReserva();
			Object[] fila = { nroHuesped, nombre, apellido, fechaNac, nacionalidad,tel,numRes};
			this.busquedaView.getModeloHuesped().addRow(fila);
		});
	}

	private void updateTableReservas(){
		System.out.println("se selecciona tabla huespedes");
		int selectedRow = this.busquedaView.getTbReservas().getSelectedRow();
		if(selectedRow==-1){
			JOptionPane.showMessageDialog(busquedaView,"Debe seleccionar una fila");
			return;
		}
		Reserva reserva = this.listaReserva.get(selectedRow);
		String nroReserva = this.busquedaView.getTbReservas().getValueAt(selectedRow,0).toString();
		LocalDate fechaIn = convertStringToLocalDate(this.busquedaView.getTbReservas().getValueAt(selectedRow,1).toString());
		LocalDate  fechaOut = convertStringToLocalDate(this.busquedaView.getTbReservas().getValueAt(selectedRow,2).toString());
		double valor = Double.parseDouble(this.busquedaView.getTbReservas().getValueAt(selectedRow,3).toString());
		String formaPago = this.busquedaView.getTbReservas().getValueAt(selectedRow,4).toString();
		this.reservaDAO.actualizar(reserva.getId(),nroReserva,fechaIn,fechaOut,valor,formaPago,reserva.getHuespedes());
		this.reservaDAO.actualizar(reserva);
	}

	private void updateTableHuespedes(){
		System.out.println("se selecciona tabla huespedes");
		int selectedRow = this.busquedaView.getTbHuespedes().getSelectedRow();
		if(selectedRow==-1){
			JOptionPane.showMessageDialog(busquedaView,"Debe seleccionar una fila");
			return;
		}
		Huesped huesped = this.listaHuespedes.get(selectedRow);
		Long id = Long.parseLong(this.busquedaView.getTbHuespedes().getValueAt(selectedRow,0).toString());
		String nombre = this.busquedaView.getTbHuespedes().getValueAt(selectedRow,1).toString();
		String apellido = this.busquedaView.getTbHuespedes().getValueAt(selectedRow,2).toString();
		LocalDate fechaNac = convertStringToLocalDate(this.busquedaView.getTbHuespedes().getValueAt(selectedRow,3).toString());
		String nacionalidad = this.busquedaView.getTbHuespedes().getValueAt(selectedRow,4).toString();
		String tel = this.busquedaView.getTbHuespedes().getValueAt(selectedRow,5).toString();
		String nroReserva = this.busquedaView.getTbHuespedes().getValueAt(selectedRow,6).toString();
		this.huespedDAO.actualizar(id,nombre,apellido,fechaNac,nacionalidad,tel,huesped.getReserva());
	}

	private LocalDate convertStringToLocalDate(String date){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-mm-dd");
		return LocalDate.parse(date);
	}
}
