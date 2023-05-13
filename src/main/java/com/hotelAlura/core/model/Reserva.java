package com.hotelAlura.core.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import com.hotelAlura.core.utils.JPAUtils;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.hotelAlura.core.dao.ReservaDAO;


@Entity
@Table(name = "reservas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Reserva implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private LocalDate fechaEntrada;
	@NotNull
	private LocalDate fechaSalida;
	@NotNull
	private double valor;
	@NotNull
	private String formaPago;
	@NotNull
	private String nroReserva;
	
    @OneToMany(mappedBy = "reserva",cascade = CascadeType.ALL)
    private List<Huesped> huespedes;
    
    //eta vaina se genera antes de que se inserte la entidad en la bd
    @PrePersist
    private void generarNumeroDeReserva() {
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
