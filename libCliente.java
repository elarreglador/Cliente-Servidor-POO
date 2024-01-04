import java.io.*;
import java.net.*;

//Cliente TCP que permite enviar y recibir Strings

public class libCliente {
    String nombreServidor;
    String nombreCliente = "Cliente java Alpha";

    Boolean conectado = false;

    String IP;
    int puerto;
    Socket sCliente;
    InputStream is;
    DataInputStream bajada;
    OutputStream os;
    DataOutputStream subida;

    public libCliente(String IP, int puerto) {
        this.IP = IP;
        this.puerto = puerto;
    }

    public void conecta() {
        try {
            sCliente = new Socket(IP, puerto);
            is = sCliente.getInputStream();
            bajada = new DataInputStream(is);
            os = sCliente.getOutputStream();
            subida = new DataOutputStream(os);

            envia(nombreCliente);
            nombreServidor = recibe();
            System.out.println("**************************************************************");
            System.out.println("Conectado al servidor '" + nombreServidor + "'@" + IP + ":" + puerto);
            System.out.println("**************************************************************");

            conectado = true;

        } catch (Exception e) {
            System.out.println("Excepcion en coenecta(): " + e);
        }
    }

    public void cierra() {
        try {
            subida.close();
            os.close();
        } catch (IOException e) {
            System.out.println("Excepcion en cierra(): " + e);
        }
        try {
            bajada.close();
            is.close();
        } catch (IOException e) {
            System.out.println("Excepcion en cierra(): " + e);
        }
        conectado = false;
    }

    public String envia(String texto) {
        try {
            subida.writeUTF(texto);
        } catch (IOException e) {
            System.out.println("Excepcion en sube(): " + e);
        }
        return texto;
    }

    public String recibe() {
        String retorno = null;
        try {
            retorno = bajada.readUTF();
        } catch (IOException e) {
            System.out.println("Excepcion en baja(): " + e);
        }
        return retorno;
    }

    public boolean getConectado(){
        return conectado;
    }

    public int getPuerto() {
        return puerto;
    }

    public String getIP() {
        return IP;
    }

    public String printServidor(String texto) {
        System.out.println("[SERVIDOR] " + texto);
        return "[SERVIDOR] " + texto;
    }

    public String printCliente(String texto) {
        System.out.println("[CLIENTE] " + texto);
        return "[CLIENTE] " + texto;
    }
}
