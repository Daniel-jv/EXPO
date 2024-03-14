package reloj_clases;

import java.util.Scanner;

public class Reloj_clases {
    
    static int hora = 233;
    static Scanner leer = new Scanner(System.in);
    static int cont = 0;
    
    public static void main(String[] args) {
        Alarma alarms [] = new Alarma [5];
        int op = 0;
        boolean var = true;
        while(var){
            
            System.out.print("---Opciones\n1)¿Que hora es?\n2)Crear Alarma\n3)¿Que hora es en otro pais?\n4)Alarmas\n5)Eliminar Alarma\n6)Salir\nIngrese una opcion:");
            op = leer.nextInt();
            es_hora(alarms);
            switch (op) {
                
                case 1:{
                    String H = hour();
                    System.out.println("\nHora: "+H);
                    hora += 1;
                    nextHOUR();
                    check();
                    break;
                }//fin case1
                
                case 2:{
                    String hour = "";
                    System.out.print("\nIngrese el nombre de la alarma: ");
                    leer.nextLine();
                    String nombre = leer.nextLine();
                    boolean ok = true;
                    while(ok){
                        System.out.print("Ingrese la hora(hora:minuto): ");
                        hour = leer.nextLine();
                        int errors = 0;
                        if(hour.length() != 4 && hour.length() != 5){
                            System.out.println("Datos incorrectos");
                            errors++;
                        }else if(hour.length() == 4 || hour.length() == 5){
                            if (hour.length() == 4) {
                                String HORA = hour.substring(0, 1);
                                String sintaxis = hour.substring(1,2);
                                String min = hour.substring(2, 4);
                                int H = Integer.parseInt(HORA);
                                if(H > 12 || H < 0){
                                    System.out.println("Datos incorrectos");
                                    errors++;
                                }
                                if(!sintaxis.equals(":")){
                                    System.out.println("Datos incorrectos");
                                    errors++;
                                }
                                int M = Integer.parseInt(min);
                                if(M % 10 != 0 || M > 50 || M < 0){
                                    System.out.println("Datos incorrectos");
                                    errors++;
                                }
                            }else if(hour.length() == 5){
                            String HORA = hour.substring(0, 2);
                            String sintaxis = hour.substring(2,3);
                            String min = hour.substring(3, 5);
                            int H = Integer.parseInt(HORA);
                                if(H > 25 || H < 0){
                                    System.out.println("Datos incorrectos");
                                    errors++;
                                }
                                if(!sintaxis.equals(":")){
                                    System.out.println("Datos incorrectos");
                                    errors++;
                                }
                                int M = Integer.parseInt(min);
                                if(M % 10 != 0 || M > 50 || M < 0){
                                    System.out.println("Datos incorrectos");
                                    errors++;
                                }
                            }
                        }
                        if(errors == 0){
                            ok = false;
                        }
                    }
                    System.out.print("Ingrese una Cancion: ");
                    String cancion = leer.nextLine();
                    Alarma nuevaAlarma = new Alarma(nombre,hour,cancion);
                    alarms[cont] = nuevaAlarma;
                    cont = cont + 1;
                    hora += 1;
                    check();
                    nextHOUR();
                    break;
                }//fin case2
                
                case 3:{
                    System.out.print("\n¿Que hora desea ver?\n1-USA\n2-Spaña\n3-China\nIngrese una opcion:");
                    int pais = leer.nextInt();
                    System.out.println();
                    switch(pais){
                        
                        case 1:{
                            int sumada = hora + 20;
                            sumada = nextHOUR2(sumada);
                            String pais_hora = country(sumada);
                            System.out.println("La hora en USA es: "+pais_hora);
                            break;
                        }
                        
                        case 2:{
                            int sumada = hora + 70;
                            sumada = nextHOUR2(sumada);
                            String pais_hora = country(sumada);
                            System.out.println("La hora en Spaña es: "+pais_hora);
                            break;
                        }
                        
                        case 3:{
                            int sumada = hora + 140;
                            sumada = nextHOUR2(sumada);
                            String pais_hora = country(sumada);
                            System.out.println("La hora en China es: "+pais_hora);
                            break;
                        }
                        
                        default:{
                            System.out.println("\nOPCION NO VALIDA");
                            break;
                        }
                        
                    }
                    hora += 1;
                    check();
                    nextHOUR();
                    break;
                }//fin case3
                
                case 4:{
                    System.out.println("\n----ALARMAS---");
                    if(cont < 1){
                        System.out.println("No tienes alarmas");
                    }else{
                        for (int i = 0; i < cont; i++) {
                            System.out.println(i+1+ ")" + alarms[i].toString());
                        }
                    }
                    hora += 1;
                    check();
                    nextHOUR();
                    break;
                }//fin case4
                
                case 5:{
                    System.out.println("\n---ELIMINAR---");
                    System.out.print("Ingrese una alarma para borrar: ");
                    int borrar = leer.nextInt();
                    borrar--;
                    if(cont < 1){
                        System.out.println("No tienes alarmas");
                    }else if(borrar > cont){
                        System.out.println("Solo tiene "+cont+"alarmas");
                    }else{
                        Alarma alarm = new Alarma ("","","");
                        alarms[cont] = alarm;
                        System.out.println("Eliminaste la alarma");
                        cont = cont - 2;
                    }
                    break;
                }///fin case 5
                
                case 6:{
                    System.out.println("\nHa salido de la aplicacion");
                    var = false;
                    break;
                }//fin case5
                
                default:{
                    System.out.println("\nOPCION NO VALIDA");
                    hora += 1;
                    check();
                    nextHOUR();
                    break;
                }//fin default
                
            }//fin switch
            System.out.println();
        }//fin while
        
    }//fin main
    
