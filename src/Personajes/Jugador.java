package Personajes;

import java.awt.Graphics2D;

import javax.swing.JFrame;

import Animacion.Control_Animaciones;
import Animacion.Estados_Personaje;
import Controles.Teclado;

public class Jugador {

	public boolean visible;
	public int pasosini;
	public int pasos;
	public int pulsaciones;

	public String person;

	public Estados_Personaje Estado;
	public boolean descanso;
	public final int temporizar = 600;
	public int tiempoCaminar;
	public int tiempoRecuperacion;
	public int spirit;

	/*
	 * public Graphics2D g2d; public JFrame frame;
	 */

	public Jugador(JFrame frame, Graphics2D g2d, String person) {
		setVisible(true);
		pasos = 0;
		tiempoCaminar = 0;
		pulsaciones = 0;
		pasosini = 1000;
		Estado = new Estados_Personaje(frame, g2d);
		this.person = person;
		this.spirit = 10;

	}

	public void setVisible(boolean visib) {
		visible = visib;

	}

	public boolean getVisible() {
		return visible;
	}

	public void caminar(Teclado pulso) {

		tiempoCaminar++;
		// System.out.println(an.arriba);
		if (tiempoCaminar < 160) {
			Estado.Caminar();

		} else {
			Espera();
		}

		if (tiempoCaminar > 10) {
			// System.out.println(an.arriba);
			if (pulso.arriba && pulsaciones == 0) {
				pulsaciones = 1;
				pasosini--;

				System.out.println(pasosini);
				tiempoCaminar = 0;

			} else if (!pulso.arriba && pulsaciones == 1) {

				pulsaciones = 0;

			}
		}

		/*
		 * if (getVisible()) {
		 * 
		 * Estado.Caminar();
		 * 
		 * 
		 * }
		 */

	}

	public void setSpirit(int spiri) {
		if (this.spirit < 99 && spiri > 0) {
			this.spirit += spiri;
		} else if (this.spirit > 0 && spiri < 0 && spirit + spiri >= 0) {
			this.spirit += spiri;
		}

	}

	public int getSpirit() {
		return spirit;
	}

	/*
	 * public void setDescanso(boolean des) { this.descanso = des;
	 * 
	 * }
	 * 
	 * public boolean getDescanso() { return descanso; }
	 */
	public void Espera() {
		Estado.Espera();
	}

	public void Descansar() {
		tiempoRecuperacion++;
		// Estado.Descansar();
		if (temporizar < tiempoRecuperacion) {
			tiempoRecuperacion = 0;
			setSpirit(-10);
			System.out.print("Carga " + getSpirit());

		}

	}

	public void Alerta() {
		Estado.Alerta();

	}

	public void Derrota() {
		Estado.Derrota();

	}

	public void Ganar() {
		Estado.Ganar();

	}
}
