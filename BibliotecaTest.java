package ar.edu.unlam.pb2.biblioteca;

import org.junit.Test;
import static org.junit.Assert.*;

public class BibliotecaTest {
	
	@Test
	public void queSePuedaPrestarUnLibroACualquierEstudiante() {
		Estudiante estudiante = new Estudiante(42156466, "Diaz", "Brenda");
		
		Geografia geografia = new Geografia(123, "Mapas", "I");
		
		Biblioteca bibliotecaNacional = new Biblioteca("BBB");
		
		assertTrue(bibliotecaNacional.registrarPrestamo(estudiante, geografia, 12));
	}
	
	@Test
	public void queLosEstudiantesNoSePuedanLlevarMasDeDosLibrosEnSimultaneo() {
		Estudiante estudiante = new Estudiante(42156466, "Diaz", "Brenda");
		
		Geografia geografia = new Geografia(1, "Mapas", "I");
		Historia historia = new Historia(12, "Historia", "S");
		Matematicas matematicas = new Matematicas(123, "Mate", "I");
		
		Biblioteca bibliotecaNacional = new Biblioteca("BBB");
		
		Integer prestamo1 = 1;
		Integer prestamo2 = 2;
		
		assertTrue(bibliotecaNacional.registrarPrestamo(estudiante, geografia, 1));
		assertEquals(estudiante.getcantidadDeLibrosPrestados(), prestamo1);
		
		assertTrue(bibliotecaNacional.registrarPrestamo(estudiante, historia, 123));
		assertEquals(estudiante.getcantidadDeLibrosPrestados(), prestamo2);
		
		assertFalse(bibliotecaNacional.registrarPrestamo(estudiante, matematicas, 1234));
		assertEquals(estudiante.getcantidadDeLibrosPrestados(), prestamo2);
	}
	
	@Test
	public void queSePuedanFotocopiarGeografiaEHistoria() {
		String LibrosNoFotocopiables= "No se puede fotocopiar";
		String LibrosFotocopiables = "Textoo de libro";
		
		Geografia geografia = new Geografia(1, "Mapas", "I");
		Historia historia = new Historia(12, "Historia", "S");
		Matematicas matematicas = new Matematicas(123, "Mate", "I");
		
		Biblioteca bibliotecaNacional = new Biblioteca("BBB");
		
		assertEquals(bibliotecaNacional.fotocopiarLibrosDeGeografiaEHistoria(matematicas), LibrosNoFotocopiables);	
		assertEquals(bibliotecaNacional.fotocopiarLibrosDeGeografiaEHistoria(historia), LibrosFotocopiables);
		assertEquals(bibliotecaNacional.fotocopiarLibrosDeGeografiaEHistoria(geografia), LibrosFotocopiables);
	}
	

	@Test
	public void queLosLibrosNoEstenDisponiblesSiEstanPrestados() {
		Estudiante estudiante1 = new Estudiante(42156466, "Brenda", "Diaz");
		Estudiante estudiante2 = new Estudiante(42156466, "Diaz", "Brenda");
		
		Geografia geografia = new Geografia(1, "Mapas", "I");
		
		Biblioteca bibliotecaNacional = new Biblioteca("BBB");
		
		assertTrue(bibliotecaNacional.registrarPrestamo(estudiante1, geografia, 1));
		assertFalse(bibliotecaNacional.registrarPrestamo(estudiante2, geografia, 2));
	}
	
	@Test
	public void queSePuedanDevolverLosLibros() {
		Estudiante estudiante1 = new Estudiante(42156466, "Brenda", "Diaz");
		Estudiante estudiante2 = new Estudiante(42156467, "Diaz", "Brenda");
		Estudiante estudiante3 = new Estudiante(42156468, "D", "Bren");
		
		Geografia geografia = new Geografia(1, "Mapas", "I");
		Historia historia = new Historia(12, "Historia", "S");
		Matematicas matematicas = new Matematicas(123, "Mate", "I");
		
		Biblioteca bibliotecaNacional = new Biblioteca("BBB");
		
		Integer prestamo = 1;
		Integer devolucion = 0;
		
		assertTrue(bibliotecaNacional.registrarPrestamo(estudiante1, geografia, 2));
		assertTrue(bibliotecaNacional.registrarPrestamo(estudiante2, historia, 3));
		assertTrue(bibliotecaNacional.registrarPrestamo(estudiante3, matematicas, 4));
		assertTrue(geografia.getPrestado());
		assertTrue(historia.getPrestado());
		assertTrue(matematicas.getPrestado());
		assertEquals(estudiante1.getcantidadDeLibrosPrestados(), prestamo);
		assertEquals(estudiante2.getcantidadDeLibrosPrestados(), prestamo);
		assertEquals(estudiante3.getcantidadDeLibrosPrestados(), prestamo);
		
		assertTrue(bibliotecaNacional.devolverLibro(estudiante1, geografia, 2));
		assertFalse(geografia.getPrestado());
		assertTrue(historia.getPrestado());
		assertTrue(matematicas.getPrestado());
		assertEquals(estudiante1.getcantidadDeLibrosPrestados(), devolucion);
		assertEquals(estudiante2.getcantidadDeLibrosPrestados(), prestamo);
		assertEquals(estudiante3.getcantidadDeLibrosPrestados(), prestamo);
		
		
		assertTrue(bibliotecaNacional.registrarPrestamo(estudiante1, geografia, 2));
		assertTrue(geografia.getPrestado());
		assertEquals(estudiante1.getcantidadDeLibrosPrestados(), prestamo);
	}
	
}
