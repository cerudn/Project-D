import java.util.ArrayList;

import Personajes.Personaje;

public class Status {
	// private ArrayList Personajes;
	// private Personaje person;

	public Status() {

	}

	private Personaje getPersonaje(int posicion) {
		ArrayList<Personaje> persona = Personaje.getPersonajes();

		return persona.get(posicion);

	}

}
