import Controlador.ControladorMision;
import modelo.Mision;
import Vista.VistaConsola;

public class App {

    public static void main(String[] args) {

        Mision mision = new Mision();
        VistaConsola vista = new VistaConsola();

        ControladorMision controlador =
                new ControladorMision(mision, vista);

        controlador.iniciar();
    }
}
