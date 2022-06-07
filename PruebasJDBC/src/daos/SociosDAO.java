package daos;

import dominio.Socio;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.util.LinkedList;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author Aldo Mendivil
 */
public class SociosDAO implements ISociosDAO{

    private IConexionBD conexionBD;
    
    public SociosDAO(IConexionBD conexion) {
        this.conexionBD = conexion;
    }

    @Override
    public int agregar(Socio socio) {
        try{
            Connection conexion = this.conexionBD.crearConexion();
            Statement comandoSQL = conexion.createStatement();
            
            String codigoSQL = String
                    .format("INSERT INTO socios(nombre, telefono) VALUES('%s','%s')",
                            socio.getNombre(),
                            socio.getTelefono());
            int registrosAfectados = comandoSQL.executeUpdate(codigoSQL);
            
            return registrosAfectados;
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return 0;
        }
    }

    @Override
    public List<Socio> consultarTodos() {
        List<Socio> socios = new LinkedList<>();
        try{
            Connection conexion = this.conexionBD.crearConexion();
            
            Statement comandoSQL = conexion.createStatement();
            
            String codigoSQL = String
                    .format("SELECT * FROM socios;");
            
            ResultSet resultados = comandoSQL.executeQuery(codigoSQL);
            
            while(resultados.next()){
                Long idSocio = resultados.getLong("id_socio");
                String nombre = resultados.getString("nombre");
                String telefono = resultados.getString("telefono");
                Socio socio = new Socio(idSocio, nombre, telefono);
                socios.add(socio);
            }
            
            return socios;
        } catch(SQLException ex){
            System.err.println(ex.getMessage());
            return socios;
        }
    }

    @Override
    public int actualizar(Socio socio) {
        try{
            Connection conexion = this.conexionBD.crearConexion();
            Statement comandoSQL = conexion.createStatement();
            
            String codigoSQL = String
                    .format("UPDATE socios SET nombre='%s', telefono='%s' WHERE id_socio=%d",
                            socio.getNombre(),
                            socio.getTelefono(),
                            socio.getId());
            
            int registrosAfectados = comandoSQL.executeUpdate(codigoSQL);
            
            return registrosAfectados;
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return 0;
        }
    }

    @Override
    public int eliminar(Socio socio) {
        try{
            Connection conexion = this.conexionBD.crearConexion();
            Statement comandoSQL = conexion.createStatement();
            
            String codigoSQL = String
                    .format("DELETE FROM socios WHERE id_socio=%d",
                            socio.getId());
            
            int registrosAfectados = comandoSQL.executeUpdate(codigoSQL);
            
            return registrosAfectados;
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return 0;
        }
    }

    @Override
    public Socio consultarSocio(Socio socio) {
        Socio socioEncontrado = null;
        try{
            Connection conexion = this.conexionBD.crearConexion();
            Statement comandoSQL = conexion.createStatement();
            
            String codigoSQL = String
                    .format("SELECT * FROM socios WHERE id_socio=%d",
                            socio.getId());
            
            ResultSet resultado = comandoSQL.executeQuery(codigoSQL);
            
            if(resultado.next()){
                Long idSocio = resultado.getLong("id_socio");
                String nombre = resultado.getString("nombre");
                String telefono = resultado.getString("telefono");
                socioEncontrado = new Socio(idSocio, nombre, telefono);
                
            }
            return socioEncontrado;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
    
    
    
}
