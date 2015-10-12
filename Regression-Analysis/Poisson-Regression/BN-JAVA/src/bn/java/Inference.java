/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bn.java;

import static bn.java.DoInference.getBorderDistState;
import static bn.java.DoInference.getLSTstate;
import static bn.java.DoInference.getMalariaState;
import static bn.java.DoInference.getMonthState;
import static bn.java.DoInference.getNDVIstate;
import static bn.java.DoInference.getRainfallState;
import static bn.java.DoInference.getSlopeState;
import static bn.java.DoInference.getStreamDensityState;
import static bn.java.DoInference.getStreamDistState;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import norsys.netica.Environ;
import norsys.netica.Net;
import norsys.netica.Node;
import norsys.netica.Streamer;

/**
 *
 * @author imrul
 */
public class Inference {
    public static void main(String[] args) {
        System.out.println("This is the do inference class");
        try {
            Environ environ = new Environ("+HaddawyP/AIT/120,310-5-A/11987");

            Net net = new Net(new Streamer("/home/hasan/Downloads/updated_network_7th_September_dne.dne"));

            //Nodes that are required to set data
            Node Month_w0 = net.getNode("Month_w0");
            Node Month_w1 = net.getNode("Month_w1");
            Node Month_w2 = net.getNode("Month_w2");
            Node Month_w3 = net.getNode("Month_w3");
            Node LST_w0 = net.getNode("LST_w0");
            Node LST_w1 = net.getNode("LST_w1");
            Node LST_w2 = net.getNode("LST_w2");
            Node LST_w3 = net.getNode("LST_w3");
            Node NDVI_w0 = net.getNode("NDVI_w0");
            Node NDVI_w1 = net.getNode("NDVI_w1");
            Node NDVI_w2 = net.getNode("NDVI_w2");
            Node NDVI_w3 = net.getNode("NDVI_w3");
            Node rainfall_w0 = net.getNode("Rainfall_w0");
            Node rainfall_w1 = net.getNode("Rainfall_w1");
            Node rainfall_w2 = net.getNode("Rainfall_w2");
            Node rainfall_w3 = net.getNode("Rainfall_w3");
            Node rainfall_wm1 = net.getNode("Rainfall_wm1");
            Node Malaria_w0 = net.getNode("Malaria_w0");
            Node Malaria_w1 = net.getNode("Malaria_w1");
            Node Malaria_w2 = net.getNode("Malaria_w2");
            Node Malaria_w3 = net.getNode("Malaria_w3");
            Node slope = net.getNode("slope");
            Node dist_to_stream = net.getNode("Dist_to_Stream");
            Node dist_to_border = net.getNode("Dist_to_Border");
            Node strm_density = net.getNode("strm_density");

            // Nodes for getting original/correct probability
            Node M_Slope_Rainfall_w1 = net.getNode("M_Slope_Rainfall_w1");
            Node M_Dist_to_Border_w1 = net.getNode("M_Dist_to_Border_w1");
            Node M_Dist_to_Stream_w1 = net.getNode("M_Dist_to_Stream_w1");
            Node M_Stream_Density_w1 = net.getNode("M_Stream_Density_w1");
            Node M_NDVI_w1 = net.getNode("M_NDVI_w1");

            net.compile();

//            Malaria_w0.finding().enterState(3);
            String csvFile = "/home/hasan/Downloads/model_data.csv";
            BufferedReader br = null;
            String line = "";
            String csvSplitBy = ",";
            
            int i = 0;
            try {
                br = new BufferedReader(new FileReader(csvFile));
                while ((line = br.readLine()) != null) {
                    if (i != 0) {
                        String[] dataWithNoSeparator = line.split(csvSplitBy);
                        int month_0_state = getMonthState(Double.valueOf(dataWithNoSeparator[0]));
                        int dist_to_strm_state = getStreamDistState(Double.valueOf(dataWithNoSeparator[1]));
                        int dist_to_brdr_state = getBorderDistState(Double.valueOf(dataWithNoSeparator[2]));
                        int slope_state = getSlopeState(Double.valueOf(dataWithNoSeparator[3]));
                        int strmDensty_state = getStreamDensityState(Double.valueOf(dataWithNoSeparator[4]));
                        int rainfall_0_state = getRainfallState(Double.valueOf(dataWithNoSeparator[5]));
                        int ndvi_0_state = getNDVIstate(Double.valueOf(dataWithNoSeparator[6]));
                        int malaria_0_state = getMalariaState(Double.valueOf(dataWithNoSeparator[7]));
                        int lst_0_state = getLSTstate(Double.valueOf(dataWithNoSeparator[8]));
                        int month_1_state = getMonthState(Double.valueOf(dataWithNoSeparator[9]));
                        int rainfall_1_state = getRainfallState(Double.valueOf(dataWithNoSeparator[10]));
                        int ndvi_1_state = getNDVIstate(Double.valueOf(dataWithNoSeparator[11]));
                        int lst_1_state = getLSTstate(Double.valueOf(dataWithNoSeparator[12]));
                        int malaria_1_state = getMalariaState(Double.valueOf(dataWithNoSeparator[13]));
                        double malaria_1 = Double.valueOf(dataWithNoSeparator[13]);
                        int month_2_state = getMonthState(Double.valueOf(dataWithNoSeparator[19]));
                        int rainfall_2_state = getRainfallState(Double.valueOf(dataWithNoSeparator[20]));
                        int ndvi_2_state = getNDVIstate(Double.valueOf(dataWithNoSeparator[21]));
                        int lst_2_state = getLSTstate(Double.valueOf(dataWithNoSeparator[22]));
                        int malaria_2_state = getMalariaState(Double.valueOf(dataWithNoSeparator[23]));
                        int month_3_state = getMonthState(Double.valueOf(dataWithNoSeparator[29]));
                        int rainfall_3_state = getMonthState(Double.valueOf(dataWithNoSeparator[30]));
                        int ndvi_3_state = getNDVIstate(Double.valueOf(dataWithNoSeparator[31]));
                        int lst_3_state = getLSTstate(Double.valueOf(dataWithNoSeparator[32]));
                        int malaria_3_state = getMalariaState(Double.valueOf(dataWithNoSeparator[33]));
                        int rainfallwm1_state = getRainfallState(Double.valueOf(dataWithNoSeparator[39]));

                        Month_w0.finding().enterState(month_0_state);
                        dist_to_stream.finding().enterState(dist_to_strm_state);
                        dist_to_border.finding().enterState(dist_to_brdr_state);
                        slope.finding().enterState(slope_state);
                        strm_density.finding().enterState(strmDensty_state);
                        rainfall_w0.finding().enterState(rainfall_0_state);
                        rainfall_w1.finding().enterState(rainfall_1_state);
                        rainfall_w2.finding().enterState(rainfall_2_state);
                        rainfall_w3.finding().enterState(rainfall_3_state);
                        NDVI_w0.finding().enterState(ndvi_0_state);
                        NDVI_w1.finding().enterState(ndvi_1_state);
                        NDVI_w2.finding().enterState(ndvi_2_state);
                        NDVI_w3.finding().enterState(ndvi_3_state);
                        Malaria_w0.finding().enterState(malaria_0_state);
                        Malaria_w1.finding().enterState(malaria_1_state);
                        Malaria_w2.finding().enterState(malaria_2_state);
                        Malaria_w3.finding().enterState(malaria_3_state);
                        LST_w0.finding().enterState(lst_0_state);
                        LST_w1.finding().enterState(lst_1_state);
                        LST_w2.finding().enterState(lst_2_state);
                        LST_w3.finding().enterState(lst_3_state);
                        Month_w1.finding().enterState(month_1_state);
                        Month_w2.finding().enterState(month_2_state);
                        Month_w3.finding().enterState(month_3_state);
                        rainfall_wm1.finding().enterState(rainfallwm1_state);
                        

                        System.out.println(M_NDVI_w1.getBeliefs()[0] + ";"
                                + M_NDVI_w1.getBeliefs()[1] + ";" + M_NDVI_w1.getBeliefs()[2] + ";"
                                + M_NDVI_w1.getBeliefs()[3] + ";" + M_NDVI_w1.getBeliefs()[4] + ","
                                + M_Dist_to_Border_w1.getBeliefs()[0] + ";" + M_Dist_to_Border_w1.getBeliefs()[1] + ";"
                                + M_Dist_to_Border_w1.getBeliefs()[2] + ";" + M_Dist_to_Border_w1.getBeliefs()[3] + ";"
                                + M_Dist_to_Border_w1.getBeliefs()[4] + ","
                                + M_Dist_to_Stream_w1.getBeliefs()[0] + ";" + M_Dist_to_Stream_w1.getBeliefs()[1] + ";"
                                + M_Dist_to_Stream_w1.getBeliefs()[2] + ";" + M_Dist_to_Stream_w1.getBeliefs()[3] + ";"
                                + M_Dist_to_Stream_w1.getBeliefs()[4] + ","
                                + M_Slope_Rainfall_w1.getBeliefs()[0] + ";" + M_Slope_Rainfall_w1.getBeliefs()[1] + ";"
                                + M_Slope_Rainfall_w1.getBeliefs()[2] + ";" + M_Slope_Rainfall_w1.getBeliefs()[3] + ";"
                                + M_Slope_Rainfall_w1.getBeliefs()[4] + ","
                                + M_Stream_Density_w1.getBeliefs()[0] + ";" + M_Stream_Density_w1.getBeliefs()[1] + ";"
                                + M_Stream_Density_w1.getBeliefs()[2] + ";" + M_Stream_Density_w1.getBeliefs()[3] + ";"
                                + M_Stream_Density_w1.getBeliefs()[4] + "," + malaria_1);

                        
                        NDVI_w0.finding().clear();
                        NDVI_w1.finding().clear();
                        NDVI_w2.finding().clear();
                        NDVI_w3.finding().clear();
                        Malaria_w0.finding().clear();
                        Malaria_w1.finding().clear();
                        Malaria_w2.finding().clear();
                        Malaria_w3.finding().clear();
                        LST_w0.finding().clear();
                        LST_w1.finding().clear();
                        LST_w2.finding().clear();
                        LST_w3.finding().clear();
                        rainfall_w0.finding().clear();
                        rainfall_w1.finding().clear();
                        rainfall_w2.finding().clear();
                        rainfall_w3.finding().clear();
                        rainfall_wm1.finding().clear();
                        Month_w0.finding().clear();
                        dist_to_stream.finding().clear();
                        dist_to_border.finding().clear();
                        slope.finding().clear();
                        strm_density.finding().clear();
                        Month_w1.finding().clear();
                        Month_w2.finding().clear();
                        Month_w3.finding().clear();

//                        all the nodes should be clear
                    }
                    i++;
                }
//                bw.close();

            } catch (FileNotFoundException exception) {
                exception.printStackTrace();
            }

//            System.out.println("Malaria Deu to NDVI " + M_NDVI_w1.getBeliefs()[0]);
//            System.out.println("Malaria Deu to Stream Density " + M_Stream_Density_w1.getBeliefs()[0]);
            System.out.println("We are on " + i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
