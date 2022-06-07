package daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Aldo Mendivil
 */
public class ConexionBD implements IConexionBD {

    private final String CADENA_CONEXION = "jdbc:mysql://localhost/club_nautico";
    private final String USUARIO = "root";
    private final String PASSWORD = "123456";

    @Override
    public Connection crearConexion() throws SQLException {
        Connection conexion = DriverManager.getConnection(CADENA_CONEXION, USUARIO, PASSWORD);
        return conexion;
    }
    
}
