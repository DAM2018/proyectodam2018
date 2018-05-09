package com.reto2018;

import oracle.jdbc.internal.OracleTypes;
import org.jfree.chart.ChartColor;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.axis.TickUnits;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.RangeType;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;


import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.*;
import java.net.URL;
import java.sql.*;
import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.List;

public class Usuario implements Serializable {
    public Usuario() throws IOException, UnsupportedFlavorException {

        JFrame frame = new JFrame("Usuario");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


        bienvenida.setText(Inicio.getLogin().getNombresUsuarios().get(Inicio.getLogin().getUs() - 1));

        final DefaultComboBoxModel dcm = new DefaultComboBoxModel();

        //dcm.addElement(0);
        //dcm.addElement("");
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
        dcm.setSelectedItem("");


        final DefaultComboBoxModel dcm2 = new DefaultComboBoxModel();

        //dcm2.addElement(0);
        dcm2.addElement(1);
        dcm2.addElement(2);
        dcm2.addElement(3);
        dcm2.addElement(4);
        dcm2.addElement(5);
        dcm2.addElement(6);
        dcm2.addElement(7);
        dcm2.addElement(8);
        dcm2.addElement(9);
        dcm2.addElement(10);
        dcm2.addElement(11);
        dcm2.addElement(12);
        dcm2.addElement(13);
        dcm2.addElement(14);

        comboBox2.setModel(dcm2);
        dcm2.setSelectedItem("");

        try {
            Connection conexion = Conexion.conexion;

            String sql3 = "{call calendario.verEquipos(?)}";

            CallableStatement callableStatement3 = conexion.prepareCall(sql3);

            callableStatement3.registerOutParameter(1, OracleTypes.CURSOR);

            callableStatement3.executeUpdate();

            ResultSet rs = (ResultSet) callableStatement3.getObject(1);
            listaEquipos = new ArrayList<String>();
            while (rs.next()) {
                String nombreequi = rs.getString("nombreequi");

                listaEquipos.add(nombreequi);


            }
        } catch (SQLException e2) {

            //System.out.println(e2.getMessage());

        } catch (java.lang.NullPointerException e2) {


        } catch (java.lang.IndexOutOfBoundsException e2) {


        }

        comboBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                res1.setText("");
                res2.setText("");
                fecha1.setText("");
                res3.setText("");
                res4.setText("");
                fecha2.setText("");
                res5.setText("");
                res6.setText("");
                fecha3.setText("");
                res7.setText("");
                res8.setText("");
                fecha4.setText("");


                try {

                    Connection conexion = Conexion.conexion;
                    ResultSet rs;
                    String sql = "{call calendario.crearCalendario(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

                    CallableStatement callableStatement = conexion.prepareCall(sql);


                    callableStatement.setString(1, listaEquipos.get(0));
                    callableStatement.setString(2, listaEquipos.get(1));
                    callableStatement.setString(3, listaEquipos.get(2));
                    callableStatement.setString(4, listaEquipos.get(3));
                    callableStatement.setString(5, listaEquipos.get(4));
                    callableStatement.setString(6, listaEquipos.get(5));
                    callableStatement.setString(7, listaEquipos.get(6));
                    callableStatement.setString(8, listaEquipos.get(7));
                    callableStatement.setInt(9, Integer.parseInt(dcm2.getSelectedItem().toString()));


                    callableStatement.registerOutParameter(10, java.sql.Types.VARCHAR);
                    callableStatement.registerOutParameter(11, java.sql.Types.VARCHAR);
                    callableStatement.registerOutParameter(12, java.sql.Types.VARCHAR);
                    callableStatement.registerOutParameter(13, java.sql.Types.VARCHAR);
                    callableStatement.registerOutParameter(14, java.sql.Types.VARCHAR);
                    callableStatement.registerOutParameter(15, java.sql.Types.VARCHAR);
                    callableStatement.registerOutParameter(16, java.sql.Types.VARCHAR);
                    callableStatement.registerOutParameter(17, java.sql.Types.VARCHAR);

                    callableStatement.executeUpdate();

                    eq1.setText(callableStatement.getString(10));
                    eq2.setText(callableStatement.getString(11));
                    eq3.setText(callableStatement.getString(12));
                    eq4.setText(callableStatement.getString(13));
                    eq5.setText(callableStatement.getString(14));
                    eq6.setText(callableStatement.getString(15));
                    eq7.setText(callableStatement.getString(16));
                    eq8.setText(callableStatement.getString(17));

                    String sql2 = "{call calendario.verResultados(?,?)}";

                    CallableStatement callableStatement2 = conexion.prepareCall(sql2);
                    int j = Integer.parseInt(dcm2.getSelectedItem().toString());

                    callableStatement2.setInt(1, j);
                    callableStatement2.registerOutParameter(2, OracleTypes.CURSOR);

                    callableStatement2.executeUpdate();
                    rs = (ResultSet) callableStatement2.getObject(2);

                    List<Resultado> resultados = new ArrayList<Resultado>();

                    while (rs.next()) {
                        int resultado1 = rs.getInt("resultado1");
                        int resultado2 = rs.getInt("resultado2");
                        String fecha = rs.getString("fecha");

                        resultados.add(new Resultado(resultado1, resultado2, fecha));


                    }
                    res1.setText(String.valueOf(resultados.get(0).getResultado1()));
                    res2.setText(String.valueOf(resultados.get(0).getResultado2()));
                    fecha1.setText(String.valueOf(resultados.get(0).getFecha()));
                    res3.setText(String.valueOf(resultados.get(1).getResultado1()));
                    res4.setText(String.valueOf(resultados.get(1).getResultado2()));
                    fecha2.setText(String.valueOf(resultados.get(1).getFecha()));
                    res5.setText(String.valueOf(resultados.get(2).getResultado1()));
                    res6.setText(String.valueOf(resultados.get(2).getResultado2()));
                    fecha3.setText(String.valueOf(resultados.get(2).getFecha()));
                    res7.setText(String.valueOf(resultados.get(3).getResultado1()));
                    res8.setText(String.valueOf(resultados.get(3).getResultado2()));
                    fecha4.setText(String.valueOf(resultados.get(3).getFecha()));

                    resultados.clear();
                } catch (SQLException e2) {

                    //System.out.println(e2.getMessage());

                } catch (java.lang.NullPointerException e2) {


                } catch (java.lang.IndexOutOfBoundsException e2) {


                }
            }
        });


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
                        "jornada=" + Integer.parseInt(dcm.getSelectedItem().toString()) +
                        " or jornada=" + (Integer.parseInt(dcm.getSelectedItem().toString()) - 1) +
                        " or jornada=" + (Integer.parseInt(dcm.getSelectedItem().toString()) - 2) +
                        " or jornada=" + (Integer.parseInt(dcm.getSelectedItem().toString()) - 3) +
                        " or jornada=" + (Integer.parseInt(dcm.getSelectedItem().toString()) - 4) +
                        " or jornada=" + (Integer.parseInt(dcm.getSelectedItem().toString()) - 5) +
                        " or jornada=" + (Integer.parseInt(dcm.getSelectedItem().toString()) - 6) +
                        " or jornada=" + (Integer.parseInt(dcm.getSelectedItem().toString()) - 7) +
                        " or jornada=" + (Integer.parseInt(dcm.getSelectedItem().toString()) - 8) +
                        " or jornada=" + (Integer.parseInt(dcm.getSelectedItem().toString()) - 9) +
                        " or jornada=" + (Integer.parseInt(dcm.getSelectedItem().toString()) - 10) +
                        " or jornada=" + (Integer.parseInt(dcm.getSelectedItem().toString()) - 11) +
                        " or jornada=" + (Integer.parseInt(dcm.getSelectedItem().toString()) - 12) +
                        " or jornada=" + (Integer.parseInt(dcm.getSelectedItem().toString()) - 13) +


                        " group by equipo order by sum(puntos) desc, equipo";

                ResultSet rs = null;
                try {
                    rs = st.executeQuery(sql);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

                try {
                    while (rs.next()) {

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

                } catch (java.lang.IndexOutOfBoundsException e1) {

                }
            }
        });


        final DefaultComboBoxModel dcm3 = new DefaultComboBoxModel();
        dcm3.addElement(listaEquipos.get(0));
        dcm3.addElement(listaEquipos.get(1));
        dcm3.addElement(listaEquipos.get(2));
        dcm3.addElement(listaEquipos.get(3));
        dcm3.addElement(listaEquipos.get(4));
        dcm3.addElement(listaEquipos.get(5));
        dcm3.addElement(listaEquipos.get(6));
        dcm3.addElement(listaEquipos.get(7));

        comboBox4.setModel(dcm3);
        dcm3.setSelectedItem("");

        comboBox4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                jugador1.setText("");
                jugador2.setText("");
                jugador3.setText("");
                jugador4.setText("");
                jugador5.setText("");
                jugador6.setText("");
                equi.setText(dcm3.getSelectedItem().toString());
                List<String> jugadores = new ArrayList<String>();

                Connection conexion = Conexion.conexion;

                Statement st = null;
                try {
                    st = conexion.createStatement();

                    String sql = "select nick from jugador where CodigoEquiJug='" + dcm3.getSelectedItem().toString() + "'";

                    ResultSet rs = st.executeQuery(sql);

                    while (rs.next()) {

                        jugadores.add(rs.getString("nick"));

                    }

                    jugador1.setText(jugadores.get(0));
                    jugador2.setText(jugadores.get(1));
                    jugador3.setText(jugadores.get(2));
                    jugador4.setText(jugadores.get(3));
                    jugador5.setText(jugadores.get(4));
                    jugador6.setText(jugadores.get(5));


                } catch (SQLException e1) {
                    e1.printStackTrace();
                } catch (java.lang.IndexOutOfBoundsException e1) {
                    // e1.printStackTrace();
                }

            }
        });


        final DefaultComboBoxModel dcm4 = new DefaultComboBoxModel();
        dcm4.addElement(listaEquipos.get(0));
        dcm4.addElement(listaEquipos.get(1));
        dcm4.addElement(listaEquipos.get(2));
        dcm4.addElement(listaEquipos.get(3));
        dcm4.addElement(listaEquipos.get(4));
        dcm4.addElement(listaEquipos.get(5));
        dcm4.addElement(listaEquipos.get(6));
        dcm4.addElement(listaEquipos.get(7));
        comboBox3.setModel(dcm4);
        dcm4.setSelectedItem("");

        comboBox3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                Connection conexion = Conexion.conexion;

                Statement st = null;
                try {
                    st = conexion.createStatement();

                    String sql = "select nombreequi,fundacion,ciudad,estadio,capacidad,titulos from equipo where nombreequi='" + dcm4.getSelectedItem().toString() + "'";

                    ResultSet rs = st.executeQuery(sql);

                    while (rs.next()) {

                        nombreEquipo.setText(rs.getString("nombreequi"));
                        fundacion.setText(String.valueOf(rs.getInt("fundacion")));
                        ciudad.setText(rs.getString("ciudad"));
                        estadio.setText(rs.getString("estadio"));
                        capacidad.setText(String.valueOf(rs.getInt("capacidad")));
                        titulos.setText(String.valueOf(rs.getInt("titulos")));

                    }

                    st = null;

                    st = conexion.createStatement();

                    sql = "select nombredue,nombre,edad,profesion from dueño where equidue='" + dcm4.getSelectedItem().toString() + "'";

                    rs = st.executeQuery(sql);

                    while (rs.next()) {

                        nombreDueño.setText(rs.getString("nombredue"));
                        nombre.setText(rs.getString("nombre"));
                        edad.setText(String.valueOf(rs.getInt("edad")));
                        profesion.setText(rs.getString("profesion"));


                    }


                } catch (SQLException e1) {
                    e1.printStackTrace();
                } catch (java.lang.IndexOutOfBoundsException e1) {
                    // e1.printStackTrace();
                }


            }
        });
        cambiarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);


                try {
                    Connection conexion = Conexion.conexion;

                    if (new String(passwordField1.getPassword()).equals(new String(passwordField2.getPassword())) &&
                            textField1.getText().equals(textField2.getText())) {

                        String sql = "update usuarios set nombre=?,password2=? where email=?";


                        PreparedStatement st;

                        st = conexion.prepareStatement(sql);
                        st.setString(1, textField1.getText());
                        st.setString(2, new String(passwordField1.getPassword()));
                        st.setString(3, Inicio.getLogin().getEmails().get(Inicio.getLogin().getUs() - 1));


                        st.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Cambiado con exito!!", "Cambiar", JOptionPane.OK_OPTION);

                    }

                } catch (SQLException e1) {
                    // e1.printStackTrace();
                } catch (java.lang.NumberFormatException e1) {
                    //e1.printStackTrace();
                }


            }
        });

        grafico.setLayout(new BorderLayout());
        Grafico g = new Grafico();
        grafico.add(g.getCp(), BorderLayout.CENTER);
        grafico.validate();
        //BufferedImage originalImage = g.getChart().createBufferedImage(500, 300);
        //gr.setIcon(new ImageIcon(originalImage));
        //URL imageUrl = ClassLoader.getSystemResource(originalImage)
        // g.getCp().doCopy();
        //Transferable t = clipboard.getContents(DataFlavor.imageFlavor );
        // Object o = t.getTransferData( DataFlavor.imageFlavor );



