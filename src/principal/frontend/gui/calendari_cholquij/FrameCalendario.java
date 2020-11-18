/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.frontend.gui.calendari_cholquij;

import javax.swing.JOptionPane;
import principal.backend.calendari_cholquij.calcular_fecha.CalcularFecha;
import principal.frontend.gui.calendari_cholquij.matriz.matrizCholquijFrame;

/**
 *
 * @author bryangmz
 */
public class FrameCalendario extends javax.swing.JFrame {

    private matrizCholquijFrame frame;
    
    /**
     * Creates new form FrameCalendario
     */
    public FrameCalendario() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        btnMatrizCalendario2 = new javax.swing.JButton();
        btnCalendarioLunar = new javax.swing.JButton();
        btnMatrizCalendario = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setBackground(new java.awt.Color(0, 0, 0));
        lblTitulo.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("CALENDARIO CHOLQ'IJ");
        getContentPane().add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 470, 70));

        btnMatrizCalendario2.setBackground(new java.awt.Color(51, 51, 51));
        btnMatrizCalendario2.setFont(new java.awt.Font("Waree", 1, 18)); // NOI18N
        btnMatrizCalendario2.setForeground(new java.awt.Color(204, 204, 204));
        btnMatrizCalendario2.setText("Nahual - Energia Cholq'ij");
        btnMatrizCalendario2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatrizCalendario2ActionPerformed(evt);
            }
        });
        getContentPane().add(btnMatrizCalendario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 290, -1));

        btnCalendarioLunar.setBackground(new java.awt.Color(51, 51, 51));
        btnCalendarioLunar.setFont(new java.awt.Font("Waree", 1, 18)); // NOI18N
        btnCalendarioLunar.setForeground(new java.awt.Color(204, 204, 204));
        btnCalendarioLunar.setText("Calcular Fecha Cholq'ij");
        btnCalendarioLunar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalendarioLunarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCalendarioLunar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 290, -1));

        btnMatrizCalendario.setBackground(new java.awt.Color(51, 51, 51));
        btnMatrizCalendario.setFont(new java.awt.Font("Waree", 1, 18)); // NOI18N
        btnMatrizCalendario.setForeground(new java.awt.Color(204, 204, 204));
        btnMatrizCalendario.setText("Informacion Cholq'ij");
        btnMatrizCalendario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatrizCalendarioActionPerformed(evt);
            }
        });
        getContentPane().add(btnMatrizCalendario, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 290, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/principal/frontend/gui/calendari_cholquij/Portada.png"))); // NOI18N
        jLabel1.setText(" ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 590));

        jMenuBar1.setBackground(new java.awt.Color(51, 51, 51));
        jMenuBar1.setForeground(new java.awt.Color(204, 204, 204));
        jMenuBar1.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N

        jMenu1.setBackground(new java.awt.Color(51, 51, 51));
        jMenu1.setForeground(new java.awt.Color(204, 204, 204));
        jMenu1.setText("Calendario Lunar");
        jMenu1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu3.setBackground(new java.awt.Color(51, 51, 51));
        jMenu3.setForeground(new java.awt.Color(204, 204, 204));
        jMenu3.setText("Cholq'ij");
        jMenu3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jMenu4.setText("Forma de Contar");
        jMenu4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
        });
        jMenu4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenu4);

        jMenu5.setText("Días");
        jMenu5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jMenu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu5MouseClicked(evt);
            }
        });
        jMenu3.add(jMenu5);

        jMenu6.setText("Calendario");
        jMenu6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jMenu6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu6MouseClicked(evt);
            }
        });
        jMenu3.add(jMenu6);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        // TODO add your handling code here:
        String mensaje = "Calendario Lunar"
                + "\nAl Cholq’ij también se le denomina calendario lunar y marca \n"
                + "nueve lunas llenas, período en el que se gesta un ser humano. \n"
                + "De acuerdo con la cosmovisión maya, la lectura de los signos\n"
                + "y numerales mayas descritos en este calendario espiritual y\n"
                + "material le permite al ajq’ij orientar la vida de \n"
                + "las personas, según su fecha de nacimiento; y también es \n"
                + "utilizado por la Iyom para programar el recibimiento de una\n"
                + "nueva criatura";
        JOptionPane.showMessageDialog(null, mensaje, "Calendario Lunar", JOptionPane.INFORMATION_MESSAGE, new javax.swing.ImageIcon(getClass().getResource("/principal/frontend/gui/calendari_cholquij/calendario-maya-lunar.png")));
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu4ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jMenu4ActionPerformed

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
        // TODO add your handling code here:
        String mensaje = "Forma de contar el Cholq’ij\n\n"
                + "Una manera de contar el Cholq’ij para los maya k’iche’ de la actualidad es iniciar el conteo\n"
                + "en Waqxaqib’ B’atz’ (8 B’atz’), repitiendo así cada 260 días ese número y fecha \n"
                + "(Aj Xol Ch’ok, 2008). Cada día del calendario se combina con un numeral que va del 1 al 13, \n"
                + "hasta completar 260 días. El mismo día en que inicia la cuenta vuelve a repetirse cada \n"
                + "260 días. En la antigüedad se acostumbraba a empezar el calendario en 1 Imox y se seguía el \n"
                + "mismo proceso de multiplicación de los numerales con los días para alcanzar el total de 260 \n"
                + "(Aj Xol Ch’ok, 2008). La construcción del ciclo de 260 días del calendario Cholq’ij tiene \n"
                + "como base la disciplina vigesimal maya (13X20); “esta relación organiza una frecuencia matemática \n"
                + "del movimiento natural lunar de 13:20 que se determina en base a las gravitaciones, \n"
                + "principalmente de la Luna–Tierra, las cualidades del ser en la madre Tierra de acuerdo a su \n"
                + "día de engendración, día del nacimiento y su proyección o misión en la vida” (García, Curruchiche \n"
                + "& Taquirá, 2009, p. 234). Los días de este calendario “son representados también en los 10 \n"
                + "dedos superiores de las manos, más los 10 dedos inferiores de los pies, lo que suma 20, que \n"
                + "representa los días del Cholq’ij”, pues la construcción matemática del sistema vigesimal \n"
                + "maya “se fundamenta en el Jun Winaq de 20 dedos”";
        JOptionPane.showMessageDialog(null, mensaje, "Formas de Contar", JOptionPane.INFORMATION_MESSAGE, new javax.swing.ImageIcon(getClass().getResource("/principal/frontend/gui/calendari_cholquij/300px-Cholq'ij.jpg")));
    }//GEN-LAST:event_jMenu4MouseClicked

    private void jMenu5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseClicked
        // TODO add your handling code here:
        String mensaje = "Días del Cholq’ij\n"
                + "En maya k’iche’, los veinte días del Cholq’ij reciben los siguientes \n"
                + "nombres: B’atz’, E, Aj, I’x, Tz’ikin, Ajmaq, No’j, Tijax, \n"
                + "Kawoq, Ajpu, Imox, Iq’, Aq’ab’al, K’at, Kan, Kame, Kej, Q’anil, \n"
                + "Toj, Tz’i’. Estos nombres corresponden al de los 20 nahuales o signos \n"
                + "de los días del calendario, los cuales simbolizan ciertas \n"
                + "particularidades que se asocian a las personas según la fecha de su \n"
                + "nacimiento (Barrios, 2004; León, 1999; Aj Xol Ch’ok, 2008; Rupflin, 1999).";
        JOptionPane.showMessageDialog(null, mensaje, "Dias del Calendario", JOptionPane.INFORMATION_MESSAGE, new javax.swing.ImageIcon(getClass().getResource("/principal/frontend/gui/calendari_cholquij/dias.jpg")));
    }//GEN-LAST:event_jMenu5MouseClicked

    private void jMenu6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu6MouseClicked
        // TODO add your handling code here:
        String mensaje = "Calendario Cholquij\n"
                + "El Cholq’ij (término maya kaqchikel) es un calendario sagrado \n"
                + "del pueblo Maya, compuesto por 260 días divididos en 13 meses\n"
                + "También recibe el nombre de calendario ritual o calendario \n"
                + "sagrado o Tzolkin";
        JOptionPane.showMessageDialog(null, mensaje, "Calendario", JOptionPane.INFORMATION_MESSAGE, new javax.swing.ImageIcon(getClass().getResource("/principal/frontend/gui/calendari_cholquij/Cholquij.jpg")));
    }//GEN-LAST:event_jMenu6MouseClicked

    private void btnCalendarioLunarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalendarioLunarActionPerformed
        // TODO add your handling code here:
        CalcularFecha calcularFecha = new CalcularFecha(this, true);
        calcularFecha.setVisible(true);
    }//GEN-LAST:event_btnCalendarioLunarActionPerformed

    private void btnMatrizCalendarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatrizCalendarioActionPerformed
        // TODO add your handling code here:
        matrizCholquijFrame cholquijFrame = new matrizCholquijFrame();
        cholquijFrame.setVisible(true);
    }//GEN-LAST:event_btnMatrizCalendarioActionPerformed

    private void btnMatrizCalendario2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatrizCalendario2ActionPerformed
        // TODO add your handling code here:
        CholqijFrame cholqijFrame = new CholqijFrame();
        cholqijFrame.setVisible(true);
    }//GEN-LAST:event_btnMatrizCalendario2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalendarioLunar;
    private javax.swing.JButton btnMatrizCalendario;
    private javax.swing.JButton btnMatrizCalendario2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
