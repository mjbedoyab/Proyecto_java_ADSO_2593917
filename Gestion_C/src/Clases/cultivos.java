
package Clases;


public class cultivos {
    private String id_cultivo;
    private String nombre;
    private String descripcion;
    private String tipo;

    public cultivos(String id_cultivo, String nombre, String descripcion, String tipo) {
        this.id_cultivo = id_cultivo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }

    public String getId_cultivo() {
        return id_cultivo;
    }

    public void setId_cultivo(String id_cultivo) {
        this.id_cultivo = id_cultivo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}
