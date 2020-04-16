/*
 * Copyright 2019 Carlos Alejandro Escobar Marulanda ealejandro101@gmail.com
 * Permission is hereby granted, free of charge, to any person 
 * obtaining a copy of this software and associated documentation 
 * files (the "Software"), to deal in the Software without 
 * restriction, including without limitation the rights to use, 
 * copy, modify, merge, publish, distribute, sublicense, and/or 
 * sell copies of the Software, and to permit persons to whom the 
 * Software is furnished to do so, subject to the following 
 * conditions:
 * The above copyright notice and this permission notice shall 
 * be included in all copies or substantial portions of the 
 * Software.
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, 
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES 
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND 
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 *  WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING 
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR 
 * OTHER DEALINGS IN THE SOFTWARE.
 */
package practica2;

import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Alejandro Escobar
 */
public class ArbolNarioListaGeneralizada {

    NodoNario raiz;
    NodoNario soport;
    
      // Constructor de la clase inicializa la variables Dios
    public ArbolNarioListaGeneralizada() {
        Persona pDios = new Persona();
        pDios.setNombre("Dios");
        pDios.setId("0");
        NodoNario Dios = new NodoNario(pDios);
        Dios.setSw(0);
        Dios.setLiga(null);
        raiz = Dios;
    }
    
      //metodo en el cua el primer nodo pasa a ser Dos
   /* public String nombreDios() {
        String nombre = "";
        Persona muñeco;
        NodoNario recorrer;
        recorrer = raiz;
        muñeco = (Persona) recorrer.getDato();
        nombre = muñeco.getNombre();
        return nombre;
    }*/
    
     // añade una persona con sw 0 y lo manda a addNodo
    public void addPersona(Persona a) {
        NodoNario Nodo = new NodoNario(a);
        Nodo.setSw(0);//SE AÑADE LA BANDERA DEL NODO INICIAL
        Nodo.setLiga(null);
        this.addNodo(Nodo);
    }
       //obtiene el dato del nodo que se le ingresa
    /*public void Obtenerdato(NodoNario a) {
        Persona sisas;
        sisas = (Persona) a.getDato();
    }*/
   //recorre el arbol y lo imprime
    public void imprime() {

    }

   

    public void addNodo(NodoNario persona) {
        if(nodoEsta(persona)){
            //System.out.println("Ya esta ");  
        }
        else{
        NodoNario recorrido = raiz;
        Persona pnodo = (Persona) persona.getDato();
        Persona pliga;
        Stack pila = new Stack();
//------------------------------------------------------------------------------
//primera persona
        if (recorrido.getLiga() == null) {
            recorrido.setLiga(persona);
        } //------------------------------------------------------------------------------
        //si no tiene padre preestablecido        
        else {
            if (pnodo.getPadre().equals("")) {
                while (recorrido.getLiga() != null) {
                    recorrido = recorrido.getLiga();
                }
                recorrido.setLiga(persona);
            } //------------------------------------------------------------------------------
            //si tiene padre o hay ramificacion
            else {
                int fin = 0;
                int cont = 0;

                while (recorrido.getLiga() != null) {
                    cont++;
                    recorrido = recorrido.getLiga();// avanzamos el la lista;
//------------------------------------------------------------------------------
//si encontro un padre y el padre no tiene mas hijos
                    if (recorrido.getSw() == 0) {
                        pliga = (Persona) recorrido.getDato();
                        if (pnodo.getPadre().equals(pliga.getNombre())) {
                            recorrido.setSw(1);
                            Persona pauxiliar = new Persona();
                            pauxiliar = pliga;
                            NodoNario auxiliar = new NodoNario(pauxiliar);
                            auxiliar.setLiga(null);
                            recorrido.setDato(auxiliar);
                            auxiliar.setLiga(persona);
                            fin = 1;
                            break;
                        }
                    }
//------------------------------------------------------------------------------
//si encontramos una ramificacion
                    if (recorrido.getSw() == 1) {
                        pila.add(recorrido);
                        recorrido = (NodoNario) recorrido.getDato();
                        pliga = (Persona) recorrido.getDato();

                        if (pnodo.getPadre().equals(pliga.getNombre())) {
                            while (recorrido.getLiga() != null) {
                                recorrido = recorrido.getLiga();
                            }
                            persona.setLiga(null);
                            recorrido.setLiga(persona);
                            fin = 1;
                        } else {
                                cont = 0;
                            
                        }
                    }
                
//------------------------------------------------------------------------------
//si despues dela primera ronde de apilar un nodo llegamos al final de recorrido
                if (recorrido.getLiga() == null && !pila.empty() && cont > 0) {
                    recorrido = (NodoNario) pila.pop();
                    while (recorrido.getLiga() == null && !pila.empty()) {
                        recorrido = (NodoNario) pila.pop();
                    }
                }
            }

//------------------------------------------------------------------------------
//Si luego del recorrido no se encontro el padre 
                if (fin == 0) {
                    recorrido = raiz;
                    while (recorrido.getLiga() != null) {
                        recorrido = recorrido.getLiga();
                    }
                    recorrido.setLiga(persona);
                    recorrido = recorrido.getLiga();
                    recorrido.setLiga(null);
                }
            }
        }

    }
        
    }
    
   

