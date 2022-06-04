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
}