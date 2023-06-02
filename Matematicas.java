package ar.edu.unlam.pb2.biblioteca;

public class Matematicas extends Libro {

	public Matematicas(int codigo, String nombreLibro, String autor) {
		super(codigo, nombreLibro, autor, false);
	}
	
	@Override
	public String libroFotocopiado() {
		return "Textoo de matematicas";
	}
}
