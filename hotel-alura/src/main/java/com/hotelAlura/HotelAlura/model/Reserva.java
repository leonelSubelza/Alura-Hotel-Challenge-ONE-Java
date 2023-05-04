package com.hotelAlura.HotelAlura.model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "reservas")
@NoArgsConstructor
@AllArgsConstructor
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDate fechaEntrada;
	private LocalDate fechaSalida;
	private double valor;
	private String formaPago;
	
//	@ManyToOne
//	private Huesped huesped;
}
