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
import sun.misc.BASE64Encoder;
import tutorial.encripcion.cliente.pojos.RegistrarRequest;
import tutorial.encripcion.cliente.pojos.RegistrarResponse;
import tutorial.encripcion.cliente.pojos.ValidarRequest;


/**
 * Interfaz de usuario que se encarga de enviar las solicitudes al web service.
 * Utiliza la librería Gson para generar las cadenas json de las solicitudes al 
 * web service.
 * @author John Jairo Martínez
 */
public class frCliente extends javax.swing.JFrame {

    
    private static final String DIRECCION_WEB_SERVICE = "http://138.91.48.35/Publica.Servidor/webresources/Servicio/";
    //private static final String DIRECCION_WEB_SERVICE = "http://localhost:8080/Publica.Servidor/webresources/Servicio/";
    
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

        panGenerarLlaves = new javax.swing.JPanel();
        btnSeleccionarRuta = new javax.swing.JButton();
        txtRuta = new javax.swing.JTextField();
        btnGenerar = new javax.swing.JButton();
        panPruebasWS = new javax.swing.JPanel();
        panRegistroLlavesPublicas = new javax.swing.JPanel();
        btnLlavePublica = new javax.swing.JButton();
        txtLlavePublica = new javax.swing.JTextField();
        btnRegistarPublica = new javax.swing.JButton();
        panValidarEncripcionMsgs = new javax.swing.JPanel();
        btnLlavePrivada = new javax.swing.JButton();
        txtLlavePrivada = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMensaje = new javax.swing.JTextArea();
        btnComprobarMensaje = new javax.swing.JButton();
        txtIdentificador = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cliente para Encripción");

        panGenerarLlaves.setBorder(javax.swing.BorderFactory.createTitledBorder("Generar Llaves"));

