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
public class Practica2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArbolNarioListaGeneralizada x = new ArbolNarioListaGeneralizada();

        Persona a = new Persona();
        a.setNombre("Pedro");
        a.setId("1");
        a.setPadre("");
        Persona b = new Persona();
        b.setNombre("Jose");
        b.setId("2");
        b.setPadre("");
        Persona c = new Persona();
        c.setNombre("Toño");
        c.setId("3");
        c.setPadre("");
        Persona d = new Persona();
        d.setNombre("Manuel");
        d.setId("4");
        d.setPadre("Pedro");
        Persona e = new Persona();
        e.setNombre("Pitter");
        e.setId("5");
        e.setPadre("Pedro");
        Persona f = new Persona();
        f.setNombre("Carlos");
        f.setId("6");
        f.setPadre("Jose");
        Persona g = new Persona();
        g.setNombre("Andres");
        g.setId("7");
        g.setPadre("Jose");
        Persona h = new Persona();
        h.setNombre("covid");
        h.setId("8");
        h.setPadre("Carlos");
        Persona i = new Persona();
        // i.setNombre("norman");i.setId("9");i.setPadre("Lula")
        x.addPersona(a);
        x.addPersona(b);
        x.addPersona(c);
        x.addPersona(d);
        x.addPersona(e);
        x.addPersona(f);
        x.addPersona(g);
        x.addPersona(h);
        x.addPersona(g);
        //System.out.println(x.imprimir());
        NodoNario w = new NodoNario(a);
        x.raiz = w;

        String probando = "a05,papa,cfueXcigarros";
        x.crearPersona(probando);

    }

}
