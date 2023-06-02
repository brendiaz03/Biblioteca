package ar.edu.unlam.pb2.biblioteca;

public class Geografia extends Libro{

	public Geografia(int codigo, String nombreLibro, String autor) {
		super(codigo, nombreLibro, autor, true);
	}
	
	@Override
	public String libroFotocopiado() {
		return "Textoo de libro";
	}

}
