package estados;

import principal.maquinaestado.EstadoActual;
import principal.maquinaestado.GestorMenu;

public class gestorDeEstados {
	private EstadoActual[] estados;
	private EstadoActual estadoActual;

	public gestorDeEstados() {
		iniciarEstado();
		iniciarEstadoActual();
	}

	private void iniciarEstadoActual() {
		estadoActual = estados[0];
	}

	private void iniciarEstado() {
		estados = new EstadoActual[2];
		estados[0]=new GestorMenu();
		

	}

	public void actualizar() {
		estadoActual.actualizar();
	}

	public void cambiarEstadoActual(final int nuevoEstado) {
		estadoActual = estados[nuevoEstado];

	}

	public EstadoActual obtenerEstadoActual() {
		return estadoActual;

	}

}
