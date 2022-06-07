package daos;

import dominio.Socio;
import java.util.List;

/**
 *
 * @author Aldo Mendivil
 */
public interface ISociosDAO {
    public int agregar(Socio socio);
    public List<Socio> consultarTodos();
    public int actualizar(Socio socio);
    public int eliminar(Socio socio);
    public int consultarSocio();
}
