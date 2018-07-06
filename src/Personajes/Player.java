package Personajes;

import java.io.Serializable;
import java.util.ArrayList;

public class Player implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6623520843815845533L;
	private int healt;
	private int spirit;
	private int stamina;
	private int skill;
	private int id;
	private String nombre;
	private int level;
	

	public Player(String nombre, int id) {
	
		healt = 10;
		spirit = 10;
		skill = 10;
		stamina = 110;
		this.id = id;
		this.nombre = nombre;
		level = 1;

	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Player() {
		healt = 10;
		spirit = 10;
		skill = 10;
		stamina = 110;
		
		
		level = 1;
	}

	public int getHealt() {
		return healt;
	}

	public void setHealt(int healt) {
		this.healt = healt;
	}

	public int getSpirit() {
		return spirit;
	}

	public void setSpirit(int spirit) {
		this.spirit = spirit;
	}

	public int getStamina() {
		return stamina;
	}

	public void setStamina(int stamina) {
		this.stamina = stamina;
	}

	public int getSkill() {
		return skill;
	}

	public void setSkill(int skill) {
		this.skill = skill;
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

	public void UpdateValues(int level) {

	}

	

}
