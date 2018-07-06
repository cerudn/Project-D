package Menus;

import java.util.ArrayList;

public class Invocador {
private ArrayList<Icommand>comandos;

public Invocador() {
	
}

public void setCommand(Icommand comando) {
	
	comandos.add(comando);
	
}

public Icommand getComando(int comando) {
	return comandos.get(comando);
}
}
