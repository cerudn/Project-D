package Menus;

public class ComandoPersona implements Icommand{

	
	private Personajes per;
	
	public ComandoPersona(Personajes per) {
		this.per=per;
		
	}
	public void ejecutar() {
		per.Abrir();
		
	}
	

}
