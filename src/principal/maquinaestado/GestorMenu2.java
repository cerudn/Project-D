package principal.maquinaestado;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import Controles.gestorTeclado;
import Menus.Menu;
import principal.Sprites.HojaSprites;

public class GestorMenu2 implements EstadoActual {
	private ArrayList<String> Categorias;
	private Menu menu;
	private int posicion;
	private boolean pulsado;
	private boolean cancelar;
	private String EstadoMenu;
	private HojaSprites hs;

	public GestorMenu2() {
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
		Categorias.add("DATABASE");
		Categorias.add("DIGITS");
		Categorias.add("GAME");
		Categorias.add("SEARCH");
		

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
			case "DATABASE":

				break;
			case "DIGITS":

				break;
			case "GAME":

				break;
			case "SEARCH":
				menu.seleccionaMenu();
				cancelar = menu.cancelar();

				break;
			

			}
		}

	}

	private int getPosicion() {

		if (gestorTeclado.teclado.a.estaPulsada() && posicion < 5 && pulsado) {
			posicion++;
			pulsado = false;
		}
		if (posicion > 3) {

			posicion = 0;
		} else if (!gestorTeclado.teclado.a.estaPulsada()) {
			pulsado = true;
		}

		return posicion;

	}

	public void dibujar(Graphics g) {
		BufferedImage imagen;
		switch (EstadoMenu) {
		case "DATABASE":
			imagen = hs.obtenerSprite(0, 1).obtenerImagen();
			g.drawImage(imagen, 205, 90, null);
			break;
		case "DIGITS":
			imagen = hs.obtenerSprite(1,1).obtenerImagen();
			g.drawImage(imagen, 205, 90, null);
			break;
		case "GAME":
			imagen = hs.obtenerSprite(2, 1).obtenerImagen();
			g.drawImage(imagen, 205, 90, null);
			break;
		case "SEARCH":
			imagen = hs.obtenerSprite(3, 1).obtenerImagen();
			g.drawImage(imagen, 205, 90, null);
			break;
		
		}

	}

}
