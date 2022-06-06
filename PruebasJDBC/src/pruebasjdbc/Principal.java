package pruebasjdbc;

import daos.ConexionBD;
import daos.IConexionBD;
import daos.ISociosDAO;
import daos.SociosDAO;
import dominio.Socio;
import guis.SociosForm;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aldo Mendivil
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IConexionBD conexionBD = new ConexionBD();
        ISociosDAO sociosDAO = new SociosDAO(conexionBD);
        Socio socio = new Socio(7, "Martin Chavez", "6445868956");
        sociosDAO.actualizar(socio);
        
        
        
        new SociosForm(sociosDAO).setVisible(true);
        
        
        
        
        
        
        
        
        
//        List<Socio> socios = sociosDAO.consultarTodos();
//        for(Socio socio: socios){
//            System.out.println(socio);
//        }
//        
//        
        
//        Socio socio = new Socio("Jesus Miranda","6442527845");
//        int registrosAfectados = sociosDAO.agregar(socio);
//        
//        if(registrosAfectados == 1){
//            System.out.println("Se agregó el socio correctamente");
//        } else{
//            System.out.println("No se agregó el socio");
//        }
        
        
    }
    
}
