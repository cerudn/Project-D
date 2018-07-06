package Animacion;

import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.JFrame;

import java.awt.Color;

public class Estados_Batalla {

	JFrame frame;
	Graphics2D g2d;
	int temporizador;
	Control_Animaciones imagen;
	Control_Animaciones imagen1;
	int cont;

	public Estados_Batalla(JFrame frame, Graphics2D g2d, String direccion) {
		this.frame = frame;
		this.g2d = g2d;
		cont = 0;
		imagen = new Control_Animaciones(frame, g2d);
		imagen1 = new Control_Animaciones(frame, g2d);
		imagen.cargar(direccion, 5, 7, 32, 32);
		imagen1.cargar("/Energy/Ball.png", 5, 7, 32, 32);

		imagen.retrasarFrame = 40;
		imagen.posicion.x = 250;
		imagen.posicion.y = 250;
		imagen1.retrasarFrame = 200;
		imagen1.posicion.x = 253;
		imagen1.posicion.y = 250;

	}

	public void AtaqueEnergy(int temporizar) {
		//System.out.print("ok");
		if (temporizar < 79) {
			imagen.retrasarFrame = 70;
			imagen.posicionEmpezar = 0;
			imagen.numeroFrames = 2;
			imagen.direccionFrame = 1;
			imagen.dibujaSprite(true, true);
		} else {
			imagen1.posicionEmpezar = 1;
			imagen.dibujaSprite(true, false);
			imagen1.posicion.x += -1;
			Bola();
		}
		
		if (colision(imagen1)) {
			System.out.print("ok");
		}

	}

	public void Bola() {
		imagen1.posicionEmpezar = 0;
		imagen1.dibujaSprite(true, false);

		imagen1.rectangulo(Color.RED);

	}

	public boolean colision(Control_Animaciones imagen12) {
		Point a=new Point(200,250);
		
		if(imagen12.collidesWith(a)){
			return true;
		}
			return false;
	}
}
