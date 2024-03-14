package reloj_clases;

public class Alarma {
    
    String nombre;
    String hour;
    String cancion;

    public Alarma(String nombre, String hora, String cancion) {
        this.nombre = nombre;
        this.hour = hora;
        this.cancion = cancion;
    }

    @Override
    public String toString() {
        return "Nombre= " + nombre + ", Hora= " + hour + ", Cancion= " + cancion    ;
    }

    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHour() {
        return hour;
    }

        public void setHour(String hora) {
        this.hour = hora;
    }

    public String getCancion() {
        return cancion;
    }

    public void setCancion(String cancion) {
        this.cancion = cancion;
    }
    
}
