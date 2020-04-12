package seguridadrsa;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
import javax.swing.JFileChooser;

public class WebSocket {

    /**
     * Stores the main class where the graphic interface is being executed
     */
    FileShare main;
    /**
     * Class that establish a connection between two instances of the same program
     * @param main 
     * @throws IOException 
     */
    public WebSocket(FileShare main) throws IOException {
        this.main = main;
    }

    /**
     * Creates a connection between two instances of a this program, and sends a file chosen by the user.
     * this should be called after the second instance is succesfully waiting for the file.
     * the used port to communicate is 3000
     * @param ip it corresponds to the IP direction of the destiny
     * @throws IOException 
     */
    public void Server(String ip) throws IOException {

        Socket socket = new Socket(ip, 3000);

        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(main);
        File file = chooser.getSelectedFile();

        File transferFile = new File(file.getAbsolutePath());
        byte[] bytearray = new byte[(int) transferFile.length()];
        FileInputStream fin = new FileInputStream(transferFile);
        BufferedInputStream bin = new BufferedInputStream(fin);
        bin.read(bytearray, 0, bytearray.length);
        OutputStream os = socket.getOutputStream();
        System.out.println("Sending Files...");
        os.write(bytearray, 0, bytearray.length);
        os.flush();
        socket.close();
        System.out.println("File transfer complete");

    }

    /**
     * Makes the program to listen for an incomming connection to recieve a file and asks the user where to store it.
     * the used port is 3000
     * @throws IOException 
     */
    public void Client() throws IOException {

        int filesize = 1022386;
        int bytesRead;
        int currentTot = 0;

        ServerSocket serverSocket = new ServerSocket(3000);
        Socket socket = serverSocket.accept();
        System.out.println("Accepted connection : " + socket);

        byte[] bytearray = new byte[filesize];
        InputStream is = socket.getInputStream();

        JFileChooser chooser = new JFileChooser();
        int retval = chooser.showSaveDialog(null);
        if (retval == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            if (file == null) {
                return;
            }
            try {
                FileOutputStream fos = new FileOutputStream(file);
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                bytesRead = is.read(bytearray, 0, bytearray.length);
                currentTot = bytesRead;

                do {
                    bytesRead
                            = is.read(bytearray, currentTot, (bytearray.length - currentTot));
                    if (bytesRead >= 0) {
                        currentTot += bytesRead;
                    }
                } while (bytesRead > -1);

                bos.write(bytearray, 0, currentTot);
                bos.flush();
                bos.close();
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
