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

/**
 *
 * @author Alejandro Escobar
 */
public class ArbolNarioListaGeneralizada {

    NodoNario raiz;
    NodoNario soport;

    public ArbolNarioListaGeneralizada() {
        Persona pDios = new Persona();
        pDios.setNombre("Dios");
        pDios.setId("0");
        NodoNario Dios = new NodoNario(pDios);
        Dios.setSw(0);
        Dios.setLiga(null);
        raiz = Dios;
    }

    public String nombreDios() {
        String nombre = "";
        Persona muñeco;
        NodoNario recorrer;
        recorrer = raiz;
        muñeco = (Persona) recorrer.getDato();
        nombre = muñeco.getNombre();
        return nombre;
    }

    public void addPersona(Persona a) {
        NodoNario Nodo = new NodoNario(a);
        Nodo.setSw(0);//SE AÑADE LA BANDERA DEL NODO INICIAL
        Nodo.setLiga(null);
        this.addNodo(Nodo);
    }

    public void Obtenerdato(NodoNario a) {
        Persona sisas;
        sisas = (Persona) a.getDato();
    }

    public void imprime() {
        NodoNario recorrido = raiz;
        Persona mostrar;

        while (recorrido.getDato() != null && recorrido.getLiga() != null) {

            mostrar = (Persona) recorrido.getDato();
            System.out.println("Nombre: " + mostrar.getNombre() + "\nId: " + mostrar.getId() + "\nPadre: " + mostrar.getPadre());
            recorrido = recorrido.getLiga();
        }
    }

    public StringBuilder imprimir() {
        StringBuilder data = new StringBuilder();
        NodoNario recorrer;
        recorrer = raiz;
        Persona muñeco;
        muñeco = (Persona) recorrer.getDato();
        data.append("(").append(muñeco.getNombre()).append(",").append(muñeco.getId()).append(",").append(muñeco.getPadre())
                .append(",").append(recorrer.getSw()).append(")");
        while (recorrer.getLiga() != null) {
            recorrer = recorrer.getLiga();
            if (recorrer.getSw() == 0) {
                muñeco = (Persona) recorrer.getDato();
                data.append("(").append(muñeco.getNombre()).append(",").append(muñeco.getId()).append(",").append(muñeco.getPadre())
                        .append(",").append(recorrer.getSw()).append(")");
            } else {
                data.append("(");
                NodoNario aux;
                aux = recorrer;
                aux = (NodoNario) recorrer.getDato();
                muñeco = (Persona) aux.getDato();
                data.append("(").append(muñeco.getNombre()).append(",").append(muñeco.getId()).append(",").append(muñeco.getPadre())
                        .append(",").append(aux.getSw()).append(")");
                aux = aux.getLiga();
                muñeco = (Persona) aux.getDato();
                data.append("(").append(muñeco.getNombre()).append(",").append(muñeco.getId()).append(",").append(muñeco.getPadre())
                        .append(",").append(aux.getSw()).append(")");
                aux = aux.getLiga();
                data.append(")");

            }

        }
        return data;
    }

    public void addNodo(NodoNario persona) {
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
                    System.out.println("volvio a entrar");
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
