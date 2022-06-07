package dominio;

/**
 *
 * @author Aldo Mendivil
 */
public class Socio {
    private long id;
    private String nombre;
    private String telefono;

    public Socio(){
        
    }
    public Socio(long id){
        this.id=id;
    }
    public Socio(long id, String nombre, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
    }
    
    public Socio(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Socio other = (Socio) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "SOCIOS: " + "Id: " + id + ", Nombre: " + nombre + ", Telefono: " + telefono;
    }


}
