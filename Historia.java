package ar.edu.unlam.pb2.biblioteca;

public class Historia extends Libro {
	private Boolean fotocopiable = true;

	public Historia(int codigo, String nombreLibro, String autor) {
		super(codigo, nombreLibro, autor, true);
	}
	
	@Override
	public String libroFotocopiado() {
		return "Textoo de libro";
	}
}
