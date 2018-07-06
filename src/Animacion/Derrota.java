package Animacion;

import java.awt.Graphics2D;

import javax.swing.JFrame;

public class Derrota {
	
	JFrame frame;
	Graphics2D g2d;
	int temporizador;
	Control_Animaciones imagen;
	
	
	public Derrota(JFrame frame , Graphics2D g2d){
		this.frame=frame;
		this.g2d=g2d;
		
		imagen = new Control_Animaciones(frame,g2d);
		imagen.cargar("/Jugadores/Tommy.png",5,7,32,32);
		
		
		imagen.retrasarFrame=40;
		imagen.posicion.x=250;
		imagen.posicion.y=250;
		imagen.direccionFrame=6;
	}

	
	
	public void Iniciar_Alerta(){
		 imagen.numeroFrames=5;
		 imagen.direccionFrame=4;
		
		
			imagen.dibujaSprite(true, true);
			
			
		
		
		
		
		
		
	}

}
