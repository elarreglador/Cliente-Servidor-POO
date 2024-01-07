
************************************
ACERCA DEL AUTOR
************************************

David M.

elarreglador@protonmail.cocm

https://github.com/elarreglador


************************************
ACERCA DE LA APLICACION
************************************
Desenvolupa un servidor TCP/IP (sockets TCP) que funcione com un servidor de reserves
de butaques d'un teatre, de la següent forma:

●S'ha de realitzar la pràctica amb sockets de tipus TCP.
●El client (socket TCP) rep com a paràmetre del programa el nom de la màquina on es
troba el servidor (per exemple, localhost si s'executen els dos programes en la mateixa
màquina). El servidor no rep res.
●El client es connecta al servidor i li enviarà un missatge de salutació formal mitjançant la
cadena “Hola”.
●El servidor analitzarà la cadena i mostrarà per pantalla el missatge del client i contestarà
amb la cadena “Hola, sóc el servidor”.
●El client imprimirà sempre els missatges que rep del servidor anteposant la cadena
“Servidor: ”. Igual en el client que anteposarà “Client: ”.
●A partir d'ara, l'usuari introduirà un tipus de butaca i el client l'enviarà al servidor.
●Si el servidor té entrades d'aqueix tipus, imprimirà per la seua pantalla el tipus de
butaca seleccionat i enviarà al client la cadena formada per “Reserva (tipusButaca)
(númerodeButaquesLliures)”.
●El servidor assigna un nombre de butaques disminuint el nombre de les disponibles, és
a dir, no s'assigna una butaca determinada. Les butaques no són numerades.
●De no existir butaques disponibles retornarà la cadena “Butaques esgotades”.
●El client l'imprimirà per pantalla podent repetir el mateix procés (enviar un missatge al
servidor i esperar a la contestació) tantes vegades com desitge.
●Els tipus de butaques (codi) i el número inicial de butaques està descrit en la imatge
anterior. Cal tindre en compte que el número de butaques disponibles mai serà menor
que 0.
●El client només reservarà una butaca en cada reserva.
●Des del client es pot consultar el número disponible i preu de les butaques amb l'opció
“Veure butaques”.
●Quan l'usuari vullga finalitzar l'execució del programa, escriurà per teclat “Fi”. El client
l'indicarà al servidor, enviant-li aquesta cadena. El servidor contestarà amb el mateix
missatge i el client finalitzarà la seua execució. Però el servidor, tancarà aquesta
connexió (socket) i continuarà executant-se esperant la connexió d'un nou client.
●S'ha de controlar tant en la part client com en el servidor les possibles excepcions.
●El client mai comprovarà els missatges enviats al servidor. En canvi, el servidor haurà
de procedir a interpretar què vol el client i actuar en conseqüència. Si el client envia un
missatge que no correspon amb cap opció comentada anteriorment, enviarà el client un
missatge de “Error”..

NOTA: Opcionalmente estoy tratando de manejar este ejercicio con hilos

************************************
LANZAR LA APP 
************************************

Para lanzar el servidor:

<pre>
javac ServidorMain.java
java ServidorMain
</pre>

Papra lanzar el cliente:

<pre>
javac ClienteMain.java
java ClienteMain
</pre>




                                                                                David M.
                                                                 11 de diciembre de 2023


