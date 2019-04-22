import java.util.ArrayList;

public class fin_de_factura implements SujetoObservable {

    private ArrayList<Observador> observadores;
    public fin_de_factura() {observadores = new ArrayList<Observador>();}

    public void terminar_factura(){
        notificar();
    }
    public void enlazarObservador(Observador o){ observadores.add(o);};

    @Override
    public void notificar() {
        for (Observador o:observadores){o.actualizar();}
    }
}
