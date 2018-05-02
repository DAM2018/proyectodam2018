package com.reto2018;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
    public Usuario() {

        JFrame frame = new JFrame("Usuario");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);



        final DefaultComboBoxModel dcm=new DefaultComboBoxModel();

        dcm.addElement(0);
        dcm.addElement(1);
        dcm.addElement(2);
        dcm.addElement(3);
        dcm.addElement(4);
        dcm.addElement(5);
        dcm.addElement(6);
        dcm.addElement(7);
        dcm.addElement(8);
        dcm.addElement(9);
        dcm.addElement(10);
        dcm.addElement(11);
        dcm.addElement(12);
        dcm.addElement(13);
        dcm.addElement(14);

        comboBox1.setModel(dcm);


        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                List<Clasificacion> clasificacion = new ArrayList<Clasificacion>();


                Connection conexion = Conexion.conexion;

                Statement st = null;
                try {
                    st = conexion.createStatement();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

                String sql = "select equipo,sum(puntos),sum(ganados),sum(empatados),sum(perdidos) from clasificacion2 where " +
                        "jornada="+Integer.parseInt(dcm.getSelectedItem().toString())+
                        " or jornada="+(Integer.parseInt(dcm.getSelectedItem().toString())-1)+
                        " or jornada="+(Integer.parseInt(dcm.getSelectedItem().toString())-2)+
                        " or jornada="+(Integer.parseInt(dcm.getSelectedItem().toString())-3)+
                        " or jornada="+(Integer.parseInt(dcm.getSelectedItem().toString())-4)+
                        " or jornada="+(Integer.parseInt(dcm.getSelectedItem().toString())-5)+
                        " or jornada="+(Integer.parseInt(dcm.getSelectedItem().toString())-6)+
                        " or jornada="+(Integer.parseInt(dcm.getSelectedItem().toString())-7)+
                        " or jornada="+(Integer.parseInt(dcm.getSelectedItem().toString())-8)+
                        " or jornada="+(Integer.parseInt(dcm.getSelectedItem().toString())-9)+
                        " or jornada="+(Integer.parseInt(dcm.getSelectedItem().toString())-10)+
                        " or jornada="+(Integer.parseInt(dcm.getSelectedItem().toString())-11)+
                        " or jornada="+(Integer.parseInt(dcm.getSelectedItem().toString())-12)+
                        " or jornada="+(Integer.parseInt(dcm.getSelectedItem().toString())-13)+


                        " group by equipo order by sum(puntos) desc, equipo";

                ResultSet rs= null;
                try {
                    rs = st.executeQuery(sql);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

                try {
                    while(rs.next()){

                        clasificacion.add(new Clasificacion(
                                //    rs.getString(1),
                                rs.getString(1),
                                rs.getInt(2),
                                rs.getInt(3),
                                rs.getInt(4),
                                rs.getInt(5)));

                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

                try {

                    equipo1.setText(clasificacion.get(0).getEquipo());
                    equipo2.setText(clasificacion.get(1).getEquipo());
                    equipo3.setText(clasificacion.get(2).getEquipo());
                    equipo4.setText(clasificacion.get(3).getEquipo());
                    equipo5.setText(clasificacion.get(4).getEquipo());
                    equipo6.setText(clasificacion.get(5).getEquipo());
                    equipo7.setText(clasificacion.get(6).getEquipo());
                    equipo8.setText(clasificacion.get(7).getEquipo());

                    puntos1.setText(String.valueOf(clasificacion.get(0).getPuntos()));
                    puntos2.setText(String.valueOf(clasificacion.get(1).getPuntos()));
                    puntos3.setText(String.valueOf(clasificacion.get(2).getPuntos()));
                    puntos4.setText(String.valueOf(clasificacion.get(3).getPuntos()));
                    puntos5.setText(String.valueOf(clasificacion.get(4).getPuntos()));
                    puntos6.setText(String.valueOf(clasificacion.get(5).getPuntos()));
                    puntos7.setText(String.valueOf(clasificacion.get(6).getPuntos()));
                    puntos8.setText(String.valueOf(clasificacion.get(7).getPuntos()));

                    ganados1.setText(String.valueOf(clasificacion.get(0).getGanados()));
                    ganados2.setText(String.valueOf(clasificacion.get(1).getGanados()));
                    ganados3.setText(String.valueOf(clasificacion.get(2).getGanados()));
                    ganados4.setText(String.valueOf(clasificacion.get(3).getGanados()));
                    ganados5.setText(String.valueOf(clasificacion.get(4).getGanados()));
                    ganados6.setText(String.valueOf(clasificacion.get(5).getGanados()));
                    ganados7.setText(String.valueOf(clasificacion.get(6).getGanados()));
                    ganados8.setText(String.valueOf(clasificacion.get(7).getGanados()));

                    empatados1.setText(String.valueOf(clasificacion.get(0).getEmpatados()));
                    empatados2.setText(String.valueOf(clasificacion.get(1).getEmpatados()));
                    empatados3.setText(String.valueOf(clasificacion.get(2).getEmpatados()));
                    empatados4.setText(String.valueOf(clasificacion.get(3).getEmpatados()));
                    empatados5.setText(String.valueOf(clasificacion.get(4).getEmpatados()));
                    empatados6.setText(String.valueOf(clasificacion.get(5).getEmpatados()));
                    empatados7.setText(String.valueOf(clasificacion.get(6).getEmpatados()));
                    empatados8.setText(String.valueOf(clasificacion.get(7).getEmpatados()));

                    perdidos1.setText(String.valueOf(clasificacion.get(0).getPerdidos()));
                    perdidos2.setText(String.valueOf(clasificacion.get(1).getPerdidos()));
                    perdidos3.setText(String.valueOf(clasificacion.get(2).getPerdidos()));
                    perdidos4.setText(String.valueOf(clasificacion.get(3).getPerdidos()));
                    perdidos5.setText(String.valueOf(clasificacion.get(4).getPerdidos()));
                    perdidos6.setText(String.valueOf(clasificacion.get(5).getPerdidos()));
                    perdidos7.setText(String.valueOf(clasificacion.get(6).getPerdidos()));
                    perdidos8.setText(String.valueOf(clasificacion.get(7).getPerdidos()));

                    clasificacion.clear();

                }catch (java.lang.IndexOutOfBoundsException e1) {

                    }
            }
        });
    }

    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JComboBox comboBox1;
    private JLabel equipo1;
    private JLabel equipo2;
    private JLabel equipo4;
    private JLabel equipo5;
    private JLabel equipo6;
    private JLabel equipo3;
    private JLabel equipo7;
    private JLabel equipo8;
    private JLabel puntos1;
    private JLabel puntos2;
    private JLabel puntos3;
    private JLabel puntos4;
    private JLabel puntos5;
    private JLabel puntos6;
    private JLabel puntos7;
    private JLabel puntos8;
    private JLabel ganados1;
    private JLabel ganados2;
    private JLabel ganados3;
    private JLabel ganados4;
    private JLabel ganados5;
    private JLabel ganados6;
    private JLabel ganados7;
    private JLabel ganados8;
    private JLabel empatados1;
    private JLabel empatados2;
    private JLabel empatados3;
    private JLabel empatados4;
    private JLabel empatados5;
    private JLabel empatados6;
    private JLabel empatados7;
    private JLabel empatados8;
    private JLabel perdidos1;
    private JLabel perdidos2;
    private JLabel perdidos3;
    private JLabel perdidos4;
    private JLabel perdidos5;
    private JLabel perdidos6;
    private JLabel perdidos7;
    private JLabel perdidos8;
}
