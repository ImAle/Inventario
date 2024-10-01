package servicies;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private static Connection conn = null;
    private static String URL = "jdbc:mysql://localhost:3306/inventario?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static String USER = "user";
    private static String PASSWORD = "user";

    public static Connection conectar() throws SQLException, ClassNotFoundException {
        if (conn == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
                
            } catch (SQLException ex) {
                throw new SQLException(ex);
            } catch (ClassNotFoundException ex) {
                throw new ClassCastException(ex.getMessage());
            }
        }
        return conn;
    }

    public static void cerrarConexion() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }
    
    public static void main(String[] args) {
		try {
			Connection conn = conectar();
			if(conn != null)
				System.out.println("Conexión exitosa");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}