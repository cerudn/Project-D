package Menus;

import Controles.gestorTeclado;
import principal.graficos.SuperficieDibujo;
import principal.maquinaestado.GestorEstados;

public class Personajes {
	private int posicion;
	private boolean pulsado;
	private GestorEstados gestor;

	public Personajes(GestorEstados ge) {
		posicion = 1;
		pulsado = false;
		gestor = ge;
	}

	

	public void Abrir() {
		System.out.print("Abierto");

	}

	public void seleccionaMenu() {

		switch (getPosicion()) {

		case 1:

			System.out.println(11);

			break;
		case 2:
			System.out.println(21);
			break;
		case 3:
			System.out.println(31);
			
			break;
		case 4:

			System.out.println(41);
			break;
		case 5:
			System.out.println(51);
			gestor.cambiarEstadoActual(0);
			break;
		case 6:
			//gestor.cambiarEstadoActual(0);

		}

	}

	private int getPosicion() {

		if (gestorTeclado.teclado.a.estaPulsada() && posicion < 6 && pulsado) {
			posicion++;
			pulsado = false;

		} else if (!gestorTeclado.teclado.a.estaPulsada()) {
			pulsado = true;
		} else if (gestorTeclado.teclado.b.estaPulsada()) {
			posicion = 6;
		} else if (posicion > 5) {
			posicion = 1;
		}
		return posicion;
	}

}
