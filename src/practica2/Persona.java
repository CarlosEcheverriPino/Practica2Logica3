/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

/**
 *
 * @author CompucenterPC1
 */
public class Persona {
    
    //Esta clase almacena las variables de las personas y contiene sus respectiivos getter and setter
    
   private String nombre = "";   // nombre de la persona
   private String id = "";      //Id de la persona
   private String padre = "";  //nombre del padre

    public String getPadre() {
        return padre;
    }

    public void setPadre(String padre) {
        this.padre = padre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
   
    /*public String Obtenerdato(NodoNario a){
        Persona sisas;
        sisas = (Persona)a.getDato();
        String name ="";
        name = sisas.getPadre();
        return name;
        
    }*/
   
   
   
    
    
}