/*
       Transferable t = Toolkit.getDefaultToolkit().getSystemClipboard()
                .getContents(null);

        //grafico.add(t.getTransferData(DataFlavor.allHtmlFlavor), BorderLayout.CENTER);


        if (t != null && t.isDataFlavorSupported(DataFlavor.imageFlavor)) {
            Image img = (Image) t.getTransferData(DataFlavor.imageFlavor);

            gr.setIcon(new ImageIcon(img));

        }*/
        // CopyChartPanel ccp=new C


        /*Image objBufferedImage = g.getCp().createImage(500,500);
        ByteArrayOutputStream bas = new ByteArrayOutputStream();
        try {
            ImageIO.write(objBufferedImage, "png", bas);
        } catch (IOException e) {
            e.printStackTrace();
        }

        byte[] byteArray=bas.toByteArray();

        InputStream in = new ByteArrayInputStream(byteArray);
        BufferedImage image = ImageIO.read(in);
        Graphics graphics = g.getCp().getGraphics();
        ImageIcon iconQuit = new ImageIcon();*/
        // grafico.add(graphics, BorderLayout.CENTER);

      /*  System.out.println(g.getCp().getChart().createBufferedImage(500, 500));

       *//* File outputfile = new File("image.png");
        ImageIO.write(image, "png", outputfile);
*//*
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//Object o=clipboard.getData(DataFlavor.imageFlavor);
//Transferable t=clipboard.getContents(o);
        //      Image result = (Image) t.getTransferData(DataFlavor.imageFlavor);


        //java.io.Reader r = (java.io.Reader) t.getTransferData(DataFlavor.imageFlavor);


        //       Image image = (Image)t.getTransferData(DataFlavor.imageFlavor);

        BufferedImage buffered = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB);

        //       buffered.getGraphics().drawImage(image, 0, 0 , null);
        ImageIO.write(buffered, "jpg", new File("./out3.jpg"));

        File f = new File("./out3.jpg");
        BufferedImage b = ImageIO.read(f);

        gr.setIcon(new ImageIcon(buffered));
*/

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
    private JPanel grafico;
    private JComboBox comboBox2;
    private JLabel resultado1;
    private JLabel res1;
    private JLabel eq1;
    private JLabel eq3;
    private JLabel eq2;
    private JLabel eq4;
    private JLabel eq5;
    private JLabel eq6;
    private JLabel eq7;
    private JLabel eq8;
    private JLabel res2;
    private JLabel res3;
    private JLabel res4;
    private JLabel res5;
    private JLabel res6;
    private JLabel res7;
    private JLabel res8;
    private JLabel fecha1;
    private JLabel fecha2;
    private JLabel fecha3;
    private JLabel fecha4;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JLabel jugador1;
    private JLabel jugador2;
    private JLabel jugador3;
    private JLabel jugador4;
    private JLabel jugador5;
    private JLabel jugador6;
    private JLabel equi;
    private JLabel bienvenida;
    private JLabel nombreEquipo;
    private JLabel nombreDueño;
    private JLabel fundacion;
    private JLabel ciudad;
    private JLabel estadio;
    private JLabel capacidad;
    private JLabel titulos;
    private JLabel nombre;
    private JLabel edad;
    private JLabel profesion;
    private JTextField textField1;
    private JTextField textField2;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JButton cambiarButton;
    private List<String> listaEquipos;

    public JPanel getGrafico() {
        return grafico;
    }

    public void setGrafico(JPanel grafico) {
        this.grafico = grafico;
    }


}
