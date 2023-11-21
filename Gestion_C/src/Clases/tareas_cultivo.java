
package Clases;

public class tareas_cultivo {
    
    private String id_cultivo;
    private String id_agricultor;

    public tareas_cultivo(String id_cultivo, String id_agricultor) {
        this.id_cultivo = id_cultivo;
        this.id_agricultor = id_agricultor;
    }

    public String getId_cultivo() {
        return id_cultivo;
    }

    public String getId_agricultor() {
        return id_agricultor;
    }

    public void setId_cultivo(String id_cultivo) {
        this.id_cultivo = id_cultivo;
    }

    public void setId_agricultor(String id_agricultor) {
        this.id_agricultor = id_agricultor;
    }
    
    
}
