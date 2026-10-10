package modelo;

public class ModuloTierra extends Modulo {
    private final String estacion;
    private final double capacidadDescarga;
    private final double energiaPorDescarga;
    private double totalDescargado;

    public ModuloTierra(String id, String nombre, int salud, boolean activo, double costoConstruccion, String estacion, double capacidadDescarga, double energiaPorDescarga) {
    this(id, nombre, salud, activo, costoConstruccion, estacion, capacidadDescarga, energiaPorDescarga, 0);
}

public ModuloTierra(String id, String nombre, int salud, boolean activo, double costoConstruccion, String estacion, double capacidadDescarga, double energiaPorDescarga, double totalDescargado) {
    super(id, nombre, salud, activo, costoConstruccion);
    this.estacion = estacion;
    this.capacidadDescarga = capacidadDescarga;
    this.energiaPorDescarga = energiaPorDescarga;
    this.totalDescargado = totalDescargado;
}
    public String getEstacion() {
        return estacion;
    }

    public double getCapacidadDescarga() {
        return capacidadDescarga;
    }

    public double getEnergiaPorDescarga() {
        return energiaPorDescarga;
    }

    public double getTotalDescargado() {
        return totalDescargado;
    }

     @Override
    public String procesarCiclo(EstadoMision estado) {

        if (!isActivo()) {
            return "El módulo de tierra " + getNombre()
                    + " está inactivo y no descargó datos.";
        }

        if (estado.getEnergiaDisponible() < energiaPorDescarga) {
            return "El módulo de tierra " + getNombre()
                    + " no tiene suficiente energía para descargar.";
        }

        if (estado.getDatosEnOrbita() <= 0) {
            return "El módulo de tierra " + getNombre()
                    + " no encontró datos pendientes en órbita.";
        }

        double cantidadDescargada = Math.min(
                capacidadDescarga,
                estado.getDatosEnOrbita()
        );

        estado.consumirEnergia(energiaPorDescarga);
        estado.descargarDatos(cantidadDescargada);
        totalDescargado += cantidadDescargada;

        return "El módulo de tierra " + getNombre()
                + " consumió " + energiaPorDescarga
                + " unidades de energía y descargó "
                + cantidadDescargada + " MB.";
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nTipo: Módulo de tierra"
                + "\nEstación: " + estacion
                + "\nCapacidad de descarga: "
                + capacidadDescarga + " MB por ciclo"
                + "\nEnergía necesaria por descarga: "
                + energiaPorDescarga
                + "\nTotal histórico descargado: "
                + totalDescargado + " MB";
    }

    
}
