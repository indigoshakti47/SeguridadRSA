package seguridadrsa;

import org.bouncycastle.openssl.jcajce.JcaPEMWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.*;

public class FileShare {

    PrivateKey PrivKey;
    PublicKey PubKey;

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        FileShare este = new FileShare();
        este.crearClaves();


    }

    public void crearClaves() throws NoSuchAlgorithmException, IOException {
        KeyPairGenerator keygen = KeyPairGenerator.getInstance("RSA"); //Crea la instancia del generador de keys y lo configura para que use RSA
        keygen.initialize(1024); //Inicializa el generador en 1024 bits
        KeyPair keypair = keygen.generateKeyPair(); //genera las keys

        PrivKey = keypair.getPrivate(); //Obtiene la key privada
        PubKey = keypair.getPublic(); //Obtiene la Key publica
        
        //Escribe la clave privada en un archivo .PEM, este se guarda en el directorio del proyecto
        JcaPEMWriter writer = new JcaPEMWriter(new FileWriter(new File("PrivateKey.pem")));
        writer.writeObject(PrivKey);
        writer.close();
        
         //Escribe la clave publica en un archivo .PEM, este se guarda en el directorio del proyecto
        writer = new JcaPEMWriter(new FileWriter(new File("PublicKey.pem")));
        writer.writeObject(PubKey);
        writer.close();
    }
    public void descifrarArchivo(){


    }
}
