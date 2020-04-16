/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author CompucenterPC1
 */
public class Practica2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int entrada = 0;
        String Nombre;
        String Id;
        String Padre;
        ArbolNarioListaGeneralizada arbol = new ArbolNarioListaGeneralizada();
        
         do{ //controlador del menu
             //menu de opciones
         
        while(entrada < 1 ||entrada> 3){
            entrada = Integer.parseInt(JOptionPane.showInputDialog("Seleccione una de las siguientes opciones:"
            + "\n"+"1 - Ingresar una persona \n"
            + "2 - Buscar una persona \n"
            + "3 - salir "));
            
     if(entrada < 1 || entrada > 3){//--> controlador respuesta por fuera de rango.
                JOptionPane.showMessageDialog(null,"Opcion no encontrada, favor eliga de nuevo.");
            }         
        }
        switch(entrada){
            
            //si elige la opcion de ingresar
            case 1:
                Nombre = JOptionPane.showInputDialog("ingrese el nombre");
                Id = JOptionPane.showInputDialog("Ingrese el id");
                Padre = JOptionPane.showInputDialog("ingrese el id o el nombre del padre");
                Persona per = new Persona();
                per.setId(Id);
                per.setNombre(Nombre);
                per.setPadre(Padre);
                arbol.addPersona(per);
                break;
                
            case 2:
                //si elige la opcion de buscar
                String buscar =JOptionPane.showInputDialog("Ingrese la id a buscar");
                if(buscar != null){
                    arbol.buscar(buscar);
                    
                break; 
                }
        }
        
               if(entrada >= 1 && entrada <= 2){//-->reseteador de seleccion en caso de que la seleccion
           entrada = 0;                   //este dentro del rango para poder ingresar al bucle.
               }          
    }while(entrada != 3);
    JOptionPane.showMessageDialog(null,"Fin de la ejecucion.");
    
         }
         
}
         


        
     
         
 

