package principal.maquinaestado;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import Controles.gestorTeclado;
import Personajes.Digimons;
import Personajes.drive;
import principal.Sprites.HojaSprites;

public class GestorJugador implements EstadoActual {
	private boolean pulsado;
	private int posicion;
	private drive jugador;
	private boolean caminar;
	private boolean aceptar;
	private int distancia;
	private int pasos;
	private HojaSprites hsJugador;
	private HojaSprites hsCompaneros;
	private HojaSprites pos;
	private int Temporizar;
	private int cambioAnimacion;
	private int descansa;
	private int Temporizador;
	private int posicionPa = 200;
	private int posicionPay = 100;
	int a;
	int b;
	int c;
	int d;

	public GestorJugador(drive ju) {
		hsJugador = new HojaSprites("/Jugadores/Tommy.png", 30, 32, false);
		posicion = 0;
		aceptar = false;
		pulsado = false;
		jugador = ju;
		caminar = false;
		distancia = jugador.getDistance();
		pasos = jugador.getSteps();
		Temporizar = 0;
		descansa = 0;
		Temporizador = 0;
		aleatorio();
	}

	public void actualizar() {
		caminar();

	}

	private void caminar() {
		if (gestorTeclado.teclado.Caminar.estaPulsada() && caminar) {
			caminar = false;
			cambioAnimacion = 0;
			descansa = 1;
			jugador.setSteps(++pasos);
			if (jugador.getDistance() != 0) {
				jugador.setDistance(--distancia);
			}

		} else if (!gestorTeclado.teclado.Caminar.estaPulsada()) {
			caminar = true;

		}

	}

	public void dibujar(final Graphics g) {
		if (gestorTeclado.teclado.a.estaPulsada()) {
			aceptar = true;
			Temporizador = 0;
		}
		if (aceptar) {
			System.out.println(posicion);
			seleccionar(g);

			if (!gestorTeclado.teclado.a.estaPulsada()) {
				Temporizador++;
				System.out.println(Temporizador);
				if ((Temporizador > 20000) || gestorTeclado.teclado.c.estaPulsada()) {
					aceptar = false;
					posicion = 5;
					descansa = 0;

				}

			}
		} else if (!aceptar) {

			switch (descansa) {
			case 1:
				if (cambioAnimacion == 11000) {
					descansa = 0;
					cambioAnimacion = 0;

				}
				cambioAnimacion++;

				dibCaminar(g);
				break;
			case 0:
				dibDescansar(g);
				break;
			}
		}

	}

	private void dibDescansar(Graphics g) {
		BufferedImage imagen;

		if (Temporizar < 7000) {
			imagen = hsJugador.obtenerSprite(a, 0).obtenerImagen();
			g.drawImage(imagen, posicionPa, posicionPay, null);
			Temporizar++;
		} else if (Temporizar < 11000) {
			imagen = hsJugador.obtenerSprite(b, 0).obtenerImagen();

			g.drawImage(imagen, posicionPa, posicionPay, null);
			Temporizar++;
		} else if (Temporizar < 18000) {

			imagen = hsJugador.obtenerSprite(c, 0).obtenerImagen();

			g.drawImage(invertirImagen(imagen), posicionPa, posicionPay, null);
			Temporizar++;
		} else if (Temporizar < 24000) {
			imagen = hsJugador.obtenerSprite(d, 0).obtenerImagen();

			g.drawImage(invertirImagen(imagen), posicionPa, posicionPay, null);
			Temporizar++;
		} else {

			aleatorio();
			imagen = hsJugador.obtenerSprite(a, 0).obtenerImagen();
			g.drawImage(imagen, posicionPa, posicionPay, null);
			Temporizar = 0;
		}

	}

	private void dibCaminar(final Graphics g) {
		BufferedImage imagen;
		if (Temporizar < 4000) {
			imagen = hsJugador.obtenerSprite(2, 0).obtenerImagen();
			g.drawImage(imagen, posicionPa, posicionPay, null);

			Temporizar++;

		} else if (Temporizar < 7000) {
			imagen = hsJugador.obtenerSprite(3, 0).obtenerImagen();
			g.drawImage(imagen, posicionPa, posicionPay, null);
			Temporizar++;
			;
		} else {
			imagen = hsJugador.obtenerSprite(2, 0).obtenerImagen();
			g.drawImage(imagen, posicionPa, posicionPay, null);
			Temporizar = 0;
		}
	}

