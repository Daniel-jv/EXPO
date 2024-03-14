package reloj_clases;

import java.util.Scanner;

public class Reloj_clases {
    
    static int hora = 120;
    static Scanner leer = new Scanner(System.in);
    static int cont = 0;
    
    public static void main(String[] args) {
        Alarma alarms [] = new Alarma [5];
        int op = 0;
        boolean var = true;
        while(var){
            
            System.out.print("---Opciones\n1)¿Que hora es?\n2)Crear Alarma\n3)¿Que hora es en otro pais?\n4)Alarmas\n5)Salir\nIngrese una opcion:");
            op = leer.nextInt();
            
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
                    System.out.print("\nIngrese el nombre de la alarma: ");
                    String nombre = leer.nextLine();
                    System.out.print("Ingrese la hora: ");
                    String hour = leer.nextLine();
                    System.out.print("Ingrese una Cancion: ");
                    String cancion = leer.nextLine();
                    Alarma nuevaAlarma = new Alarma(nombre,hour,cancion);
                    alarms[cont] = nuevaAlarma;
                    cont++;
                    hora += 1;
                    nextHOUR();
                    check();
                    break;
                }//fin case2
                
                case 3:{
                    System.out.print("\n¿Que hora desea ver?\n1-USA\n2-Spaña\n3-China\nIngrese una opcion:");
                    int pais = leer.nextInt();
                    switch(pais){
                        
                        case 1:{
                            int sumada = 120 + 20;
                            country(sumada);
                            
                            break;
                        }
                        
                        case 2:{
                            int sumada = 120 + 70;
                            country(sumada);
                            break;
                        }
                        
                        case 3:{
                            int sumada = 120 + 140;
                            country(sumada);
                            break;
                        }
                        
                        default:{
                            System.out.println("\nOPCION NO VALIDA");
                            break;
                        }
                        
                    }
                    hora += 1;
                    nextHOUR();
                    check();
                    break;
                }//fin case3
                
                case 4:{
                    System.out.println("\n----ALARMAS---");
                    for (int i = 0; i < cont; i++) {
                        System.out.println(i+1+ ")" + alarms[i]);
                    }
                    hora += 1;
                    nextHOUR();
                    check();
                    break;
                }//fin case4
                
                case 5:{
                    System.out.println("\nHa salido de la aplicacion");
                    var = false;
                    break;
                }//fin case5
                
                default:{
                    System.out.println("\nOPCION NO VALIDA");
                    hora += 1;
                    nextHOUR();
                    check();
                    break;
                }//fin default
                
            }//fin switch
            System.out.println();
        }//fin while
        
    }//fin main
    
    public static String hour(){
        check();
        String h = Integer.toString(hora);
        String HORA = h.substring(0, 2);
        String min = h.substring(2, 3);;
        String H = HORA;
        String hour = (H+":"+min+"0");
        return hour;
    }//fin hour
    
    public static void nextHOUR(){
        check();
        String h = Integer.toString(hora);
        String min = h.substring(2, 3);;
        int MIN = Integer.parseInt(min);
        if(MIN > 5){
            hora += 4;
        }
    }//fin nextHOUR
    
    public static String country(int sumada){
        check();
        String h = Integer.toString(sumada);
        String HORA = h.substring(0, 2);
        String min = h.substring(2, 3);;
        String H = HORA;
        String hour = (H+":"+min+"0");
        return hour;
    }//fin hour
    
    public static void check(){
        if(hora > 240){
            hora = hora - 240;
        }
    }//fin check
    
}//fin class
