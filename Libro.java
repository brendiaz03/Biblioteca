package ar.edu.unlam.pb2.biblioteca;

public abstract class Libro {
	private Integer codigo;
	private String nombreLibro;
	private String autor;
	private Boolean prestado = false;
	private Boolean fotocopiable;
	
	public Libro(int codigo, String nombreLibro, String autor, Boolean fotocopiable) {
		this.codigo= codigo;
		this.nombreLibro = nombreLibro;
		this.autor = autor;
		this.fotocopiable = fotocopiable;
		this.prestado = false;
	}
	
	public Boolean getPrestado() {
		return this.prestado;
	}
	
	public void setlibroPrestado(boolean prestado) {
		this.prestado = prestado;
	}

	public Boolean getFotocopiable() {
		return fotocopiable;
	}

	public void setFotocopiable(Boolean fotocopiable) {
		this.fotocopiable = fotocopiable;
	}
	
	public abstract String libroFotocopiado();
	
}
