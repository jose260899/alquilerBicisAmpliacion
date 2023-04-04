package alquilerBici;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * Clase connectionSingleton utilizada para establecer la conexión con la base de datos
 * @author Mónica Alcañiz y José Ayala
 * @version 04/04/2023
 *
 */
public class ConnectionSingleton {
	/**
	 * Variable estática y privada con que almacena la conexión a la base de datos
	 */
	private static Connection con;
	/**
	 * Método Connection getConnection de tipo público y estático que devuelve si ha habido o no conexión
	 * @param URL. Parámetro de tipo String que específica la dirección del servidor de la base de datos
	 * @param USER. Parámetro de tipo String que hace referencia al nombre del usuario.
	 * @param PASSWORD. Parámetro de tipo String que hace referencia a la contraseña del usuario
	 * @return con valor de retorno de tipo Connection que especifíca si la conexión se ha establecido o no
	 * @throws SQLException. Excepción lanzada si hay problemas para conectarse a la base de datos
	 */
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:mysql://127.0.0.1:3307/alquilerBici";
		String user = "alumno";
		String password = "alumno";
		if (con == null || con.isClosed()) {
			con = DriverManager.getConnection(url, user, password);
		}
		return con;
	}
}
