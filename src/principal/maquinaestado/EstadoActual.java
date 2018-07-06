package principal.maquinaestado;

import java.awt.Graphics;

public interface EstadoActual {
	public void actualizar();
	public void dibujar(final Graphics g);
}
