package test;

import dao.IncidenciaDao;
import modelo.Incidencia;

public class OperacionesHibernateJPA {

	public static void main(String[] args) {
		try (IncidenciaDao incidenciaDao = new IncidenciaDao()) {

			// insertar
			Incidencia incidencia = new Incidencia();
			incidencia.s("Carlos");
			incidencia.setApellido("Lara");
			incidencia.setEmail("clara@mail.com");
			incidencia.setTelefono("55443322");

			// personaDao.insertar(persona);

			// 3. Caso actualizar
//            persona = new Persona();
//            persona.setIdPersona(6);
//
//            persona = personaDao.buscarPersonaPorId(persona);
//            System.out.println("persona encontrada = " + persona);
//
//            //persona.setNombre("Carlos");
//            persona.setApellido("Esparza");
//            persona.setEmail("cesparza@mail.com");
//            //persona.setTelefono("55443322");
//
//            personaDao.modificar(persona);
//            personaDao.imprimirPersonas();

		}
	}
}
