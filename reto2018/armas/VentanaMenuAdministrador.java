package jose.armas;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class VentanaMenuAdministrador {
    private JPanel contenedorPrincipal;
    private JPanel contenedorCrud;
    private JButton jugadoresButton;
    private JButton equiposButton;
    private JButton duenyosButton;
    private JButton usuariosButton;
    private JTabbedPane tabbedCalendarResults;
    private JPanel calendar;
    private JPanel results;
    private JPanel contenedor1ªvuelta;
    private JPanel conteJornada1;
    private JLabel partido1;
    private JLabel partido2;
    private JLabel partido3;
    private JLabel partido4;
    private JPanel contenedorJornada2;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JPanel contenedorJornada3;
    private JLabel l1;
    private JLabel l2;
    private JLabel l3;
    private JLabel l4;
    private JPanel contenedorJornada4;
    private JLabel p1;
    private JLabel p2;
    private JLabel p3;
    private JLabel p4;
    private JPanel contenedorJornada5;
    private JLabel la1;
    private JLabel la2;
    private JLabel la3;
    private JLabel la4;
    private JPanel contenedorJornada6;
    private JLabel lab1;
    private JLabel lab2;
    private JLabel lab3;
    private JLabel lab4;
    private JPanel contenedorJornada7;
    private JLabel labe1;
    private JLabel labe2;
    private JLabel labe3;
    private JLabel labe4;
    private JPanel contendor2ªvuelta;
    private JLabel encuentro1;
    private JLabel encuentro2;
    private JLabel encuentro3;
    private JLabel encuentro4;
    private JLabel part1;
    private JLabel past2;
    private JLabel part3;
    private JLabel past4;
    private JLabel enc1;
    private JLabel enc2;
    private JLabel enc3;
    private JLabel enc4;
    private JLabel match1;
    private JLabel match2;
    private JLabel match3;
    private JLabel match4;
    private JLabel mat1;
    private JLabel mat2;
    private JLabel mat3;
    private JLabel m1;
    private JLabel m2;
    private JLabel m3;
    private JLabel m4;
    private JLabel ma1;
    private JLabel mac4;
    private JLabel mac3;
    private JLabel mac2;
    private JButton generarCalendarioButton;
    private JPanel jornada8;
    private JPanel jornada9;
    private JPanel jornada10;
    private JPanel jornada11;
    private JPanel jornada12;
    private JLabel mat4;
    private JPanel jornada13;
    private JPanel jornada14;
    private JComboBox comboBoxJornadas;
    private JButton volverButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JLabel partido1Label;
    private JLabel partido2label;
    private JLabel partido3label;
    private JLabel partido4label;
    private JPanel contendorCombobox;
    private JButton introducirResultadosButton;
    private JPanel jornada;

    //Asociaciones.
    private VentanaUsuarioContrasenya ventanaUsuarioContrasenya;
    private VentanaCrudJugadores ventanaCrudJugadores;
    private VentanaCrudEquipos ventanaCrudEquipos;
    private VentanaCrudDuenyo ventanaCrudDuenyo;
    private VentanaUsuario ventanaUsuario;
    private Jornada jornadaDeLiga;

    VentanaUsuarioContrasenya windowUserpassword;
    VentanaMenuAdministrador windowMenuAdmon;
    VentanaMenuAdministrador ventanaCrudUser;

    public VentanaMenuAdministrador(VentanaUsuarioContrasenya vUc) {

        windowUserpassword = vUc;

        windowMenuAdmon = this;
        ventanaCrudUser = this;


        JFrame frame = new JFrame("VentanaMenuAdminstrador");
        frame.setContentPane(contenedorPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


        jugadoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ventanaCrudJugadores = new VentanaCrudJugadores(windowMenuAdmon);

            }
        });

        equiposButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaCrudEquipos = new VentanaCrudEquipos(windowMenuAdmon);
            }
        });


        duenyosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ventanaCrudDuenyo = new VentanaCrudDuenyo(windowMenuAdmon);

            }
        });
        usuariosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ventanaUsuario = new VentanaUsuario(ventanaCrudUser);

            }
        });
        generarCalendarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                List<Equipo> equipos = EquiposBd.equiposDeLaBD();

                generarCalendario(8, equipos);

            }
        });

        DefaultComboBoxModel<String> jornadaDefaultComboBoxModel = new DefaultComboBoxModel<>();


        List <Equipo> equipoList = EquiposBd.equiposDeLaBD();

        for (int i = 0; i < 14; i++) {
            String jornada = (String)"Jornada "+(i+1);
            jornadaDefaultComboBoxModel.insertElementAt(jornada,i);
        }

        comboBoxJornadas.setModel(jornadaDefaultComboBoxModel);


        comboBoxJornadas.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String [][] primeraVuelta = generarEmparejamientosPrimeraVuelta(equipoList);
                String [][]segundaVuelta = generarEmparejamientosSegundaVuelta(equipoList);
               int index = comboBoxJornadas.getSelectedIndex();
                switch (index){
                    case 0:
                        for (int i = 0; i < 4; i++) {
                            switch (i){
                                case 0:
                                    partido1Label.setText(primeraVuelta[0][i]);
                                    break;
                                case 1:
                                    partido2label.setText(primeraVuelta[0][i]);
                                    break;
                                case 2:
                                    partido3label.setText(primeraVuelta[0][i]);
                                    break;
                                case 3:
                                    partido4label.setText(primeraVuelta[0][i]);
                                    break;
                            }
                        }
                        break;
                    case 1:
                        for (int i = 0; i < 4; i++) {
                            switch (i){
                                case 0:
                                    partido1Label.setText(primeraVuelta[1][i]);
                                    break;
                                case 1:
                                    partido2label.setText(primeraVuelta[1][i]);
                                    break;
                                case 2:
                                    partido3label.setText(primeraVuelta[1][i]);
                                    break;
                                case 3:
                                    partido4label.setText(primeraVuelta[1][i]);
                                    break;
                            }

                        }
                        break;
                    case 2:
                        for (int i = 0; i < 4; i++) {
                            switch (i){
                                case 0:
                                    partido1Label.setText(primeraVuelta[2][i]);
                                    break;
                                case 1:
                                    partido2label.setText(primeraVuelta[2][i]);
                                    break;
                                case 2:
                                    partido3label.setText(primeraVuelta[2][i]);
                                    break;
                                case 3:
                                    partido4label.setText(primeraVuelta[2][i]);
                                    break;
                            }
                        }
                        break;
                    case 3:
                        for (int i = 0; i < 4; i++) {
                            switch (i){
                                case 0:
                                    partido1Label.setText(primeraVuelta[3][i]);
                                    break;
                                case 1:
                                    partido2label.setText(primeraVuelta[3][i]);
                                    break;
                                case 2:
                                    partido3label.setText(primeraVuelta[3][i]);
                                    break;
                                case 3:
                                    partido4label.setText(primeraVuelta[3][i]);
                                    break;
                            }
                        }
                        break;
                    case 4:
                        for (int i = 0; i < 4; i++) {
                            switch (i){
                                case 0:
                                    partido1Label.setText(primeraVuelta[4][i]);
                                    break;
                                case 1:
                                    partido2label.setText(primeraVuelta[4][i]);
                                    break;
                                case 2:
                                    partido3label.setText(primeraVuelta[4][i]);
                                    break;
                                case 3:
                                    partido4label.setText(primeraVuelta[4][i]);
                                    break;
                            }
                        }
                        break;
                    case 5:
                        for (int i = 0; i < 4; i++) {
                            switch (i){
                                case 0:
                                    partido1Label.setText(primeraVuelta[5][i]);
                                    break;
                                case 1:
                                    partido2label.setText(primeraVuelta[5][i]);
                                    break;
                                case 2:
                                    partido3label.setText(primeraVuelta[5][i]);
                                    break;
                                case 3:
                                    partido4label.setText(primeraVuelta[5][i]);
                                    break;
                            }
                        }
                        break;
                    case 6:
                        for (int i = 0; i < 4; i++) {
                            switch (i){
                                case 0:
                                    partido1Label.setText(primeraVuelta[6][i]);
                                    break;
                                case 1:
                                    partido2label.setText(primeraVuelta[6][i]);
                                    break;
                                case 2:
                                    partido3label.setText(primeraVuelta[6][i]);
                                    break;
                                case 3:
                                    partido4label.setText(primeraVuelta[6][i]);
                                    break;
                            }

                        }

                        break;

                    case 7:
                        for (int i = 0; i < 4; i++) {
                            switch (i){
                                case 0:
                                    partido1Label.setText(segundaVuelta[0][i]);
                                    break;
                                case 1:
                                    partido2label.setText(segundaVuelta[0][i]);
                                    break;
                                case 2:
                                    partido3label.setText(segundaVuelta[0][i]);
                                    break;
                                case 3:
                                    partido4label.setText(segundaVuelta[0][i]);
                                    break;
                            }
                        }
                        break;
                    case 8:
                        for (int i = 0; i < 4; i++) {
                            switch (i){
                                case 0:
                                    partido1Label.setText(segundaVuelta[1][i]);
                                    break;
                                case 1:
                                    partido2label.setText(segundaVuelta[1][i]);
                                    break;
                                case 2:
                                    partido3label.setText(segundaVuelta[1][i]);
                                    break;
                                case 3:
                                    partido4label.setText(segundaVuelta[1][i]);
                                    break;
                            }

                        }
                        break;
                    case 9:
                        for (int i = 0; i < 4; i++) {
                            switch (i){
                                case 0:
                                    partido1Label.setText(segundaVuelta[2][i]);
                                    break;
                                case 1:
                                    partido2label.setText(segundaVuelta[2][i]);
                                    break;
                                case 2:
                                    partido3label.setText(segundaVuelta[2][i]);
                                    break;
                                case 3:
                                    partido4label.setText(segundaVuelta[2][i]);
                                    break;
                            }
                        }
                        break;
                    case 10:
                        for (int i = 0; i < 4; i++) {
                            switch (i){
                                case 0:
                                    partido1Label.setText(segundaVuelta[3][i]);
                                    break;
                                case 1:
                                    partido2label.setText(segundaVuelta[3][i]);
                                    break;
                                case 2:
                                    partido3label.setText(segundaVuelta[3][i]);
                                    break;
                                case 3:
                                    partido4label.setText(segundaVuelta[3][i]);
                                    break;
                            }
                        }
                        break;
                    case 11:
                        for (int i = 0; i < 4; i++) {
                            switch (i){
                                case 0:
                                    partido1Label.setText(segundaVuelta[4][i]);
                                    break;
                                case 1:
                                    partido2label.setText(segundaVuelta[4][i]);
                                    break;
                                case 2:
                                    partido3label.setText(segundaVuelta[4][i]);
                                    break;
                                case 3:
                                    partido4label.setText(segundaVuelta[4][i]);
                                    break;
                            }
                        }
                        break;
                    case 12:
                        for (int i = 0; i < 4; i++) {
                            switch (i){
                                case 0:
                                    partido1Label.setText(segundaVuelta[5][i]);
                                    break;
                                case 1:
                                    partido2label.setText(segundaVuelta[5][i]);
                                    break;
                                case 2:
                                    partido3label.setText(segundaVuelta[5][i]);
                                    break;
                                case 3:
                                    partido4label.setText(segundaVuelta[5][i]);
                                    break;
                            }
                        }
                        break;
                    case 13:
                        for (int i = 0; i < 4; i++) {
                            switch (i){
                                case 0:
                                    partido1Label.setText(segundaVuelta[6][i]);
                                    break;
                                case 1:
                                    partido2label.setText(segundaVuelta[6][i]);
                                    break;
                                case 2:
                                    partido3label.setText(segundaVuelta[6][i]);
                                    break;
                                case 3:
                                    partido4label.setText(segundaVuelta[6][i]);
                                    break;
                            }
                        }
                        break;
                }
            }
        });


        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frame.dispose();

            }
        });

        DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>();
        modelo.insertElementAt("hola", 0);
        comboBoxJornadas.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);

                String texto = (String) comboBoxJornadas.getItemAt(0);

                textField1.setText(texto
                );
            }
        });
        introducirResultadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{
                    int numeroJOrnada = comboBoxJornadas.getSelectedIndex();
                }catch (NullPointerException n){

                }



                Equipo equipo = new Equipo();
                Partido partido = new Partido();



                List<Equipo>listadeEquipos = EquiposBd.equiposDeLaBD();
                List<Partido>partidoList = new ArrayList<>();

                partidoList = equipo.getPartidos();




                for (int i = 0; i < 14; i++) {
                    for (int j = 0; j < 4; j++) {

                    }
                }


                //Recojo datos del partido.
                String date = null;
                String resultado = textField1.getText()+textField2.getText();
                String [] equipos = label1.getText().split(" vs ");
                String local = equipos[0];
                String visitante = equipos[1];
                String codPartido = Integer.toString(1);
                String codLocal =null;
                String codVisitante=null;




                for (Equipo equipe:listadeEquipos) {
                    if (equipo.getNombre().equalsIgnoreCase(local)) {
                        codLocal=equipe.getCodigo();
                    }
                    if (equipo.getNombre().equalsIgnoreCase(visitante)) {

                        codVisitante=equipe.getCodigo();
                    }
                }








            }
        });
    }


    /**
     * @param N      es el número de equipos que van formar parte.
     * @param clubes que se pasa para confeccionar los emparejamientos.
     * @method que se encarga de generar el calendario de liga.
     */
    public void generarCalendario(int N, List<Equipo> clubes) {

        String[] equipos;
        String[][] matriz1, matriz2, jornadas, jornadas2;

        equipos = new String[N];

        //Relleno el array de equipos.
        int contador = 0;

        for (Equipo e : clubes) {
            if (contador < N) {
                equipos[contador] = e.getNombre();
                contador++;
            }
        }

        matriz1 = new String[N - 1][N / 2];
        matriz2 = new String[N - 1][N / 2];
        jornadas = new String[N - 1][N / 2]; //primera vuelta
        jornadas2 = new String[N - 1][N / 2]; //segunda vuelta

        //Relleno las matrices

        int cont = 0;
        int cont2 = N - 2;

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N / 2; j++) {
                //matriz1
                matriz1[i][j] = String.valueOf(equipos[cont]);
                cont++;
                if (cont == (N - 1)) cont = 0;

                //matriz2
                if (j == 0) matriz2[i][j] = String.valueOf(equipos[N - 1]);
                else {
                    matriz2[i][j] = String.valueOf(equipos[cont2]);
                    cont2--;
                    if (cont2 == -1) cont2 = N - 2;
                }

                //Elaboro la matriz final de enfrentamientos por jornada (primera vuelta)
                if (j == 0) {
                    if (i % 2 == 0) jornadas[i][j] = matriz2[i][j] + " vs " + matriz1[i][j] + " ";
                    else jornadas[i][j] = matriz1[i][j] + " vs " + matriz2[i][j] + " ";
                } else jornadas[i][j] = matriz1[i][j] + " vs " + matriz2[i][j] + " ";


                //segunda vuelta - al reves que la primera
                if (j == 0) {
                    if (i % 2 == 0) jornadas2[i][j] = matriz1[i][j] + " vs " + matriz2[i][j] + " ";
                    else jornadas2[i][j] = matriz2[i][j] + " vs " + matriz1[i][j] + " ";
                } else jornadas2[i][j] = matriz2[i][j] + " vs " + matriz1[i][j] + " ";

            }
        }
        //Relleno labels j1
        partido1.setText(jornadas[0][0]);
        partido2.setText(jornadas[0][1]);
        partido3.setText(jornadas[0][2]);
        partido4.setText(jornadas[0][3]);
        //Relleno labels j2
        label1.setText(jornadas[1][0]);
        label2.setText(jornadas[1][1]);
        label3.setText(jornadas[1][2]);
        label4.setText(jornadas[1][3]);
        //Relleno labels j3
        l1.setText(jornadas[2][0]);
        l2.setText(jornadas[2][1]);
        l3.setText(jornadas[2][2]);
        l4.setText(jornadas[2][3]);
        //Relleno labels j4
        p1.setText(jornadas[3][0]);
        p2.setText(jornadas[3][1]);
        p3.setText(jornadas[3][2]);
        p4.setText(jornadas[3][3]);
        //Relleno labels j5
        la1.setText(jornadas[4][0]);
        la2.setText(jornadas[4][1]);
        la3.setText(jornadas[4][2]);
        la4.setText(jornadas[4][3]);
        //Relleno labels j6
        lab1.setText(jornadas[5][0]);
        lab2.setText(jornadas[5][1]);
        lab3.setText(jornadas[5][2]);
        lab4.setText(jornadas[5][3]);
        //Relleno labels j7
        labe1.setText(jornadas[6][0]);
        labe2.setText(jornadas[6][1]);
        labe3.setText(jornadas[6][2]);
        labe4.setText(jornadas[6][3]);
        //Relleno labels j8
        encuentro1.setText(jornadas2[0][0]);
        encuentro2.setText(jornadas2[0][1]);
        encuentro3.setText(jornadas2[0][2]);
        encuentro4.setText(jornadas2[0][3]);
        //Relleno labels j9
        part1.setText(jornadas2[1][0]);
        past2.setText(jornadas2[1][1]);
        part3.setText(jornadas2[1][2]);
        past4.setText(jornadas2[1][3]);
        //Relleno labels j10
        enc1.setText(jornadas2[2][0]);
        enc2.setText(jornadas2[2][1]);
        enc3.setText(jornadas2[2][2]);
        enc4.setText(jornadas2[2][3]);
        //Relleno labels j11
        match1.setText(jornadas2[3][0]);
        match2.setText(jornadas2[3][1]);
        match3.setText(jornadas2[3][2]);
        match4.setText(jornadas2[3][3]);
        //Relleno labels j12
        mat1.setText(jornadas2[4][0]);
        mat2.setText(jornadas2[4][1]);
        mat3.setText(jornadas2[4][2]);
        match4.setText(jornadas2[4][3]);
        //Relleno labels j13
        m1.setText(jornadas2[5][0]);
        m2.setText(jornadas2[5][1]);
        m3.setText(jornadas2[5][2]);
        m4.setText(jornadas2[5][3]);
        //Relleno labels j14
        ma1.setText(jornadas2[6][0]);
        mac2.setText(jornadas2[6][1]);
        mac3.setText(jornadas2[6][2]);
        mac4.setText(jornadas2[6][3]);

    }

    /**
     * @method que genera los emparejamientos de la primera vuelta.
     * @param clubes
     * @return jorandas que es una matriz donde están las 7 jornadas de la 1ª vuelta.
     */
    public  String[][]  generarEmparejamientosPrimeraVuelta ( List<Equipo> clubes){

        int N = clubes.size();

        String[] equipos;
        String[][] matriz1,matriz2,jornadas,jornadas2;

        equipos = new String[N];

        //Relleno el array de equipos.
        int contador =0;

        for (Equipo e:clubes) {
            if(contador<N){
                equipos[contador]=e.getNombre();
                contador++;
            }
        }

        matriz1 = new String[N-1][N/2];
        matriz2 = new String[N-1][N/2];
        jornadas = new String[N-1][N/2]; //primera vuelta
        jornadas2 = new String[N-1][N/2]; //segunda vuelta

        //Relleno las matrices

        int cont = 0;
        int cont2 = N-2;

        for(int i=0;i<N-1;i++){
            for(int j=0;j<N/2;j++){
                //matriz1
                matriz1[i][j] = String.valueOf(equipos[cont]);
                cont++;
                if(cont==(N-1)) cont=0;

                //matriz2
                if(j==0) matriz2[i][j] = String.valueOf(equipos[N-1]);
                else {
                    matriz2[i][j] = String.valueOf(equipos[cont2]);
                    cont2--;
                    if(cont2==-1) cont2 = N-2;
                }

                //Elaboro la matriz final de enfrentamientos por jornada (primera vuelta)
                if(j==0){
                    if(i%2==0) jornadas[i][j] = matriz2[i][j] + " vs " + matriz1[i][j] + " ";
                    else jornadas[i][j] = matriz1[i][j] + " vs " + matriz2[i][j] + " ";
                }
                else jornadas[i][j] = matriz1[i][j] + " vs " + matriz2[i][j] + " ";


                /*segunda vuelta - al reves que la primera
                if(j==0){
                    if(i%2==0) jornadas2[i][j] = matriz1[i][j] + " vs " + matriz2[i][j] + " ";
                    else jornadas2[i][j] = matriz2[i][j] + " vs " + matriz1[i][j] + " ";
                }
                else jornadas2[i][j] = matriz2[i][j] + " vs " + matriz1[i][j] + " ";*/

            }
        }

        return jornadas;
    }

    /**
     * @method que genera los emparejamientos de la segunda vuelta.
     * @param clubes
     * @return jorandas2 que es una matriz donde están las 7 jornadas de la 2ªvuelta.
     */
    public  String[][]  generarEmparejamientosSegundaVuelta ( List<Equipo> clubes){

        int N = clubes.size();

        String[] equipos;
        String[][] matriz1,matriz2,jornadas,jornadas2;

        equipos = new String[N];

        //Relleno el array de equipos.
        int contador =0;

        for (Equipo e:clubes) {
            if(contador<N){
                equipos[contador]=e.getNombre();
                contador++;
            }
        }

        matriz1 = new String[N-1][N/2];
        matriz2 = new String[N-1][N/2];
        jornadas = new String[N-1][N/2]; //primera vuelta
        jornadas2 = new String[N-1][N/2]; //segunda vuelta

        //Relleno las matrices

        int cont = 0;
        int cont2 = N-2;

        for(int i=0;i<N-1;i++){
            for(int j=0;j<N/2;j++){
                //matriz1
                matriz1[i][j] = String.valueOf(equipos[cont]);
                cont++;
                if(cont==(N-1)) cont=0;

                //matriz2
                if(j==0) matriz2[i][j] = String.valueOf(equipos[N-1]);
                else {
                    matriz2[i][j] = String.valueOf(equipos[cont2]);
                    cont2--;
                    if(cont2==-1) cont2 = N-2;
                }

                /*Elaboro la matriz final de enfrentamientos por jornada (primera vuelta)
                if(j==0){
                    if(i%2==0) jornadas[i][j] = matriz2[i][j] + " vs " + matriz1[i][j] + " ";
                    else jornadas[i][j] = matriz1[i][j] + " vs " + matriz2[i][j] + " ";
                }
                else jornadas[i][j] = matriz1[i][j] + " vs " + matriz2[i][j] + " ";*/


                //segunda vuelta - al reves que la primera
                if(j==0){
                    if(i%2==0) jornadas2[i][j] = matriz1[i][j] + " vs " + matriz2[i][j] + " ";
                    else jornadas2[i][j] = matriz2[i][j] + " vs " + matriz1[i][j] + " ";
                }
                else jornadas2[i][j] = matriz2[i][j] + " vs " + matriz1[i][j] + " ";

            }
        }

        return jornadas2;
    }


}
