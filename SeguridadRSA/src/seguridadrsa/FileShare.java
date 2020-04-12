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
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
// esta librería de java no es soportada en el JDK 9
import sun.misc.BASE64Decoder;

public class FileShare extends javax.swing.JFrame {

    /**
     * Represents the idea of how communication software works It uses public
     * key infrastructure and RSA to its implementation
     */
    public FileShare() throws IOException {
        this.socket = new WebSocket(this);
        initComponents();
        this.setLocationRelativeTo(null);
        this.lbl_loadedFile.setText("");
        this.lbl_routeprivkey.setText("");
        this.lbl_routepubkey.setText("");
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
        jPanel1 = new javax.swing.JPanel();
        btn_escuchar = new javax.swing.JButton();
        btn_enviar = new javax.swing.JButton();
        txtfld_ip = new javax.swing.JTextField();

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
                    .addComponent(btn_loadPrivKey, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
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

        btn_escuchar.setText("Recibir Archivo");
        btn_escuchar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_escucharActionPerformed(evt);
            }
        });

        btn_enviar.setText("Enviar Archivo");
        btn_enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_enviarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_enviar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtfld_ip)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_escuchar, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtfld_ip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_enviar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_escuchar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * ends the app
     *
     * @param evt respective button clicked
     */
    private void btn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btn_exitActionPerformed
    /**
     * button action that asks the user to select a public key .PEM file, calls
     * "leerllave" method and stores its return in the corresponding global
     * variable
     *
     * @param evt respective button clicked
     */
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
    /**
     * button action that asks the user to select a private key .PEM file, calls
     * "leerllave" method and stores its return in the corresponding global
     * variable
     *
     * @param evt respective button clicked
     */
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
    /**
     * button action that asks the user to select a file
     * and stores it corresponding global variable
     * @param evt respective button clicked
     */
    private void btn_readfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_readfileActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(this);
        readFile = chooser.getSelectedFile();
        this.lbl_loadedFile.setText(readFile.getName());
    }//GEN-LAST:event_btn_readfileActionPerformed
    /**
     * button action calls "cifrarArchivo" method with the global file 
     * variable and the global plublic key variable as parameters
     * @param evt respective button clicked
     */
    private void btn_ciphActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ciphActionPerformed
        try {
            this.cifrarArchivo(readFile, PubKey);
        } catch (IOException ex) {
            Logger.getLogger(FileShare.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_ciphActionPerformed
    /**
     * button action calls "descifrarArchivo" method with the global file 
     * variable and the global private key variable as parameters
     * @param evt respective button clicked
     */
    private void btn_desciphActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_desciphActionPerformed
        try {
            this.descifrarArchivo(readFile, PrivKey);
        } catch (IOException ex) {
            Logger.getLogger(FileShare.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_desciphActionPerformed
    /**
     * button action calls "crearClaves" method that creates the pair 
     * of keys and stores them in their respectives global variables
     * @param evt respective button clicked
     */
    private void btn_genKeysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_genKeysActionPerformed
        try {
            this.crearClaves();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(FileShare.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileShare.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_genKeysActionPerformed

    private void btn_escucharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_escucharActionPerformed
        try {
            socket.Client();
        } catch (IOException ex) {
            Logger.getLogger(FileShare.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_escucharActionPerformed

    private void btn_enviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_enviarActionPerformed
        try {
            socket.Server(this.txtfld_ip.getText());
        } catch (IOException ex) {
            Logger.getLogger(FileShare.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_enviarActionPerformed

    /**
     * it stores a private key for decryption
     */
    PrivateKey PrivKey;
    /**
     * it stores a public key for encryption
     */
    PublicKey PubKey;
    /**
     * it stores the file that is going to be encrypted or decrypted
     */
    File readFile;
    
    WebSocket socket;

    /**
     * initializes the visual components
     *
     * @param args
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FileShare().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(FileShare.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    /**
     * Creates a pair of keys, public and private and asks the user the storage
     * location for the corresponding .PEM files
     *
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */
    public void crearClaves() throws NoSuchAlgorithmException, IOException {
        KeyPairGenerator keygen = KeyPairGenerator.getInstance("RSA"); //Crea la instancia del generador de keys y lo configura para que use RSA
        keygen.initialize(1024); //Inicializa el generador en 1024 bits
        KeyPair keypair = keygen.generateKeyPair(); //genera las keys

        PrivKey = keypair.getPrivate(); //Obtiene la key privada
        PubKey = keypair.getPublic(); //Obtiene la Key publica

        JOptionPane.showMessageDialog(null, "LLaves generadas");

        // guarda la llave publica
        JOptionPane.showMessageDialog(null, "seleccione la ruta de la llave publica");
        this.GuardarLlave(PubKey);
        
        // guarda la llave privada
        JOptionPane.showMessageDialog(null, "seleccione la ruta de la llave privada");
        this.GuardarLlave(PrivKey);
    }

    /**
     * asks the user the storage location for a key .PEM files
     *
     * @param Key corresponds to the key that is going to be storaged, could be
     * both private or public key
     */
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
                    //Escribe la llave en un archivo .PEM
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

    /**
     * Reads a .PEM file and extracts the respective key. returns null if type
     * parameter is not inserted properly
     *
     * @param file corresponds to the key .PEM file
     * @param type corresponds to the type of key residing in the .PEM file.
     * "public" and "private" if the key is public or private respectively
     * @return returns the corresponding key stored in the .PEM file. returns
     * null if type parameter is not inserted properly
     * @throws Exception
     */
    public Key leerllave(File file, String type) throws Exception {
        
        // metodo para llaves publicas
        if (type.equals("public")) {
            
            // lee el archivo y lo ingresa en un array de bytes
            FileInputStream in = new FileInputStream(file);
            byte[] keyBytes = new byte[in.available()];
            in.read(keyBytes);
            in.close();
            
            //pone su contenido en un string eliminando los headers
            String pubKey = new String(keyBytes, "UTF-8");
            pubKey = pubKey.replaceAll("(-+BEGIN PUBLIC KEY-+\\r?\\n|-+END PUBLIC KEY-+\\r?\\n?)", "");

            // lo convierte a base 64
            BASE64Decoder decoder = new BASE64Decoder();
            keyBytes = decoder.decodeBuffer(pubKey);
            
            //le pone su respectivo formato y lo retorna
            X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            return keyFactory.generatePublic(spec);

            //metodo para llaves privadas
        } else if (type.equals("private")) {
            
            /* para ser sincero, no se que hace exactamente la siguiente linea.
            Esta linea la encontré despues de buscar en internet un error de formato
            que me arrojaba netbeans, que no tenía sentido porque el formato de la llave privada
            es el correcto, está respuesta apareció y el que la posteó no dió más información
            más que el hecho de que poniendo la linea su programa empezaba a detectar bien el formato.
            En mi programa ocurrió lo mismo pero sigo sin saber porqué arrojaba el error en primer
            lugar, o bien, la razón detras de que la siguiente linea arregla el error*/
            
            java.security.Security.addProvider(
                    new org.bouncycastle.jce.provider.BouncyCastleProvider()
            );
            
            // lee el archivo y lo ingresa en un array de bytes
            FileInputStream in = new FileInputStream(file);
            byte[] keyBytes = new byte[in.available()];
            in.read(keyBytes);
            in.close();

            //pone su contenido en un string eliminando los headers
            String privateKey = new String(keyBytes, "UTF-8");
            privateKey = privateKey.replaceAll("(-+BEGIN RSA PRIVATE KEY-+\\r?\\n|-+END RSA PRIVATE KEY-+\\r?\\n?)", "");

            // lo convierte a base 64
            BASE64Decoder decoder = new BASE64Decoder();
            keyBytes = decoder.decodeBuffer(privateKey);
            
            //le pone su respectivo formato y lo retorna
            PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            return keyFactory.generatePrivate(spec);

        } else {
            return null;
        }
    }

    /**
     * Encrypts the file provided with the key provided and asks the user for
     * the storage location of the encrypted file
     *
     * @param data corresponds to the file thas is going to be encrypted
     * @param key corresponds to the public key that is going to encrypt the
     * file
     * @throws IOException
     */
    public void cifrarArchivo(File data, PublicKey key) throws IOException {
        // verifica que se haya cargado el archivo y la llave correspondiente
        if (key != null && data != null) {
            
            //lee los datos del archivo
            byte[] datosACifrar = Files.readAllBytes(data.toPath());
            byte[] datosEncriptados = null;
            try {
                //cifra el archivo con RSA y la llave publica correspondiente
                Cipher cipher = Cipher.getInstance("RSA");
                cipher.init(Cipher.ENCRYPT_MODE, key);
                datosEncriptados = cipher.doFinal(datosACifrar);
                System.out.println("Los datos ya encriptados son:  " + datosEncriptados);

            } catch (Exception e) {
                e.printStackTrace();
            }
            
            // se pide al usuario que escoja donde se guardara el archivo cifrado
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

    /**
     * decrypts an encrypted file with a private key asks the user for the
     * storage location of the decrypted file
     *
     * @param data corresponds to the file thas is going to be decrypted
     * @param key corresponds to the private key that is going to decrypt the
     * file
     * @throws IOException
     */
    public void descifrarArchivo(File data, PrivateKey key) throws IOException {
        // verifica que se haya cargado el archivo y la llave correspondiente
        if (key != null && data != null) {
            
            //lee los datos del archivo
            byte[] datosADescifrar = Files.readAllBytes(data.toPath());
            byte[] datosDescifrados = null;
            
            //descifra el archivo con RSA y la llave privada correspondiente
            try {
                Cipher cipher = Cipher.getInstance("RSA");
                cipher.init(Cipher.DECRYPT_MODE, key);
                datosDescifrados = cipher.doFinal(datosADescifrar);
                System.out.println("Los datos descifrados son: " + new String(datosDescifrados));

            } catch (Exception e) {
                e.printStackTrace();
            }
            
            // se pide al usuario que escoja donde se guardara el archivo descifrado
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
    private javax.swing.JButton btn_enviar;
    private javax.swing.JButton btn_escuchar;
    private javax.swing.JButton btn_exit;
    private javax.swing.JButton btn_genKeys;
    private javax.swing.JButton btn_loadPrivKey;
    private javax.swing.JButton btn_loadPubKey;
    private javax.swing.JButton btn_readfile;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_loadedFile;
    private javax.swing.JLabel lbl_routefile;
    private javax.swing.JLabel lbl_routeprivkey;
    private javax.swing.JLabel lbl_routepubkey;
    private javax.swing.JTextField txtfld_ip;
    // End of variables declaration//GEN-END:variables
}
