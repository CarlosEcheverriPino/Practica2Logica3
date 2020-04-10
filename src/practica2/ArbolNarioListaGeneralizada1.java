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
public class ArbolNarioListaGeneralizada1 {

    NodoNario raiz;
    final static boolean TRANSFORMAR = true;
    final static boolean NOTRANSFORMAR = false;

    private ArbolNarioListaGeneralizada1(NodoNario raiz) {
        this.raiz = raiz;
    }

    public ArbolNarioListaGeneralizada1(Persona h) {

        //Stack migas = new Stack();
        //NodoNario ultimo = new NodoNario();
        NodoNario primero = new NodoNario();
        NodoNario nodoX;

        if (raiz == null) {
            primero = new NodoNario(h);
//            ultimo = primero;
            raiz = primero;
        } else if (h.getPadre() == null) {
            raiz.setSw(1);
            nodoX = new NodoNario(h);
            while (primero.getLiga() != null) {
                primero = primero.getLiga();
            }
            primero.setLiga(nodoX);
        } else if (h.getPadre() != null) {
            NodoNario nodoPadre = buscar(h.getPadre());
            nodoPadre.setSw(1);
            nodoX = new NodoNario(h);
            if (nodoPadre.getDato() != null) {

                while (nodoPadre.getLiga() != null) {
                    nodoPadre = nodoPadre.getLiga();
                }
                nodoPadre.setLiga(nodoX);
//                ultimo=nodoX;
            }
        }

    }
    

    private NodoNario buscar(String identificacion) {

        Stack<NodoNario> migas = new Stack();

        NodoNario recorrido = raiz;
        Persona idNodo = (Persona) recorrido.getDato();
        

        while (!idNodo.getPadre().equals(identificacion)) {
            if (recorrido.getSw() == 0) {
                recorrido = recorrido.getLiga();
            }else{
                migas.add(recorrido);
            }
        }

        return null;
    }

    public NodoNario getRaiz() {
        return raiz;
    }

}
