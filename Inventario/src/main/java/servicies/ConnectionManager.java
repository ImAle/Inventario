package servicies;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private static Connection conn = null;
    private static String URL = "jdbc:mysql://localhost:3306/inventario?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static String USER = "user";
    private static String PASSWORD = "user";

    public static Connection conectar() {
    	try {
    		if (conn == null || conn.isClosed())
    			conn = DriverManager.getConnection(URL, USER, PASSWORD);

    	} catch (SQLException e) {
    		e.printStackTrace();
    	}

    	return conn;
    }

    public static void cerrarConexion() throws SQLException {
    	if (conn != null) {
    		conn.close();
    	}
    }
    
}