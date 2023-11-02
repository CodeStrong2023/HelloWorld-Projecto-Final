package TaTeTI;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class TaTeTi {
    //Atributos de la clase

    //definimos los atributos de jugador uno y jugador dos
    public String jugador1;
    public String jugador2;
    //definimos el tablero como coordenadas
    public String[][] coordenadas = new String[3][3];
    //definimos todas las coordenadas
    private String unoUno, unoDos, unoTres, dosUno, dosDos, dosTres, tresUno, tresDos, tresTres;

    public void Menu() {
        Scanner entrada = new Scanner(System.in);
        int opcion;
        String opcionParaJugar = "S";

        System.out.println("TRABAJO INTEGRADOR GRUPO HELLO WORLD");
        System.out.println("TA-TE-TI");

        do {
            do {
                System.out.println("A continuación elige la opción:");
                System.out.println("1-Iniciar Juego");
                System.out.println("2-Ayuda");
                System.out.println("3-Salir");
                opcion = entrada.nextInt();
            } while (opcion < 1 || opcion > 3);

            switch (opcion) {
                case 1:
                    System.out.println("Iniciemos");
                    IniciarJuego();
                    break;
                case 2:
                    System.out.println("1-El juego cuenta con dos jugadores.");
                    System.out.println("2-Los mismos cuentan con 3 fichas, las cuales serán ubicadas en el tablero.");
                    System.out.println("3-El tablero cuenta con 9 coordenadas, por las cuales van a moverse las fichas.");
                    System.out.println("4-Cada jugador podrá mover una ficha por ronda, la cual será elegida por el jugador.");
                    System.out.println("5-El objetivo del juego es conseguir que las tres fichas de un jugador formen una línea recta.");

                    do {
                        System.out.println("¿Deseas jugar? (S o N)");
                        opcionParaJugar = entrada.next().toUpperCase();
                    } while (!opcionParaJugar.equals("S") && !opcionParaJugar.equals("N"));
                    break;
                case 3:
                    System.out.println("Salió del juego");
                    opcionParaJugar = "N";
                    break;
            }

            if (opcionParaJugar.equals("N")) {
                System.out.println("Salió del juego");
            }
        } while (opcionParaJugar.equals("S"));
    }

    public void IniciarJuego() {
        //EN ESTE CONSTRUCTOR LE VAMOS A ASIGNAR A CADA VARIABLE DE POSICION UNA CADENA
        //LA CUAL CORRESPONDE A LA POSICION
        //LAS CORRDENAS VAN DESDE 1,1;1,2...3,3 RESPECTIVAMENTE

        unoUno = "1,1";
        unoDos = "1,2";
        unoTres = "1,3";
        dosUno = "2,1";
        dosDos = "2,2";
        dosTres = "2,3";
        tresUno = "3,1";
        tresDos = "3,2";
        tresTres = "3,3";

        coordenadas[0][0] = unoUno;
        coordenadas[0][1] = unoDos;
        coordenadas[0][2] = unoTres;
        coordenadas[1][0] = dosUno;
        coordenadas[1][1] = dosDos;
        coordenadas[1][2] = dosTres;
        coordenadas[2][0] = tresUno;
        coordenadas[2][1] = tresDos;
        coordenadas[2][2] = tresTres;

        //UNA VEZ LLENAS LAS COORDENADAS LLAMAMOS A UN metodo MEDIANTE EL CUAL PREGUNTAMOS EL NOMBRE DE LOS JUGADORES Y SE LOS ASGINAMOS A LAS VARIABLES
        //AL metodo NombrarJugadores 
        NombrarJugadores();
        Tablero();
        ubicarFichas();
        turnos();
    }

    public void NombrarJugadores() {
        Scanner entrada = new Scanner(System.in);

        do {
            // Le pedimos al usuario que ingrese el nombre del primer jugador con exactamente 3 caracteres
            System.out.println("DAME EL NOMBRE DEL PRIMER JUGADOR, SOLO PUEDE CONTAR CON 3 CARACTERES");
            this.jugador1 = entrada.nextLine();

            // Si el usuario no ingresa un nombre de 3 caracteres, mostramos un mensaje de error
            if (this.jugador1.length() != 3) {
                System.out.println("ERROR, TU NOMBRE NO CUENTA CON 3 CARACTERES");
            }
        } while (this.jugador1.length() != 3);

        do {
            // Le pedimos al usuario que ingrese el nombre del segundo jugador con exactamente 3 caracteres
            System.out.println("DAME EL NOMBRE DEL SEGUNDO JUGADOR, SOLO PUEDE CONTAR CON 3 CARACTERES");
            this.jugador2 = entrada.nextLine();

            // Si el usuario no ingresa un nombre de 3 caracteres, mostramos un mensaje de error
            if (this.jugador2.length() != 3) {
                System.out.println("ERROR, TU NOMBRE NO CUENTA CON 3 CARACTERES");
            }
        } while (this.jugador2.length() != 3);
    }

    public void Tablero() {
        //EN ESTE METODO VAMOS A mostrar el tablero segun las 9 coordenadas 
        //

        System.out.println(coordenadas[0][0] + "______________________" + coordenadas[0][1] + "______________________" + coordenadas[0][2]);
        System.out.println("  |    \\                   |                    /  |  ");
        System.out.println("  |       \\                |                  /    |  ");
        System.out.println("  |          \\             |                /      |  ");
        System.out.println("  |             \\          |             /         |  ");
        System.out.println("  |               \\        |          /            |  ");
        System.out.println("  |                 \\      |       /               |  ");
        System.out.println("  |                   \\    |    /                  |  ");
        System.out.println("  |                     \\  |  /                    |  ");
        System.out.println(coordenadas[1][0] + "_______________________" + coordenadas[1][1] + "______________________" + coordenadas[1][2]);
        System.out.println("  |                     /  |  \\                    |  ");
        System.out.println("  |                  /     |    \\                  |  ");
        System.out.println("  |               /        |       \\               |  ");
        System.out.println("  |             /          |          \\            |  ");
        System.out.println("  |           /            |             \\         |  ");
        System.out.println("  |        /               |               \\       |  ");
        System.out.println("  |     /                  |                 \\     |  ");
        System.out.println("  |  /                     |                    \\  ");
        System.out.println(coordenadas[2][0] + "_______________________" + coordenadas[2][1] + "______________________" + coordenadas[2][2]);
    }

    public void ubicarFichas() {
        //le asignamos el valor 1 a la variable vueltas para poder ir poniendole 
        //un numero a cada ficha
        int vueltas = 1;
        //mediante el siguiente while hacenos que el codigo solo se repita tres veces
        //parq que cada jugador cuente con 3 fichas
        while (vueltas <= 3) {
            //Llamamos al metodo jugadores y le pasamos la variable vueltas y jugador
            //para poder asignarle el nombre dle jugador a las fichas para identificarlas
            Jugadores(vueltas, this.jugador1);
            //mostramos el tablero para saber que posiciones se va ocupando
            Tablero();
            //repetimos el proceso con el jugador dos
            Jugadores(vueltas, this.jugador2);
            Tablero();
            //incrementamos en 1 la variable vueltas 
            vueltas++;
        }
    }

    public void turnos() {
        boolean verificador = false;
        boolean comprobarMovimiento = false;

        // Llamamos a FinJuego con jugador 1 para verificar si ya ganó antes de mover fichas
        verificador = FinJuego(this.jugador1, verificador);
        // Llamamos a FinJuego con jugador 2 para verificar si ya ganó antes de mover fichas
        verificador = FinJuego(jugador2, verificador);
        // Si ninguno ha ganado, continúa el juego
        if (!verificador) {
            // El siguiente bucle se repetirá hasta que uno de los jugadores gane (verificador sea verdadero)
            do {
                // El siguiente bucle se repetirá hasta que el jugador uno realice un movimiento
                do {
                    // Invocamos al subproceso juego pasándole como parámetros la variable comprobarMovimiento, jugadorUno y la matriz coordenadas para que mueva su ficha
                    comprobarMovimiento = Juego(comprobarMovimiento, this.jugador1);

                    // Llamamos a FinJuego con jugador uno, la matriz coordenadas y verificador para controlar si el primer jugador ganó
                    verificador = FinJuego(this.jugador1, verificador);

                    // Si comprobarMovimiento es falso, muestra un mensaje de que no hay movimientos disponibles para la ficha seleccionada
                    if (!comprobarMovimiento) {
                        System.out.println("/////////////////////////////////////////////////////////////////////////");
                        System.out.println("No hay movimientos disponibles para la ficha seleccionada, elija otra");
                        System.out.println("/////////////////////////////////////////////////////////////////////////");
                    }
                } while (!comprobarMovimiento);
                Tablero();

                // Reiniciamos comprobarMovimiento a falso para permitir que el jugador dos realice un movimiento
                comprobarMovimiento = false;

                // Solo permitirá que el segundo jugador se mueva si el primer jugador no ha ganado (verificador sigue siendo falso)
                if (!verificador) {
                    // El siguiente bucle se repetirá hasta que el jugador dos realice un movimiento
                    do {
                        // Invocamos al subproceso juego pasándole como parámetros la variable comprobarMovimiento, jugadorDos y la matriz coordenadas para que mueva su ficha
                        comprobarMovimiento = Juego(comprobarMovimiento, this.jugador2);

                        // Llamamos a FinJuego con jugador dos, la matriz coordenadas y verificador para controlar si el segundo jugador ganó
                        verificador = FinJuego(this.jugador2, verificador);

                        // Si comprobarMovimiento es falso, muestra un mensaje de que no hay movimientos disponibles para la ficha seleccionada
                        if (!comprobarMovimiento) {
                            System.out.println("/////////////////////////////////////////////////////////////////////////");
                            System.out.println("No hay movimientos disponibles para la ficha seleccionada, elija otra");
                            System.out.println("/////////////////////////////////////////////////////////////////////////");
                        }
                    } while (!comprobarMovimiento);
                    Tablero();
                }
            } while (!verificador);
        }
    }

    public void Jugadores(int vueltas, String jugador) {
        Scanner entrada = new Scanner(System.in);
        int opcion = 0;

        while (opcion == 0) {
            //le asignamos a contador el valor de 1
            int contador = 1;
            //mostramos por pantalla de que jugador es el turno
            System.out.println("TURNO DE: " + jugador);
            System.out.println(jugador + " las opciones disponibles son solo las que no tienen ficha aun");
            //mediante un ciclo FOR  con las variables j e i vamos a mostrar por pantalla las opciones disponibles
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    //usamos la variable contador para darle un orden numerico a las opciones
                    System.out.println("opcion " + contador + ": " + coordenadas[i][j]);
                    //incrementamos contador en 1
                    contador++;
                }
            }
            //le asignamos a contador el valor de 1 para poder reutilizarlo
            contador = 1;
            //le asignamos la opcion el valor que ingrese el usuario por teclado
            opcion = entrada.nextInt();
            // usamos una funcion segun para poder realizar una funcion dependiendo de la opcion elegida
            switch (opcion) {
                //ahora dependien de la opcion mediante el uso de condicionales vamos a chuequear que el lugar este disponible
                case 1:
                    //en este caso si elige la opcion uno, para que si pueda mover la ficha tiene que coincidir que en la variable unoUno
                    //tenga como valor "1,1" eso quiere decir que no hay ninguna ficha en esa posicion
                    if (unoUno.equals("1,1")) {
                        //en el caso de que este vacia ahora la variable unoUno va a tener una ficha,
                        //donde le vamos a unir el nombre del jugador que viene como argumento y las vueltas que vienen por argumento
                        //tambien pero en forma de string por ejemplo si por argumento viene jugador1= GER, la ficha va a ser GER1
                        unoUno = jugador + Integer.toString(vueltas);
                        System.out.println("Perfecto");
                    } else {
                        //en el caso de no estar vacia , a opcion se le vuelve a asignar el valor 0 para que no salga del ciclo repètir y este jugador pueda elegir
                        //otra opcion y asi ubicar una ficha en el lugar correcto
                        opcion = 0;
                        //le mostramos ademas por pantalla que la opcion no esta disponile
                        System.out.println("incorrecto esa posicion ya esta ocupada");
                    }
                    break;
                case 2:
                    //en este caso se hace lo mismo que en la opcion 1 pero ahora para que si se puede ubicar la ficha en esta posicion la variable unoDos tiene que
                    //ser igual a "1,2";
                    if (unoDos.equals("1,2")) {
                        unoDos = jugador + Integer.toString(vueltas);
                    } else {
                        opcion = 0;
                        System.out.println("incorrecto esa posicion ya esta ocupada");
                    }
                    break;
                case 3:
                    //en este caso se hace lo mismo que en la opcion 1 pero ahora para que si se puede ubicar la ficha en esta posicion la variable unoTres tiene que
                    //ser igual a "1,3";
                    if (unoTres.equals("1,3")) {
                        unoTres = jugador + Integer.toString(vueltas);
                    } else {
                        opcion = 0;
                        System.out.println("incorrecto esa posicion ya esta ocupada");
                    }
                    break;
                case 4:
                    //en este caso se hace lo mismo que en la opcion 1 pero ahora para que si se puede ubicar la ficha en esta posicion la variable dosUno tiene que
                    //ser igual a "2,1";
                    if (dosUno.equals("2,1")) {
                        dosUno = jugador + Integer.toString(vueltas);
                    } else {
                        opcion = 0;
                        System.out.println("incorrecto esa posicion ya esta ocupada");
                    }
                    break;
                case 5:
                    //en este caso se hace lo mismo que en la opcion 1 pero ahora para que si se puede ubicar la ficha en esta posicion la variable dosDos tiene que
                    //ser igual a "2,2";
                    if (dosDos.equals("2,2")) {
                        dosDos = jugador + Integer.toString(vueltas);
                    } else {
                        opcion = 0;
                        System.out.println("incorrecto esa posicion ya esta ocupada");
                    }
                    break;
                case 6:
                    //en este caso se hace lo mismo que en la opcion 1 pero ahora para que si se puede ubicar la ficha en esta posicion la variable dosTres tiene que
                    //ser igual a "2,3";
                    if (dosTres.equals("2,3")) {
                        dosTres = jugador + Integer.toString(vueltas);
                    } else {
                        opcion = 0;
                        System.out.println("incorrecto esa posicion ya esta ocupada");
                    }
                    break;
                case 7:
                    //en este caso se hace lo mismo que en la opcion 1 pero ahora para que si se puede ubicar la ficha en esta posicion la variable tresUno tiene que
                    //ser igual a "3,1";
                    if (tresUno.equals("3,1")) {
                        tresUno = jugador + Integer.toString(vueltas);
                    } else {
                        opcion = 0;
                        System.out.println("incorrecto esa posicion ya esta ocupada");
                    }
                    break;
                case 8:
                    //en este caso se hace lo mismo que en la opcion 1 pero ahora para que si se puede ubicar la ficha en esta posicion la variable tresDos tiene que
                    //ser igual a "3,2";
                    if (tresDos.equals("3,2")) {
                        tresDos = jugador + Integer.toString(vueltas);
                    } else {
                        opcion = 0;
                        System.out.println("incorrecto esa posicion ya esta ocupada");
                    }
                    break;
                case 9:
                    //en este caso se hace lo mismo que en la opcion 1 pero ahora para que si se puede ubicar la ficha en esta posicion la variable tresTres tiene que
                    //ser igual a "3,3";
                    if (tresTres.equals("3,3")) {
                        tresTres = jugador + Integer.toString(vueltas);
                    } else {
                        opcion = 0;
                        System.out.println("incorrecto esa posicion ya esta ocupada");
                    }
                    break;
                default:
                    //en el caso de que la opcion elegida por el usuario no sea correcta se le muestra por pantalla el error al usuario
                    System.out.println("incorrecto");
                    //y a opcion le asignamos el valor 0 
                    opcion = 0;
                    break;
            }
            //VOLVEMOS A LLENAR COORDENADAS CON LOS NUEVOS VALORES
            coordenadas[0][0] = unoUno;
            coordenadas[0][1] = unoDos;
            coordenadas[0][2] = unoTres;
            coordenadas[1][0] = dosUno;
            coordenadas[1][1] = dosDos;
            coordenadas[1][2] = dosTres;
            coordenadas[2][0] = tresUno;
            coordenadas[2][1] = tresDos;
            coordenadas[2][2] = tresTres;
        }

        // Una vez que el jugador coloca su ficha y sale del bucle, la opción vuelve a ser 0
        opcion = 0;
    }

    public boolean FinJuego(String jugador, boolean verificador) {
        // Corrobora horizontal desde 1,1 hasta 1,3

        if (coordenadas[0][0].substring(0, 3).equals(jugador)
                && coordenadas[0][1].substring(0, 3).equals(jugador)
                && coordenadas[0][2].substring(0, 3).equals(jugador)) {
            verificador = true;
            Ganador(jugador);
        }

        // Corrobora vertical desde 1,1 hasta 3,1
        if (coordenadas[0][0].substring(0, 3).equals(jugador)
                && coordenadas[1][0].substring(0, 3).equals(jugador)
                && coordenadas[2][0].substring(0, 3).equals(jugador)) {
            verificador = true;
            Ganador(jugador);
        }

        // Corrobora diagonal desde 1,1 hasta 3,3
        if (coordenadas[0][0].substring(0, 3).equals(jugador)
                && coordenadas[1][1].substring(0, 3).equals(jugador)
                && coordenadas[2][2].substring(0, 3).equals(jugador)) {
            verificador = true;
            Ganador(jugador);
        }

        // Corrobora vertical desde 1,2 hasta 3,2
        if (coordenadas[0][1].substring(0, 3).equals(jugador)
                && coordenadas[1][1].substring(0, 3).equals(jugador)
                && coordenadas[2][1].substring(0, 3).equals(jugador)) {
            verificador = true;
            Ganador(jugador);
        }

        // Corrobora diagonal desde 1,3 hasta 3,1
        if (coordenadas[0][2].substring(0, 3).equals(jugador)
                && coordenadas[1][1].substring(0, 3).equals(jugador)
                && coordenadas[2][0].substring(0, 3).equals(jugador)) {
            verificador = true;
            Ganador(jugador);
        }

        // Corrobora vertical desde 1,3 hasta 3,3
        if (coordenadas[0][2].substring(0, 3).equals(jugador)
                && coordenadas[1][2].substring(0, 3).equals(jugador)
                && coordenadas[2][2].substring(0, 3).equals(jugador)) {
            verificador = true;
            Ganador(jugador);
        }

        // Corrobora horizontal desde 2,1 hasta 2,3
        if (coordenadas[1][0].substring(0, 3).equals(jugador)
                && coordenadas[1][1].substring(0, 3).equals(jugador)
                && coordenadas[1][2].substring(0, 3).equals(jugador)) {
            verificador = true;
            Ganador(jugador);
        }

        // Corrobora horizontal desde 3,1 hasta 3,3
        if (coordenadas[2][0].substring(0, 3).equals(jugador)
                && coordenadas[2][1].substring(0, 3).equals(jugador)
                && coordenadas[2][2].substring(0, 3).equals(jugador)) {
            verificador = true;
            Ganador(jugador);
        }
        return verificador;

    }

    ;
    public boolean Juego(boolean comprobarMovimiento, String jugador) {
        Scanner entrada = new Scanner(System.in);
        int eleccion;
        String ficha = "";

        // Mostramos por pantalla a qué jugador le toca jugar
        System.out.println("Es tu turno : " + jugador);

        // Mostramos las fichas disponibles para mover
        System.out.println("Dime qué ficha deseas mover");
        System.out.println("1- " + jugador + "1");
        System.out.println("2- " + jugador + "2");
        System.out.println("3- " + jugador + "3");
        // Creamos un bucle que solo terminará cuando ficha tenga un valor correcto
        while (ficha.equals("")) {
            // El usuario ingresa el valor que le corresponde a elección
            eleccion = entrada.nextInt();

            // Utilizamos condicionales para asignar el valor correcto a la variable ficha
            if (eleccion == 1) {
                ficha = jugador + "1";
            } else if (eleccion == 2) {
                ficha = jugador + "2";
            } else if (eleccion == 3) {
                ficha = jugador + "3";
            } else {
                // Si ingresa cualquier otro número, mostramos un mensaje de error
                System.out.println("La elección es incorrecta por favor ingresa una elección entre 1 y 3");
            }
        }// Una vez que tenemos la ficha que queremos mover, creamos un ciclo para recorrer las coordenadas
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                // Comprobamos si en la posición actual de coordenadas se encuentra la ficha elegida por el usuario
                if (coordenadas[i][j].equals(ficha)) {
                    // Invocamos al metodo MovimientosDisponibles pasando como parámetros la variable comprobarMovimiento,
                    // la ficha elegida por el usuario, las coordenadas donde se encuentra esa ficha y la matriz coordenadas.
                    comprobarMovimiento = MovimientosDisponibles(comprobarMovimiento, ficha, i, j);

                    // Salimos del ciclo
                    i = 2;
                    j = 2;
                }
            }
        }
        return comprobarMovimiento;
    }

    ;
    public boolean MovimientosDisponibles(boolean comprobarMovimiento, String ficha, int coordenadaEnI, int coordenadaEnJ) {
        Scanner entrada = new Scanner(System.in);
        int contador = 0;
        String siOno;
        String coorDeTexto;
        siOno = "N";
        coorDeTexto = Integer.toString(coordenadaEnI) + Integer.toString(coordenadaEnJ);
        int coorANumero = Integer.parseInt(coorDeTexto);

        while (contador < 10 && siOno != "S") {
            contador++;
            switch (coorANumero) {
                //en esta opcicion entras si la ficha elegida es la de la esquina superior, entonces va a chequear primero si la coordenada que tiene
                //en su derecha esta libre, mediante el condicional si corrobora que que en esa posicion este la cadena "1,2" es decir que no haya otra ficha
                //ya ocupando ese lugar
                case 0:
                    if (coordenadas[0][1].equals("1,2")) {
                        // Si está vacía, mostrará un mensaje por pantalla preguntando si quiere mover la ficha a esa posición
                        System.out.println("¿Deseas mover la ficha: " + ficha + " a 1,2 ?");
                        // Creamos un bucle do-while para que solo deje de ejecutarse si se ingresa 'S' (sí) o 'N' (no)

                        do {
                            System.out.println("S para sí o N para no");
                            siOno = entrada.nextLine(); // Reemplaza esta función con tu método de lectura
                            siOno = siOno.toUpperCase();
                        } while (!siOno.equals("S") && !siOno.equals("N"));
                        // Hacemos otro condicional para que en caso de que la respuesta sea 'S' entre
                        // y una vez dentro, la coordenada de la derecha tome el valor de 'ficha' y donde estaba 'ficha' tome la cadena "1,1"
                        if (siOno.equals("S")) {
                            coordenadas[0][1] = ficha;
                            coordenadas[0][0] = "1,1";

                            // La variable comprobarMovimiento se vuelve verdadera, lo que indica que el usuario ya realizó su movimiento
                            comprobarMovimiento = true;
                        }
                    }

                    // Luego comprobamos que la posición de abajo esté vacía (es decir, que no haya otra ficha).
                    // Este condicional también verifica que la variable siOno sea "N" porque si es "S" significa que la ficha ya se movió.
                    if (coordenadas[1][0].equals("2,1") && siOno.equals("N")) {
                        // Repetimos los pasos anteriores para que el usuario elija si mover o no la ficha
                        System.out.println("¿Desea mover la ficha " + ficha + " a 2,1?");

                        do {
                            System.out.println("S para sí o N para no");
                            siOno = entrada.nextLine();
                            siOno = siOno.toUpperCase();
                        } while (!siOno.equals("S") && !siOno.equals("N"));

                        if (siOno.equals("S")) {
                            coordenadas[1][0] = ficha;
                            coordenadas[0][0] = "1,1";
                            comprobarMovimiento = true;
                        }
                    }
                    // Luego comprobamos la siguiente posición en la diagonal principal para ver si está vacía.
                    // Este condicional también verifica que la variable siOno sea "N" porque si es "S" significa que la ficha ya se movió.
                    if (coordenadas[1][1].equals("2,2") && siOno.equals("N")) {
                        System.out.println("¿Desea mover la ficha " + ficha + " a 2,2?");

                        do {
                            System.out.println("S para sí o N para no");
                            siOno = entrada.nextLine();
                            siOno = siOno.toUpperCase();
                        } while (!siOno.equals("S") && !siOno.equals("N"));

                        if (siOno.equals("S")) {
                            coordenadas[1][1] = ficha;
                            coordenadas[0][0] = "1,1";
                            comprobarMovimiento = true;
                        }
                    }
                    break;

                case 01:
                    //si entra a esta opcion se va a aplicar lo mismo que en la opcion 00 pero cuando la ficha elegida se encuentre en coordenadas[0,1] y va a 
                    //chequear si existe la posibildad de mover su ficha a la izquierda, derecha o abajo.
                    if (coordenadas[0][2].equals("1,3")) {
                        System.out.print("¿Deseas mover la ficha " + ficha + " a 1,3? ");
                        do {
                            System.out.print("S para sí o N para no: ");
                            siOno = entrada.next().toUpperCase();
                        } while (!siOno.equals("S") && !siOno.equals("N"));

                        if (siOno.equals("S")) {
                            coordenadas[0][2] = ficha;
                            coordenadas[0][1] = "1,2";
                            comprobarMovimiento = true;
                        }
                    }

                    if (coordenadas[0][0].equals("1,1") && siOno.equals("N")) {
                        System.out.print("¿Desea mover la ficha " + ficha + " a 1,1? ");
                        do {
                            System.out.print("S para sí o N para no: ");
                            siOno = entrada.next().toUpperCase();
                        } while (!siOno.equals("S") && !siOno.equals("N"));

                        if (siOno.equals("S")) {
                            coordenadas[0][0] = ficha;
                            coordenadas[0][1] = "1,1";
                            comprobarMovimiento = true;
                        }
                    }

                    if (coordenadas[1][1].equals("2,2") && siOno.equals("N")) {
                        System.out.print("¿Desea mover la ficha " + ficha + " a 2,2? ");
                        do {
                            System.out.print("S para sí o N para no: ");
                            siOno = entrada.next().toUpperCase();
                        } while (!siOno.equals("S") && !siOno.equals("N"));

                        if (siOno.equals("S")) {
                            coordenadas[1][1] = ficha;
                            coordenadas[0][1] = "1,2";
                            comprobarMovimiento = true;
                        }
                    }
                    break;
                case 02:
                    //si entra a esta opcion se va a aplicar lo mismo que en la opcion 00 pero cuando la ficha elegida se encuentre en coordenadas[0,2] y va a 
                    //chequear si existe la posibildad de mover su ficha a la izquierda, diagonal secundaria o abajo.
                    if (coordenadas[0][1].equals("1,2")) {
                        System.out.print("¿Deseas mover la ficha " + ficha + " a 1,2? ");
                        do {
                            System.out.print("S para sí o N para no: ");
                            siOno = entrada.next().toUpperCase();
                        } while (!siOno.equals("S") && !siOno.equals("N"));

                        if (siOno.equals("S")) {
                            coordenadas[0][1] = ficha;
                            coordenadas[0][2] = "1,3";
                            comprobarMovimiento = true;
                        }
                    }

                    if (coordenadas[1][1].equals("2,2") && siOno.equals("N")) {
                        System.out.print("¿Deseas mover la ficha " + ficha + " a 2,2? ");
                        do {
                            System.out.print("S para sí o N para no: ");
                            siOno = entrada.next().toUpperCase();
                        } while (!siOno.equals("S") && !siOno.equals("N"));

                        if (siOno.equals("S")) {
                            coordenadas[1][1] = ficha;
                            coordenadas[0][2] = "1,3";
                            comprobarMovimiento = true;
                        }
                    }

                    if (coordenadas[1][2].equals("2,3") && siOno.equals("N")) {
                        System.out.print("¿Deseas mover la ficha " + ficha + " a 2,3? ");
                        do {
                            System.out.print("S para sí o N para no: ");
                            siOno = entrada.next().toUpperCase();
                        } while (!siOno.equals("S") && !siOno.equals("N"));

                        if (siOno.equals("S")) {
                            coordenadas[1][2] = ficha;
                            coordenadas[0][2] = "1,3";
                            comprobarMovimiento = true;
                        }
                    }
                    break;
                case 10:
                    //si entra a esta opcion se va a aplicar lo mismo que en la opcion 00 pero cuando la ficha elegida se encuentre en coordenadas[1,0] y va a 
                    //chequear si existe la posibildad de mover su ficha a la derecha, hacia abajo o hacia arriba.
                    if (coordenadas[0][0].equals("1,1")) {
                        System.out.print("¿Deseas mover la ficha " + ficha + " a 1,1? ");
                        do {
                            System.out.print("S para sí o N para no: ");
                            siOno = entrada.next().toUpperCase();
                        } while (!siOno.equals("S") && !siOno.equals("N"));

                        if (siOno.equals("S")) {
                            coordenadas[0][0] = ficha;
                            coordenadas[1][0] = "2,1";
                            comprobarMovimiento = true;
                        }
                    }

                    if (coordenadas[1][1].equals("2,2") && siOno.equals("N")) {
                        System.out.print("¿Desea mover la ficha " + ficha + " a 2,2? ");
                        do {
                            System.out.print("S para sí o N para no: ");
                            siOno = entrada.next().toUpperCase();
                        } while (!siOno.equals("S") && !siOno.equals("N"));

                        if (siOno.equals("S")) {
                            coordenadas[1][1] = ficha;
                            coordenadas[1][0] = "2,1";
                            comprobarMovimiento = true;
                        }
                    }

                    if (coordenadas[2][0].equals("3,1") && siOno.equals("N")) {
                        System.out.print("¿Desea mover la ficha " + ficha + " a 3,1? ");
                        do {
                            System.out.print("S para sí o N para no: ");
                            siOno = entrada.next().toUpperCase();
                        } while (!siOno.equals("S") && !siOno.equals("N"));

                        if (siOno.equals("S")) {
                            coordenadas[2][0] = ficha;
                            coordenadas[1][0] = "2,1";
                            comprobarMovimiento = true;
                        }
                    }
                    break;
                case 11:
                    //si entra a esta opcion se va a aplicar lo mismo que en la opcion 00 pero  cuando la ficha elegida se encuentre en coordenadas[1,1] 
                    //va a tener muchas mas posiciones para las cual moverse, es decir que va a cheuqear movimientos hacia toda la primer columna ,
                    //toda la primer fila, toda la tercer columna y toda la tercer fila de la matriz.

                    if (coordenadas[0][0].equals("1,1")) {
                        System.out.print("¿Deseas mover la ficha " + ficha + " a 1,1? ");
                        do {
                            System.out.print("S para sí o N para no: ");
                            siOno = entrada.next().toUpperCase();
                        } while (!siOno.equals("S") && !siOno.equals("N"));

                        if (siOno.equals("S")) {
                            coordenadas[0][0] = ficha;
                            coordenadas[1][1] = "2,2";
                            comprobarMovimiento = true;
                        }
                    }

                    if (coordenadas[0][1].equals("1,2") && siOno.equals("N")) {
                        System.out.print("¿Desea mover la ficha " + ficha + " a 1,2? ");
                        do {
                            System.out.print("S para sí o N para no: ");
                            siOno = entrada.next().toUpperCase();
                        } while (!siOno.equals("S") && !siOno.equals("N"));

                        if (siOno.equals("S")) {
                            coordenadas[0][1] = ficha;
                            coordenadas[1][1] = "2,2";
                            comprobarMovimiento = true;
                        }
                    }
                    if (coordenadas[0][2].equals("1,3") && siOno.equals("N")) {
                        System.out.print("¿Desea mover la ficha " + ficha + " a 1,3? ");
                        do {
                            System.out.print("S para sí o N para no: ");
                            siOno = entrada.next().toUpperCase();
                        } while (!siOno.equals("S") && !siOno.equals("N"));

                        if (siOno.equals("S")) {
                            coordenadas[0][2] = ficha;
                            coordenadas[1][1] = "2,2";
                            comprobarMovimiento = true;
                        }
                    }

                    if (coordenadas[1][0].equals("2,1") && siOno.equals("N")) {
                        System.out.print("¿Desea mover la ficha " + ficha + " a 2,1? ");
                        do {
                            System.out.print("S para sí o N para no: ");
                            siOno = entrada.next().toUpperCase();
                        } while (!siOno.equals("S") && !siOno.equals("N"));

                        if (siOno.equals("S")) {
                            coordenadas[1][0] = ficha;
                            coordenadas[1][1] = "2,2";
                            comprobarMovimiento = true;
                        }
                    }
                    if (coordenadas[1][2].equals("2,3") && siOno.equals("N")) {
                        System.out.print("¿Desea mover la ficha " + ficha + " a 2,3? ");
                        do {
                            System.out.print("S para sí o N para no: ");
                            siOno = entrada.next().toUpperCase();
                        } while (!siOno.equals("S") && !siOno.equals("N"));

                        if (siOno.equals("S")) {
                            coordenadas[1][2] = ficha;
                            coordenadas[1][1] = "2,2";
                            comprobarMovimiento = true;
                        }
                    }

                    if (coordenadas[2][0].equals("3,1") && siOno.equals("N")) {
                        System.out.print("¿Desea mover la ficha " + ficha + " a 3,1? ");
                        do {
                            System.out.print("S para sí o N para no: ");
                            siOno = entrada.next().toUpperCase();
                        } while (!siOno.equals("S") && !siOno.equals("N"));

                        if (siOno.equals("S")) {
                            coordenadas[2][0] = ficha;
                            coordenadas[1][1] = "2,2";
                            comprobarMovimiento = true;
                        }
                    }
                    if (coordenadas[2][1].equals("3,2") && siOno.equals("N")) {
                        System.out.print("¿Desea mover la ficha " + ficha + " a 3,2? ");
                        do {
                            System.out.print("S para sí o N para no: ");
                            siOno = entrada.next().toUpperCase();
                        } while (!siOno.equals("S") && !siOno.equals("N"));

                        if (siOno.equals("S")) {
                            coordenadas[2][1] = ficha;
                            coordenadas[1][1] = "2,2";
                            comprobarMovimiento = true;
                        }
                    }

                    if (coordenadas[2][2].equals("3,3") && siOno.equals("N")) {
                        System.out.print("¿Desea mover la ficha " + ficha + " a 3,3? ");
                        do {
                            System.out.print("S para sí o N para no: ");
                            siOno = entrada.next().toUpperCase();
                        } while (!siOno.equals("S") && !siOno.equals("N"));

                        if (siOno.equals("S")) {
                            coordenadas[2][2] = ficha;
                            coordenadas[1][1] = "2,2";
                            comprobarMovimiento = true;
                        }
                    }
                    break;
                case 12:
                    //si entra a esta opcion se va a aplicar lo mismo que en la opcion 00 pero cuando la ficha elegida se encuentre en coordenadas[1,2] y va a 
                    //chequear si existe la posibildad de mover su ficha hacia arriba, el medio, o hacia abajo

                    if (coordenadas[0][2].equals("1,3")) {
                        System.out.print("¿Deseas mover la ficha " + ficha + " a 1,3? ");
                        do {
                            System.out.print("S para sí o N para no: ");
                            siOno = entrada.next().toUpperCase();
                        } while (!siOno.equals("S") && !siOno.equals("N"));

                        if (siOno.equals("S")) {
                            coordenadas[0][2] = ficha;
                            coordenadas[1][2] = "2,3";
                            comprobarMovimiento = true;
                        }
                    }

                    if (coordenadas[1][1].equals("2,2") && siOno.equals("N")) {
                        System.out.print("¿Desea mover la ficha " + ficha + " a 2,2? ");
                        do {
                            System.out.print("S para sí o N para no: ");
                            siOno = entrada.next().toUpperCase();
                        } while (!siOno.equals("S") && !siOno.equals("N"));

                        if (siOno.equals("S")) {
                            coordenadas[1][1] = ficha;
                            coordenadas[1][2] = "2,3";
                            comprobarMovimiento = true;
                        }
                    }

                    if (coordenadas[2][2].equals("3,3") && siOno.equals("N")) {
                        System.out.print("¿Desea mover la ficha " + ficha + " a 3,3? ");
                        do {
                            System.out.print("S para sí o N para no: ");
                            siOno = entrada.next().toUpperCase();
                        } while (!siOno.equals("S") && !siOno.equals("N"));

                        if (siOno.equals("S")) {
                            coordenadas[2][2] = ficha;
                            coordenadas[1][2] = "2,3";
                            comprobarMovimiento = true;
                        }
                    }
                    break;
                case 20:
                    //si entra a esta opcion se va a aplicar lo mismo que en la opcion 00 pero cuando la ficha elegida se encuentre en coordenadas[2,0] y va a 
                    //chequear si existe la posibildad de mover su ficha hacia arriba,
                    if (coordenadas[1][0].equals("2,1")) {
                        System.out.print("¿Deseas mover la ficha " + ficha + " a 2,1? ");
                        do {
                            System.out.print("S para sí o N para no: ");
                            siOno = entrada.next().toUpperCase();
                        } while (!siOno.equals("S") && !siOno.equals("N"));

                        if (siOno.equals("S")) {
                            coordenadas[1][0] = ficha;
                            coordenadas[2][0] = "3,1";
                            comprobarMovimiento = true;
                        }
                    }

                    if (coordenadas[1][1].equals("2,2") && siOno.equals("N")) {
                        System.out.print("¿Deseas mover la ficha " + ficha + " a 2,2? ");
                        do {
                            System.out.print("S para sí o N para no: ");
                            siOno = entrada.next().toUpperCase();
                        } while (!siOno.equals("S") && !siOno.equals("N"));

                        if (siOno.equals("S")) {
                            coordenadas[1][1] = ficha;
                            coordenadas[2][0] = "3,1";
                            comprobarMovimiento = true;
                        }
                    }

                    if (coordenadas[2][1].equals("3,2") && siOno.equals("N")) {
                        System.out.print("¿Desea mover la ficha " + ficha + " a 3,2? ");
                        do {
                            System.out.print("S para sí o N para no: ");
                            siOno = entrada.next().toUpperCase();
                        } while (!siOno.equals("S") && !siOno.equals("N"));

                        if (siOno.equals("S")) {
                            coordenadas[2][1] = ficha;
                            coordenadas[2][0] = "3,1";
                            comprobarMovimiento = true;
                        }
                    }
                    break;
                case 21:
                    if (coordenadas[2][0].equals("3,1")) {
                        System.out.print("¿Deseas mover la ficha " + ficha + " a 3,1? ");
                        do {
                            System.out.print("S para sí o N para no: ");
                            siOno = entrada.next().toUpperCase();
                        } while (!siOno.equals("S") && !siOno.equals("N"));

                        if (siOno.equals("S")) {
                            coordenadas[2][0] = ficha;
                            coordenadas[2][1] = "3,2";
                            comprobarMovimiento = true;
                        }
                    }

                    if (coordenadas[1][1].equals("2,2") && siOno.equals("N")) {
                        System.out.print("¿Desea mover la ficha " + ficha + " a 2,2? ");
                        do {
                            System.out.print("S para sí o N para no: ");
                            siOno = entrada.next().toUpperCase();
                        } while (!siOno.equals("S") && !siOno.equals("N"));

                        if (siOno.equals("S")) {
                            coordenadas[1][1] = ficha;
                            coordenadas[2][1] = "3,2";
                            comprobarMovimiento = true;
                        }
                    }

                    if (coordenadas[2][2].equals("3,3") && siOno.equals("N")) {
                        System.out.print("¿Desea mover la ficha " + ficha + " a 3,3? ");
                        do {
                            System.out.print("S para sí o N para no: ");
                            siOno = entrada.next().toUpperCase();
                        } while (!siOno.equals("S") && !siOno.equals("N"));

                        if (siOno.equals("S")) {
                            coordenadas[2][2] = ficha;
                            coordenadas[2][1] = "3,2";
                            comprobarMovimiento = true;
                        }
                    }
                    break;
                case 22:
                    if (coordenadas[2][1].equals("3,2")) {
                        System.out.print("¿Deseas mover la ficha " + ficha + " a 3,2? ");
                        do {
                            System.out.print("S para sí o N para no: ");
                            siOno = entrada.next().toUpperCase();
                        } while (!siOno.equals("S") && !siOno.equals("N"));

                        if (siOno.equals("S")) {
                            coordenadas[2][1] = ficha;
                            coordenadas[2][2] = "3,3";
                            comprobarMovimiento = true;
                        }
                    }

                    if (coordenadas[1][1].equals("2,2") && siOno.equals("N")) {
                        System.out.print("¿Desea mover la ficha " + ficha + " a 2,2? ");
                        do {
                            System.out.print("S para sí o N para no: ");
                            siOno = entrada.next().toUpperCase();
                        } while (!siOno.equals("S") && !siOno.equals("N"));

                        if (siOno.equals("S")) {
                            coordenadas[1][1] = ficha;
                            coordenadas[2][2] = "3,3";
                            comprobarMovimiento = true;
                        }
                    }

                    if (coordenadas[1][2].equals("2,3") && siOno.equals("N")) {
                        System.out.print("¿Desea mover la ficha " + ficha + " a 2,3? ");
                        do {
                            System.out.print("S para sí o N para no: ");
                            siOno = entrada.next().toUpperCase();
                        } while (!siOno.equals("S") && !siOno.equals("N"));

                        if (siOno.equals("S")) {
                            coordenadas[1][2] = ficha;
                            coordenadas[2][2] = "3,3";
                            comprobarMovimiento = true;
                        }
                    }

            }

        }
        return comprobarMovimiento;
    }

    ;
    public void Ganador(String jugador) {
        System.out.println("        ¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶ ");
        System.out.println("        ¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶ ");
        System.out.println("   ¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶");
        System.out.println(" ¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶ ");
        System.out.println("¶¶¶¶      ¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶      ¶¶¶¶ ");
        System.out.println("¶¶¶       ¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶       ¶¶¶ ");
        System.out.println("¶¶        ¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶        ¶¶¶ ");
        System.out.println("¶¶¶     ¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶      ¶¶¶ ");
        System.out.println("¶¶¶    ¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶    ¶¶¶¶ ");
        System.out.println(" ¶¶¶   ¶¶¶ ¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶ ¶¶¶    ¶¶¶ ");
        System.out.println(" ¶¶¶¶   ¶¶¶ ¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶ ¶¶¶¶  ¶¶¶¶ ");
        System.out.println("   ¶¶¶¶  ¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶ ¶¶¶¶¶ ");
        System.out.println("    ¶¶¶¶¶¶¶¶ ¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶ ¶¶¶¶¶¶¶¶¶ ");
        System.out.println("      ¶¶¶¶¶¶  ¶¶¶¶¶¶¶¶¶¶¶¶¶¶  ¶¶¶¶¶¶ ");
        System.out.println("               ¶¶¶¶¶¶¶¶¶¶¶¶ ");
        System.out.println("                 ¶¶¶¶¶¶¶¶ ");
        System.out.println("                   ¶¶¶¶ ");
        System.out.println("                   ¶¶¶¶ ");
        System.out.println("                   ¶¶¶¶ ");
        System.out.println("                   ¶¶¶¶ ");
        System.out.println("               ¶¶¶¶¶¶¶¶¶¶¶¶ ");
        System.out.println("            ¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶ ");
        System.out.println("            ¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶ ");
        System.out.println("            ¶¶¶   GANADOR  ¶¶¶ ");
        System.out.println("            ¶¶¶     " + jugador + "    ¶¶¶ ");
        System.out.println("            ¶¶¶   WINNER   ¶¶¶ ");
        System.out.println("            ¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶ ");
        System.out.println("            ¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶ ");
        System.out.println("          ¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶ ");
        System.out.println("         ¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶ ");
    }
}
