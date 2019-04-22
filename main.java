

public class main {
    public static void main(String[] args)
    {

        cuerpo cw = cuerpo.getInstance();
        cw.inicio();
        cw.Correr();
        cw.Finish();

        obs x = new obs();
        fin_de_factura y = new fin_de_factura();
        y.enlazarObservador(x);
        y.terminar_factura();

    }
}