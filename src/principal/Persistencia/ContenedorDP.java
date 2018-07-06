package principal.Persistencia;

import java.util.ArrayList;
import java.util.HashMap;

import Personajes.Digimons;
import Personajes.Player;

public class ContenedorDP {
	
	private static HashMap<String,Digimons>digimons;
	private static ArrayList<Player> players;
	public ContenedorDP() {
		super();
		this.digimons = new HashMap<String,Digimons>();;
		this.players = new ArrayList<Player>();
		
		iniciarPlayer();
		iniciarDigimons();
		
	}
	private void iniciarDigimons() {
		
		Digimons digimon=new Digimons(0, "Agunimon",'c', "ICE", 100, 50, 20,60, 1, false, 440, "12345");
		
		digimons.put("12345", digimon);
		
	}
	private void iniciarPlayer() {
		Player takuya = new Player();
		Player koji = new Player();
		Player J_P = new Player();
		Player Tommy = new Player();
		Player Zoe = new Player();
		
		players.add(takuya);
		players.add(koji);
		players.add(J_P);
		players.add(Zoe);
		players.add(Tommy);
		
		
		
		
	}
	
	
	public static Player getPlayer(int player) {
		return players.get(player);
		
	}
	
	
	public static Digimons getDigimon(String Codigo) {
		return digimons.get(Codigo);
		
	}
	
	

}
