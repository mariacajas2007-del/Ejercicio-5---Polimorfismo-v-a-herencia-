package modelo;

public class ModuloVuelo extends Modulo {
    private final String tipoInstrumento;
    private final double datosPorCiclo;
    private final double consumoEnergia;
    private int ciclosAcumulados;
    private double totalDatosRecolectados;

    public ModuloVuelo(String id, String nombre, int salud, boolean activo, double costoConstruccion, String tipoInstrumento, double datosPorCiclo, double consumoEnergia) {
    this(id, nombre, salud, activo, costoConstruccion, tipoInstrumento, datosPorCiclo, consumoEnergia, 0, 0);
}

public ModuloVuelo(String id, String nombre, int salud, boolean activo, double costoConstruccion, String tipoInstrumento, double datosPorCiclo, double consumoEnergia, int ciclosAcumulados, double totalDatosRecolectados) {
    super(id, nombre, salud, activo, costoConstruccion);
    this.tipoInstrumento = tipoInstrumento;
    this.datosPorCiclo = datosPorCiclo;
    this.consumoEnergia = consumoEnergia;
    this.ciclosAcumulados = ciclosAcumulados;
    this.totalDatosRecolectados = totalDatosRecolectados;
}

    public String getTipoInstrumento() {
        return tipoInstrumento;
    }

    public double getDatosPorCiclo() {
        return datosPorCiclo;
    }

    public double getConsumoEnergia() {
        return consumoEnergia;
    }

    public int getCiclosAcumulados() {
        return ciclosAcumulados;
    }

    public double getTotalDatosRecolectados() {
        return totalDatosRecolectados;
    }

    @Override
    public String procesarCiclo(EstadoMision estado) {

        if (!isActivo()) {
            return "El módulo de vuelo " + getNombre()
                    + " está inactivo y no recolectó datos.";
        }

        if (estado.getEnergiaDisponible() < consumoEnergia) {
            return "El módulo de vuelo " + getNombre()
                    + " no tiene suficiente energía para operar.";
        }

        estado.consumirEnergia(consumoEnergia);
        estado.agregarDatosEnOrbita(datosPorCiclo);

        ciclosAcumulados++;
        totalDatosRecolectados += datosPorCiclo;

        return "El módulo de vuelo " + getNombre()
                + " consumió " + consumoEnergia
                + " unidades de energía y recolectó "
                + datosPorCiclo + " MB.";
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nTipo: Módulo de vuelo"
                + "\nInstrumento: " + tipoInstrumento
                + "\nDatos recolectados por ciclo: "
                + datosPorCiclo + " MB"
                + "\nConsumo de energía por ciclo: "
                + consumoEnergia
                + "\nCiclos acumulados: "
                + ciclosAcumulados
                + "\nTotal histórico recolectado: "
                + totalDatosRecolectados + " MB";
    }
}
