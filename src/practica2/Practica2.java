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

/**
 *
 * @author CompucenterPC1
 */
public class Practica2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {/* throws IOException {
        CargaTexto sisas = new CargaTexto();
        Persona ojo = new Persona();
        sisas.leer(ojo);
        System.out.println(ojo.getId()+ojo.getNombre()+ ojo.getPadre());
        
     
    
    }
         */
 /* ArbolNarioListaGeneralizada arbol = new ArbolNarioListaGeneralizada();
        System.out.println(arbol.nombreDios());*/
        ArbolNarioListaGeneralizada x = new ArbolNarioListaGeneralizada();
        Persona a = new Persona();
        a.setNombre("Pedro");a.setId("1");a.setPadre("");
        Persona b = new Persona();
        b.setNombre("Jose");b.setId("2");b.setPadre("Pedro");
        Persona c = new Persona();
        c.setNombre("Toño");c.setId("3");c.setPadre("");
        Persona d = new Persona();
        d.setNombre("Manuel");d.setId("4");d.setPadre("");
        x.addPersona(a);x.addPersona(b);x.addPersona(c);x.addPersona(d);
        System.out.println(x.imprimir());
   

    }
}
