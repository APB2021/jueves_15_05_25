package modelo;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "incidencias")
public class Incidencia implements Serializable {

	private static final long serialVersionUID = -3507503388498013262L;

	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;

	@Column(name = "titulo", nullable = false)
	private String titulo; // titulo VARCHAR(50) NOT NULL,

	@Column(name = "descripcion", nullable = false)
	private String descripcion; // descripcion VARCHAR(50) NOT NULL,

	private LocalDate fechaCreacion; // fecha DATE NOT NULL,

	@Column(name = "estado", nullable = false)
	private String estado; // estado VARCHAR(50) NOT NULL, CHECK // (estado IN ('Abierta', 'En progreso',
							// 'Cerrada')),

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tecnico")
	private Tecnico tecnico;

	public Incidencia() {
	}

	public Incidencia(int id, String titulo, String descripcion, LocalDate fechaCreacion, String estado,
			Tecnico tecnico) {
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
		this.tecnico = tecnico;
	}

	public Incidencia(int id, String titulo, String descripcion, LocalDate fechaCreacion, String estado,
			String nombreTecnico, String emailTecnico) {
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;

		String nombre = this.tecnico.getNombre();
		String email = this.tecnico.getEmail();

		nombre = nombreTecnico;
		email = emailTecnico;

	}
	/*
	 * 
	 * 
	 * (1, "Pantalla azul", "Error grave", LocalDate.now(), "Abierta", "Juan",
	 * "juan@ejemplo.com");
	 * 
	 * 
	 */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
