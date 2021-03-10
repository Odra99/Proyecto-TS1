package principal.frontend.gui.calendari_cholquij;

import principal.backend.calendari_cholquij.matriz.ManejadorDeCalendarioCholqij;
import principal.backend.calendari_cholquij.matriz.elementos.KinCholqij;


/**
 *
 * @author jesfrin
 */
public class CholqijFrame extends javax.swing.JFrame {

    private ManejadorDeCalendarioCholqij manejador;

    public CholqijFrame() {
        initComponents();
        this.manejador = new ManejadorDeCalendarioCholqij();
        this.infoTextArea.setText(contarTexto(""
                + "Imox significa la esencia de nuestra conciencia\n "
                + "y de nuestra mente. Imox es el lado izquierdo, la \n"
                + "parte sutil del ser humano. Imox es la sensibilidad,\n"
                + "lo inusual y lo excéntrico."));
        this.setLocationRelativeTo(null);
        

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        energiaLabel = new javax.swing.JLabel();
        anteriorButton = new javax.swing.JButton();
        siguienteButton = new javax.swing.JButton();
        nahualLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        infoTextArea = new javax.swing.JTextArea();
        lblTitulo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        energiaLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenesNumerosMayas/numero1.jpg"))); // NOI18N

        anteriorButton.setBackground(new java.awt.Color(102, 102, 102));
        anteriorButton.setFont(new java.awt.Font("Liberation Mono", 2, 18)); // NOI18N
        anteriorButton.setForeground(new java.awt.Color(255, 51, 0));
        anteriorButton.setText("<");
        anteriorButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        anteriorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anteriorButtonActionPerformed(evt);
            }
        });

        siguienteButton.setBackground(new java.awt.Color(102, 102, 102));
        siguienteButton.setFont(new java.awt.Font("Liberation Mono", 2, 18)); // NOI18N
        siguienteButton.setForeground(new java.awt.Color(255, 51, 0));
        siguienteButton.setText(">");
        siguienteButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        siguienteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siguienteButtonActionPerformed(evt);
            }
        });

        nahualLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenesNahualesMayas/Nahual1.jpg"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Liberation Mono", 1, 18)); // NOI18N
        jLabel1.setText("Energia");

        jLabel2.setFont(new java.awt.Font("Liberation Mono", 1, 18)); // NOI18N
        jLabel2.setText("Nahual");

        infoTextArea.setEditable(false);
        infoTextArea.setBackground(new java.awt.Color(102, 102, 102));
        infoTextArea.setColumns(20);
        infoTextArea.setForeground(new java.awt.Color(0, 0, 0));
        infoTextArea.setRows(5);
        jScrollPane1.setViewportView(infoTextArea);

        lblTitulo.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        lblTitulo.setText("NAHUAL");

        jLabel3.setFont(new java.awt.Font("Liberation Mono", 1, 18)); // NOI18N
        jLabel3.setText("Informacion");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(nahualLabel)
                        .addGap(16, 16, 16))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(anteriorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(siguienteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(energiaLabel)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jLabel2)))
                        .addGap(17, 17, 17)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(143, 143, 143))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(169, 169, 169)
                .addComponent(lblTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(nahualLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(energiaLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(anteriorButton)
                            .addComponent(siguienteButton)))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void siguienteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguienteButtonActionPerformed
        KinCholqij dia = this.manejador.verDiaSiguiente();
        cambioDeDia(dia);
    }//GEN-LAST:event_siguienteButtonActionPerformed

    private void anteriorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteriorButtonActionPerformed
        KinCholqij dia = this.manejador.verDiaAnterior();
        cambioDeDia(dia);
    }//GEN-LAST:event_anteriorButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton anteriorButton;
    private javax.swing.JLabel energiaLabel;
    private javax.swing.JTextArea infoTextArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel nahualLabel;
    private javax.swing.JButton siguienteButton;
    // End of variables declaration//GEN-END:variables

    private void cambioDeDia(KinCholqij dia) {
        energiaLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(dia.getEnergia().getDireccionDeImagen()))); // NOI18N
        nahualLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(dia.getNahual().getDireccionDeImagen()))); // NOI18N
        this.infoTextArea.setText(contarTexto(dia.getNahual().getDescripcion()));
    }
    
    private String contarTexto(String text){
        String retornar;
        String[] split = text.split(" ");
        if (split.length > 2) {
            retornar = split[0] + "\n\n";
            if (split[1].equalsIgnoreCase("significa")) {
                retornar += "Significa ";
            } else if (split[1].equalsIgnoreCase("simboliza")) {
                retornar += "Simboliza ";
            } else {
                retornar += split[1];
            }
            int contador = 0;
            String cadena;
            for (int i = 2; i < split.length; i++) {
                cadena = split[i].replaceAll("\n", "");
                cadena = cadena.replaceAll(" ", "");
                if (contador == 6) {
                    retornar += cadena + "\n";
                    contador = 0;
                } else{
                    retornar += cadena + " ";
                    contador++;
                }
            } return retornar;
        } return "";
        
    }

}