	private void seleccionar(final Graphics g) {
		BufferedImage imagen;

		pos = new HojaSprites("/Menu/Empty.png", 64, false);
		System.out.println(posicion);
		switch (getPosicion()) {
		case 0:
			dibDatosDistancia(g);

			break;
		case 1:
			dibDatosWins(g);
			break;
		case 3:

			imagen = pos.obtenerSprite(0, 0).obtenerImagen();
			g.drawImage(imagen, 187, 78, null);
			Digimons digi0 = jugador.getCompanions()[0];

			if (digi0 != null) {
				hsCompaneros = new HojaSprites("/Digimons/" + digi0.getNombre() + ".png", 72, false);
				imagen = hsCompaneros.obtenerSprite(0, 0).obtenerImagen();
				g.drawImage(imagen, posicionPa, posicionPay, null);
			}else {
				g.setColor(Color.BLACK);
				g.drawString("EMPTY", 200, 120);
			}

			break;
		case 2:
			dibDatosSpirit(g);
			break;
		case 4:
			imagen = pos.obtenerSprite(0, 0).obtenerImagen();
			g.drawImage(imagen, 187, 78, null);
			Digimons digi1 = jugador.getCompanions()[1];
			if (digi1 != null) {
				hsCompaneros = new HojaSprites("/Digimons/" + digi1.getNombre() + ".png", 72, false);
				imagen = hsCompaneros.obtenerSprite(0, 0).obtenerImagen();
				g.drawImage(imagen, posicionPa, posicionPay, null);
			}else {
				g.setColor(Color.BLACK);
				g.drawString("EMPTY", 200, 120);
			}

			break;
		case 5:
			imagen = pos.obtenerSprite(0, 0).obtenerImagen();
			g.drawImage(imagen, 187, 78, null);
			Digimons digi2 = jugador.getCompanions()[2];
			if (digi2 != null) {
				hsCompaneros = new HojaSprites("/Digimons/" + digi2.getNombre() + ".png", 72, false);
				imagen = hsCompaneros.obtenerSprite(0, 0).obtenerImagen();
				g.drawImage(imagen, posicionPa, posicionPay, null);
			}else {
				g.setColor(Color.BLACK);
				g.drawString("EMPTY", 200, 120);
			}
			break;
		case 6:
			imagen = pos.obtenerSprite(0, 0).obtenerImagen();
			g.drawImage(imagen, 187, 78, null);
			Digimons digi3 = jugador.getCompanions()[3];
			if (digi3 != null) {
				hsCompaneros = new HojaSprites("/Digimons/" + digi3.getNombre() + ".png", 72, false);
				imagen = hsCompaneros.obtenerSprite(0, 0).obtenerImagen();
				g.drawImage(imagen, posicionPa, posicionPay, null);
			} else {
				g.setColor(Color.BLACK);
				g.drawString("EMPTY", 200, 120);
			}
			break;
		}

	}

	private void dibDatosSpirit(final Graphics g) {
		String numero = jugador.getSpirit_power() + "";
		int x = (numero.length() - 1) * 7;

		g.setColor(Color.BLACK);
		g.drawString("SPIRITS", 195, 89);

		g.drawString("POWER", 195, 99);
		g.drawString(numero, 235 - x, 135);
	}

	private void dibDatosDistancia(final Graphics g) {
		String numero = jugador.getSteps() + "";
		String numero1 = jugador.getDistance() + "";

		int x = (numero.length() - 1) * 7;
		int x1 = (numero1.length() - 1) * 7;
		System.out.println(x1);
		g.setColor(Color.BLACK);
		g.drawString("DISTANCE", 190, 89);
		g.drawString(numero1, 245 - x1, 102);
		g.drawString("STEPS", 190, 122);
		g.drawString(numero, 245 - x, 135);

	}

	private void dibDatosWins(final Graphics g) {
		String numero = jugador.getWins() + "";
		String numero1 = jugador.getVictoryOnline() + "%";
		int x = (numero.length() - 1) * 7;
		int x1 = (numero1.length() - 1) * 7;
		g.setColor(Color.BLACK);
		g.drawString("VICTORY", 190, 89);
		g.drawString(numero1, 233 - x1, 102);
		g.drawString("WIN", 190, 122);
		g.drawString(numero, 227 - x, 135);

	}

	// Modificar getPosicion
	private int getPosicion() {

		if (gestorTeclado.teclado.a.estaPulsada() && pulsado) {
			posicion++;
			pulsado = false;
		}
		if (posicion > 5) {

			posicion = 0;
		} else if (!gestorTeclado.teclado.a.estaPulsada()) {
			pulsado = true;
		}

		return posicion;

	}

	private BufferedImage invertirImagen(BufferedImage imagen) {

		AffineTransform tx = AffineTransform.getScaleInstance(-1.0, 1.0); // scaling
		tx.translate(-imagen.getWidth(), 0); // translating
		AffineTransformOp tr = new AffineTransformOp(tx, null);
		imagen = tr.filter(imagen, null);
		return imagen;

	}

	private void aleatorio() {

		a = (int) ((Math.random() * 2) + 1) - 1;
		b = (int) ((Math.random() * 2) + 1) - 1;
		c = (int) ((Math.random() * 2) + 1) - 1;
		d = (int) ((Math.random() * 2) + 1) - 1;

	}
}
