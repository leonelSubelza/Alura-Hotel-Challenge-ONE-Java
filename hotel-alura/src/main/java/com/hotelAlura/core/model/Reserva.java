package com.hotelAlura.core.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import com.hotelAlura.core.utils.JPAUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import com.hotelAlura.core.dao.ReservaDAO;


@Entity
@Table(name = "reservas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Reserva implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDate fechaEntrada;
	private LocalDate fechaSalida;
	private double valor;
	private String formaPago;
	private String nroReserva;
	
    @OneToMany(mappedBy = "reserva")
    private List<Huesped> huespedes;
    
    //eta vaina se genera antes de que se inserte la entidad en la bd
    @PrePersist
    private void generarNumeroDeReserva() {
		System.out.println("se genera el nro de reserva");
		EntityManager em = JPAUtils.getEntityManager();
		ReservaDAO reservaDAO = new ReservaDAO(em);
    	String ultNroReserva = reservaDAO.obtenerUltNroReserva();
    	if(ultNroReserva.equals("")) {
    		this.nroReserva = "000001";
    		return;
    	}
    	int numero = Integer.parseInt(ultNroReserva)+1;
    	//Se transforma el nro a un largo de 6 caracteres
    	this.nroReserva = String.format("%06d", numero);
    }
}
