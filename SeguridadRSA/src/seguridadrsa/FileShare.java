package seguridadrsa;

import org.bouncycastle.openssl.jcajce.JcaPEMWriter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import sun.misc.BASE64Decoder;

public class FileShare extends javax.swing.JFrame {

    public FileShare() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btn_readfile = new javax.swing.JButton();
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
        btn_genKeys = new javax.swing.JButton();
        lbl_loadedFile = new javax.swing.JLabel();
        btn_exit = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btn_readfile.setText("Abrir Archivo");
        btn_readfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_readfileActionPerformed(evt);
            }
        });

        jLabel3.setText("Archivo Cargado:");

        btn_ciph.setText("Cifrar y Guardar");
        btn_ciph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ciphActionPerformed(evt);
            }
        });

        btn_desciph.setText("Descifrar y Guardar");
        btn_desciph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_desciphActionPerformed(evt);
            }
        });

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

        btn_genKeys.setText("Generar Llaves");
        btn_genKeys.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_genKeysActionPerformed(evt);
            }
        });

        lbl_loadedFile.setText("jLabel1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_routefile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_loadPubKey, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_genKeys, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_desciph, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_ciph, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_loadPrivKey, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_readfile, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_loadedFile)
                            .addComponent(jLabel3)
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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(lbl_routefile))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_genKeys, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_readfile, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_loadedFile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(btn_loadPubKey, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_routepubkey)
                .addGap(30, 30, 30)
                .addComponent(btn_loadPrivKey, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_routeprivkey)
                .addGap(30, 30, 30)
                .addComponent(btn_ciph, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_desciph, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(178, 178, 178)
                .addComponent(btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(165, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btn_exitActionPerformed

    private void btn_loadPubKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loadPubKeyActionPerformed
        try {
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(this);
            File file = chooser.getSelectedFile();
            this.PubKey = (PublicKey) this.leerllave(file, "public");
            this.lbl_routepubkey.setText(file.getName());
        } catch (IOException ex) {
            Logger.getLogger(FileShare.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(FileShare.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_loadPubKeyActionPerformed

    private void btn_loadPrivKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loadPrivKeyActionPerformed
        try {
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(this);
            File file = chooser.getSelectedFile();
            this.PrivKey = (PrivateKey) this.leerllave(file, "private");
            this.lbl_routeprivkey.setText(file.getName());
        } catch (IOException ex) {
            Logger.getLogger(FileShare.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(FileShare.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_loadPrivKeyActionPerformed

    private void btn_readfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_readfileActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(this);
        readFile = chooser.getSelectedFile();
        this.lbl_loadedFile.setText(readFile.getName());
    }//GEN-LAST:event_btn_readfileActionPerformed

    private void btn_ciphActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ciphActionPerformed
        try {
            this.cifrarArchivo(readFile);
        } catch (IOException ex) {
            Logger.getLogger(FileShare.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_ciphActionPerformed

    private void btn_desciphActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_desciphActionPerformed
        try {
            this.descifrarArchivo(readFile);
        } catch (IOException ex) {
            Logger.getLogger(FileShare.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_desciphActionPerformed

    private void btn_genKeysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_genKeysActionPerformed
        try {
            this.crearClaves();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(FileShare.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileShare.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_genKeysActionPerformed

    PrivateKey PrivKey;
    PublicKey PubKey;
    File readFile;

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FileShare().setVisible(true);
            }
        });
    }

    public void crearClaves() throws NoSuchAlgorithmException, IOException {
        KeyPairGenerator keygen = KeyPairGenerator.getInstance("RSA"); //Crea la instancia del generador de keys y lo configura para que use RSA
        keygen.initialize(1024); //Inicializa el generador en 1024 bits
        KeyPair keypair = keygen.generateKeyPair(); //genera las keys

        PrivKey = keypair.getPrivate(); //Obtiene la key privada
        PubKey = keypair.getPublic(); //Obtiene la Key publica

        System.out.println(PrivKey.getFormat());

        JOptionPane.showMessageDialog(null, "LLaves generadas");

        JOptionPane.showMessageDialog(null, "seleccione la ruta de la llave publica");
        this.GuardarLlave(PubKey);
        JOptionPane.showMessageDialog(null, "seleccione la ruta de la llave privada");
        this.GuardarLlave(PrivKey);
    }

    public void GuardarLlave(Key Key) {
        if (Key != null) {
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
                    //Escribe la clave privada en un archivo .PEM
                    JcaPEMWriter writer = new JcaPEMWriter(new FileWriter(file));
                    writer.writeObject(Key);
                    writer.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No ha generado un par de llaves");
        }
    }

    /*private PublicKey leerllaveprivada() throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        FileInputStream in = new FileInputStream("mykey.pem.pub");
        byte[] keyBytes = new byte[in.available()];
        in.read(keyBytes);
        in.close();

        String pubKey = new String(keyBytes, "UTF-8");
        pubKey = pubKey.replaceAll("(-+BEGIN PUBLIC KEY-+\\r?\\n|-+END PUBLIC KEY-+\\r?\\n?)", "");

        BASE64Decoder decoder = new BASE64Decoder();
        keyBytes = decoder.decodeBuffer(pubKey);

        // generate public key
        X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(spec);

        return publicKey;
    }*/
    public Key leerllave(File file, String type) throws Exception {
        if (type.equals("public")) {
            FileInputStream in = new FileInputStream(file);
            byte[] keyBytes = new byte[in.available()];
            in.read(keyBytes);
            in.close();

            String pubKey = new String(keyBytes, "UTF-8");
            pubKey = pubKey.replaceAll("(-+BEGIN PUBLIC KEY-+\\r?\\n|-+END PUBLIC KEY-+\\r?\\n?)", "");

            BASE64Decoder decoder = new BASE64Decoder();
            keyBytes = decoder.decodeBuffer(pubKey);

            X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            return keyFactory.generatePublic(spec);

        } else if (type.equals("private")) {
            java.security.Security.addProvider(
                    new org.bouncycastle.jce.provider.BouncyCastleProvider()
            );
            FileInputStream in = new FileInputStream(file);
            byte[] keyBytes = new byte[in.available()];
            in.read(keyBytes);
            in.close();

            String privateKey = new String(keyBytes, "UTF-8");
            privateKey = privateKey.replaceAll("(-+BEGIN RSA PRIVATE KEY-+\\r?\\n|-+END RSA PRIVATE KEY-+\\r?\\n?)", "");

            BASE64Decoder decoder = new BASE64Decoder();
            keyBytes = decoder.decodeBuffer(privateKey);

            PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            return keyFactory.generatePrivate(spec);

        } else {
            return null;
        }
    }

    public void cifrarArchivo(File data) throws IOException {
        if (PubKey != null && data!=null) {
            byte[] datosACifrar = Files.readAllBytes(data.toPath());
            byte[] datosEncriptados = null;
            try {
                Cipher cipher = Cipher.getInstance("RSA");
                cipher.init(Cipher.ENCRYPT_MODE, PubKey);
                datosEncriptados = cipher.doFinal(datosACifrar);
                System.out.println("Los datos ya encriptados son:  " + datosEncriptados);

            } catch (Exception e) {
                e.printStackTrace();
            }

            JFileChooser chooser = new JFileChooser();
            int retval = chooser.showSaveDialog(null);
            if (retval == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                //en caso de no poner nombre se devuelve
                if (file == null) {
                    return;
                }
                try {
                    OutputStream os = new FileOutputStream(file);
                    os.write(datosEncriptados);
                    os.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No ha cargado ninguna clave o archivo");
        }
    }

    public void descifrarArchivo(File data) throws IOException {
        if (PrivKey != null && data!=null) {
            byte[] datosADescifrar = Files.readAllBytes(data.toPath());
            byte[] datosDescifrados = null;

            try {
                Cipher cipher = Cipher.getInstance("RSA");
                cipher.init(Cipher.DECRYPT_MODE, PrivKey);
                datosDescifrados = cipher.doFinal(datosADescifrar);
                System.out.println("Los datos descifrados son: " + new String(datosDescifrados));

            } catch (Exception e) {
                e.printStackTrace();
            }
            JFileChooser chooser = new JFileChooser();
            int retval = chooser.showSaveDialog(null);
            if (retval == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                //en caso de no poner nombre se devuelve
                if (file == null) {
                    return;
                }
                try {
                    OutputStream os = new FileOutputStream(file);
                    os.write(datosDescifrados);
                    os.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No ha cargado ninguna clave o archivo");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ciph;
    private javax.swing.JButton btn_desciph;
    private javax.swing.JButton btn_exit;
    private javax.swing.JButton btn_genKeys;
    private javax.swing.JButton btn_loadPrivKey;
    private javax.swing.JButton btn_loadPubKey;
    private javax.swing.JButton btn_readfile;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_loadedFile;
    private javax.swing.JLabel lbl_routefile;
    private javax.swing.JLabel lbl_routeprivkey;
    private javax.swing.JLabel lbl_routepubkey;
    // End of variables declaration//GEN-END:variables
}
