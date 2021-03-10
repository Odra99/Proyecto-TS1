
package api.login;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import modelos.database.UsuarioDb;
import modelos.objetos.Usuario;
import principal.menu.MenuPrincipal;


public class Login extends javax.swing.JFrame {

    private FondoPanel fondoPanel = new FondoPanel();
    private SingUp singUp = new SingUp(this);
    private UsuarioDb usuarioDb = new UsuarioDb();
    private MenuPrincipal menu;
    private ArchivoLogin archivoLogin = new ArchivoLogin();
    
    public Login() {
        this.setContentPane(fondoPanel);
        initComponents();
        this.setLocationRelativeTo(null);
        panelSesion.setBackground(new Color(255, 255, 255, 100));
        ImageIcon imIcon = new ImageIcon("src/api/login/imagenes/icono.png");
        Icon icono = new ImageIcon(imIcon.getImage().getScaledInstance(labelIcono.getWidth(), labelIcono.getHeight(), Image.SCALE_DEFAULT));
        labelIcono.setIcon(icono);
        ImageIcon imIconExit = new ImageIcon("src/api/login/imagenes/salir.png");
        Icon iconoExit = new ImageIcon(imIconExit.getImage().getScaledInstance(botonSalir.getWidth(), botonSalir.getHeight(), Image.SCALE_DEFAULT));
        botonSalir.setIcon(iconoExit);
    }
    //logue al usuario
    public void loguear(){
        Usuario usuario = usuarioDb.validacionUsuario(textFieldCorreo.getText(), passFieldContrasenia.getText());
        if(usuario!=null){
            System.out.println("Se logueo xD");
            recordarSesion(usuario);
            menu = new MenuPrincipal(usuario);
            menu.setVisible(true);
            this.setVisible(false);
        }else{
            System.out.println("NO Se logueo xD");
            JOptionPane.showMessageDialog(null, "El Correo o Contraseña son Incorrectos");
        }
    }
    
    private void recordarSesion(Usuario usuarioGuardar){
        if(checkBoxRecordar.isSelected()){
            archivoLogin.escribirArchivo(new UsuarioLogueo(usuarioGuardar.getEmail(), usuarioGuardar.getPassword()));
        }else{
            archivoLogin.escribirArchivo(null);
        }
    }

    private void verificarCampos(){
        if (!textFieldCorreo.getText().isEmpty() && !passFieldContrasenia.getText().isEmpty()){
            loguear();
        }else{
            JOptionPane.showMessageDialog(null, "Uno de los campos deben de ser LLenados\n(Todos los campos son obligatorios)*");
        }
    }
    
    public void iniciar(){
        archivoLogin.verificarExitenciaArchivo();
        UsuarioLogueo usuarioLogueo = archivoLogin.leerLogueo();
        
        if(usuarioLogueo!=null){
            Usuario usuario = usuarioDb.validacionUsuario(usuarioLogueo.getCorreo(), usuarioLogueo.getContrasenia());
            if(usuario!=null){
                System.out.println("Se logueo xD");
                menu = new MenuPrincipal(usuario);
                menu.setVisible(true);
                this.setVisible(false);
            }else{
                System.out.println("NO Se logueo xD");
                this.setVisible(true);
        }
        }else{
            this.setVisible(true);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new FondoPanel();
        botonSalir = new javax.swing.JButton();
        panelSesion = new javax.swing.JPanel();
        correo = new javax.swing.JLabel();
        textFieldCorreo = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        passFieldContrasenia = new javax.swing.JPasswordField();
        checkBoxRecordar = new javax.swing.JCheckBox();
        botonSingIn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        botonSingUp = new javax.swing.JButton();
        labelIcono = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        setResizable(false);

        botonSalir.setBackground(new java.awt.Color(255, 255, 255));
        botonSalir.setForeground(new java.awt.Color(255, 255, 255));
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirbuttonExitActionPerformed(evt);
            }
        });

        correo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        correo.setForeground(new java.awt.Color(255, 255, 255));
        correo.setText("Correo");

        textFieldCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldCorreojTextField2ActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Contraseña");

        passFieldContrasenia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                passFieldContraseniaKeyReleased(evt);
            }
        });

        checkBoxRecordar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        checkBoxRecordar.setForeground(new java.awt.Color(255, 255, 255));
        checkBoxRecordar.setText("Recordar Sesion");
        checkBoxRecordar.setOpaque(false);
        checkBoxRecordar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxRecordarActionPerformed(evt);
            }
        });

        botonSingIn.setBackground(new java.awt.Color(247, 228, 22));
        botonSingIn.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botonSingIn.setText("SING IN");
        botonSingIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSingInActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(247, 228, 22));

        botonSingUp.setBackground(new java.awt.Color(158, 247, 22));
        botonSingUp.setText("SING UP");
        botonSingUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSingUpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSesionLayout = new javax.swing.GroupLayout(panelSesion);
        panelSesion.setLayout(panelSesionLayout);
        panelSesionLayout.setHorizontalGroup(
            panelSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSesionLayout.createSequentialGroup()
                .addGroup(panelSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSesionLayout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(correo))
                    .addGroup(panelSesionLayout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(labelIcono, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelSesionLayout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(panelSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(panelSesionLayout.createSequentialGroup()
                                    .addComponent(checkBoxRecordar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                                    .addComponent(botonSingIn, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(textFieldCorreo, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(passFieldContrasenia, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(botonSingUp))))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        panelSesionLayout.setVerticalGroup(
            panelSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSesionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelIcono, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(correo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textFieldCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passFieldContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkBoxRecordar)
                    .addComponent(botonSingIn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonSingUp, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(panelSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(135, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addComponent(panelSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(panel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonSalirbuttonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirbuttonExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_botonSalirbuttonExitActionPerformed

    private void textFieldCorreojTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldCorreojTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldCorreojTextField2ActionPerformed

    private void checkBoxRecordarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxRecordarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkBoxRecordarActionPerformed

    private void passFieldContraseniaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passFieldContraseniaKeyReleased
        if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
            //LOGUEAR
            botonSingIn.doClick();
        }
    }//GEN-LAST:event_passFieldContraseniaKeyReleased

    private void botonSingUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSingUpActionPerformed
        singUp.limpiar();
        singUp.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_botonSingUpActionPerformed

    private void botonSingInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSingInActionPerformed
        verificarCampos();
    }//GEN-LAST:event_botonSingInActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonSalir;
    private javax.swing.JButton botonSingIn;
    private javax.swing.JButton botonSingUp;
    private javax.swing.JCheckBox checkBoxRecordar;
    private javax.swing.JLabel correo;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelIcono;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel panelSesion;
    private javax.swing.JPasswordField passFieldContrasenia;
    private javax.swing.JTextField textFieldCorreo;
    // End of variables declaration//GEN-END:variables
    
    class FondoPanel extends JPanel{
        
        private Image imagen;
        @Override
        public void paint(Graphics g){
            imagen = new ImageIcon(getClass().getResource("imagenes/tikal.jpg")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
    }
    
    
    
}
