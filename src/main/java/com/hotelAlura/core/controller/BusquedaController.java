package com.hotelAlura.core.controller;

import java.awt.event.*;
import java.math.BigDecimal;
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

		this.busquedaView.getTxtBusqueda().addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				super.keyReleased(e);
				if(busquedaView.getTxtBusqueda().getText().equals("")){
					fillTables();
				}
			}
		});

		this.busquedaView.getPanelBuscar().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				int tabSelected = busquedaView.getPanel().getSelectedIndex();
				if(tabSelected==0){
					searchReserva();
				}else{
					searchHuesped();
				}
			}
		});
	}

	private void fillTables() {
		fillTableHuespedes();
		fillTableReservas();
	}

	private void fillTableReservas(){
		deleteElementsFromTable(this.busquedaView.getModelo(),this.busquedaView.getColReservas().toArray());
		this.listaHuespedes = this.huespedDAO.consultarTodos();
		this.listaReserva = this.reservaDAO.consultarTodos();
		this.listaReserva.forEach(this::addReservaItemToTable);
	}

	private void fillTableHuespedes(){
		deleteElementsFromTable(this.busquedaView.getModeloHuesped(),this.busquedaView.getColHuespedes().toArray());
		this.listaHuespedes = this.huespedDAO.consultarTodos();
		this.listaReserva = this.reservaDAO.consultarTodos();
		this.listaHuespedes.forEach(this::addHuespedItemToTable);
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
		BigDecimal valor =  new BigDecimal(this.busquedaView.getTbReservas().getValueAt(selectedRow,3).toString());
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

	private void searchHuesped() {
		String search = this.busquedaView.getTxtBusqueda().getText();
		if(search.equals("")){
			JOptionPane.showMessageDialog(busquedaView,"Debe escribir algo");
			return;
		}
		try {
			List<Huesped> huespedes = this.huespedDAO.searchForSurname(search);
			fillTbHuespedWithSpecificValue(huespedes);
		}catch (Exception e){
			JOptionPane.showMessageDialog(busquedaView,"Ha ocurrido un error al realizar la búsqueda");
		}
	}

	private void addHuespedItemToTable(Huesped huesped){
		String nroHuesped = huesped.getId().toString();
		String nombre = huesped.getNombre();
		String apellido = huesped.getApellido();
		String fechaNac = huesped.getFechaNacimiento().toString();
		String nacionalidad = huesped.getNacionalidad();
		String tel = huesped.getTelefono();
		String numRes = huesped.getReserva().getNroReserva();
		Object[] fila = { nroHuesped, nombre, apellido, fechaNac, nacionalidad,tel,numRes};
		this.busquedaView.getModeloHuesped().addRow(fila);
	}

	private void addReservaItemToTable(Reserva reserva){
		String nroReserva = reserva.getNroReserva();
		String fechaI = reserva.getFechaEntrada().toString();
		String fechaS = reserva.getFechaSalida().toString();
		String valor = reserva.getValor()+"";
		String formaPago = reserva.getFormaPago();
		Object[] fila = { nroReserva, fechaI, fechaS, valor, formaPago};
		this.busquedaView.getModelo().addRow(fila);
	}

	private void fillTbHuespedWithSpecificValue(List<Huesped> huespedes){
		deleteElementsFromTable(this.busquedaView.getModeloHuesped(),this.busquedaView.getColHuespedes().toArray());
		huespedes.forEach(this::addHuespedItemToTable);
	}

	private void fillTbReservaWithSpecificValue(List<Reserva> reservas){
		deleteElementsFromTable(this.busquedaView.getModelo(),this.busquedaView.getColReservas().toArray());
		reservas.forEach(this::addReservaItemToTable);
	}

	private void searchReserva() {
			String search = this.busquedaView.getTxtBusqueda().getText();
			if(search.equals("")){
				JOptionPane.showMessageDialog(busquedaView,"Debe escribir algo");
				return;
			}
			try {
				List<Reserva> reservas = this.reservaDAO.obtenerReservasPorNumeroDeReserva(search);
				fillTbReservaWithSpecificValue(reservas);
			}catch (Exception e){
				JOptionPane.showMessageDialog(busquedaView,"Ha ocurrido un error al realizar la búsqueda");
			}
		}
}
