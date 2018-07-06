package Personajes;

public class Personaje {

	private String nombre;
	private int nivel;
	private int vida;
	private boolean disponible;

	public Personaje(String nombre, int nivel, int vida, boolean disponible) {

		this.nombre = nombre;
		this.nivel = nivel;
		this.vida = vida;
		this.disponible = disponible;

	}

	public Personaje() {

		this.nombre = "";
		this.nivel = 1;
		this.vida = 1;
		this.disponible = true;

	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}



}
