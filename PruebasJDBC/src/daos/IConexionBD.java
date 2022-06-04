package daos;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Aldo Mendivil
 */
public interface IConexionBD {
    Connection crearConexion() throws SQLException;
}
