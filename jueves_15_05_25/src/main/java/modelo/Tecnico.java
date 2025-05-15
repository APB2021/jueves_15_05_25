package modelo;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tecnicos")

public class Tecnico implements Serializable {

	private static final long serialVersionUID = 2339010496666921604L;

	@Column(name = "id_tecnico")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id_tecnico; // id INT PRIMARY KEY AUTO_INCREMENT,

	@Column(name = "nombre", nullable = false)
	private String nombre;

	@Column(name = "email", nullable = false)
	private String email;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tecnico")
	private Incidencia incidencia;

	public Tecnico() {
	}

	public Tecnico(String nombre, String email) {
		this.nombre = nombre;
		this.email = email;
	}

	public Tecnico(int id_tecnico, String nombre, String email) {
		this.id_tecnico = id_tecnico;
		this.nombre = nombre;
		this.email = email;
	}

	public int getId_tecnico() {
		return id_tecnico;
	}

	public void setId_tecnico(int id_tecnico) {
		this.id_tecnico = id_tecnico;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Tecnico [id_tecnico=" + id_tecnico + ", nombre=" + nombre + ", email=" + email + "]";
	}

}
