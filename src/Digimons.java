

public class Digimons extends Personaje {
	private int en;
	private int cr;
	private int ab;
	private int id;

	public Digimons(String nombre, int nivel, int vida, int en, int cr, int ab, int id) {
		super(nombre, nivel, vida,true);
		this.en = en;
		this.cr = cr;
		this.ab = ab;
		this.id = id;

	}

	public int getEn() {
		return en;
	}

	public void setEn(int en) {
		this.en = en;
	}

	public int getCr() {
		return cr;
	}

	public void setCr(int cr) {
		this.cr = cr;
	}

	public int getAb() {
		return ab;
	}

	public void setAb(int ab) {
		this.ab = ab;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
