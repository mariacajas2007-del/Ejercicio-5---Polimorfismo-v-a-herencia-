package modelo;
public abstract class Modulo {
    private String id;
    private String nombre;
    private int salud;
    private boolean activo;
    private double costoConstruccion;

    public Modulo(String id, String nombre, int salud, boolean activo, double costoConstruccion) {
        this.id = id;
        this.nombre = nombre;
        this.salud = salud;
        this.activo = activo;
        this.costoConstruccion = costoConstruccion;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getSalud() {
        return salud;
    }

    public boolean isActivo() {
        return activo;
    }

    public double getCostoConstruccion() {
        return costoConstruccion;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public void setCostoConstruccion(double costoConstruccion) {
        this.costoConstruccion = costoConstruccion;
    }

    public abstract String procesarCiclo(EstadoMision estado);

    @Override 
    public String toString() {
    return "ID: " + id
            + "\nNombre: " + nombre
            + "\nSalud: " + salud + "%"
            + "\nActivo: " + (activo ? "Sí" : "No")
            + "\nCosto de construcción: Q" + costoConstruccion;
}
}