    public boolean nodoEsta(NodoNario persona) {
        
        NodoNario recorrido = raiz;
        Persona pnodo = (Persona) persona.getDato();
        Persona pliga;
        Stack pila = new Stack();
        boolean encontrar = false;
//------------------------------------------------------------------------------
//primera persona
        if (recorrido.getLiga() == null) {
            encontrar = false;
        }      
        else {
//------------------------------------------------------------------------------
//inicie a recorrer la lista            
                int fin = 0;
                int cont = 0;

                while (recorrido.getLiga() != null) {
                    cont++;
                    recorrido = recorrido.getLiga();// avanzamos el la lista;
//------------------------------------------------------------------------------
//si encontro un padre y el padre no tiene mas hijos
                    if (recorrido.getSw() == 0) {
                        pliga = (Persona) recorrido.getDato();
                        if (pnodo.getNombre().equals(pliga.getNombre())) {
                            encontrar = true;
                            fin = 1;
                            break;
                        }
                    }
//------------------------------------------------------------------------------
//si encontramos una ramificacion
                    if (recorrido.getSw() == 1) {
                        pila.add(recorrido);
                        recorrido = (NodoNario) recorrido.getDato();
                        pliga = (Persona) recorrido.getDato();

                        if (pnodo.getNombre().equals(pliga.getNombre())) {
                            encontrar = true;
                            fin = 1;
                            
                        } else {
                                cont = 0;
                            
                        }
                    }
                
//------------------------------------------------------------------------------
//si despues dela primera ronde de apilar un nodo llegamos al final de recorrido
                if (recorrido.getLiga() == null && !pila.empty() && cont > 0) {
                    recorrido = (NodoNario) pila.pop();
                    while (recorrido.getLiga() == null && !pila.empty()) {
                        recorrido = (NodoNario) pila.pop();
                    }
                }
            }

//------------------------------------------------------------------------------
//Si luego del recorrido no se encontro el padre 
                if (fin == 0) {
                    encontrar = false;
                    }

                }
   
    return encontrar;   
    
    }
    
//  ------------------------------------------------------------------------------
//  ------------------------------------------------------------------------------  
        public StringBuilder BuscarId(String id) {
        
        NodoNario recorrido = raiz;
        Persona pliga;
        Stack pila = new Stack();
            StringBuilder encontrar = new StringBuilder();
//------------------------------------------------------------------------------
//primera persona
        if (recorrido.getLiga() == null) {
            encontrar.append("No se encontro ningun registro cod el id : ").append(id);
        }      
        else {
//------------------------------------------------------------------------------
//inicie a recorrer la lista            
                int fin = 0;
                int cont = 0;

                while (recorrido.getLiga() != null) {
                    cont++;
                    recorrido = recorrido.getLiga();// avanzamos el la lista;
//------------------------------------------------------------------------------
//si encontro un padre y el padre no tiene mas hijos
                    if (recorrido.getSw() == 0) {
                        pliga = (Persona) recorrido.getDato();
                        if (id.equals(pliga.getId())) {
                            encontrar.append("Nombre: ").append(pliga.getNombre()).append("\n");
                            encontrar.append("ID: ").append(pliga.getId()).append("\n");
                            encontrar.append("Padre: ").append(pliga.getPadre()).append("\n");
                            fin = 1;
                            break;
                        }
                    }
//------------------------------------------------------------------------------
//si encontramos una ramificacion
                    if (recorrido.getSw() == 1) {
                        pila.add(recorrido);
                        recorrido = (NodoNario) recorrido.getDato();
                        pliga = (Persona) recorrido.getDato();

                        if (id.equals(pliga.getId())) {
                            encontrar.append("Nombre: ").append(pliga.getNombre()).append("\n");
                            encontrar.append("ID: ").append(pliga.getId()).append("\n");
                            encontrar.append("Padre: ").append(pliga.getPadre()).append("\n");
                            fin = 1;
                            
                        } else {
                                cont = 0;
                            
                        }
                    }
                
//------------------------------------------------------------------------------
//si despues dela primera ronde de apilar un nodo llegamos al final de recorrido
                if (recorrido.getLiga() == null && !pila.empty() && cont > 0) {
                    recorrido = (NodoNario) pila.pop();
                    while (recorrido.getLiga() == null && !pila.empty()) {
                        recorrido = (NodoNario) pila.pop();
                    }
                }
            }

//------------------------------------------------------------------------------
//Si luego del recorrido no se encontro el padre 
                if (fin == 0) {
                   encontrar.append("No se encontro ningun registro cod el id : ").append(id);
                    }

                }
   
    return encontrar; 
}

//--------------------------------------------------------------------------------
//--------------------------------------------------------------------------------        
        
