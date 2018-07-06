package Personajes;

import java.io.Serializable;

public class Digimons implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5430147043906122563L;
	/**
	 * 
	 */

	private final int id;
	private String nombre;
	private final char Categoria;
	private final String tipo;
	private int salud;
	private int energy;
	private int cruss;
	private int ability;
	private final int nivel;
	private boolean disponible;
	private final int numeroEnBaseDatos;
	private final String clave;

	public Digimons(int id, String nombre, char categoria, String tipo, int salud, int energy, int cruss, int ability,
			int nivel, boolean disponible, int numeroEnBaseDatos, String clave) {

		this.id = id;
		this.nombre = nombre;
		Categoria = categoria;
		this.tipo = tipo;
		this.salud = salud;
		this.energy = energy;
		this.cruss = cruss;
		this.ability = ability;
		this.nivel = nivel;
		this.disponible = disponible;
		this.numeroEnBaseDatos = numeroEnBaseDatos;
		this.clave = clave;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public char getCategoria() {
		return Categoria;
	}

	public String getTipo() {
		return tipo;
	}

	public int getSalud() {
		return salud;
	}

	public void setSalud(int salud) {
		this.salud = salud;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public int getCruss() {
		return cruss;
	}

	public void setCruss(int cruss) {
		this.cruss = cruss;
	}

	public int getAbility() {
		return ability;
	}

	public void setAbility(int ability) {
		this.ability = ability;
	}

	public int getNivel() {
		return nivel;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public int getNumeroEnBaseDatos() {
		return numeroEnBaseDatos;
	}

	public String getClave() {
		return clave;
	}

}