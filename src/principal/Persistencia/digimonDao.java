package principal.Persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Personajes.Digimons;

public class digimonDao {

	
	
	
	
	public ArrayList<Digimons> getListaDigimon() {
		Connect conect = new Connect();
		Connection co = conect.connect();
		Statement stm;

		ResultSet rs;

		String sql = "SELECT * FROM digimons order by id";
		ArrayList<Digimons> digmons = new ArrayList<Digimons>();

		try {
			stm = co.createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {

				

			}
			co.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error: Clase ClienteDaoImple, método obtener");
			e.printStackTrace();
		}

		return digmons;
	}
}
