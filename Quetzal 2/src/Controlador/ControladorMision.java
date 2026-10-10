package Controlador;

import modelo.Mision;
import modelo.Modulo;
import Vista.VistaConsola;

public class ControladorMision {
    private final Mision mision;
    private final VistaConsola vista;

    public ControladorMision(Mision mision, VistaConsola vista) {
        this.mision = mision;
        this.vista = vista;
    }

    public void iniciar() {
        int opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.LeerOpcion();

            switch (opcion) {
               case 1:
                    vista.mostrarMensaje(
                            mision.listarModulos()
                    );
                    break;

                case 2:
                    buscarModulo();
                    break;

                case 3:
                    vista.mostrarMensaje(
                            mision.catalogoOrdenadoPorCosto()
                    );
                    break;

                case 4:
                    vista.mostrarMensaje(
                            mision.avanzarCiclo()
                    );
                    break;

                case 5:
                    vista.mostrarMensaje(
                            mision.generarResumenComunicaciones()
                    );
                    break;

                case 0:
                    vista.mostrarMensaje(
                            "Simulador finalizado."
                    );
                    break;

                default:
                    vista.mostrarMensaje(
                            "Opción inválida."
                    );
            }

        } while (opcion != 0);
    }

    private void buscarModulo() {

        String criterio = vista.leerTexto(
                "Ingrese el ID o nombre del módulo: "
        );

        Modulo modulo = mision.buscarModulo(criterio);

        if (modulo == null) {
            vista.mostrarMensaje(
                    "No se encontró el módulo."
            );
        } else {
            vista.mostrarMensaje(
                    "\n=== MÓDULO ENCONTRADO ===\n"
                            + modulo
            );
        }
    }
}
