package principal.Sprites;

import java.awt.image.BufferedImage;

public class Sprite{
	private final BufferedImage imagen;
	private int ancho;
	private int alto;
	
	
	public Sprite(final BufferedImage imagen) {
		
		this.imagen=imagen;
		ancho = imagen.getWidth();
		alto=imagen.getHeight();
	}
	
	public BufferedImage obtenerImagen() {
		return imagen;
	}
	
	public int obtenerAncho() {
		return ancho;
	}
	
	public int ontenerAlto() {
		return alto;
	}
	
	

}
