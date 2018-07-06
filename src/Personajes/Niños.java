package Personajes;

public class Niños extends Personaje {

	private int spirit;
	private int stamina;
	private int skill;

	public Niños(String nombre, int nivel, int vida,int spirit,int stamina,int skill) {
		super(nombre, nivel, vida);
		this.spirit=spirit;
		this.stamina=stamina;
		this.skill=skill;
		// TODO Auto-generated constructor stub
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

}
