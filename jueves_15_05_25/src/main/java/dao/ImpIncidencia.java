package dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import modelo.Incidencia;

public class ImpIncidencia implements IncidenciaDAO {

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

	@Override
	public List<Incidencia> listarTodas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Incidencia buscarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean actualizarEstado(int id, String nuevoEstado) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Incidencia> buscarPorestado(String estado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eliminarPorId(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
