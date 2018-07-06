package Lanzador;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.JFrame;

import Animacion.Alerta;
import Animacion.Cargar;
import Animacion.Control_Animaciones;
import Animacion.Derrota;
import Animacion.Estados_Batalla;
import Animacion.Estados_Personaje;
import Animacion.Ganar;
import Controles.Teclado;
import Controles.gestorTeclado;
import Menus.Menu;
import Personajes.Jugador;
import estados.gestorDeEstados;

public class Lanzadora extends JFrame implements Runnable {
	static int ScreenWidth = 400;
	static int ScreenHeight = 400;
	Thread gameloop;
	private gestorDeEstados estados;
	BufferedImage backbuffer;
	Graphics2D g2d;

	public static void main(String[] args) {
		new Lanzadora();

	}

	public Lanzadora() {
		super("Animation Class Demo");
		setSize(ScreenWidth, ScreenHeight);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addKeyListener(gestorTeclado.teclado);
		estados=new gestorDeEstados();
		backbuffer = new BufferedImage(ScreenWidth, ScreenHeight, BufferedImage.TYPE_INT_RGB);

		g2d = backbuffer.createGraphics();

		gameloop = new Thread(this);
		gameloop.start();

	}

	public void run() {
		final int nanosegundoactualizar = 1000000000;
		final byte objetivo = 60;
		final double nanosegundoporactualizacion = nanosegundoactualizar / objetivo;
		long referencia = System.nanoTime();
		double transcurrido;
		double delta = 0;

		while (true) {
			final long inicio = System.nanoTime();
			transcurrido = inicio - referencia;
			referencia = inicio;
			delta += transcurrido / nanosegundoporactualizacion;
			while (delta > 1) {
				gameUpdate();
				delta--;
			}

		}
	}

	public void gameUpdate() {
		
		estados.actualizar();

		repaint();
	}

	public void paint(Graphics g) {
		// draw the back buffer to the screen
		g.drawImage(backbuffer, 0, 0, this);
	}

}
