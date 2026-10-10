package modelo;

public class ModuloEnergia extends Modulo {
    private final double energiaPorCiclo;
    private int ciclosAcumulados;
    private double totalEnergiaGenerada;

    public ModuloEnergia(String id, String nombre, int salud, boolean activo, double costoConstruccion, double energiaPorCiclo) {
    this(id, nombre, salud, activo, costoConstruccion, energiaPorCiclo,0, 0);
}

public ModuloEnergia(String id, String nombre, int salud, boolean activo, double costoConstruccion, double energiaPorCiclo, int ciclosAcumulados, double totalEnergiaGenerada) {

    super(id, nombre, salud, activo, costoConstruccion);
    this.energiaPorCiclo = energiaPorCiclo;
    this.ciclosAcumulados = ciclosAcumulados;
    this.totalEnergiaGenerada = totalEnergiaGenerada;
}

    public double getEnergiaPorCiclo() {
        return energiaPorCiclo;
    }

    public int getCiclosAcumulados() {
        return ciclosAcumulados;
    }

    public double getTotalEnergiaGenerada() {
        return totalEnergiaGenerada;
    }

     @Override
    public String procesarCiclo(EstadoMision estado) {

        if (!isActivo()) {
            return "El módulo de energía " + getNombre()
                    + " está inactivo y no generó energía.";
        }

        estado.agregarEnergia(energiaPorCiclo);
        ciclosAcumulados++;
        totalEnergiaGenerada += energiaPorCiclo;

        return "El módulo de energía " + getNombre()
                + " generó " + energiaPorCiclo
                + " unidades de energía.";
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nTipo: Módulo de energía"
                + "\nEnergía generada por ciclo: "
                + energiaPorCiclo
                + "\nCiclos acumulados: "
                + ciclosAcumulados
                + "\nTotal histórico de energía generada: "
                + totalEnergiaGenerada;
    }

    
}
