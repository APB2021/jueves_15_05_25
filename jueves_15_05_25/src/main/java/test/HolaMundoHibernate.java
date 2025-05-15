package test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import modelo.Incidencia;

public class HolaMundoHibernate {
	public static void main(String[] args) {
		String hql = "SELECT p FROM Persona p";

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateEjemplo1");

		try (EntityManager em = emf.createEntityManager()) {
			var personas = em.createQuery(hql, Incidencia.class).getResultList();
			personas.forEach(persona -> System.out.println(" " + persona));
		}
	}
}
