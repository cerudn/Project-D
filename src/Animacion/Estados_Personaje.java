package Animacion;

import java.awt.Graphics2D;

import javax.swing.JFrame;

public class Estados_Personaje {

	JFrame frame;
	Graphics2D g2d;
	int temporizador;
	Control_Animaciones imagen;
	int cont;

	public Estados_Personaje(JFrame frame, Graphics2D g2d) {
		this.frame = frame;
		this.g2d = g2d;
		cont = 0;
		imagen = new Control_Animaciones(frame, g2d);
		imagen.cargar("/Jugadores/Tommy.png", 5, 7, 32, 32);

		imagen.retrasarFrame = 40;
		imagen.posicion.x = 250;
		imagen.posicion.y = 250;

	}

	public void Alerta() {
		imagen.posicionEmpezar=0;
		imagen.numeroFrames = 6;
		imagen.direccionFrame = 5;

		imagen.dibujaSprite(true, true);

	}

	public void Derrota() {
		imagen.posicionEmpezar=0;
		imagen.numeroFrames = 7;
		imagen.direccionFrame = 6;

		imagen.dibujaSprite(true, true);

	}

	public void Ganar() {
		imagen.posicionEmpezar=0;
		imagen.numeroFrames = 5;
		imagen.direccionFrame = 4;

		imagen.dibujaSprite(true, true);

	}

	public void Caminar() {

		if (cont < 1) {
			imagen.empezar = 2;
			cont++;
		}
		imagen.numeroFrames = 4;

		imagen.direccionFrame = 1;
		imagen.posicionEmpezar = 2;

		imagen.dibujaSprite(true, true);

	}

	public void Espera() {
		imagen.posicionEmpezar=0;
		imagen.numeroFrames = 2;
		imagen.direccionFrame = 1;

		imagen.dibujaSprite(true, true);

	}
	
}
