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
import javax.swing.table.DefaultTableModel;

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
				if(tabSelected==0){
					updateReserva();
				}else{
					updateHuesped();
				}
			}
		});
		this.busquedaView.getPanelEliminar().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				int tabSelected = busquedaView.getPanel().getSelectedIndex();
				if(tabSelected==0){
					deleteReserva();
				}else{
					deleteHuesped();
				}
			}
		});
	}

	private void fillTables() {
		fillTableHuespedes();
		fillTableReservas();
	}

	private void fillTableReservas(){
		deleteElementsFromTable(this.busquedaView.getModelo(),
				new Object[]{"Numero de Reserva","Fecha Check In","Fecha Check Out","Valor","Forma de Pago"});
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

	private void fillTableHuespedes(){
		deleteElementsFromTable(this.busquedaView.getModeloHuesped(),new Object[]{"Número de Huesped","Nombre","Apellido","Fecha de Nacimiento","Nacionalidad","Telefono","Número de Reserva"});
		this.listaHuespedes = this.huespedDAO.consultarTodos();
		this.listaReserva = this.reservaDAO.consultarTodos();
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

	private void deleteElementsFromTable(DefaultTableModel tableModel,Object[] columns){
		tableModel.setRowCount(0);
		tableModel.setColumnCount(0);
		tableModel.setColumnIdentifiers(columns);
	}

	private void updateReserva(){
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
		try {
			this.reservaDAO.actualizar(reserva.getId(),nroReserva,fechaIn,fechaOut,valor,formaPago,reserva.getHuespedes());
			JOptionPane.showMessageDialog(null,"Reserva con id: "+reserva.getId()+" actualizada correctamente");
			fillTables();
		}catch (Exception e){
			JOptionPane.showMessageDialog(null,"Error al actualizar la Reserva con id: "+reserva.getId());
		}

	}

	private void updateHuesped(){
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
		try {
			this.huespedDAO.actualizar(id,nombre,apellido,fechaNac,nacionalidad,tel,huesped.getReserva());
			JOptionPane.showMessageDialog(null,"Huesped con id:"+id+" actualizado con exito!");
			fillTables();
		}catch (Exception e){
			JOptionPane.showMessageDialog(null,"Error al actualizar al Huesped con id: "+id);
		}

	}

	private LocalDate convertStringToLocalDate(String date){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-mm-dd");
		return LocalDate.parse(date);
	}

	private void deleteHuesped() {
		int selectedRow = this.busquedaView.getTbHuespedes().getSelectedRow();
		if(selectedRow==-1){
			JOptionPane.showMessageDialog(busquedaView,"Debe seleccionar una fila");
			return;
		}
		Huesped huesped = this.listaHuespedes.get(selectedRow);
		try {
			this.huespedDAO.remover(huesped);
			JOptionPane.showMessageDialog(null,"Huesped con id: "+huesped.getId()+" eliminado con éxito!");
			fillTables();
		}catch (Exception e){
			JOptionPane.showMessageDialog(null,"Error al eliminar Huesped con id: "+huesped.getId());
		}
	}

	private void deleteReserva() {
		int selectedRow = this.busquedaView.getTbReservas().getSelectedRow();
		if(selectedRow==-1){
			JOptionPane.showMessageDialog(busquedaView,"Debe seleccionar una fila");
			return;
		}
		Reserva reserva = this.listaReserva.get(selectedRow);
		try {
			this.reservaDAO.remover(reserva);
			JOptionPane.showMessageDialog(null,"Reserva con id: "+reserva.getId()+" eliminada con éxito!");
			fillTables();
		}catch (Exception e){
			JOptionPane.showMessageDialog(null,"Error al eliminar la Reserva con id: "+reserva.getId());
		}
	}
}
