package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import modelo.Incidencia;

public class ImpIncidencia implements IncidenciaDao {
	
	private final EntityManagerFactory emf;
	private final EntityManager em;

	@Override
	public boolean crear(Incidencia i) {

		return false;
	}

}
