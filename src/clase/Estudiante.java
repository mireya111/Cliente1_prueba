package clase;

import lombok.Getter;
import lombok.Setter;

public class Estudiante {
    @Getter @Setter private int id;
    @Getter @Setter private String nombre;
    @Getter @Setter private String telefono;
    @Getter @Setter private String carrera;
    @Getter @Setter private int semestre;
    @Getter @Setter private boolean gratuidad;

    public Estudiante(int id, String nombre, String telefono, String carrera, int semestre, boolean gratuidad) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.carrera = carrera;
        this.semestre = semestre;
        this.gratuidad = gratuidad;
    }

}
