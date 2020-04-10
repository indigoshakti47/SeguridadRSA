package seguridadrsa;

import org.bouncycastle.openssl.jcajce.JcaPEMWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.security.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import sun.misc.IOUtils;

public class FileShare extends javax.swing.JFrame {

    public FileShare() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btn_genKeys = new javax.swing.JButton();
        btn_savepubKeys = new javax.swing.JButton();
        btn_saveprivKey = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lbl_routefile = new javax.swing.JLabel();
        btn_ciph = new javax.swing.JButton();
        btn_desciph = new javax.swing.JButton();
        btn_loadPubKey = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        lbl_routepubkey = new javax.swing.JLabel();
        btn_loadPrivKey = new javax.swing.JButton();
        lbl_routeprivkey = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btn_exit = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btn_genKeys.setText("Generar Llaves");
        btn_genKeys.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_genKeysActionPerformed(evt);
            }
        });

        btn_savepubKeys.setText("Guardar Llave Publica");
        btn_savepubKeys.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_savepubKeysActionPerformed(evt);
            }
        });

        btn_saveprivKey.setText("Guardar Llave Privada");
        btn_saveprivKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveprivKeyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btn_saveprivKey, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                    .addComponent(btn_savepubKeys, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_genKeys, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_genKeys, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_savepubKeys, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_saveprivKey, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton2.setText("Abrir Archivo");

        jLabel3.setText("Archivo Cargado:");

        lbl_routefile.setText("jLabel4");

        btn_ciph.setText("Cifrar y Guardar");

        btn_desciph.setText("Descifrar y Guardar");

        btn_loadPubKey.setText("Cargar Llave Publica");
        btn_loadPubKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loadPubKeyActionPerformed(evt);
            }
        });

        jLabel4.setText("Archivo Cargado:");

        lbl_routepubkey.setText("jLabel4");

        btn_loadPrivKey.setText("Cargar Llave Privada");
        btn_loadPrivKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loadPrivKeyActionPerformed(evt);
            }
        });

        lbl_routeprivkey.setText("jLabel4");

        jLabel5.setText("Archivo Cargado:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_desciph, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_ciph, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_loadPubKey, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                    .addComponent(btn_loadPrivKey, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(lbl_routefile)
                            .addComponent(jLabel4)
                            .addComponent(lbl_routepubkey)
                            .addComponent(jLabel5)
                            .addComponent(lbl_routeprivkey))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(lbl_routefile)
                .addGap(18, 18, 18)
                .addComponent(btn_loadPubKey, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(lbl_routepubkey)
                .addGap(18, 18, 18)
                .addComponent(btn_loadPrivKey, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(lbl_routeprivkey)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(btn_ciph, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_desciph, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btn_exit.setText("Cerrar");
        btn_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(273, 273, 273)
                .addComponent(btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_genKeysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_genKeysActionPerformed
        try {
            // TODO add your handling code here:
            this.crearClaves();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(FileShare.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileShare.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btn_genKeysActionPerformed

    private void btn_savepubKeysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_savepubKeysActionPerformed
        // TODO add your handling code here:
        this.GuardarLlavePublica();
    }//GEN-LAST:event_btn_savepubKeysActionPerformed

    private void btn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btn_exitActionPerformed

    private void btn_loadPubKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loadPubKeyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_loadPubKeyActionPerformed

    private void btn_loadPrivKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loadPrivKeyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_loadPrivKeyActionPerformed

    private void btn_saveprivKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveprivKeyActionPerformed
        // TODO add your handling code here:
        this.GuardarLlavePrivada();
    }//GEN-LAST:event_btn_saveprivKeyActionPerformed

    PrivateKey PrivKey;
    PublicKey PubKey;
    PrivateKey PrivKeyread;
    PublicKey PubKeyread;

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
            java.util.logging.Logger.getLogger(FileShare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FileShare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FileShare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FileShare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FileShare().setVisible(true);
            }
        });
    }

    private void crearClaves() throws NoSuchAlgorithmException, IOException {
        KeyPairGenerator keygen = KeyPairGenerator.getInstance("RSA"); //Crea la instancia del generador de keys y lo configura para que use RSA
        keygen.initialize(1024); //Inicializa el generador en 1024 bits
        KeyPair keypair = keygen.generateKeyPair(); //genera las keys

        PrivKey = keypair.getPrivate(); //Obtiene la key privada
        PubKey = keypair.getPublic(); //Obtiene la Key publica

        JOptionPane.showMessageDialog(null, "LLaves generadas");
    }

    private void GuardarLlavePrivada() {
        if (PrivKey != null) {
            // Inicializa el Filechooser
            JFileChooser chooser = new JFileChooser();
            int retval = chooser.showSaveDialog(null);
            if (retval == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                //en caso de no poner nombre se devuelve
                if (file == null) {
                    return;
                }
                // pone extension automaticamente
                if (!file.getName().toLowerCase().endsWith(".pem")) {
                    file = new File(file.getParentFile(), file.getName() + ".pem");
                }
                try {
                    //Escribe la clave privada en un archivo .PEM, este se guarda en el directorio del proyecto
                    JcaPEMWriter writer = new JcaPEMWriter(new FileWriter(file));
                    writer.writeObject(PrivKey);
                    writer.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No ha generado un par de llaves");
        }
    }

    private void GuardarLlavePublica() {
        if (PubKey != null) {
            // Inicializa el Filechooser
            JFileChooser chooser = new JFileChooser();
            int retval = chooser.showSaveDialog(null);
            if (retval == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                //en caso de no poner nombre se devuelve
                if (file == null) {
                    return;
                }
                // pone extension automaticamente
                if (!file.getName().toLowerCase().endsWith(".pem")) {
                    file = new File(file.getParentFile(), file.getName() + ".pem");
                }
                try {
                    //Escribe la clave publica en un archivo .PEM
                    JcaPEMWriter writer = new JcaPEMWriter(new FileWriter(file));
                    writer.writeObject(PubKey);
                    writer.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No ha generado un par de llaves");
        }
    }

    private void leerllaveprivada() {
        
        String privateKeyPEM = key;
        privateKeyPEM = privateKeyPEM.replace("-----BEGIN PRIVATE KEY-----\n", "");
        privateKeyPEM = privateKeyPEM.replace("-----END PRIVATE KEY-----", "");
        byte[] encoded = Base64.decodeBase64(privateKeyPEM);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(encoded);
        RSAPrivateKey privKey = (RSAPrivateKey) kf.generatePrivate(keySpec);
        return privKey;
    }

    public void cifrarArchivo(File data) throws IOException {

        System.out.println("Datos a encriptar (Deberia ser archivo y no string) " + data);
        byte[] datosACifrar = Files.readAllBytes(data);
        byte[] datosEncriptados = null;
        try {
            PublicKey llavePub = leerArchivoLlavePublica(this.Archivo_Llave_Publica);
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, PubKeyread);
            datosEncriptados = cipher.doFinal(datosACifrar);
            System.out.println("Los datos ya encriptados son:  " + datosEncriptados);

        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | BadPaddingException | IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return datosEncriptados;

    }

    public void descifrarArchivo() {

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ciph;
    private javax.swing.JButton btn_desciph;
    private javax.swing.JButton btn_exit;
    private javax.swing.JButton btn_genKeys;
    private javax.swing.JButton btn_loadPrivKey;
    private javax.swing.JButton btn_loadPubKey;
    private javax.swing.JButton btn_saveprivKey;
    private javax.swing.JButton btn_savepubKeys;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_routefile;
    private javax.swing.JLabel lbl_routeprivkey;
    private javax.swing.JLabel lbl_routepubkey;
    // End of variables declaration//GEN-END:variables
}
