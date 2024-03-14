package reloj_clases;

public class Alarma {
    
    String nombre;
    int hora;
    String cancion;

    public Alarma(String nombre, int hora, String cancion) {
        this.nombre = nombre;
        this.hora = hora;
        this.cancion = cancion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public String getCancion() {
        return cancion;
    }

    public void setCancion(String cancion) {
        this.cancion = cancion;
    }
    
}
