package com.reto2018;

import org.jasypt.util.text.StrongTextEncryptor;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SuperUsuario {


    public SuperUsuario() {
        JFrame frame = new JFrame("SuperUsuario");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        DefaultListModel modelList1 = new DefaultListModel();
        list1.setModel(modelList1);
        DefaultListModel modelList2 = new DefaultListModel();


        try {
            StrongTextEncryptor textEncryptor = new StrongTextEncryptor();
            textEncryptor.setPassword("pass");

            BufferedReader in = new BufferedReader(new FileReader("src/passwords.txt"));
            BufferedReader in2 = new BufferedReader(new FileReader("src/usuarios.txt"));
            BufferedReader in3 = new BufferedReader(new FileReader("src/nombre.txt"));

            String line;
            String line2;
            String line3;



            List<String> nombre = new ArrayList<String>();

            String[][] matriz = new String[100][3];

            String plainText;
            int i = 0;
            while ((line = in.readLine()) != null) {
                plainText = textEncryptor.decrypt(line);
                matriz[i][0] = plainText;
                i++;
            }
            in.close();
            i=0;
            while ((line2 = in2.readLine()) != null) {
                plainText = textEncryptor.decrypt(line2);
                matriz[i][1] = plainText;
                i++;
            }
            in2.close();
            i=0;
            while ((line3 = in3.readLine()) != null) {
                //plainText = textEncryptor.decrypt(line3);
                nombre.add(line3);
                matriz[i][2] = line3;
                i++;
            }
            in3.close();

            for (int j = 0; j < nombre.size(); j++) {
                modelList1.add(j, Arrays.asList(matriz[j]));


            }

        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }


    }

    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JList list1;
    private JList list2;
    private JList list3;
}
