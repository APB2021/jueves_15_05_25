package modelo;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tecnicos")

public class Tecnico implements Serializable {

	private static final long serialVersionUID = 2339010496666921604L;

	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id; // id INT PRIMARY KEY AUTO_INCREMENT,
	private String nombre;
	private String email;

	public Tecnico() {
	}

	public Tecnico(String nombre, String email) {
		this.nombre = nombre;
		this.email = email;
	}

	public Tecnico(int id, String nombre, String email) {
		this.id = id;
		this.nombre = nombre;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return "Tecnico [id=" + id + ", nombre=" + nombre + ", email=" + email + "]";
	}

}
