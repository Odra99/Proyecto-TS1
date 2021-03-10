/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.login;

import java.awt.Graphics;
import java.awt.Image;
import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import modelos.database.RolDb;
import modelos.database.UsuarioDb;
import modelos.objetos.Rol;
import modelos.objetos.Usuario;

/**
 *
 * @author LENOVO-PC
 */
public class SingUp extends javax.swing.JFrame {

    private FondoPanel fondoPanel = new FondoPanel();
    private Login login;
    private LinkedList<Rol> listaRoles = new LinkedList<>();
    private UsuarioDb usuarioDb = new UsuarioDb();
    
    public SingUp(Login login) {
        this.login = login;
        this.setContentPane(fondoPanel);
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    private void verificarDatosCorrectos(){
        
        
        if(verificarCampos()){
            if (isContraseniaIgual()) {
                Date fecha = new Date(dateChoserFecha.getDate().getYear(), dateChoserFecha.getDate().getMonth(), dateChoserFecha.getDate().getDay());
                //Aquie se enviaria los datos del Usuario para ser Registrado
                Usuario usuarioNuevo = new Usuario(textFieldUserName.getText(),
                                                    textFieldContrasenia.getText(),
                                                    textFieldCorreo.getText(),
                                                    textFieldNombre.getText(),
                                                    textFieldApellido.getText(),
                                                    textFieldTelefono.getText(),
                                                    fecha,
                                                    2);
                //Aqui irian los metodos o lo que sea para registrar
                //se enviaria este -> usuarioNuevo,
                usuarioDb.crearUsuario(usuarioNuevo);
                
                
            }else{
                JOptionPane.showMessageDialog(null, "Las contraseñas no COINCIDEN");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Todos los campos deben de ser LLenados\n(Todos los campos son obligatorios)*");
        }
    }
    //limpia cada uno de los campos
    public void limpiar(){
        textFieldNombre.setText("");
        textFieldApellido.setText("");
        textFieldCorreo.setText("");
        textFieldUserName.setText("");
        textFieldConfirme.setText("");
        textFieldContrasenia.setText("");
        dateChoserFecha.setDate(null);
        
    }
    
    //este se encargar de ver si estan llenos los campos y si no correctos
    private boolean verificarCampos(){
        boolean datosLlenos = (!textFieldNombre.getText().isEmpty() && !textFieldNombre.getText().equals("")) && 
                                (!textFieldApellido.getText().isEmpty() && !textFieldApellido.getText().equals("")) &&
                                (!textFieldCorreo.getText().isEmpty() && !textFieldCorreo.getText().equals("")) &&
                                (!textFieldUserName.getText().isEmpty() && !textFieldUserName.getText().equals("")) &&
                                (!textFieldContrasenia.getText().isEmpty() && !textFieldContrasenia.getText().equals("")) &&
                                (!textFieldConfirme.getText().isEmpty() && !textFieldConfirme.getText().equals("")) &&
                                (dateChoserFecha.getDate()!=null && !dateChoserFecha.getDate().equals("")) &&
                                (!textFieldTelefono.getText().isEmpty() && !textFieldTelefono.getText().equals(""));
        if(datosLlenos)
            return true;
        
        return false;
    }
    //verifica que ambas contrasenias sean iguales
    private boolean isContraseniaIgual(){
        String contrasenia1 = textFieldContrasenia.getText();
        String contrasenia2 = textFieldConfirme.getText();
        if(contrasenia1.equals(contrasenia2))
            return true;
        
        return false;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        botonRegresar = new javax.swing.JButton();
        labelNombre = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        labelUserName = new javax.swing.JLabel();
        labelContreseña = new javax.swing.JLabel();
        labelConfirmar = new javax.swing.JLabel();
        labelFecha = new javax.swing.JLabel();
        labelTelefono = new javax.swing.JLabel();
        dateChoserFecha = new com.toedter.calendar.JDateChooser();
        textFieldNombre = new javax.swing.JTextField();
        textFieldApellido = new javax.swing.JTextField();
        textFieldUserName = new javax.swing.JTextField();
        textFieldCorreo = new javax.swing.JTextField();
        textFieldTelefono = new javax.swing.JTextField();
        textFieldContrasenia = new javax.swing.JPasswordField();
        textFieldConfirme = new javax.swing.JPasswordField();
        botonRegistrarse = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Registrarse");
        jLabel1.setOpaque(true);

        botonRegresar.setBackground(new java.awt.Color(0, 204, 204));
        botonRegresar.setForeground(new java.awt.Color(0, 0, 0));
        botonRegresar.setText("Regresar");
        botonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegresarbuttonExitActionPerformed(evt);
            }
        });

