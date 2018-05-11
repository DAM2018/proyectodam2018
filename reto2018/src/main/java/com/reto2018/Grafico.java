package com.reto2018;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.RangeType;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;

import java.awt.*;
import java.nio.*;
import java.sql.*;

public class Grafico {


    private ChartPanel cp;
    private JFreeChart chart;

    public Grafico() {


        XYDataset ds = createDataset();

        chart =
                ChartFactory.createXYLineChart("Clasificacion",
                        "jornada", "puntos", ds, PlotOrientation.VERTICAL, true, true,
                        false);


        cp = new ChartPanel(chart, 1024, 768, 300, 200, 1024, 768, true, true, false, false, true, true);


        XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesStroke(0, new BasicStroke(4.0f));

        renderer.setSeriesPaint(1, Color.BLUE);
        renderer.setSeriesStroke(1, new BasicStroke(4.0f));

        renderer.setSeriesStroke(2, new BasicStroke(4.0f));
        renderer.setSeriesStroke(3, new BasicStroke(4.0f));
        renderer.setSeriesStroke(4, new BasicStroke(4.0f));
        renderer.setSeriesStroke(5, new BasicStroke(4.0f));
        renderer.setSeriesStroke(6, new BasicStroke(4.0f));
        renderer.setSeriesStroke(7, new BasicStroke(4.0f));

        plot.setRenderer(renderer);
        Color c = new Color(76, 118, 75);
        Color c2 = new Color(177, 187, 48);

        plot.setBackgroundPaint(c);

        Paint p = new GradientPaint(0, 0, c, 1000, 0, c2);
        chart.setBackgroundPaint(p);

        plot.setRangeGridlinesVisible(true);
        plot.setDomainGridlinesVisible(true);

        NumberAxis yAxis = (NumberAxis) plot.getRangeAxis(0);
        NumberAxis xAxis = (NumberAxis) plot.getDomainAxis(0);

        yAxis.setRangeType(RangeType.FULL);
        xAxis.setLowerBound(1);
        xAxis.setUpperBound(14);

        yAxis.setTickUnit(new NumberTickUnit(1));
        xAxis.setTickUnit(new NumberTickUnit(1));


    }


    private XYDataset createDataset() {

        DefaultXYDataset ds = new DefaultXYDataset();
        try {

            Connection conexion = Conexion.conexion;

            Statement st = null;
            st = conexion.createStatement();

            String sql2 = "select distinct equipo from clasificacion2 order by equipo";

            ResultSet rs = null;
            rs = st.executeQuery(sql2);


            String[] eq = new String[8];
            int i = 0;

            while (rs.next()) {

                eq[i] = rs.getString(1);

                i++;
            }


            String sql = "{call calendario.grafico(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";


            for (int j = 0; j < 8; j++) {


                CallableStatement callableStatement = conexion.prepareCall(sql);

                callableStatement.setString(1, eq[j]);
                callableStatement.registerOutParameter(2, Types.INTEGER);
                callableStatement.registerOutParameter(3, Types.INTEGER);
                callableStatement.registerOutParameter(4, Types.INTEGER);
                callableStatement.registerOutParameter(5, Types.INTEGER);
                callableStatement.registerOutParameter(6, Types.INTEGER);
                callableStatement.registerOutParameter(7, Types.INTEGER);
                callableStatement.registerOutParameter(8, Types.INTEGER);
                callableStatement.registerOutParameter(9, Types.INTEGER);
                callableStatement.registerOutParameter(10, Types.INTEGER);
                callableStatement.registerOutParameter(11, Types.INTEGER);
                callableStatement.registerOutParameter(12, Types.INTEGER);
                callableStatement.registerOutParameter(13, Types.INTEGER);
                callableStatement.registerOutParameter(14, Types.INTEGER);
                callableStatement.registerOutParameter(15, Types.INTEGER);


                callableStatement.executeUpdate();

                int[] puntos = new int[14];

                puntos[0] = callableStatement.getInt(2);
                puntos[1] = callableStatement.getInt(3);
                puntos[2] = callableStatement.getInt(4);
                puntos[3] = callableStatement.getInt(5);
                puntos[4] = callableStatement.getInt(6);
                puntos[5] = callableStatement.getInt(7);
                puntos[6] = callableStatement.getInt(8);
                puntos[7] = callableStatement.getInt(9);
                puntos[8] = callableStatement.getInt(10);
                puntos[9] = callableStatement.getInt(11);
                puntos[10] = callableStatement.getInt(12);
                puntos[11] = callableStatement.getInt(13);
                puntos[12] = callableStatement.getInt(14);
                puntos[13] = callableStatement.getInt(15);

                double[][] data = {{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14}, {puntos[0],
                        puntos[1],
                        puntos[2],
                        puntos[3],
                        puntos[4],
                        puntos[5],
                        puntos[6],
                        puntos[7],
                        puntos[8],
                        puntos[9],
                        puntos[10],
                        puntos[11],
                        puntos[12],
                        puntos[13],
                }};

                ds.addSeries(eq[j], data);
            }


        } catch (SQLException e2) {

            // System.out.println(e.getMessage());

        } catch (java.lang.NullPointerException e2) {


        } catch (java.lang.IndexOutOfBoundsException e2) {


        }

        // double[][] data2 = { {0.5, 0.6, 0.7}, {3, 4, 5} };


        // ds.addSeries("series2", data2);


        return (XYDataset) ds;
    }

    public ChartPanel getCp() {
        return cp;
    }

    public void setCp(ChartPanel cp) {
        this.cp = cp;
    }

    public JFreeChart getChart() {
        return chart;
    }

    public void setChart(JFreeChart chart) {
        this.chart = chart;
    }

}
