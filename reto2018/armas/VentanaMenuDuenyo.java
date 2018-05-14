package jose.armas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VentanaMenuDuenyo {
    private JPanel contenedorPrincipal;
    private JPanel contenedorCrearEquipo;
    private JPanel contenedorResultados;
    private JPanel contenedorClasificacion;
    private JList list1;
    private JPanel contenedorLIst;
    private JTable table1;
    private JPanel contendorFunciones;
    private JButton ficharButton;
    private JButton borrarButton;
    private JScrollPane contendorEquipo;
    private JButton volverButton;
    private JComboBox comboBox1;
    private JPanel contenedorCombobox;
    private JPanel contendorCombobox;
    private JLabel partido1Label;
    private JTextField textField1;
    private JTextField textField2;
    private JLabel partido2label;
    private JTextField textField3;
    private JTextField textField4;
    private JLabel partido3label;
    private JTextField textField5;
    private JTextField textField6;
    private JLabel partido4label;
    private JTextField textField7;
    private JTextField textField8;


    //Asociaciones.
    private VentanaUsuarioContrasenya ventanaUsuarioContrasenya;
    private Duenyo duenyo;
    private List<Equipo>equiposVentanaMenuduenyo;

    public VentanaMenuDuenyo() {
    }



    public VentanaMenuDuenyo(VentanaUsuarioContrasenya vUc) throws SQLException {

        ventanaUsuarioContrasenya = vUc;

        JFrame frame = new JFrame("VentanaMenuDuenyo");
        frame.setContentPane(contenedorPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        Duenyo duenyo = DuenyoBD.duenyoEquipo1();
        List<Equipo> equipos = EquiposBd.equiposDeLaBD();

        String titulo = "";
        String codigoEquipo=null;

        for (Equipo e : equipos) {
            if (e.getCodigo().equalsIgnoreCase(duenyo.getCodigoEquipo())) {
                titulo = e.getNombre();
                codigoEquipo = e.getCodigo();
            }
        }

        contendorEquipo.setBorder(javax.swing.BorderFactory.createTitledBorder(titulo));

        List<Jugador>jugadoresLibres = JugadoresBD.listaDeJugadoresLIbres();

        ponerEnJlistLosJugadoresLIbres(jugadoresLibres);
        generarModeloTablaConLosJugadoresDeEseEquipo();

        DefaultComboBoxModel<String> jornadaDefaultComboBoxModel = new DefaultComboBoxModel<>();


        List <Equipo> equipoList = EquiposBd.equiposDeLaBD();

        for (int i = 0; i < 14; i++) {
            String jornada = (String)"Jornada "+(i+1);
            jornadaDefaultComboBoxModel.insertElementAt(jornada,i);
        }

        comboBox1.setModel(jornadaDefaultComboBoxModel);

        ficharButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (list1.getSelectedValue() == null) {
                    JOptionPane.showMessageDialog(null, "Seleccione un jugador de la lista.");
                } else {
                    Jugador jugadorAfichar = (Jugador) list1.getSelectedValue();
                    int fila = table1.getSelectedRow();
                    if (fila < 0) {
                        JOptionPane.showMessageDialog(null, "Seleccione una fila de la tabla");
                    } else {

                        for (int x = 0; x < 6; x++) {
                            switch (x) {
                                case 0:
                                    table1.setValueAt(jugadorAfichar.getNombreJugador(), fila, x);
                                    break;
                                case 1:
                                    table1.setValueAt(jugadorAfichar.getNickJugador(), fila, x);
                                    break;
                                case 2:
                                    table1.setValueAt(jugadorAfichar.getSueldoJugador(),fila, x);
                                    break;
                                case 3:
                                    table1.setValueAt(jugadorAfichar.getDniJugador(), fila, x);
                                    break;
                                case 4:
                                    table1.setValueAt(jugadorAfichar.getCaracteristicasJugador(), fila, x);
                                    break;
                                case 5:
                                    table1.setValueAt("1", fila, x);
                                    jugadorAfichar.setCodigoEquipoJugador("1");
                                    break;
                            }
                        }
                    }
                    try {
                        JugadoresBD.actualizarCodigoEquipoDelJugador(jugadorAfichar);
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                    try {
                        List<Jugador> jug = JugadoresBD.listaDeJugadoresLIbres();
                        ponerEnJlistLosJugadoresLIbres(jug);
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
        borrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int fila = table1.getSelectedRow();
                if (fila < 0) {
                    JOptionPane.showMessageDialog(null, "Seleccione una fila de la tabla");
                } else{

                    String name ="";
                    String nick ="";
                    Integer sueldo=null;
                    String dnijug ="";
                    String caracteristicas ="";
                    String codigoequi ="";

                    for (int x = 0; x < 6; x++) {
                        switch (x) {
                            case 0:
                                name = (String )table1.getValueAt( fila, x);
                                table1.setValueAt("", fila, x);
                                break;
                            case 1:
                                nick = (String )table1.getValueAt( fila, x);
                                table1.setValueAt("", fila, x);
                                break;
                            case 2:
                               sueldo = (Integer ) table1.getValueAt( fila, x);
                                table1.setValueAt("",fila, x);
                                break;
                            case 3:
                                dnijug = (String )table1.getValueAt( fila, x);
                                table1.setValueAt("", fila, x);
                                break;
                            case 4:
                                caracteristicas = (String )table1.getValueAt( fila, x);
                                table1.setValueAt("", fila, x);
                                break;
                            case 5:
                                codigoequi = (String )table1.getValueAt( fila, x);
                                table1.setValueAt("", fila, x);
                                break;
                        }
                    }

                    Jugador jugadorAborrar = new Jugador(name,nick,sueldo,dnijug,caracteristicas,null);
                    try {
                        JugadoresBD.actualizarCodigoEquipoDelJugador(jugadorAborrar);
                        List<Jugador>jugadorList = JugadoresBD.listaDeJugadoresLIbres();
                        ponerEnJlistLosJugadoresLIbres(jugadorList);
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        comboBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String [][] primeraVuelta = generarEmparejamientosPrimeraVuelta(equipoList);
                String [][]segundaVuelta = generarEmparejamientosSegundaVuelta(equipoList);
                int index = comboBox1.getSelectedIndex();
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
    }


    /**
     * @throws SQLException
     * @method generarModeloTablaConLosJugadoresDeEseEquipo() que se encarga de elaborar el modelo de la tabla y añadir
     * los jugadores del equipo 1.
     */
    private void generarModeloTablaConLosJugadoresDeEseEquipo() throws SQLException {
        DefaultTableModel modeloTabla = new DefaultTableModel();
        String[] columnas = {"Nombre", "Nick", "Sueldo", "DNI", "caracteristicas", "Equipo"};

        modeloTabla.setColumnCount(6);
        modeloTabla.setNumRows(6);
        modeloTabla.setColumnIdentifiers(columnas);

        table1.setModel(modeloTabla);

        List<Jugador> jugadoresDelMismoEquipo = JugadoresBD.ListarJugadoresDeUnMismoEquipo(1);

        for (int i = 0; i < jugadoresDelMismoEquipo.size(); i++) {
            System.out.println(jugadoresDelMismoEquipo.get(i).getNombreJugador());
        }

        for (int i = 0; i < jugadoresDelMismoEquipo.size(); i++) {
            for (int x = 0; x < 6; x++) {
                switch (x) {
                    case 0:
                        modeloTabla.setValueAt(jugadoresDelMismoEquipo.get(i).getNombreJugador(), i, x);
                        break;
                    case 1:
                        modeloTabla.setValueAt(jugadoresDelMismoEquipo.get(i).getNickJugador(), i, x);
                        break;
                    case 2:
                        modeloTabla.setValueAt(jugadoresDelMismoEquipo.get(i).getSueldoJugador(), i, x);
                        break;
                    case 3:
                        modeloTabla.setValueAt(jugadoresDelMismoEquipo.get(i).getDniJugador(), i, x);
                        break;
                    case 4:
                        modeloTabla.setValueAt(jugadoresDelMismoEquipo.get(i).getCaracteristicasJugador(), i, x);
                        break;
                    case 5:
                        modeloTabla.setValueAt(jugadoresDelMismoEquipo.get(i).getCodigoEquipoJugador(), i, x);
                        break;
                }

            }
        }
    }


    /**
     * @method ponerEnJlistLosJugadoresLIbres() que obtiene los jugadores de la BD para seleccionar cuál de ellos
     * está sin equipo y así mostrarlo en el Jlist cómo libres para que los pueda fichar el dueño.
     */
    private void ponerEnJlistLosJugadoresLIbres(List<Jugador>players) {


            DefaultListModel<Jugador> jugadores = new DefaultListModel<>();

        for (Jugador j :players) {
            jugadores.addElement(j);
        }


            list1.setModel(jugadores);


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
