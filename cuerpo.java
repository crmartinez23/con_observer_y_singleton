import java.util.ArrayList;
import java.util.Scanner;


public class cuerpo {
    private  static cuerpo instancia;

   private cuerpo(){

    }

    public  static cuerpo getInstance(){
        if (instancia==null){
            instancia = new cuerpo();
        }
        return instancia;
    }
    private Scanner sc;
    ArrayList clientes;
    ArrayList cajeros;
     float PRECIO_LAVADO = 100.0f;
     float PRECIO_MOTOR = 150.0f;
    float PRECIO_ASPIRADO = 200.0f;
    float IMPUESTO_DE_VENTA = 1.15f;
    float PRECIO_PASTEADO = 220.0F;
    float PRECIO__ROBINEADO = 300.0F;

    public void inicio() {
        sc = new Scanner(System.in);
        clientes = new ArrayList();
        cajeros = new ArrayList();
    }

    public void Correr() {
        int[] Opciones = new int[5];
        int OpcionContinuar;
        do{
            CicloCompra(Opciones);
            Cliente C = CicloCliente();
            ImprimirFactura(Opciones,C.getNombre(),C.getApeido());
            System.out.println("\nDesea Continuar?  1.Otra Factura 2.Salir");
            OpcionContinuar = sc.nextInt();
            Opciones = new int[5];
        }while(OpcionContinuar == 1);
    }

    public void Finish() {
        cajeros.clear();
        clientes.clear();
        sc.close();
    }

    private Cliente CicloCliente() {
        System.out.println("Ingrese el id del Cliente?");
        int id = sc.nextInt();
        Cliente C;
        String nombre;
        String apeido;
        int indice = -1;
        for(int i = 0; i< clientes.size(); i++)
        {
            if(((Cliente)clientes.get(i)).getId() == id)
            {
                indice = i;
            }
        }
        if(indice!=-1)
        {
            C = (Cliente)clientes.get(indice);
        }else
        {
            System.out.println("Cliente no existe.");

            System.out.println("Ingrese el Nombre?");
            nombre = sc.next();

            System.out.println("Ingrese el Apeido?");
            apeido = sc.next();

            C = new Cliente(id, nombre, apeido);
            clientes.add(C);
        }
        return C;
    }

    private void ImprimirFactura(int[] Opciones,String nombre, String apeido) {
        float totalizar = (Opciones[0] * PRECIO_LAVADO
                + Opciones[1] * PRECIO_MOTOR
                + Opciones[2] * PRECIO_ASPIRADO
                + Opciones[3] * PRECIO_PASTEADO
                + Opciones[4] * PRECIO__ROBINEADO)
                * IMPUESTO_DE_VENTA;
        Object[] args = {nombre,apeido,new Float(totalizar) };
        System.out.println(String.format("Gracias %s %s por su Compra!! \n\n\nEl total a pagar es: L.%s", args));
    }

    private void CicloCompra(int[] Opciones) {
        int OpcionLavado;
        do{
            System.out.println("\t\t\t\tLavados martinez_lopez!!");
            System.out.println();
            System.out.println();
            System.out.println("elija el numero de la opcion deseada ");
            System.out.println();
            System.out.println();
            System.out.println("Opciones :");

            System.out.println();
            System.out.println("1. lavado.\t\t\t L.100");

            System.out.println();
            System.out.println("2. lavado motor.\t\t L.150");

            System.out.println();
            System.out.println("3. aspirado.\t\t\t L.200");

            System.out.println();
            System.out.println("4. pasteado.\t\t\t L.220");

            System.out.println();
            System.out.println("5. robineado.\t\t\t L.300");

            System.out.println();
            System.out.println("6. Imprimir factura.");

            OpcionLavado = sc.nextInt();

            if(1 == OpcionLavado)
            {
                Opciones[0]++;
            }
            if(2 == OpcionLavado)
            {
                Opciones[1]++;
            }
            if(3 == OpcionLavado)
            {
                Opciones[2]++;
            }
            if(4 == OpcionLavado)
            {
                Opciones[3]++;
            }
            if(5 == OpcionLavado)
            {
                Opciones[4]++;
            }

        }while(OpcionLavado != 6 );
    }


}