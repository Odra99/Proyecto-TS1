
package gui.infonahuales;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import modelos.database.ConexionDb;
import modelos.database.NahualDb;
import modelos.objetos.Nahual;
import principal.backend.calendari_cholquij.calcular_fecha.CalcularFecha;

public class VentanaInfoNahuales extends javax.swing.JFrame {
    
    //ManejadorNahualGUI manejadorNahualGUI = new ManejadorNahualGUI();
    private NahualDb nahualDb = new NahualDb();
    private ArrayList<Nahual> listaNahuales = null;
    private ConexionDb conexionDb = new ConexionDb();
    private int indice = 0;
    private JTextPane textPaneSig = new JTextPane();
    private JTextPane textPaneDes = new JTextPane();
    private JLabel labelDescripcion = new JLabel("Descripcion");
    
    private FondoPanel fondoPanel = new FondoPanel();
    
    public VentanaInfoNahuales() {
        this.setContentPane(fondoPanel);
        initComponents();
        this.setLocationRelativeTo(null);
        
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(null);
        //scrollPane.setBackground(new Color(255, 255, 255, 100));
        //panelInfo.setBackground(new Color(255, 255, 255, 100));
        textPaneSig.setEditable(false);
        textPaneDes.setEditable(false);
        labelDescripcion.setFont(labelSignificado.getFont());
        labelDescripcion.setBackground(labelSignificado.getBackground());
        labelDescripcion.setForeground(labelSignificado.getForeground());
        
//        textPaneSig.setBackground(new Color(255, 255, 255, 100));
        //textPaneSig.setOpaque(false);
        
        panelInfo.add(textPaneSig);
        panelInfo.add(labelDescripcion);
        panelInfo.add(textPaneDes);
        
        ImageIcon imIconAnterior = new ImageIcon("./src/gui/imagenes/anterior.png");
        Icon iconoAnterior = new ImageIcon(imIconAnterior.getImage().getScaledInstance(botonAnterior.getWidth(), botonAnterior.getHeight(), Image.SCALE_DEFAULT));
        botonAnterior.setIcon(iconoAnterior);
        ImageIcon imIconSiguiente = new ImageIcon("./src/gui/imagenes/siguiente.png");
        Icon iconoSiguiente = new ImageIcon(imIconSiguiente.getImage().getScaledInstance(botonSiguiente.getWidth(), botonSiguiente.getHeight(), Image.SCALE_DEFAULT));
        botonSiguiente.setIcon(iconoSiguiente);
        
        //Levantamos el listado de nahuales en la db y lo agragamos y lista ya estaria fucionando al 100
        listaNahuales = (ArrayList<Nahual>) nahualDb.getNahuales();
        pintar();
        setPosiciones();
    }
    public void setPosiciones(){
        
        textPaneSig.setBounds(labelSignificado.getX(), labelSignificado.getHeight()+labelSignificado.getY()+2, panelInfo.getWidth()-40, calcularFilas(textPaneSig.getText())*25);
        labelDescripcion.setBounds(labelSignificado.getX(), labelSignificado.getHeight()+textPaneSig.getHeight()+20, labelSignificado.getWidth()+10, labelSignificado.getHeight());
        textPaneDes.setBounds(labelDescripcion.getX(), labelSignificado.getHeight()+textPaneSig.getHeight()+labelDescripcion.getHeight()+25, panelInfo.getWidth()-40, calcularFilas(textPaneDes.getText())*25);
        
//        int lineas = textPaneSig.set
        //String texto = textPaneDes.getText();
        //System.out.println("Tamanio: "+texto.length());
        //System.out.println("TamanioM: "+texto.substring(0, 143));
        
        //scrollPane.repaint();
        panelInfo.repaint();
        panelInfo.updateUI();
        //scrollPane.repaint();
        
        //System.out.println(texto);
    }
    
    private boolean verificarNahuales(){
        if(listaNahuales!=null && listaNahuales.size()>2){
            return true;
        }
        return false;
    }
    
