package principal.Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connect {
	 String url = "C:\\Users\\Alberto\\git\\digivice\\db\\digivice";
	 Connection connect;

	public Connection connect() {
		try {
			connect = DriverManager.getConnection("jdbc:sqlite:" + url);
			if (connect != null) {
				System.out.println("Conectado");
			}
		} catch (SQLException ex) {
			System.err.println("No se ha podido conectar a la base de datos\n" + ex.getMessage());
		}
		return connect;
		
	}
	public void close() throws SQLException {
		connect.close();
	}
	
	
	
}


