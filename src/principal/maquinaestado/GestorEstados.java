package principal.maquinaestado;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Controles.gestorTeclado;
import Personajes.drive;
import principal.Persistencia.ContenedorDP;
import principal.Sprites.HojaSprites;
import principal.graficos.SuperficieDibujo;

public class GestorEstados {
	private drive jugador;
	private EstadoActual[] estados;
	private EstadoActual estadoActual;
	private HojaSprites hsJugador;
	private boolean activo;

	public GestorEstados(final SuperficieDibujo sd) {
		ContenedorDP f = new ContenedorDP();
		jugador = new drive(ContenedorDP.getPlayer(2));
		hsJugador = new HojaSprites("/Menu/panel2.png", 228, 350, false);

		iniciarEstados(sd);
		iniciarEstadoActual();

	}

	private void iniciarEstados(final SuperficieDibujo sd) {

		estados = new EstadoActual[4];
		estados[0] = new GestorMenu();
		estados[1] = new GestorJugador(jugador);
		estados[2] = new GestorMenu2();

	}

	private void iniciarEstadoActual() {
		estadoActual = estados[1];
	}

	public void actualizar() {
		estadoActual.actualizar();

	}

	public void dibujar(final Graphics g) {
		BufferedImage imagen;
		estadoActual.dibujar(g);
		imagen = hsJugador.obtenerSprite(0).obtenerImagen();
		g.drawImage(imagen, 125, 0, null);

	}

	public void cambiarEstadoActual(final int nuevoEstado) {
		estadoActual = estados[nuevoEstado];
	}

	public EstadoActual obtenerEstadoActual() {
		return estadoActual;
	}
}
