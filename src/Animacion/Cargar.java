package Animacion;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JFrame;


public class Cargar {//ññsñs
	Control_Animaciones a;
	Rectangle an;
	Graphics2D sa;
	int temp=2;
	int o=0;
public Cargar(JFrame al,Graphics2D d){
	
	a=new Control_Animaciones(al,d);
	a.posicion.x=0;
	a.posicion.y=0;
	a.cargar("/Menu/Menu.png", 5, 13, 32, 30);
	an=new Rectangle();
}
public void dibujar(){
	
	

		
		a.empezar=13;
		
		
		
		
		if(a.collidesWith(new Point(0,(0-32)))){
			a.posicion.y=32;
			
		}
		if(temp<o){
			a.posicion.y--;
			o=0;
		}
		a.dibujaSprite(true,false);
		o++;
	}
}