        public StringBuilder Imprimir() {
        
        NodoNario recorrido = raiz;
        NodoNario aux;
        Persona pliga;
        Stack pila = new Stack();
            StringBuilder arbol = new StringBuilder();
            arbol.append("(").append("Dios");
//------------------------------------------------------------------------------
//primera persona
        if (recorrido.getLiga() == null) {
            arbol.append("No se encontro ningun registro ");
        }      
        else {
//------------------------------------------------------------------------------
//inicie a recorrer la lista            
                int cont = 0;//evita que se desapile inmediatamente al apilarse

                while (recorrido.getLiga() != null) {
                    cont++;
                    recorrido = recorrido.getLiga();// avanzamos el la lista;
//------------------------------------------------------------------------------
//si encontro un padre y el padre no tiene mas hijos
                    if (recorrido.getSw() == 0) {
                        pliga = (Persona) recorrido.getDato();//-> extrae la persona del nodo recorrido
                            arbol.append(pliga.getNombre());//->lleva el nombre a un String Builder
                            if(recorrido.getLiga()!= null){//->condicionamos que si no hay mas nodos no hay comas
                                aux = recorrido.getLiga();
                                if(aux.getSw()!= 1 ){//->condicionamos que si encontramos un padre no hay comas
                                    arbol.append(",");//-> Se imprime la coma
                                }
                                
                            }
                        
                    }
//------------------------------------------------------------------------------
//si encontramos una ramificacion
                    if (recorrido.getSw() == 1) {
                        pila.add(recorrido);//-> Se añade una miga 
                        recorrido = (NodoNario) recorrido.getDato();//-> Sa avanza por la liga del dato
                        pliga = (Persona) recorrido.getDato();//-> Se carga la informacion del nodo padre
                        arbol.append("(");
                            arbol.append(pliga.getNombre());
                            aux = recorrido.getLiga();
                            if(aux.getSw()!= 1 ){
                                arbol.append(",");
                            }
                            cont = 0;

                    }
                
//------------------------------------------------------------------------------
//si despues dela primera ronde de apilar un nodo llegamos al final de recorrido
                if (recorrido.getLiga() == null && !pila.empty() && cont > 0) {
                    arbol.append(")");
                    recorrido = (NodoNario) pila.pop();
                    while (recorrido.getLiga() == null && !pila.empty()) {
                        recorrido = (NodoNario) pila.pop();
                        
                    }
                }
            }

//------------------------------------------------------------------------------
//Si luego del recorrido no se encontro el padre 

                }
   arbol.append(")");
    return arbol; 
}
    

}   

