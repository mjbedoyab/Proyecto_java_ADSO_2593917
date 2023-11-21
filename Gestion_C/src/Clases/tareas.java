
package Clases;

public class tareas {
    
    private String id_cultivo;
    private String titulo;
    private String descripcion;
    private String estado;

    
    public tareas(String id_cultivo, String titulo, String descripcion, String estado) {
        this.id_cultivo = id_cultivo;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = estado;
    }            

    public String getId_cultivo() {
        return id_cultivo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setId_cultivo(String id_cultivo) {
        this.id_cultivo = id_cultivo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
