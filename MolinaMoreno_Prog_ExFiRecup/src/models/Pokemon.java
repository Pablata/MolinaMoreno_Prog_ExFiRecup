package models;

public class Pokemon {

	protected String nombre;
	protected int numero;
	protected int nivel;
	protected String region;
	protected String tipo;
	protected String comentarios;

	/**
	 * 
	 * @param nombre
	 * @param numero
	 * @param nivel
	 * @param region
	 * @param tipo
	 */
	public Pokemon(String nombre, int numero, int nivel, String region, String tipo, String comentarios) {
		super();
		this.nombre = nombre;
		this.numero = numero;
		this.nivel = nivel;
		this.region = region;
		this.tipo = tipo;
		this.comentarios = comentarios;
	}

	public String getComentarios() {
		return comentarios;
	}

	public String setComentarios(String comentarios) {
		return this.comentarios = comentarios;
	}

	public String getNombre() {
		return nombre;
	}

	public int getNumero() {
		return numero;
	}

	public int getNivel() {
		return nivel;
	}

	public String getRegion() {
		return region;
	}

	public String getTipo() {
		return tipo;
	}

}
