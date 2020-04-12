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

    FileShare main;

    public WebSocket(FileShare main) throws IOException {
        this.main = main;
    }

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
