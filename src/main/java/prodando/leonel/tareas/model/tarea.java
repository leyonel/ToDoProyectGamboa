package prodando.leonel.tareas.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class tarea {
    @Id
    private String id;
    private String nombre;
    private boolean completado;

    public tarea(String id, String nombre, boolean completado) {
        this.id = id;
        this.nombre = nombre;
        this.completado = completado;
    }
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isCompletado() {
        return completado;
    }

    public void setCompletado(boolean completado) {
        this.completado = completado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setid(String id) {
        this.id = id;
    }
}
