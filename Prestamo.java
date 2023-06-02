package ar.edu.unlam.pb2.biblioteca;

public class Prestamo {

	private Libro libro;
	private Estudiante estudiante;
	private Integer id;

	public Prestamo(Libro libro, Estudiante estudiante, int id) {
		this.libro = libro;
		this.estudiante = estudiante;
		this.setId(id);
	}

	public Object getEstudiante() {
		return this.estudiante;
	}
	
	public Object getLibro() {
		return this.libro;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
