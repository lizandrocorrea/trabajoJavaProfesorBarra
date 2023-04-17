
package Libreria;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Acceso implements IAcceso {
    // Atributos
    private String username;
    private String llave;
    private Date fechaCaducidad;
    private int diasCaducidad;
    private boolean estadoInicial;
    private boolean estadoAcceso; 
    // Constructores
    public Acceso() {
        this.username = "";
        this.llave = "";
        this.fechaCaducidad = new Date();
        this.diasCaducidad = 0;
        this.estadoInicial = false;
        this.estadoAcceso = true;
    }
    public Acceso(String username, String llave, Date fechaCaducidad, int diasCaducidad, boolean estadoInicial, boolean estadoAcceso) {
        this.username = username;
        this.llave = llave;
        this.fechaCaducidad = fechaCaducidad;
        this.diasCaducidad = diasCaducidad;
        this.estadoInicial = estadoInicial;
        this.estadoAcceso = estadoAcceso;
    }
    // Propiedades

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLlave() {
        return llave;
    }

    public void setLlave(String llave) {
        this.llave = llave;
    }

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public int getDiasCaducidad() {
        return diasCaducidad;
    }

    public void setDiasCaducidad(int diasCaducidad) {
        this.diasCaducidad = diasCaducidad;
    }

    public boolean isEstadoInicial() {
        return estadoInicial;
    }

    public void setEstadoInicial(boolean estadoInicial) {
        this.estadoInicial = estadoInicial;
    }

    public boolean isEstadoAcceso() {
        return estadoAcceso;
    }

    public void setEstadoAcceso(boolean estadoAcceso) {
        this.estadoAcceso = estadoAcceso;
    }
    // Métodos

    @Override
    public int tieneCaracteresMayusculas() {
        try {
            String listaCaracteresMayusculas="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            for(int i=0;i<llave.length();i++){
                for(int j=0;j<listaCaracteresMayusculas.length();j++){                
                    if(llave.substring(i, i+1).contains(listaCaracteresMayusculas.substring(j, j+1))){
                       return 1; // Ok
                    }
                }
            }
            return 0; // NOk
        } catch(Exception e){
            return -1;
        }
    }

    @Override
    public int tieneCaracteresMinusculas() {
        try {
            String listaCaracteresMinusculas="abcdefghijklmnopqrstuvwxyz";
            for(int i=0;i<llave.length();i++){
                for(int j=0;j<listaCaracteresMinusculas.length();j++){                
                    if(llave.substring(i, i+1).contains(listaCaracteresMinusculas.substring(j, j+1))){
                       return 1; 
                    }
                }
            }
            return 0; 
        } catch(Exception e){
            return -1;
        }
    }

    @Override
    public int tieneCaracteresNumericos() {
        try {
            String listaCaracteresNumericos="0123456789";
            for(int i=0;i<llave.length();i++){
                for(int j=0;j<listaCaracteresNumericos.length();j++){                
                    if(llave.substring(i, i+1).contains(listaCaracteresNumericos.substring(j, j+1))){
                       return 1; 
                    }
                }
            }
            return 0;     
        } catch(Exception e){
            return -1;
        }
    }

    @Override
    public int tieneCaracterEspeciales() {
        try {
            String listaCaracteresEspeciales=".,;:-_{[";
            for(int i=0;i<llave.length();i++){
                for(int j=0;j<listaCaracteresEspeciales.length();j++){                
                    if(llave.substring(i, i+1).contains(listaCaracteresEspeciales.substring(j, j+1))){
                       return 1; 
                    }
                }
            }
            return 0;         
        } catch(Exception e){
            return -1;
        }
    }

    @Override
    public int tieneLargoMinimo() {
        try {
            if(llave.length()>IAcceso.LARGO_MINIMO) {
               return 1; 
            }         
            return 0; 
        } catch(Exception e){
            return -1;
        }
    }


    // trabajo del profesor Barra primera parte 
    @Override
    public int esFuerte() {
        try { 
            if(tieneCaracterEspeciales() == 1 && tieneCaracteresMayusculas() ==1
             && tieneCaracteresMinusculas() == 1 && tieneCaracteresNumericos() ==1 && tieneLargoMinimo() ==1) {
               return 0; 
            } else {
               return 1;
            }
        } catch(Exception e) {
            return -1;
        }
    }

    //trabajo profesor barra segunda parte Caducidad 

    @Override
public int caducoLlave(){
    try {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaCaducidad = dateFormat.parse("15-04-2023");
        Date fechaActual = new Date();
               
        if(fechaActual.after(fechaCaducidad)){
            return 1; 
        } else {
            return 0; 
        }
    } catch(Exception e){
        return -1; 
    }
}
    

//actualizar mostrar por pantalla la proxima fecha de caducidad

@Override
public int actualizarFechaCaducidad() {
    try {
        Calendar calendar = Calendar.getInstance();  
        Date fechaActual = Calendar.getInstance().getTime();
        Date fechaCaducidad = this.fechaCaducidad;
        calendar.setTime(fechaCaducidad);
        calendar.add(Calendar.DATE, 7);
        Date nuevaFechaCaducidad = calendar.getTime();
        boolean actualizacionExitosa = nuevaFechaCaducidad.after(fechaActual);
        this.fechaCaducidad = actualizacionExitosa ? nuevaFechaCaducidad : this.fechaCaducidad;
       
        System.out.println(("La fecha de caducidad es:  ") + nuevaFechaCaducidad);

        return actualizacionExitosa ? 1 : 0;
    } catch(Exception e){
        return 0; 
    }
}

    

                //DateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        

                //System.out.println("Nueva fecha: " +  formato.format(nuevaFecha));
        
        
           // if(nuevaFechaCaducidad.after(fechaActual)){
                //this.fechaCaducidad = nuevaFechaCaducidad;
                 
           
                // } else {
                //return 0;
          //  }
      //  } catch(Exception e){
        //    return -1; 
       //}
    
    
    

   // @Override
 //   public int esValidoUsername() {
      //  try {
      //      if (username.equals("perico")) {
       //         return 0; // el nombre de usuario no es válido
         //   } else {
               // return 1; // el nombre de usuario es válido
         //   }
      //  } catch(Exception e) {
         //   return -1; // manejar la excepción aquí, devolviendo -1
       // }

       
       
        

        @Override
        public int esValidoUsername() {
            final String EMAIL_REGEX =
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
            Pattern pattern = Pattern.compile(EMAIL_REGEX);
            Matcher matcher = pattern.matcher(username);
        
            if (matcher.matches()) {
                return 0;
                
            } else {
                return 1; 
            }
        }



    }
  
    
    



