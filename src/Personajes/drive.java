package Personajes;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.Map;

public class drive implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5667681511569106650L;
	private int distance;
	private int steps;
	private int victoryOnline;
	private int victoryLocal;
	private int derrotasOnline;
	private int derrotasLocal;
	private int wins;
	private int spirit_power;
	private int totalPartidasOnline;

	private Digimons companions[];
	private ArrayList<Digimons> Rookye;
	private ArrayList<Digimons> Champions;
	private ArrayList<Digimons> Ultimate;
	private ArrayList<Digimons> Mega;
	private ArrayList<Digimons> Boss;
	private ArrayList<Digimons> Ancient;
	private ArrayList<Digimons> Spirit;

	private Player jugador;
	private Map mapa;

	// Constructor de prueba
	public drive(Player jugador) {
		this.jugador = jugador;
		this.distance = 10220;
		derrotasOnline = 0;
		derrotasLocal = 0;
		this.steps = 0;
		this.victoryOnline = 0;
		victoryLocal = 0;
		this.wins = 0;
		this.spirit_power = 99;
		totalPartidasOnline = 0;
		companions = new Digimons[4];
		Rookye = new ArrayList<Digimons>();
		Champions = new ArrayList<Digimons>();
		Ultimate = new ArrayList<Digimons>();
		Mega = new ArrayList<Digimons>();
		Boss = new ArrayList<Digimons>();
		Ancient = new ArrayList<Digimons>();
		Spirit = new ArrayList<Digimons>();
	}

	public drive(int distance, int steps, int victoryOnline, int victoryLocal, int derrotasOnline, int derrotasLocal,
			int wins, int spirit_power, int totalPartidasOnline, Digimons[] companions,
			ArrayList<Digimons> rookye, ArrayList<Digimons> champions, ArrayList<Digimons> ultimate,
			ArrayList<Digimons> mega, ArrayList<Digimons> boss, ArrayList<Digimons> ancient, ArrayList<Digimons> spirit,
			Player jugador) {

		this.distance = distance;
		this.steps = steps;
		this.victoryOnline = victoryOnline;
		this.victoryLocal = victoryLocal;
		this.derrotasOnline = derrotasOnline;
		this.derrotasLocal = derrotasLocal;
		this.wins = wins;
		this.spirit_power = spirit_power;
		this.totalPartidasOnline = totalPartidasOnline;
		this.companions = companions;
		Rookye = rookye;
		Champions = champions;
		Ultimate = ultimate;
		Mega = mega;
		Boss = boss;
		Ancient = ancient;
		Spirit = spirit;
		this.jugador = jugador;

	}

	private void calCulaPorcentageVictoriasOnline() {
		if (victoryOnline == 0 && totalPartidasOnline == 0) {
			wins = 0;
		} else {
			wins = (victoryOnline * 100) / totalPartidasOnline;
		}

	}

	public int getTotalPartidasOnline() {
		return totalPartidasOnline;
	}

	public void setTotalPartidasOnline(int totalPartidasOnline) {
		this.totalPartidasOnline = totalPartidasOnline;
	}

	public Player getPa() {
		return jugador;
	}

	public void setPa(Player pa) {
		this.jugador = pa;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getSteps() {
		return steps;
	}

	public void setSteps(int steps) {
		this.steps = steps;
	}

	public int getVictory() {
		return victoryOnline;
	}

	public void setVictory(int victory) {
		this.victoryOnline = victory;
	}

	public int getWins() {
		calCulaPorcentageVictoriasOnline();
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public int getSpirit_power() {
		return spirit_power;
	}

	public void setSpirit_power(int spirit_power) {
		this.spirit_power = spirit_power;
	}

	public Digimons[] getCompanions() {
		return companions;
	}

	public void setCompanions(Digimons compa, int posicion) {
		if (companions[posicion] == null) {
			companions[posicion]=compa;

		} else {
			CambiaCompañero(compa, posicion);

		}

	}

	public void setDigimonCategoria(Digimons digimon) {
		char categoria = digimon.getCategoria();
		switch (categoria) {

		case 'r':
			Rookye.add(digimon);

			break;
		case 'c':
			Champions.add(digimon);
			break;
		case 'u':
			Ultimate.add(digimon);
			break;
		case 'm':
			Mega.add(digimon);
			break;
		case 'b':
			Boss.add(digimon);
			break;
		case 'a':
			Ancient.add(digimon);
			break;
		case 's':
			Spirit.add(digimon);

			break;

		}

	}

	public Player getJugador() {
		return jugador;
	}

	public void setJugador(Player jugador) {
		this.jugador = jugador;
	}

	public ArrayList<Digimons> getRookye() {
		return Rookye;
	}

	public ArrayList<Digimons> getChampions() {
		return Champions;
	}

	public ArrayList<Digimons> getUltimate() {
		return Ultimate;
	}

	public ArrayList<Digimons> getMega() {
		return Mega;
	}

	public ArrayList<Digimons> getBoss() {
		return Boss;
	}

	public ArrayList<Digimons> getAncient() {
		return Ancient;
	}

	public ArrayList<Digimons> getSpirit() {
		return Spirit;
	}

	public int getDerrotasLocal() {
		return derrotasLocal;
	}

	public void setDerrotasLocal(int derrotasLocal) {
		this.derrotasLocal = derrotasLocal;
	}

	public int getDerrotasOnline() {
		return derrotasOnline;
	}

	public void setDerrotasOnline(int derrotasOnline) {
		this.derrotasOnline = derrotasOnline;
	}

	public int getVictoryOnline() {
		return victoryOnline;
	}

	public void setVictoryOnline(int victoryOnline) {
		this.victoryOnline = victoryOnline;
	}

	public int getVictoryLocal() {
		return victoryLocal;
	}

	public void setVictoryLocal(int victoryLocal) {
		this.victoryLocal = victoryLocal;
	}

	public void DeleteCompanions(int posicion) {
		companions[posicion]=null;

	}

	private void CambiaCompañero(Digimons compa, int posicion) {
		companions[posicion]=compa;
		

	}
}
