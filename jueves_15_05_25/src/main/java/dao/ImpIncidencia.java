package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import modelo.Incidencia;

public class ImpIncidencia implements IncidenciaDAO {

	private final EntityManagerFactory emf;
	private final EntityManager em;

	private static SessionFactory sessionFactory;

	static {
		try {
			// Cargar la configuración de Hibernate
			// Sin especificar el nombre, Hibernate buscará automáticamente
			// hibernate.cfg.xml en src/main/resources/.
			sessionFactory = new Configuration().configure().buildSessionFactory();
			System.out.println("✅ Hibernate inicializado correctamente.");
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError("❌ Error al inicializar Hibernate: " + ex);
		}
	}

	/**
	 * Obtiene una sesión de Hibernate.
	 *
	 * @return una nueva sesión
	 */
	private Session getSession() {
		return sessionFactory.openSession();
	}

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

		Transaction tx = null;
		try (Session session = getSession()) {
			tx = session.beginTransaction();
			Incidencia incidencia = session.get(Incidencia.class, id);
			if (incidencia != null) {
				session.remove(incidencia);
				tx.commit();
				System.out.println("✅ Incidencia eliminada en Hibernate.");
				return true;
			}
			return false;
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			return false;
		}

	}

}
