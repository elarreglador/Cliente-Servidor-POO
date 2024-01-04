import java.util.Scanner;

public class ClienteMain {
    public static void main(String[] args) {
        String IP;
        if (args.length > 0){
            IP = args[1];
        } else {
            IP = "localhost";
        }

        libCliente cliente = new libCliente(IP, 6996);
        cliente.conecta();

        cliente.printCliente(cliente.envia("Hola"));
        cliente.printServidor(cliente.recibe());

        Scanner lee = new Scanner(System.in);
        String recibido;
        while(cliente.conectado){
            cliente.envia(lee.nextLine());
            recibido = cliente.recibe();
            cliente.printServidor(recibido);
            if (recibido.equals("fi")){
                System.out.println("Servidor acepta desconexion de cliente");
                cliente.cierra();
            }
        }

        cliente.cierra();
        System.out.println("Conexion cerrada.");

    }
}