        labelNombre.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        labelNombre.setForeground(new java.awt.Color(153, 0, 0));
        labelNombre.setText("Nombre: ");
        labelNombre.setOpaque(true);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 0, 0));
        jLabel3.setText("Apellidos:");
        jLabel3.setOpaque(true);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 0, 0));
        jLabel4.setText("correo:");
        jLabel4.setOpaque(true);

        labelUserName.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        labelUserName.setForeground(new java.awt.Color(153, 0, 0));
        labelUserName.setText("UserName: ");
        labelUserName.setOpaque(true);

        labelContreseña.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        labelContreseña.setForeground(new java.awt.Color(153, 0, 0));
        labelContreseña.setText("Contraseña:");
        labelContreseña.setOpaque(true);

        labelConfirmar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        labelConfirmar.setForeground(new java.awt.Color(153, 0, 0));
        labelConfirmar.setText("Confirme Contraseña:");
        labelConfirmar.setOpaque(true);

        labelFecha.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        labelFecha.setForeground(new java.awt.Color(153, 0, 0));
        labelFecha.setText("Fecha Nacimiento:");
        labelFecha.setOpaque(true);

        labelTelefono.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        labelTelefono.setForeground(new java.awt.Color(153, 0, 0));
        labelTelefono.setText("Telefono:");
        labelTelefono.setOpaque(true);

        textFieldCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldCorreoActionPerformed(evt);
            }
        });

        botonRegistrarse.setBackground(new java.awt.Color(255, 255, 0));
        botonRegistrarse.setForeground(new java.awt.Color(0, 0, 204));
        botonRegistrarse.setText("Registrarse");
        botonRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(202, 202, 202))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(botonRegresar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(botonRegistrarse, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textFieldApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                            .addComponent(textFieldCorreo)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(labelNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textFieldNombre))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelContreseña)
                            .addComponent(labelConfirmar)
                            .addComponent(labelUserName)
                            .addComponent(labelFecha))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dateChoserFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textFieldConfirme, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textFieldContrasenia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                                    .addComponent(textFieldUserName, javax.swing.GroupLayout.Alignment.TRAILING)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(labelTelefono)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textFieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNombre)
                    .addComponent(textFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textFieldApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textFieldCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelUserName)
                    .addComponent(textFieldUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelContreseña)
                    .addComponent(textFieldContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelConfirmar)
                    .addComponent(textFieldConfirme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelFecha)
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(dateChoserFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTelefono))
                .addGap(62, 62, 62)
                .addComponent(botonRegistrarse)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                .addComponent(botonRegresar)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonRegresarbuttonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarbuttonExitActionPerformed
        login.setVisible(true);
        limpiar();
        this.setVisible(false);
    }//GEN-LAST:event_botonRegresarbuttonExitActionPerformed

    private void textFieldCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldCorreoActionPerformed

    private void botonRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarseActionPerformed
        verificarDatosCorrectos();
    }//GEN-LAST:event_botonRegistrarseActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonRegistrarse;
    private javax.swing.JButton botonRegresar;
    private com.toedter.calendar.JDateChooser dateChoserFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelConfirmar;
    private javax.swing.JLabel labelContreseña;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelTelefono;
    private javax.swing.JLabel labelUserName;
    private javax.swing.JTextField textFieldApellido;
    private javax.swing.JPasswordField textFieldConfirme;
    private javax.swing.JPasswordField textFieldContrasenia;
    private javax.swing.JTextField textFieldCorreo;
    private javax.swing.JTextField textFieldNombre;
    private javax.swing.JTextField textFieldTelefono;
    private javax.swing.JTextField textFieldUserName;
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
