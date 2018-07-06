package principal.maquinaestado;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

import Controles.gestorTeclado;
import Menus.Menu;
import principal.GestorPrincipal;
import principal.Sprites.HojaSprites;
import principal.graficos.SuperficieDibujo;

public class GestorMenu implements EstadoActual {
	private ArrayList<String> Categorias;
	private Menu menu;
	private int posicion;
	private boolean pulsado;
	private boolean cancelar;
	private String EstadoMenu;
	private HojaSprites hs;

	public GestorMenu() {
		hs = new HojaSprites("/Menu/Menu.png", 30, 32, false);
		menu = new Menu();
		posicion = 0;
		cancelar = false;
		pulsado = false;
		Categorias = new ArrayList<String>();
		EstadoMenu = "Mapa";
		añadirCategorias();
	}

	private void añadirCategorias() {
		Categorias.add("Mapa");
		Categorias.add("Person");
		Categorias.add("Spirit");
		Categorias.add("Sleep");
		Categorias.add("Conection");

	}

	public void actualizar() {
		seleccionar();

	}

	private void seleccionar() {
		if (!cancelar) {
			EstadoMenu = Categorias.get(getPosicion());
			menu.setAceptar();

		}

		if (gestorTeclado.teclado.c.estaPulsada() || cancelar) {

			switch (EstadoMenu) {
			case "Mapa":

				break;
			case "Person":

				break;
			case "Spirit":

				break;
			case "Sleep":
				menu.seleccionaMenu();
				cancelar = menu.cancelar();

				break;
			case "Conection":

				break;

			}
		}

	}

	private int getPosicion() {

		if (gestorTeclado.teclado.a.estaPulsada() && posicion < 6 && pulsado) {
			posicion++;
			pulsado = false;
		}
		if (posicion > 4) {

			posicion = 0;
		} else if (!gestorTeclado.teclado.a.estaPulsada()) {
			pulsado = true;
		}

		return posicion;

	}

	public void dibujar(Graphics g) {
		BufferedImage imagen;
		switch (EstadoMenu) {
		case "Mapa":
			imagen = hs.obtenerSprite(2, 0).obtenerImagen();
			g.drawImage(imagen, 200, 200, null);
			break;
		case "Person":
			imagen = hs.obtenerSprite(3, 0).obtenerImagen();
			g.drawImage(imagen, 200, 200, null);
			break;
		case "Spirit":
			imagen = hs.obtenerSprite(4, 0).obtenerImagen();
			g.drawImage(imagen, 200, 200, null);
			break;
		case "Sleep":
			imagen = hs.obtenerSprite(0, 0).obtenerImagen();
			g.drawImage(imagen, 200, 200, null);
			break;
		case "Conection":
			g.setColor(Color.black);
			g.drawString("En progreso", 200, 200);
			break;
		case"nada":
			break;
		}

	}
	public boolean getAtras() {
		return cancelar;
		
	}

}
