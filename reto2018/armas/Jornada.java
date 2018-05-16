package jose.armas;

import java.util.List;
import java.util.Objects;

public class Jornada {

    private String numeroJOrnada;
    private String fecha;


    //Asociaciones.
    private List<Partido>partidos;
    private List<Equipo>equipos;
    private VentanaMenuAdministrador ventanaMenuAdministrador;

    public VentanaMenuAdministrador getVentanaMenuAdministrador() {
        return ventanaMenuAdministrador;
    }

    public void setVentanaMenuAdministrador(VentanaMenuAdministrador ventanaMenuAdministrador) {
        this.ventanaMenuAdministrador = ventanaMenuAdministrador;
    }

    public Jornada() {
    }

    public Jornada(String numeroJOrnada, String fecha) {
        this.numeroJOrnada = numeroJOrnada;
        this.fecha = fecha;
    }

    public String getNumeroJOrnada() {
        return numeroJOrnada;
    }

    public void setNumeroJOrnada(String numeroJOrnada) {
        this.numeroJOrnada = numeroJOrnada;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public List<Partido> getPartidos() {
        return partidos;
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jornada jornada = (Jornada) o;
        return Objects.equals(numeroJOrnada, jornada.numeroJOrnada);
    }

    @Override
    public int hashCode() {

        return Objects.hash(numeroJOrnada);
    }

    @Override
    public String toString() {
        return "Jornada: "+numeroJOrnada;
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
