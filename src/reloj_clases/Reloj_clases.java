package reloj_clases;

import java.util.Scanner;

public class Reloj_clases {
    
    static int hora = 120;
    static Scanner leer = new Scanner(System.in);
    
    public static void main(String[] args) {
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
                    break;
                }//fin case1
                
                case 2:{
                    
                    hora += 1;
                    nextHOUR();
                    break;
                }//fin case2
                
                case 3:{
                    
                    hora += 1;
                    nextHOUR();
                    break;
                }//fin case3
                
                case 4:{
                    
                    hora += 1;
                    nextHOUR();
                    break;
                }//fin case4
                
                case 5:{
                    System.out.println("Ha salido de la aplicacion");
                    var = false;
                    break;
                }//fin case5
                
                default:{
                    System.out.println("OPCION NO VALIDA");
                    hora += 1;
                    nextHOUR();
                    break;
                }//fin default
                
            }//fin switch
            System.out.println();
        }//fin while
        
    }//fin main
    
    public static String hour(){
        String h = Integer.toString(hora);
        String HORA = h.substring(0, 2);
        String min = h.substring(2, 3);;
        String H = HORA;
        String hour = (H+":"+min+"0");
        return hour;
    }//fin hour
    
    public static void nextHOUR(){
        String h = Integer.toString(hora);
        String min = h.substring(2, 3);;
        int MIN = Integer.parseInt(min);
        if(MIN > 5){
            hora += 4;
        }
    }//fin nextHOUR
    
}//fin class
