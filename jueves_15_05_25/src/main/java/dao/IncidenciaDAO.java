package dao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modelo.Incidencia;

public interface IncidenciaDAO {

	static final Logger loggerGeneral = LogManager.getRootLogger();
	static final Logger loggerExcepciones = LogManager.getLogger("exceptions");

	boolean crear(Incidencia i);

	List<Incidencia> listarTodas();

	Incidencia buscarPorId(int id);

	boolean actualizarEstado(int id, String nuevoEstado);

	List<Incidencia> buscarPorestado(String estado);

	boolean eliminarPorId(int id);

}