    public int calcularFilas(String texto){
        int total = (int) texto.length()/143;
        if(total>0){
            total += 1;
            return total;
        }
        
        return 1;
    }
    
    private Icon getIconNahual(Nahual nahual, JLabel label){
        ImageIcon imIcon = new ImageIcon(nahual.getImagen().getDirEscritorio());
        Icon icono = new ImageIcon(imIcon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
        return icono;
    }
    
    public void pintarNahuales(){
        if(indice == 0){
            labalIzquierda.setIcon(getIconNahual(listaNahuales.get(listaNahuales.size()-1), labalIzquierda));
            labelPrincipal.setIcon(getIconNahual(listaNahuales.get(indice), labelPrincipal));
            labelDerecha.setIcon(getIconNahual(listaNahuales.get(indice+1), labelDerecha));
        }else if(indice == listaNahuales.size()-1){
            labalIzquierda.setIcon(getIconNahual(listaNahuales.get(indice-1), labalIzquierda));
            labelPrincipal.setIcon(getIconNahual(listaNahuales.get(indice), labelPrincipal));
            labelDerecha.setIcon(getIconNahual(listaNahuales.get(0), labelDerecha));
        }else{
            labalIzquierda.setIcon(getIconNahual(listaNahuales.get(indice-1), labalIzquierda));
            labelPrincipal.setIcon(getIconNahual(listaNahuales.get(indice), labelPrincipal));
            labelDerecha.setIcon(getIconNahual(listaNahuales.get(indice+1), labelDerecha));
        }
        textPaneDes.setText(listaNahuales.get(indice).getDescripcion());
        textPaneSig.setText(listaNahuales.get(indice).getSignificado());
        labelNombre.setText(listaNahuales.get(indice).getId()+". "+listaNahuales.get(indice).getNombre());
    }
    private void pintar(){
        if(verificarNahuales()){
            pintarNahuales();
            
        }
    }
    
    private void anterior(){
        if(indice==0)
            indice = listaNahuales.size()-1;
        else
            indice--;
    }
    private void siguiente(){
        if(indice==(listaNahuales.size()-1))
            indice = 0;
        else
            indice++;
    }
    
    
    public int nahual(int cont){
        //System.out.println("Contador " + cont);
        int contador = cont;
        int contadorNahual = 6;
        if (contador < 0) {
            while (contador != 0) {
                if (contadorNahual == 20) {
                    contadorNahual = 1;
                } else {
                    contadorNahual++;
                } contador++;
            } return contadorNahual;
        }
        while (contador != 0) {
            if (contadorNahual == 1) {
                contadorNahual = 20;
            } else {
                contadorNahual--;
            } contador--;
        } return contadorNahual;
        
    }
    
    
    private void calcularFecha(){
        int numNahual = nahual(timeCholqij(date.getCalendar().getTime().getTime()));
        indice = numNahual;
        pintarNahuales();
        setPosiciones();
    }
    
    public int timeCholqij(long date){
        try {
            String string = "Nov 15, 2020 00:00:00 AM";
            SimpleDateFormat sdf = new SimpleDateFormat("MMM d, yyyy h:mm:ss a", Locale.ROOT);
            Date datePivote = sdf.parse(string);
//            System.out.println("DATE PIVOTE " + datePivote);
            long regresar = TimeUnit.DAYS.convert(datePivote.getTime() - date, TimeUnit.MILLISECONDS);
            return (int) regresar;
        } catch (ParseException ex) {
            Logger.getLogger(CalcularFecha.class.getName()).log(Level.SEVERE, null, ex);
        } return 1;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelNav = new javax.swing.JPanel();
        labelDerecha = new javax.swing.JLabel();
        labalIzquierda = new javax.swing.JLabel();
        labelPrincipal = new javax.swing.JLabel();
        labelNombre = new javax.swing.JLabel();
        botonSiguiente = new javax.swing.JButton();
        botonAnterior = new javax.swing.JButton();
        date = new com.toedter.calendar.JDateChooser();
        btnCalcular = new javax.swing.JButton();
        scrollPane = new javax.swing.JScrollPane();
        panelInfo = new javax.swing.JPanel();
        labelSignificado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        PanelNav.setOpaque(false);

        labelDerecha.setForeground(new java.awt.Color(204, 204, 204));
        labelDerecha.setOpaque(true);

        labalIzquierda.setOpaque(true);

        labelNombre.setBackground(new java.awt.Color(0, 0, 0));
        labelNombre.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        labelNombre.setForeground(new java.awt.Color(255, 255, 255));
        labelNombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        labelNombre.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelNombre.setOpaque(true);

        botonSiguiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonSiguienteMouseClicked(evt);
            }
        });

        botonAnterior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonAnteriorMouseClicked(evt);
            }
        });

        date.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        btnCalcular.setText("Calcular Nahual de la Fecha");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        scrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setToolTipText("");

        labelSignificado.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labelSignificado.setForeground(new java.awt.Color(0, 0, 255));
        labelSignificado.setText("Significado");

        javax.swing.GroupLayout panelInfoLayout = new javax.swing.GroupLayout(panelInfo);
        panelInfo.setLayout(panelInfoLayout);
        panelInfoLayout.setHorizontalGroup(
            panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelSignificado)
                .addContainerGap(732, Short.MAX_VALUE))
        );
        panelInfoLayout.setVerticalGroup(
            panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelSignificado)
                .addContainerGap(319, Short.MAX_VALUE))
        );

        scrollPane.setViewportView(panelInfo);

        javax.swing.GroupLayout PanelNavLayout = new javax.swing.GroupLayout(PanelNav);
        PanelNav.setLayout(PanelNavLayout);
        PanelNavLayout.setHorizontalGroup(
            PanelNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNavLayout.createSequentialGroup()
                .addGap(234, 234, 234)
                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCalcular)
                .addContainerGap(225, Short.MAX_VALUE))
            .addGroup(PanelNavLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(PanelNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scrollPane, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelNavLayout.createSequentialGroup()
                        .addComponent(botonAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(labalIzquierda, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addGroup(PanelNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                            .addComponent(labelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelDerecha, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(botonSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );
        PanelNavLayout.setVerticalGroup(
            PanelNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNavLayout.createSequentialGroup()
                .addGroup(PanelNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelNavLayout.createSequentialGroup()
                        .addGroup(PanelNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelNavLayout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addGroup(PanelNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labelDerecha, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labalIzquierda, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(PanelNavLayout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(labelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(labelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelNavLayout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(botonAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelNavLayout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(botonSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(PanelNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCalcular))
                .addGap(49, 49, 49)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        getContentPane().add(PanelNav, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAnteriorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonAnteriorMouseClicked
        if(verificarNahuales()){
            anterior();
            pintarNahuales();
            setPosiciones();
            date.setDate(null);
        }
    }//GEN-LAST:event_botonAnteriorMouseClicked

    private void botonSiguienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonSiguienteMouseClicked
        if(verificarNahuales()){
            siguiente();
            pintarNahuales();
            setPosiciones();
            date.setDate(null);
        }
    }//GEN-LAST:event_botonSiguienteMouseClicked

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        if(date.getDate()!=null){
            calcularFecha();
        }else{
            JOptionPane.showMessageDialog(null, "Debe de seleccionar o ingresar una fecha");
        }
        
        
        
    }//GEN-LAST:event_btnCalcularActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelNav;
    private javax.swing.JButton botonAnterior;
    private javax.swing.JButton botonSiguiente;
    private javax.swing.JButton btnCalcular;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JLabel labalIzquierda;
    private javax.swing.JLabel labelDerecha;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelPrincipal;
    private javax.swing.JLabel labelSignificado;
    private javax.swing.JPanel panelInfo;
    private javax.swing.JScrollPane scrollPane;
    // End of variables declaration//GEN-END:variables

    class FondoPanel extends JPanel{
        
        private Image imagen;
        @Override
        public void paint(Graphics g){
            imagen = new ImageIcon(getClass().getResource("../imagenes/fondoNahuales.jpg")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
    }
    
}
