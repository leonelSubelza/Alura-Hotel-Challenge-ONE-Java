package com.hotelAlura.HotelAlura.model;

import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "huespedes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Huesped {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String apellido;
	private LocalDate fechaNacimiento;
	private String nacionalidad;
	private String telefono;

	public Huesped(String nombre2, String apellido2, LocalDate localDate, String telefono2) {
		this.nombre = nombre2;
		this.apellido = apellido2;
		this.fechaNacimiento = localDate;
		this.telefono = telefono2;
	}
	
//	@OneToMany(targetEntity = Reserva.class)
//	private List<Reserva> reservas;

}
