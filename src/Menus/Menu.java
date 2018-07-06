package Menus;

import java.awt.Graphics2D;

import javax.swing.JFrame;

import Controles.Teclado;
import Controles.gestorTeclado;
import Personajes.Personaje;
import Personajes.Player;
import principal.GestorPrincipal;
import principal.Persistencia.ContenedorDP;
import principal.graficos.SuperficieDibujo;
import principal.maquinaestado.GestorEstados;

public class Menu {
	
	
	private int posicion;
	private boolean pulsado;

	private boolean aceptar;
	private boolean sub;
	

	public Menu() {
		posicion = 0;
		sub = false;
		pulsado = false;
		aceptar = true;
		
		
		
		
	}

	public void seleccionaMenu() {

		
			Player re;
			
			System.out.println(getPosicion()+"------");
			re=ContenedorDP.getPlayer(1);
		
			System.out.println(re.getNombre());
			System.out.println(re.getId());
			getPulsacion();
		
		
		}

		
	

	private boolean getPulsacion() {

		if (gestorTeclado.teclado.b.estaPulsada()) {

			aceptar = false;

		} 
		System.out.println(aceptar);
		return aceptar;
	}

	private int getPosicion() {

		if (!sub) {
			if (gestorTeclado.teclado.a.estaPulsada() && posicion < 2 && pulsado) {
				posicion++;
				pulsado = false;
			}  if (posicion > 1) {
				
				posicion = 0;
			} else if (!gestorTeclado.teclado.a.estaPulsada()) {
				pulsado = true;
			}
			
			return posicion;
		} else if (sub) {
			return posicion;
		}
		return posicion;
	}
	public boolean cancelar() {
		return aceptar;
		
	}
	public void setAceptar() {
		aceptar=true;
	}
}
