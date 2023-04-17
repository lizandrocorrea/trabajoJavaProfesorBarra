
package Aplicacion;

import Libreria.Acceso;
import java.util.Date;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class pruebaAcceso {
    /**
     * @param args
     */
    public static void main(String args[]){
        // Datos de prueba
        String username="Juandiazgmail.com"; // tiene que aprovar si es el numbre de usario 
        String llave="Sd1234_567";
        Date fechaCaducidad=new Date();
        int diasCaducidad=7;
        boolean estadoInicial=false;
        boolean estadoAcceso=true; 

        Acceso objAcceso = new Acceso(username,llave,fechaCaducidad,diasCaducidad,estadoInicial,estadoAcceso);
        
        int opcion= objAcceso.tieneCaracteresMayusculas();
        switch(opcion){
            case 0:
                System.out.println("No tiene caracteres en mayúscula");
                break;
            case 1:
                System.out.println("Si tiene caracteres en mayúscula");
                break;
            default:
                System.out.println("Reintente");     
        }
        opcion= objAcceso.tieneCaracteresMinusculas();
        switch(opcion){
            case 0:
                System.out.println("No tiene caracteres en minúsculas");
                break;
            case 1:
                System.out.println("Si tiene caracteres en minúsculas");
                break;
            default:
                System.out.println("Reintente");     
        }   
        opcion= objAcceso.tieneCaracteresNumericos();
        switch(opcion){
            case 0:
                System.out.println("No tiene caracteres numericos");
                break;
            case 1:
                System.out.println("Si tiene caracteres numericos");
                break;
            default:
                System.out.println("Reintente");     
        }    
        opcion= objAcceso.tieneCaracterEspeciales();
        switch(opcion){
            case 0:
                System.out.println("No tiene caracteres especiales");
                break;
            case 1:
                System.out.println("Si tiene caracteres especiales");
                break;
            default:
                System.out.println("Reintente");     
        }   
        opcion= objAcceso.tieneLargoMinimo();
        switch(opcion){
            case 0:
                System.out.println("No tiene largo minimo");
                break;
            case 1:
                System.out.println("Si tiene largo minimo");
                break;
            default:
                System.out.println("Reintente");     
        } 

        // caso desarrollado 1

        opcion= objAcceso.esFuerte();
        switch(opcion){
            case 0:
                System.out.println("Su contraseña es fuerte");
                break;
            case 1:
                System.out.println("Su contraseña debe tener los parametros aceptados, no es fuerte");
                break;
            default:
                System.out.println("Reintente");         
    }


    //caso username es valido 

    //public int esValidoUsername() {
        opcion= objAcceso.esValidoUsername();
    switch(opcion){
        case 0:
            System.out.println("El usuarios es valido ");
            break;
        case 1:
            System.out.println("Su Usuario no es valido");
            break;
        default:
            System.out.println("Reintente");   
    }

    opcion= objAcceso.caducoLlave();
    switch(opcion){
        case 0:
            System.out.println("la llave esta caducada,  ");
            break;
        case 1:
            System.out.println("la llave es valida hasta la fecha  "   +(fechaCaducidad)+ ",  pero es conversable!!");
            break;
        default:
            System.out.println("Reintente");   
    }

    opcion= objAcceso.actualizarFechaCaducidad();
    switch(opcion){
        case 1:
       
            
            
        break;
    case 0:
       System.out.println("la llave es valida hasta la fecha  "  );
        break;
    default:
        System.out.println("Reintente");   

    }
}
}



//  para la fecha saque la informacion de un video de youtube https://www.youtube.com/watch?v=Xltvgnl0kYI