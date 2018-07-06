package Animacion;

import java.awt.Graphics2D;

import javax.swing.JFrame;

public class Alerta {
	
	JFrame frame;
	Graphics2D g2d;
	int temporizador;
	Control_Animaciones imagen;
	
	
	public Alerta(JFrame frame , Graphics2D g2d){
		this.frame=frame;
		this.g2d=g2d;
		imagen = new Control_Animaciones(frame,g2d);
		imagen.cargar("/Jugadores/Tommy.png",5,6,32,32);
		
		
		imagen.retrasarFrame=40;
		imagen.posicion.x=250;
		imagen.posicion.y=250;
		imagen.direccionFrame=5;
	}
	
	public void Iniciar_Alerta(){
		
			
		
			imagen.dibujaSprite(true, true);
			
			
		
		
		
		
		
		
	}

}
