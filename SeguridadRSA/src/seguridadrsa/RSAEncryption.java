package seguridadrsa;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.*;
import java.math.BigInteger;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;



public class RSAEncryption {
    private static final String Archivo_Llave_Publica=" PublicKey.pem";
    private static final String Archivo_Llave_Privada=" PrivateKey.pem";

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {


        try{

            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA"); //Crea la instancia del generador de keys y lo configura para que use RSA
            keyPairGenerator.initialize(1024); //Inicializa el generador en 1024 bits
            KeyPair keyPair=keyPairGenerator.generateKeyPair(); //genera las keys
            PublicKey publicKey= keyPair.getPublic(); //llave publica
            PrivateKey privateKey=keyPair.getPrivate(); //llave privada


            KeyFactory keyFactory =KeyFactory.getInstance("RSA"); //Crea la instancia de Key factory y lo configura para que use RSA
            RSAPublicKeySpec rsaPubKeySpec=keyFactory.getKeySpec(publicKey,RSAPublicKeySpec.class);
            RSAPrivateKeySpec rsaPrivKeySpec=keyFactory.getKeySpec(privateKey,RSAPrivateKeySpec.class);

            RSAEncryption objetoRSA= new RSAEncryption();

            objetoRSA.guardarLlavesPEM(Archivo_Llave_Publica, rsaPubKeySpec.getModulus(),rsaPubKeySpec.getPublicExponent());
            objetoRSA.guardarLlavesPEM(Archivo_Llave_Privada,rsaPrivKeySpec.getModulus(),rsaPrivKeySpec.getPrivateExponent());


            byte[] datosEncriptados=objetoRSA.encryptData("ESTO ES LO QUE SE DESEA ENCRIPTAR, SIN EMBARGO DEBERIA SER UN ARCHIVO");
            objetoRSA.descifrarArchivo(datosEncriptados);


        } catch (NoSuchAlgorithmException | InvalidKeySpecException e){
            System.out.println(e);
        }
    }




    private void guardarLlavesPEM(String nombreArchivo, BigInteger moduloOperando, BigInteger exponente) throws IOException {

        FileOutputStream fileOutputStream=null;
        ObjectOutputStream objectOutputStream=null;

        try{
            //Acá se genera el archivo

            System.out.println("Generando "+ nombreArchivo );
            fileOutputStream= new FileOutputStream(nombreArchivo);
            objectOutputStream=new ObjectOutputStream((new BufferedOutputStream(fileOutputStream)));
            objectOutputStream.writeObject(moduloOperando);
            objectOutputStream.writeObject(exponente);

            // Ya se genero y se guardó en el proyecto.

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (objectOutputStream!=null){
                objectOutputStream.close();
                if(fileOutputStream!=null){
                    fileOutputStream.close();
                }
            }
        }
    }
    public byte[] encryptData(String data) throws IOException{


        System.out.println("Datos a encriptar (Deberia ser archivo y no string) "+ data);
        byte[] datosACifrar = data.getBytes("UTF-8");
        byte[] datosEncriptados = null;
        try{
            PublicKey llavePub =leerArchivoLlavePublica(this.Archivo_Llave_Publica);
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, llavePub);
            datosEncriptados= cipher.doFinal(datosACifrar);
            System.out.println("Los datos ya encriptados son:  "+ datosEncriptados);


        } catch (IOException | NoSuchAlgorithmException | NoSuchPaddingException |InvalidKeyException |BadPaddingException| IllegalBlockSizeException e){
            e.printStackTrace();
        }
        return datosEncriptados;

    }

    public PublicKey leerArchivoLlavePublica(String nombreArchivo) throws IOException {

        FileInputStream fileInputStream=null;
        ObjectInputStream objectInputStream =  null;
        try{
            fileInputStream=new FileInputStream(new File(nombreArchivo));
            objectInputStream= new ObjectInputStream(fileInputStream);
            BigInteger modulus =(BigInteger) objectInputStream.readObject();
            BigInteger exponent =(BigInteger) objectInputStream.readObject();
            //Trae la llave pública

            RSAPublicKeySpec rsaPublicKeySpec=new RSAPublicKeySpec(modulus,exponent);
            KeyFactory fact = KeyFactory.getInstance("RSA");
            PublicKey publicKey= fact.generatePublic(rsaPublicKeySpec);
            return publicKey;

        } catch (IOException|ClassNotFoundException|NoSuchAlgorithmException|InvalidKeySpecException e){
            e.printStackTrace();
        } finally {
            if (objectInputStream!=null){
                objectInputStream.close();
                if (fileInputStream!=null){
                    fileInputStream.close();
                }
            }
        }
        return null;
    }

    private void descifrarArchivo(byte[] data) throws IOException {

        byte[] datosDescifrados= null;

        try{
            PrivateKey privateKey = readPrivateKeyFromFile(this.Archivo_Llave_Privada);
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            datosDescifrados= cipher.doFinal(data);
            System.out.println("Los datos descifrados son: "+ new String(datosDescifrados));

        } catch(IOException| NoSuchAlgorithmException|NoSuchPaddingException|InvalidKeyException| BadPaddingException |IllegalBlockSizeException e){
            e.printStackTrace();
        }



    }

    public PrivateKey readPrivateKeyFromFile(String nombreArchivo) throws IOException{


        FileInputStream fileInputStream=null;
        ObjectInputStream objectInputStream =  null;

        try{
            fileInputStream= new FileInputStream(new File(nombreArchivo));
            objectInputStream= new ObjectInputStream(fileInputStream);
            BigInteger modulus =(BigInteger) objectInputStream.readObject();
            BigInteger exponent =(BigInteger) objectInputStream.readObject();
            //Get private key
            RSAPrivateKeySpec rsaPrivateKeySpec=new RSAPrivateKeySpec(modulus,exponent);
            KeyFactory fact = KeyFactory.getInstance("RSA");
            PrivateKey privateKey= fact.generatePrivate(rsaPrivateKeySpec);
            return privateKey;

        } catch (IOException|ClassNotFoundException|NoSuchAlgorithmException| InvalidKeySpecException e){
            e.printStackTrace();
        } finally {
            if (objectInputStream!=null){
                objectInputStream.close();
                if (fileInputStream!=null){
                    fileInputStream.close();
                }
            }
        }
        return null;

    }


}
