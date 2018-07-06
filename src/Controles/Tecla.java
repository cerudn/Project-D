package Controles;

public class Tecla {
	private boolean pulsada;


	public Tecla() {
		
	}

	public void teclaPulsada() {

		
			
		
			pulsada = true;
			
		
	}

	public void teclaLiberada() {
		pulsada = false;
	}

	public boolean estaPulsada() {
		return pulsada;
	}
	
	public void setEstapulsada(boolean pulsa) {
		pulsada=pulsa;
	}
}
