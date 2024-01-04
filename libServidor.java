import java.io.*;
import java.net.*;

//Servidor TCP que permite enviar y recibir Strings

public class libServidor {
    String nombreServidor = "Servidor Java Alpha";
    String nombreCliente;

    boolean conectado = false;

    int puerto = 6996;
    ServerSocket ssServidor;
    Socket sCliente;
    String remoteIP;

    DataOutputStream bajada;
    OutputStream os;
    DataInputStream subida;
    InputStream is;

    public libServidor(int puerto) {
        this.puerto = puerto;
    }

    public void abreSocket() {
        System.out.println("Abriendo socket");
        try {
            if (!conectado) {
                ssServidor = new ServerSocket(puerto);
                System.out.println("Escuchando en puerto " + puerto);

                sCliente = ssServidor.accept();
                System.out.println("Conectado a " + sCliente.getInetAddress());
            }
        } catch (Exception e) {
            System.out.println("Excepcion en abreSocket:" + e);
        }
    }

    public void abreStreams() {
        System.out.println("Abriendo streams");
        try {
            os = sCliente.getOutputStream();
            bajada = new DataOutputStream(os);

            is = sCliente.getInputStream();
            subida = new DataInputStream(is);

            conectado = true;

            nombreCliente = escucha();
            envia(getNombre()); // envia nombre del servidor
            System.out.println("Sirviendo a cliente '" + nombreCliente + "'");

        } catch (Exception e) {
            System.out.println("Excepcion en abreStreams(): " + e);
            cierraSocket();
        }
    }

    public void cierraStreams() {
        System.out.println("cerrando streams");
        if (conectado) {
            try {
                subida.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    
            try {
                bajada.close();
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            conectado = false;
        }
    }

    public void cierraSocket() {
        System.out.println("cerrando socket");
        try {
            sCliente.close();
            // Verificar si el socket se cerró correctamente
            if (sCliente.isClosed()) {
                System.out.println("Socket cerrado exitosamente");
            } else {
                System.out.println("Error al cerrar el socket");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean conectado() {
        return this.conectado;
    }

    public String envia(String texto) {
        try {
            bajada.writeUTF(texto);
        } catch (IOException e) {
            System.out.println("Excepcion en envia(): " + e);
            cierraSocket();
        }
        return texto;
    }

    public String escucha() {
        String retorno = null;
        try {
            retorno = subida.readUTF();
        } catch (IOException e) {
            System.out.println("Excepcion en escucha(): " + e);
        }
        return retorno;
    }

    public String getNombre() {
        return nombreServidor;
    }

    public int getPuerto() {
        return puerto;
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
