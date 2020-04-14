package practica2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.HashMap;
//import java.util.LinkedList;
//import javax.swing.JOptionPane;

import javax.swing.*;

/**
 *
 * @author netosolis.com
 */
public class Frame extends javax.swing.JFrame {

    /**
     * Creates new form Frame
     */
    ArbolNarioListaGeneralizada ab = new ArbolNarioListaGeneralizada();
    private int radio = 15;
    private int espacioVertical = 50;
    private HashMap<NodoNario, Point> coordenadas;
    
    @Override
    public void paintComponents(Graphics g) {
        jPanel2.revalidate();
        super.paintComponents(g);
//        int X = (getWidth() / 5);
//        int X2 = (getWidth() / 12);
//        int Y = getHeight() / 12;
        pintaArbol(jPanel2.getGraphics(), ab.getRaiz(), jPanel2.getWidth() / 2, 30,jPanel2.getWidth() / 5 );

    }

    @SuppressWarnings("InfiniteRecursion")
    private void pintaArbol(Graphics g, NodoNario n, int x, int y, int espacioH) {
        Persona p = (Persona) n.getDato();
        g.setColor(Color.black);
        g.fillOval(x - radio, y - radio, 30, 30);
        g.setColor(Color.white);
        g.drawString(p.getId(), x, y);
        coordenadas.put(ab.getRaiz(), new Point(x, y));
        @SuppressWarnings("element-type-mismatch")
                
        Point punto = coordenadas.get(ab.getRaiz().getLiga());       
        //dibujarLinea(g, x - espacioH, y + espacioVertical, punto.x, punto.y);
        g.drawLine(x, y, x , y );
        NodoNario raiz=ab.getRaiz();
        int hijo=ab.numeroHijos(raiz);
        pintaArbol(g, n.getLiga(), x - espacioH, y + espacioVertical, espacioH / hijo);
        //x =x + espacioH;
       
    }
    private void dibujarLinea(Graphics g, int x1, int y1, int x2, int y2) {
        double d = Math.sqrt(espacioVertical * espacioVertical + (x2 - x1) * (x2 - x1));
        int xx1 = (int) (x1 - radio * (x1 - x2) / d);
        int yy1 = (int) (y1 - radio * (y1 - y2) / d);
        int xx2 = (int) (x2 + radio * (x1 - x2) / d);
        int yy2 = (int) (y2 + radio * (y1 - y2) / d);
        
        g.drawLine(xx1, yy1, xx2, yy2);
        
    }
    

    public Frame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        txDato = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        Buscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("NetoSolis.com");
        setResizable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1166, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 478, Short.MAX_VALUE)
        );

        txDato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txDatoActionPerformed(evt);
            }
        });

        jButton1.setText("Insertar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        Buscar.setText("Buscar Persona");
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txDato)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Buscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txDato, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txDatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txDatoActionPerformed

        try {
            String datos = txDato.getText();
            Persona p = ab.crearPersona(datos);
            ab.addPersona(p);
            paint(jPanel2.getGraphics());
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(this, "Error al Insertar el Dato");
        }
    }//GEN-LAST:event_txDatoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            String datos = txDato.getText();
            Persona p = ab.crearPersona(datos);
            ab.addPersona(p);
            paint(jPanel2.getGraphics());
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(this, "Error al Insertar el Dato");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
        try {
            String dato = JOptionPane.showInputDialog(this, "Dato a buscar");
            Persona p = null;
            p.setNombre(dato);
            NodoNario r = null;
            r.setDato(p);
            JOptionPane.showMessageDialog(this, ab.buscarNodo(r) ? "Si Existe el Dato" : "No Existe el dato");
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(this, "Error al buscar el dato");
        }

    }//GEN-LAST:event_BuscarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Buscar;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField txDato;
    // End of variables declaration//GEN-END:variables

     @Override
    public void paint(Graphics g) {
        jPanel2.revalidate();
        super.paint(g);
        int X = (getWidth() / 5) * 3;
        int X2 = (getWidth() / 12);
        int Y = getHeight() / 12;
        pintaArbol(jPanel2.getGraphics(), ab.getRaiz(), jPanel2.getWidth() / 2, Y, X2, Y);

    }

    private void pintaArbol(Graphics g, NodoNario n, int x, int y, int xoff, int yoff) {
        if (n == null) {
            return;
        }
        g.setColor(Color.black);
        if (n.getLiga() != null) {
            g.drawLine(x, y, x - xoff , y + yoff);
        }
        Persona p = (Persona) n.getDato();

        g.fillOval(x - 10, y - 20, 30, 30);
        g.setColor(Color.white);
        g.drawString(p.getId() + "", x, y);

        pintaArbol(g, n.getLiga(), (int) (x - xoff), (y + yoff), xoff , yoff);
        // pintaArbol(g, n.getDer(), (int)(x + xoff), (y + yoff),xoff-nivel*2,yoff,nivel+1);
    }

}