        btnSeleccionarRuta.setText("Seleccionar Ruta");
        btnSeleccionarRuta.setToolTipText("Permite seleccionar la ruta donde se almacenarán el par de llaves");
        btnSeleccionarRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarRutaActionPerformed(evt);
            }
        });

        txtRuta.setEditable(false);

        btnGenerar.setText("Generar");
        btnGenerar.setToolTipText("Genera las llaves pública y privada en la ruta seleccionada");
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panGenerarLlavesLayout = new javax.swing.GroupLayout(panGenerarLlaves);
        panGenerarLlaves.setLayout(panGenerarLlavesLayout);
        panGenerarLlavesLayout.setHorizontalGroup(
            panGenerarLlavesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panGenerarLlavesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSeleccionarRuta)
                .addGap(18, 18, 18)
                .addComponent(txtRuta)
                .addGap(18, 18, 18)
                .addComponent(btnGenerar)
                .addContainerGap())
        );
        panGenerarLlavesLayout.setVerticalGroup(
            panGenerarLlavesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panGenerarLlavesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panGenerarLlavesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSeleccionarRuta)
                    .addComponent(txtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGenerar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panPruebasWS.setBorder(javax.swing.BorderFactory.createTitledBorder("Pruebas al Web Service"));

        panRegistroLlavesPublicas.setBorder(javax.swing.BorderFactory.createTitledBorder("Registro Llave Pública"));

        btnLlavePublica.setText("Ruta Llave Pública");
        btnLlavePublica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLlavePublicaActionPerformed(evt);
            }
        });

        txtLlavePublica.setEditable(false);

        btnRegistarPublica.setText("Registrar Llave Publica");
        btnRegistarPublica.setToolTipText("Registra la llave pública seleccionada en el servidor.");
        btnRegistarPublica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistarPublicaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panRegistroLlavesPublicasLayout = new javax.swing.GroupLayout(panRegistroLlavesPublicas);
        panRegistroLlavesPublicas.setLayout(panRegistroLlavesPublicasLayout);
        panRegistroLlavesPublicasLayout.setHorizontalGroup(
            panRegistroLlavesPublicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panRegistroLlavesPublicasLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btnLlavePublica, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtLlavePublica, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRegistarPublica)
                .addContainerGap())
        );
        panRegistroLlavesPublicasLayout.setVerticalGroup(
            panRegistroLlavesPublicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panRegistroLlavesPublicasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panRegistroLlavesPublicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLlavePublica)
                    .addComponent(txtLlavePublica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistarPublica))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        panValidarEncripcionMsgs.setBorder(javax.swing.BorderFactory.createTitledBorder("Validar Encripción de Mensajes"));

        btnLlavePrivada.setText("Ruta Llave Privada");
        btnLlavePrivada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLlavePrivadaActionPerformed(evt);
            }
        });

        txtLlavePrivada.setEditable(false);

        jLabel2.setText("Mensaje:");

        txtMensaje.setColumns(20);
        txtMensaje.setRows(5);
        txtMensaje.setToolTipText("Digite aquí el mensaje que desea enviar encriptado");
        jScrollPane1.setViewportView(txtMensaje);

        btnComprobarMensaje.setText("Comprobar Mensaje");
        btnComprobarMensaje.setToolTipText("Comprueba que el mensaje enviado se haya encriptado con la llave privada correspondiente, a la pública registrada");
        btnComprobarMensaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprobarMensajeActionPerformed(evt);
            }
        });

        jLabel3.setText("Identificador de la llave pública registrada:");

        javax.swing.GroupLayout panValidarEncripcionMsgsLayout = new javax.swing.GroupLayout(panValidarEncripcionMsgs);
        panValidarEncripcionMsgs.setLayout(panValidarEncripcionMsgsLayout);
        panValidarEncripcionMsgsLayout.setHorizontalGroup(
            panValidarEncripcionMsgsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panValidarEncripcionMsgsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panValidarEncripcionMsgsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panValidarEncripcionMsgsLayout.createSequentialGroup()
                        .addComponent(btnLlavePrivada, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtLlavePrivada))
                    .addGroup(panValidarEncripcionMsgsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(panValidarEncripcionMsgsLayout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18)
                            .addComponent(txtIdentificador, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnComprobarMensaje))
                        .addGroup(panValidarEncripcionMsgsLayout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panValidarEncripcionMsgsLayout.setVerticalGroup(
            panValidarEncripcionMsgsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panValidarEncripcionMsgsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panValidarEncripcionMsgsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLlavePrivada)
                    .addComponent(txtLlavePrivada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panValidarEncripcionMsgsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panValidarEncripcionMsgsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnComprobarMensaje)
                    .addComponent(txtIdentificador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panPruebasWSLayout = new javax.swing.GroupLayout(panPruebasWS);
        panPruebasWS.setLayout(panPruebasWSLayout);
        panPruebasWSLayout.setHorizontalGroup(
            panPruebasWSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panPruebasWSLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panPruebasWSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panRegistroLlavesPublicas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panValidarEncripcionMsgs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panPruebasWSLayout.setVerticalGroup(
            panPruebasWSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panPruebasWSLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panRegistroLlavesPublicas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panValidarEncripcionMsgs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panGenerarLlaves, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panPruebasWS, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panGenerarLlaves, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panPruebasWS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Permite seleccionar la ruta donde se va a generar las llaves privadas y públicas.
     * @param evt 
     */
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

    /**
     * Genera las llaves públicas y privadas en la carpeta seleccionada previamente.
     * @param evt 
     */
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

    /**
     * Permite seleccionar en donde se encuentra la llave publica a registrar
     * @param evt 
     */
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

    /**
     * Permite seleccionar en donde se encuentra la llave privada.
     * @param evt 
     */
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

    /**
     * Permite registrar la llave publica en el servidor, muestra un mensaje de confirmación
     * con el identificador generado.
     * @param evt 
     */
    private void btnRegistarPublicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistarPublicaActionPerformed
        try {            
            if(txtLlavePublica.getText() != null && !txtLlavePublica.getText().isEmpty()) {
                // leer archivo
                BASE64Encoder codificador = new BASE64Encoder();
                PublicKey llavePublica = Seguridad.LeerLlavePublica(txtLlavePublica.getText());
                KeyFactory fabrica = KeyFactory.getInstance("RSA");
                RSAPublicKeySpec specsLlavePublica = fabrica.getKeySpec(llavePublica, RSAPublicKeySpec.class);
                RegistrarRequest solicitud = new RegistrarRequest(
                        codificador.encode(specsLlavePublica.getModulus().toByteArray()), 
                        codificador.encode(specsLlavePublica.getPublicExponent().toByteArray()));
                Gson gson = new Gson();
                String strSolicitud = gson.toJson(solicitud);
                // hacer post
                Client cliente = ClientBuilder.newClient();
                WebTarget miRecurso = cliente.target(DIRECCION_WEB_SERVICE).path("register");
                Response response = miRecurso
                        .request(MediaType.APPLICATION_JSON).post(Entity.json(strSolicitud));
                String respuesta = response.readEntity(String.class);
                //long valor = gson.fromJson(respuesta, long.class);
                RegistrarResponse objRespuesta = gson.fromJson(respuesta, RegistrarResponse.class);
                JOptionPane.showMessageDialog(null, "Id de la llave registrada: " + objRespuesta.getId());
            } else {
                JOptionPane.showMessageDialog(null, "No ha seleccionado la llave pública");
            }
        } catch (IOException | ClassNotFoundException | NoSuchAlgorithmException | InvalidKeySpecException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }//GEN-LAST:event_btnRegistarPublicaActionPerformed

    /**
     * Permite comprobar que un mensaje fue encriptado con la llave dada.
     * @param evt 
     */
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
                    BASE64Encoder codificador = new BASE64Encoder();
                    String strMsgEncriptado = codificador.encode(msgEncriptado);
                    ValidarRequest objRequest = new ValidarRequest(strMsgEncriptado, mensaje, identificador);
                    Gson gson = new Gson();
                    // hacer post
                    Client cliente = ClientBuilder.newClient();
                    String strSolicitud = gson.toJson(objRequest, ValidarRequest.class);
                    WebTarget miRecurso = cliente.target(DIRECCION_WEB_SERVICE).path("validate");                    
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panGenerarLlaves;
    private javax.swing.JPanel panPruebasWS;
    private javax.swing.JPanel panRegistroLlavesPublicas;
    private javax.swing.JPanel panValidarEncripcionMsgs;
    private javax.swing.JTextField txtIdentificador;
    private javax.swing.JTextField txtLlavePrivada;
    private javax.swing.JTextField txtLlavePublica;
    private javax.swing.JTextArea txtMensaje;
    private javax.swing.JTextField txtRuta;
    // End of variables declaration//GEN-END:variables
}
