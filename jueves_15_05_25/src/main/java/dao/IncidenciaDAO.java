package dao;

import java.util.List;

import modelo.Incidencia;

public interface IncidenciaDAO {

	boolean crear(Incidencia i);

	List<Incidencia> listarTodas();

	Incidencia buscarPorId(int id);

	boolean actualizarEstado(int id, String nuevoEstado);

	List<Incidencia> buscarPorestado(String estado);

	boolean eliminarPorId(int id);
}