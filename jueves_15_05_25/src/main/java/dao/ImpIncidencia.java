package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import modelo.Incidencia;

public class ImpIncidencia implements IncidenciaDao {

	private final EntityManagerFactory emf;
	private final EntityManager em;

	public ImpIncidencia() {
		this.emf = Persistence.createEntityManagerFactory("HibernatePU");
		this.em = emf.createEntityManager();
	}

	@Override
	public boolean crear(Incidencia i) {

		var tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(i);
			tx.commit();
		} catch (Exception e) {
			if (tx.isActive()) {
				tx.rollback();
			}
			throw e;
		}

		return false;
	}

}
