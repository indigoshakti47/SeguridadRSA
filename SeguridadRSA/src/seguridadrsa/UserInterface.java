package seguridadrsa;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInterface extends JFrame {
    private JTextField textField;
    private JTextArea textArea;
    private FileShare2 cifrado = new FileShare2();

    public UserInterface(){
        this.setSize(600,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Proyecto de cifrado");
        this.setLocationRelativeTo(this);
        getContentPane().setLayout(null);

        textField=new JTextField();
        textField.setBounds(10,50,400,20);
        getContentPane().add(textField);
        textField.setColumns(10);

        JButton btnG = new JButton("Cifrar mensaje");
        btnG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {


            }
        });
    }

}
