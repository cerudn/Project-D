package Menus;

import java.awt.Graphics2D;

import javax.swing.JFrame;

import Animacion.Control_Animaciones;

public class MenuNormal {
	JFrame frame;
	Graphics2D g2d;
	int temporizador;
	Control_Animaciones imagen;


	private int posicion;
	private boolean seleccionado;
	private static MenuNormal menu;

	private MenuNormal(JFrame frame, Graphics2D g2d) {

		imagen = new Control_Animaciones(frame, g2d);
		imagen.cargar("/Menu/Menu.png", 5, 7, 32, 32);

		imagen.posicion.x = 250;
		imagen.posicion.y = 250;

	}

	public static MenuNormal getInstancia(JFrame frame, Graphics2D g2d) {
		if (menu == null) {
			menu = new MenuNormal(frame, g2d);

		}
		return menu;

	}

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	public void setSeleccionado(boolean seleccionado) {
		this.seleccionado = seleccionado;
	}

	public boolean isSeleccionado() {
		return seleccionado;
	}

	private void seleccionarCategoria() {
		switch (getPosicion()) {

		case 0:// mostrar imagen mapa
		case 1:
			imagen.empezar = getPosicion();
			imagen.dibujaSprite(true, false);
			System.out.println(1);

		case 2:
			imagen.empezar = getPosicion();
			imagen.dibujaSprite(true, false);
			System.out.println(2);
			break;
		// mostrar imagen spirit
		case 3:
			imagen.empezar = getPosicion();
			imagen.dibujaSprite(true, false);
			System.out.println(3);
			if(isSeleccionado()) {
				
				System.out.print("SELECCIONADO DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");
				// mostrar imagen conexion
			}
		case 4:
			imagen.empezar = getPosicion();
			imagen.dibujaSprite(true, false);
			
			System.out.println(4);// mostrar imagen campamento

		}

	}

	public void subMenu(int posicion, boolean seleccionado) {
		setPosicion(posicion);
		setSeleccionado(seleccionado);

		seleccionarCategoria();

	}

}
