package principal.graficos;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

import Controles.gestorTeclado;

import principal.maquinaestado.GestorEstados;

public class SuperficieDibujo extends Canvas {

	private static final long serialVersionUID = 7214367941942913413L;

	private int ancho;
	private int alto;

	public SuperficieDibujo(final int ancho, final int alto) {
		this.ancho = ancho;
		this.alto = alto;

		setIgnoreRepaint(true);

		setPreferredSize(new Dimension(ancho, alto));
		addKeyListener(gestorTeclado.teclado);

		setFocusable(true);
		requestFocus();
	}

	public void actualizar() {

	}

	public void dibujar(final GestorEstados ge) {
		final BufferStrategy buffer = getBufferStrategy();

		if (buffer == null) {
			createBufferStrategy(4);
			return;
		}

		final Graphics2D g = (Graphics2D) buffer.getDrawGraphics();

		ge.dibujar(g);

		g.setColor(Color.white);
		g.fillRect(0, 0, ancho, alto);
		// Toolkit.getDefaultToolkit().sync();
		ge.dibujar(g);
		g.dispose();

		buffer.show();

	}

	public int obtenerAncho() {
		return ancho;
	}

	public int obtenerAlto() {
		return alto;
	}

}
