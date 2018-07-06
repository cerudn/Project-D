package Controles;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Teclado implements KeyListener {

	public Tecla a;
	public Tecla b;
	public Tecla c;
	public Tecla Caminar;

	public Teclado() {
		a = new Tecla();
		b = new Tecla();
		c = new Tecla();
		Caminar = new Tecla();
	}

	public void keyTyped(KeyEvent e) {

	}

	public void keyPressed(KeyEvent e) {

		switch (e.getKeyCode()) {
		case KeyEvent.VK_A:
			a.teclaPulsada();

			break;
		case KeyEvent.VK_B:
			b.teclaPulsada();
			break;
		case KeyEvent.VK_C:
			c.teclaPulsada();
			break;
		case KeyEvent.VK_E:
			Caminar.teclaPulsada();
			break;

		}

	}

	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_A:
			a.teclaLiberada();
			break;
		case KeyEvent.VK_B:
			b.teclaLiberada();
			break;
		case KeyEvent.VK_C:
			c.teclaLiberada();
			break;
		case KeyEvent.VK_E:
			Caminar.teclaLiberada();
			break;

		}

	}

}
