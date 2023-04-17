
package Libreria;


public interface IAcceso {
    final int LARGO_MINIMO=8;
    //final String username= "perico";
    int tieneCaracteresMayusculas();
    int tieneCaracteresMinusculas();
    int tieneCaracteresNumericos();
    int tieneCaracterEspeciales();
    int tieneLargoMinimo();
    int esFuerte();
    int caducoLlave();
    int actualizarFechaCaducidad();
    int esValidoUsername();    
}
