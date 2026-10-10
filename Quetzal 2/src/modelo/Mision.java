package modelo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Mision {
    private final List<Modulo> modulos;
    private final EstadoMision estado;
    private int numeroDeCiclos;
    
    public Mision() {
        modulos = new ArrayList<>();
        estado = new EstadoMision(50, 30, 60);
        numeroDeCiclos = 0;
        cargarModulosIniciales();
    }

    private void cargarModulosIniciales() {

    modulos.add(new ModuloEnergia("ME1", "Generador Solar Quetzal", 100, true, 5000, 10, 4, 40));
    modulos.add(new ModuloVuelo("MV1", "Cámara Orbital", 100, true, 5000, "Cámara", 10, 4, 3, 30));
    modulos.add(new ModuloTierra("MT1", "Módulo de Tierra", 100, true, 5000, "Campus Central", 20, 5, 30));
    modulos.add(new ModuloEnergia("ME2", "Generador Solar de Respaldo", 90, true, 3000, 5, 3, 15));
    modulos.add(new ModuloVuelo("MV2", "Sensor Orbital Secundario", 85, true, 4000, "Sensor", 5, 3, 4, 20));
    modulos.add(new ModuloTierra("MT2", "Módulo de Tierra Secundario", 80, true, 4000, "Campus Norte", 15, 3, 20));
    modulos.add(new ModuloEnergia("ME3", "Panel Solar Avanzado", 75, false, 6000, 15, 2, 30));
    modulos.add(new ModuloVuelo("MV3", "Cámara Orbital Avanzada", 70, false, 6000, "Cámara", 15, 6, 2, 30));
    modulos.add(new ModuloTierra("MT3", "Módulo de Tierra Avanzado", 95, true, 6000, "Campus Sur", 25, 7, 10));
    modulos.add(new ModuloEnergia("ME4", "Generador Solar de Alta Potencia", 95, true, 8000, 20, 5, 100));
    }

    public List<Modulo> getModulos() {
        return modulos;
    }

    public EstadoMision getEstado() {
        return estado;
    }

    public String listarModulos() {

        StringBuilder resultado = new StringBuilder();

        resultado.append("=== MÓDULOS DE LA MISIÓN ===\n\n");

        for (Modulo modulo : modulos) {
            resultado.append(modulo);
            resultado.append("\n----------------------------\n");
        }

        return resultado.toString();
    }

    public Modulo buscarModulo(String criterio) {

        for (Modulo modulo : modulos) {
            if (modulo.getId().equalsIgnoreCase(criterio)
                    || modulo.getNombre().equalsIgnoreCase(criterio)) {
                return modulo;
            }
        }

        return null;
    }

    public String catalogoOrdenadoPorCosto() {

        List<Modulo> catalogo = new ArrayList<>(modulos);

        catalogo.sort(
                Comparator.comparingDouble(
                        Modulo::getCostoConstruccion
                )
        );

        StringBuilder resultado = new StringBuilder();

        resultado.append(
                "=== CATÁLOGO ORDENADO POR COSTO ===\n\n"
        );

        for (Modulo modulo : catalogo) {
            resultado.append("ID: ")
                    .append(modulo.getId())
                    .append("\nNombre: ")
                    .append(modulo.getNombre())
                    .append("\nCosto: Q")
                    .append(String.format(
                            "%.2f",
                            modulo.getCostoConstruccion()
                    ))
                    .append("\n----------------------------\n");
        }

        return resultado.toString();
    }

    public String avanzarCiclo() {

        numeroDeCiclos++;

        StringBuilder resultado = new StringBuilder();

        resultado.append("=== CICLO ")
                .append(numeroDeCiclos)
                .append(" ===\n\n");

        int orden = 1;

        for (Modulo modulo : modulos) {

            resultado.append(orden)
                    .append(". ")
                    .append(modulo.procesarCiclo(estado))
                    .append("\n");

            resultado.append("Energía disponible: ")
                    .append(String.format(
                            "%.2f",
                            estado.getEnergiaDisponible()
                    ))
                    .append("\nDatos en órbita: ")
                    .append(String.format(
                            "%.2f",
                            estado.getDatosEnOrbita()
                    ))
                    .append(" MB")
                    .append("\nDatos descargados: ")
                    .append(String.format(
                            "%.2f",
                            estado.getTotalDatosDescargados()
                    ))
                    .append(" MB\n")
                    .append("----------------------------\n");

            orden++;
        }

        resultado.append("\n=== ESTADO FINAL DEL CICLO ===\n");
        resultado.append(estado);

        return resultado.toString();
    }

    public String generarResumenComunicaciones() {

        int totalModulosTierra = 0;
        int modulosTierraActivos = 0;
        double capacidadTotalActiva = 0;
        double totalHistorico = 0;
        double mayorDescarga = -1;

        List<ModuloTierra> mayores = new ArrayList<>();

        for (Modulo modulo : modulos) {

            if (modulo instanceof ModuloTierra) {

                ModuloTierra moduloTierra =
                        (ModuloTierra) modulo;

                totalModulosTierra++;
                totalHistorico +=
                        moduloTierra.getTotalDescargado();

                if (moduloTierra.isActivo()) {
                    modulosTierraActivos++;
                    capacidadTotalActiva +=
                            moduloTierra.getCapacidadDescarga();
                }

                if (moduloTierra.getTotalDescargado()
                        > mayorDescarga) {

                    mayorDescarga =
                            moduloTierra.getTotalDescargado();

                    mayores.clear();
                    mayores.add(moduloTierra);

                } else if (Double.compare(
                        moduloTierra.getTotalDescargado(),
                        mayorDescarga) == 0) {

                    mayores.add(moduloTierra);
                }
            }
        }

        StringBuilder resultado = new StringBuilder();

        resultado.append(
                "=== RESUMEN DE COMUNICACIONES ===\n"
        );

        resultado.append("Total de módulos de tierra: ")
                .append(totalModulosTierra)
                .append("\nMódulos de tierra activos: ")
                .append(modulosTierraActivos)
                .append("\nCapacidad total activa: ")
                .append(capacidadTotalActiva)
                .append(" MB por ciclo")
                .append("\nTotal histórico descargado: ")
                .append(totalHistorico)
                .append(" MB\n");

        resultado.append(
                "\nMódulo(s) con mayor descarga histórica:\n"
        );

        for (ModuloTierra modulo : mayores) {
            resultado.append("Nombre: ")
                    .append(modulo.getNombre())
                    .append("\nID: ")
                    .append(modulo.getId())
                    .append("\nEstación: ")
                    .append(modulo.getEstacion())
                    .append("\nTotal descargado: ")
                    .append(modulo.getTotalDescargado())
                    .append(" MB\n")
                    .append("----------------------------\n");
        }

        return resultado.toString();
    }
}
