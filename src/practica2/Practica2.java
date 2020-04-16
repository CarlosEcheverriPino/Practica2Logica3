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
    public static void main(String[] args) throws IOException {
        int entrada = 0;
        String Nombre;
        String Id;
        String Padre;
        ArbolNarioListaGeneralizada arbol = new ArbolNarioListaGeneralizada();
        CargaTexto añadir = new CargaTexto();
        
        //añadir.leer(arbol);
        
         do{ //controlador del menu
             //menu de opciones
        entrada = 0; 
        while(entrada < 1 || entrada > 5){
            entrada = Integer.parseInt(JOptionPane.showInputDialog("Seleccione una de las siguientes opciones:"
            + "\n"+"1 - Ingresar una persona \n"
            + "2 - Buscar una persona \n"
            + "3 - Imprimir arbol \n"
            + "4 - Cargar archivo texto \n"        
            + "5 - salir "));
            
            if(entrada < 1 || entrada > 5){
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
                String id =JOptionPane.showInputDialog("Ingrese la id a buscar");
                if(id != null){
                    JOptionPane.showMessageDialog(null, arbol.BuscarId(id));
  
                break; 
                }
                
            case 3:
                JOptionPane.showMessageDialog(null, arbol.Imprimir());
                break;
                
            case 4:
                String ruta = "";
                ruta = JOptionPane.showInputDialog("Ingrese la ruta del archivo");
                añadir.leer(arbol, ruta);  
        }
 
      
    }while(entrada != 5);
    JOptionPane.showMessageDialog(null,"Fin de la ejecucion.");
    
         }
         
}
         


        
     
         
 

