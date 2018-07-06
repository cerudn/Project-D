package Batalla;

import Personajes.Jugador;

public class Control_Batalla {
	
	Jugador a;

		public int ataquejug() {
			return 1;

		}

		public int ataquema() {
			return (int) (Math.random() * 3) + 1;

		}

		public void batalla(Jugador af) {
			// numero 3 == ability , 2 == run 1 == energy
			if (ataquejug() == 3 && ataquema() == 3) {

			} else if (ataquejug() == 2 && ataquema() == 2) {

			} else if (ataquejug() == 1 && ataquema() == 1) {
			} else if (ataquejug() == 3 && ataquema() == 2) {

			} else if (ataquejug() == 3 && ataquema() == 1) {

			} else if (ataquejug() == 3 && ataquema() == 2) {

			} else if (ataquejug() == 2 && ataquema() == 1) {

			} else if (ataquejug() == 2 && ataquema() == 3) {

			} else if (ataquejug() == 1 && ataquema() == 2) {
			} else if (ataquejug() == 1 && ataquema() == 3) {

			}

		}
	}


