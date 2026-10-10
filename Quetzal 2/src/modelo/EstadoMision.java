package modelo;
public class EstadoMision {
    private double energiaDisponible;
    private double datosEnOrbita;
    private double totalDatosDescargados;
    
    public EstadoMision(double energiaInicial) {
        this.energiaDisponible = energiaInicial;
        this.datosEnOrbita = 0;
        this.totalDatosDescargados = 0;
    }

    public double getEnergiaDisponible() {
        return energiaDisponible;
    }

    public double getDatosEnOrbita() {
        return datosEnOrbita;
    }

    public double getTotalDatosDescargados() {
        return totalDatosDescargados;
    }

    public void agregarEnergia(double cantidad) {
        energiaDisponible += cantidad;
    }

    public boolean consumirEnergia(double cantidad) {
        if (cantidad <= energiaDisponible) {
            energiaDisponible -= cantidad;
            return true;
        }
        return false;
    }

    public void agregarDatosEnOrbita(double cantidad) {
        datosEnOrbita += cantidad;
    }

    public void descargarDatos(double cantidad) {
        datosEnOrbita -= cantidad;
        totalDatosDescargados += cantidad;
       
    }

    @Override 

     public String toString() {
        return "Energía disponible: " + energiaDisponible
                + "\nDatos en órbita: " + datosEnOrbita + " MB"
                + "\nTotal de datos descargados: "
                + totalDatosDescargados + " MB";
    }

}