package ar.edu.unlam.pb2.biblioteca;

public class Estudiante {

	private Integer dni;
	private String apellido;
	private String nombre;
	private Integer cantidadDeLibrosPrestados = 0;
	

	public Estudiante(int dni, String apellido, String nombre) {
		this.dni = dni;
		this.apellido = apellido;
		this.nombre = nombre;
	}
	
	public Integer getcantidadDeLibrosPrestados() {
		return this.cantidadDeLibrosPrestados;
	}
	
	public void incrementarCantidadLibrosPrestados() {
        this.cantidadDeLibrosPrestados++;
    }
	
	public void disminuirCantidadLibrosPrestados() {
        this.cantidadDeLibrosPrestados--;
    }
}