    public static String hour(){
        String H = "";
        String min = "";
        if(hora >= 240){
           hora = hora - 240;
        }
        String h = Integer.toString(hora);
        if(hora < 10){
            h = ("0"+Integer.toString(hora));
        }
        if(h.length() == 3){
            String HORA = h.substring(0, 2);
            min = h.substring(2, 3);
            H = HORA;
        }else if(h.length() == 2){
            String HORA = h.substring(0, 1);
            min = h.substring(1, 2);
            H = HORA;
        }
        String hour = (H+":"+min+"0");
        return hour;
    }//fin hour
    
    public static void nextHOUR(){
        String h = "";
        int MIN = 0;
        if(hora >= 240){
           hora = hora - 240;
        }
        if(hora < 10){
            MIN = hora;
        }else{
            h = Integer.toString(hora);
            String min = "";
            if(h.length() == 3){
                min = h.substring(2, 3);
            }else if(h.length() == 2){
                min = h.substring(1, 2);
            }
            MIN = Integer.parseInt(min);
        }
        if(MIN > 5){
            hora += 4;
        }
    }//fin nextHOUR
    
    public static int nextHOUR2(int num){
        int MIN = 0;
        String h = "";
        String min = "";
        if(num >= 240){
           num = num - 240;
        }
        if(num < 10){
            MIN = hora;
        }else{
            h = Integer.toString(hora);
            if(h.length() == 3){
                min = h.substring(2, 3);
            }else if(h.length() == 2){
                min = h.substring(1, 2);
            }
        }
        MIN = Integer.parseInt(min);
        System.out.println(MIN);
        if(MIN > 5){
            num += 4;
        }
        return num;
    }//fin nextHOUR2
    
    public static String country(int sumada){
        String hour = "";
        if(sumada >= 240){
            sumada = sumada - 240;
        }
        String h = Integer.toString(sumada);
        if (h.length() == 2) {
            String HORA = h.substring(0, 1);
            String min = h.substring(1, 2);
            String H = HORA;
            hour = (H+":"+min+"0");
            
        }else if(h.length() == 3){
            String HORA = h.substring(0, 2);
            String min = h.substring(2, 3);
            String H = HORA;
            hour = (H+":"+min+"0");
        }
        return hour;
    }//fin hour
    
    public static int check(){
        if(hora >= 240){
            hora = hora - 240;
        }
        return hora;
    }//fin check
    
    public static void es_hora(Alarma alarms []){
        System.out.println();
        if(hora >= 240){
            hora = hora - 240;
        }
        String h = Integer.toString(hora);
        String hour = "";
        if (h.length() == 2) {
            String HORA = h.substring(0, 1);
            String min = h.substring(1, 2);
            String H = HORA;
            hour = (H+":"+min+"0");
            
        }else if(h.length() == 3){
            String HORA = h.substring(0, 2);
            String min = h.substring(2, 3);
            String H = HORA;
            hour = (H+":"+min+"0");
        }
        for (int i = 0; i < cont; i++) {
            String alarm = alarms[i].getHour();
            if(hour.equals(alarm)){
                boolean repeat = true;
                while(repeat){
                    System.out.println("!!!!!!!!!!"+alarms[i].getNombre()+"!!!!!!!!!!");
                    System.out.println("!!!!!!!!!!"+alarms[i].getCancion()+"!!!!!!!!!!");
                    System.out.print("Ingrese x para desactivar la alarma: ");
                    char end = leer.next().charAt(0);
                    if(end == 'x'){
                        System.out.println("Alarma desactivada");
                        repeat = false;
                    }else{
                        repeat = true;
                    }
                }
            }
        }
    }//fin es_hora
    
}//fin class
