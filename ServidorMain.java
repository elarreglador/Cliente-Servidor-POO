public class ServidorMain {
    public static void main(String[] args) {

        int butacasCen = 54;
        int butacasCenPrecio = 80;
        int butacasGal = 8;
        int butacasGalPrecio = 150;
        int butacasLat1 = 4;
        int butacasLat1Precio = 100;
        int butacasLat2 = 4;
        int butacasLat2Precio = 100;
        int butacasVIP1 = 3;
        int butacasVIP1Precio = 250;
        int butacasVIP2 = 3;
        int butacasVIP2Precio = 250;

        String[] peticion;
        String respuesta;

        libServidor servidor = new libServidor(6996);
        // Inicia el servidor
        servidor.abreSocket();
        servidor.abreStreams();

        boolean sirviendo = true;
        while (sirviendo) {
            // obtiene la peticion y la pasa a minúsculas
            peticion = servidor.escucha().split(" ");
            for (int i = 0; i < peticion.length; i++) {
                peticion[i] = peticion[i].toLowerCase();
            }

            // muestra peticion por pantalla
            System.out.print("[CLIENTE] ");
            for (int i = 0; i < peticion.length; i++) {
                System.out.print(peticion[i] + " ");
            }
            System.out.println();

            // prepara respuesta según peticion del cliente
            switch (peticion[0]) {

                case "hola":
                    // Devuelve el saludo
                    respuesta = "Hola, sóc el servidor";
                    break;

                case "fi":
                    // Cierra la conexión por parte del cliente
                    respuesta = "fi";
                    break;

                case "veure":
                    // muestra informacion sobre butacas y precios
                    respuesta = ".\n" + "Butacas CEN: " + butacasCenPrecio + "EUR disponibles " + butacasCen + ".\n";
                    respuesta = respuesta + "Butacas GAL: " + butacasGalPrecio + "EUR disponibles " + butacasGal
                            + ".\n";
                    respuesta = respuesta + "Butacas LAT1: " + butacasLat1Precio + "EUR disponibles " + butacasLat1
                            + ".\n";
                    respuesta = respuesta + "Butacas LAT2: " + butacasLat2Precio + "EUR disponibles " + butacasLat2
                            + ".\n";
                    respuesta = respuesta + "Butacas VIP1: " + butacasVIP1Precio + "EUR disponibles " + butacasVIP1
                            + ".\n";
                    respuesta = respuesta + "Butacas VIP2: " + butacasVIP2Precio + "EUR disponibles " + butacasVIP2;
                    break;

                case "gal":
                    // reserva un asiento de galeria
                    if (butacasGal > 0) {
                        butacasGal--;
                        respuesta = "Reserva GALERIA " + butacasGal;
                    } else {
                        respuesta = "Imposible, butaques esgotades per a GAL";
                    }
                    break;

                case "cen":
                    // reserva un asiento de centro
                    if (butacasCen > 0) {
                        butacasCen--;
                        respuesta = "Reserva CEN " + butacasCen;
                    } else {
                        respuesta = "Imposible, butaques esgotades per a CEN";
                    }
                    break;

                case "lat1":
                    // reserva un asiento de lateral 1
                    if (butacasLat1 > 0) {
                        butacasLat1--;
                        respuesta = "Reserva LAT1 " + butacasLat1;
                    } else {
                        respuesta = "Imposible, butaques esgotades per a LAT1";
                    }
                    break;

                case "lat2":
                    // reserva un asiento de lateral 2
                    if (butacasLat2 > 0) {
                        butacasLat2--;
                        respuesta = "Reserva LAT2 " + butacasLat2;
                    } else {
                        respuesta = "Imposible, butaques esgotades per a LAT2";
                    }
                    break;

                case "vip1":
                    // reserva un asiento VIP 1
                    if (butacasVIP1 > 0) {
                        butacasVIP1--;
                        respuesta = "Reserva VIP1 " + butacasVIP1;
                    } else {
                        respuesta = "Imposible, butaques esgotades per a VIP 1";
                    }
                    break;

                case "vip2":
                    // reserva un asiento VIP 2
                    if (butacasVIP2 > 0) {
                        butacasVIP2--;
                        respuesta = "Reserva VIP2 " + butacasVIP2;
                    } else {
                        respuesta = "Imposible, butaques esgotades per a VIP 2";
                    }
                    break;

                default:
                    respuesta = "ERROR: Peticion no reconocida";
                    break;
            }
            // Envia la respuesta
            servidor.printServidor(respuesta);
            servidor.envia(respuesta);
            if (respuesta.equals("fi")) {
                servidor.cierraStreams(); // Cierra los streams
                servidor.cierraSocket(); // Cierra el socket
                sirviendo=false;
            }

        }
    }
}
