/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tutorial.encripcion.cliente;

import com.google.gson.Gson;
import java.awt.HeadlessException;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import tutorial.encripcion.cliente.pojos.RegistrarRequest;
import tutorial.encripcion.cliente.pojos.RegistrarResponse;
import tutorial.encripcion.cliente.pojos.ValidarRequest;


/**
 *
 * @author johnmartinez
 */
public class frCliente extends javax.swing.JFrame {

    /**
     * Creates new form frCliente
     */
    public frCliente() {
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

        jPanel1 = new javax.swing.JPanel();
        btnSeleccionarRuta = new javax.swing.JButton();
        txtRuta = new javax.swing.JTextField();
        btnGenerar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnLlavePrivada = new javax.swing.JButton();
        txtLlavePrivada = new javax.swing.JTextField();
        btnLlavePublica = new javax.swing.JButton();
        txtLlavePublica = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMensaje = new javax.swing.JTextArea();
        btnRegistarPublica = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtIdentificador = new javax.swing.JTextField();
        btnComprobarMensaje = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tutorial Encripción");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Generar Llaves"));

        btnSeleccionarRuta.setText("Seleccionar Ruta");
        btnSeleccionarRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarRutaActionPerformed(evt);
            }
        });

        txtRuta.setEditable(false);

        btnGenerar.setText("Generar");
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSeleccionarRuta)
                        .addGap(18, 18, 18)
                        .addComponent(txtRuta))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnGenerar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSeleccionarRuta)
                    .addComponent(txtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGenerar)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Pruebas al Web Service"));

        btnLlavePrivada.setText("Llave Privada");
        btnLlavePrivada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLlavePrivadaActionPerformed(evt);
            }
        });

        txtLlavePrivada.setEditable(false);

        btnLlavePublica.setText("Llave Pública");
        btnLlavePublica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLlavePublicaActionPerformed(evt);
            }
        });

        txtLlavePublica.setEditable(false);

        txtMensaje.setColumns(20);
        txtMensaje.setRows(5);
        jScrollPane1.setViewportView(txtMensaje);

        btnRegistarPublica.setText("Registrar Llave Publica");
        btnRegistarPublica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistarPublicaActionPerformed(evt);
            }
        });

        jLabel2.setText("Mensaje:");

        jLabel3.setText("Identificador:");

        btnComprobarMensaje.setText("Comprobar Mensaje");
        btnComprobarMensaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprobarMensajeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnLlavePublica, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLlavePublica, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRegistarPublica))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnLlavePrivada, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLlavePrivada))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtIdentificador)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnComprobarMensaje)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLlavePublica)
                    .addComponent(txtLlavePublica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistarPublica))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLlavePrivada)
                    .addComponent(txtLlavePrivada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtIdentificador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnComprobarMensaje))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeleccionarRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarRutaActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int validarGuardar = fc.showSaveDialog(null);
        if(validarGuardar == JFileChooser.APPROVE_OPTION) {
            txtRuta.setText(fc.getSelectedFile().toString());
        } else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna carpeta");
        }
    }//GEN-LAST:event_btnSeleccionarRutaActionPerformed

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        try {            
            if(txtRuta.getText() != null && !txtRuta.getText().isEmpty()) {
                KeyPair parLlaves = Seguridad.GenerarNuevoParLlaves();
                String rutaPrivada = txtRuta.getText() + "/llavePrivada.lpr";
                String rutaPublica = txtRuta.getText() + "/llavePublica.lpu";
                Seguridad.GuardarLlavePrivada(parLlaves, rutaPrivada);
                Seguridad.GuardarLlavePublica(parLlaves, rutaPublica);
                JOptionPane.showMessageDialog(null, "Llaves pública y privada generadas");
            } else {
                JOptionPane.showMessageDialog(null, "No se ha seleccionado la carpeta de destino");
            }
        } catch (NoSuchAlgorithmException | InvalidKeySpecException | IOException ex) {
            // Logger.getLogger(frCliente.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Problema guardando el par de llaves");
        }
    }//GEN-LAST:event_btnGenerarActionPerformed

    private void btnLlavePublicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLlavePublicaActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int validarGuardar = fc.showSaveDialog(null);
        if(validarGuardar == JFileChooser.APPROVE_OPTION) {
            txtLlavePublica.setText(fc.getSelectedFile().toString());
        } else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun archivo");
        }
    }//GEN-LAST:event_btnLlavePublicaActionPerformed

    private void btnLlavePrivadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLlavePrivadaActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int validarGuardar = fc.showSaveDialog(null);
        if(validarGuardar == JFileChooser.APPROVE_OPTION) {
            txtLlavePrivada.setText(fc.getSelectedFile().toString());
        } else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun archivo");
        }
    }//GEN-LAST:event_btnLlavePrivadaActionPerformed

    private void btnRegistarPublicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistarPublicaActionPerformed
        try {            
            if(txtLlavePublica.getText() != null && !txtLlavePublica.getText().isEmpty()) {
                // leer archivo
                PublicKey llavePublica = Seguridad.LeerLlavePublica(txtLlavePublica.getText());
                KeyFactory fabrica = KeyFactory.getInstance("RSA");
                RSAPublicKeySpec specsLlavePublica = fabrica.getKeySpec(llavePublica, RSAPublicKeySpec.class);
                RegistrarRequest solicitud = new RegistrarRequest(
                        specsLlavePublica.getModulus().toByteArray(), 
                        specsLlavePublica.getPublicExponent().toByteArray());
                Gson gson = new Gson();
                String strSolicitud = gson.toJson(solicitud);
                // hacer post
                Client cliente = ClientBuilder.newClient();
                WebTarget miRecurso = cliente.target("http://138.91.48.35/Publica.Servidor/webresources/Servicio/")
                        .path("register");
                Response response = miRecurso
                        .request(MediaType.APPLICATION_JSON).post(Entity.json(strSolicitud));
                String respuesta = response.readEntity(String.class);
                //long valor = gson.fromJson(respuesta, long.class);
                RegistrarResponse objRespuesta = gson.fromJson(respuesta, RegistrarResponse.class);
                JOptionPane.showMessageDialog(null, "Id de la llave registrada: " + objRespuesta.getId());
            }
        } catch (IOException | ClassNotFoundException | NoSuchAlgorithmException | InvalidKeySpecException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }  
    }//GEN-LAST:event_btnRegistarPublicaActionPerformed

    private void btnComprobarMensajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprobarMensajeActionPerformed
        // leer mensaje
        try {
            if(txtMensaje.getText() != null && !txtMensaje.getText().isEmpty() &&
                txtLlavePrivada.getText() != null && !txtLlavePrivada.getText().isEmpty() &&
                txtIdentificador.getText() != null && !txtIdentificador.getText().isEmpty()){
                // si hay llave privada y hay mensaje
                String mensaje = txtMensaje.getText();
                String direccionPrivada = txtLlavePrivada.getText();
                long identificador = -1;
                try {
                    identificador = Long.parseLong(txtIdentificador.getText());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "El campo identificador debe contener un entero");
                }
                if(identificador != -1) {
                    // si hubo identificador
                    PrivateKey llavePrivada = Seguridad.LeerLlavePrivada(direccionPrivada);
                    byte[] msgEncriptado = Seguridad.EncriptarMensaje(mensaje, llavePrivada);
                    ValidarRequest objRequest = new ValidarRequest(msgEncriptado, mensaje, identificador);
                    Gson gson = new Gson();
                    // hacer post
                    Client cliente = ClientBuilder.newClient();
                    String strSolicitud = gson.toJson(objRequest, ValidarRequest.class);
                    WebTarget miRecurso = cliente.target("http://138.91.48.35/Publica.Servidor/webresources/Servicio/")
                        .path("validate");                    
                    Response response = miRecurso.request(MediaType.APPLICATION_JSON)
                            .post(Entity.json(strSolicitud));
                    String respuesta = response.readEntity(String.class);
                    try {
                        boolean ok = gson.fromJson(respuesta, boolean.class);
                        if(ok) {
                            JOptionPane.showMessageDialog(null, "Encriptado con esa llave");
                        } else {
                            JOptionPane.showMessageDialog(null, "NO!!! encriptado con esa llave");
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "El par llave y msg no corresponde");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debe escribir un mensaje, seleccionar una llave privada y digitar un identificador");
            }
        } catch (Exception e) {
            //e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Un error ocurrió");
        }
    }//GEN-LAST:event_btnComprobarMensajeActionPerformed

    
    
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
            java.util.logging.Logger.getLogger(frCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComprobarMensaje;
    private javax.swing.JButton btnGenerar;
    private javax.swing.JButton btnLlavePrivada;
    private javax.swing.JButton btnLlavePublica;
    private javax.swing.JButton btnRegistarPublica;
    private javax.swing.JButton btnSeleccionarRuta;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtIdentificador;
    private javax.swing.JTextField txtLlavePrivada;
    private javax.swing.JTextField txtLlavePublica;
    private javax.swing.JTextArea txtMensaje;
    private javax.swing.JTextField txtRuta;
    // End of variables declaration//GEN-END:variables
}
