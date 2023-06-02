package ar.edu.unlam.pb2.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

	private String nombreBiblioteca;
	private List<Prestamo> prestamos = new ArrayList<>();

	public Biblioteca(String nombreBiblioteca) {
		this.nombreBiblioteca = nombreBiblioteca;
		prestamos = new ArrayList<>();
	}

	public Boolean registrarPrestamo(Estudiante estudiante, Libro libro, int id) {
		if(estudiante.getcantidadDeLibrosPrestados() <2 && libro.getPrestado() == false) {
			estudiante.incrementarCantidadLibrosPrestados();
			libro.setlibroPrestado(true);
			Prestamo prestamo = new Prestamo(libro, estudiante, id);
			prestamos.add(prestamo);
			return true;
		}
		return false;
	}
	
	public String fotocopiarLibrosDeGeografiaEHistoria(Libro libro) {
		if(libro.getFotocopiable()) {
			return libro.libroFotocopiado();
		}
		return "No se puede fotocopiar";
	}
	
	public Boolean devolverLibro(Estudiante estudiante, Libro libro, int id) {
		Prestamo prestamoDevuelto = null;
	    for (Prestamo prestamo : prestamos) {
	        if (prestamo.getEstudiante().equals(estudiante) &&
	            prestamo.getLibro().equals(libro) &&
	            prestamo.getId() == id) {
	            prestamoDevuelto = prestamo;
	            break;
	        }
	    }

	    if (prestamoDevuelto != null) {
	        libro.setlibroPrestado(false);
	        estudiante.disminuirCantidadLibrosPrestados();
	        prestamos.remove(prestamoDevuelto);
	        return true;
	    }

	    return false;
	}
	
}
