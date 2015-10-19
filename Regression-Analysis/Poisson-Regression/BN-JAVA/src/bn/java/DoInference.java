package bn.java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import norsys.netica.Environ;
import norsys.netica.Net;
import norsys.netica.Node;
import norsys.netica.Streamer;

/**
 *
 * @author imrul
 */
public class DoInference {
    

    public static void main(String[] args) {
        System.out.println("This is the do inference class");
        try {
            Environ environ = new Environ("+HaddawyP/AIT/120,310-5-A/11987");

            Net net = new Net(new Streamer("/media/imrul/C/Latest-Analysis/network_to_infer.dne"));

            //Nodes that are required to set data
            Node Month_w0 = net.getNode("Month_w0");
            Node Month_w1 = net.getNode("Month_w1");
            Node Month_w2 = net.getNode("Month_w2");
            Node Month_w3 = net.getNode("Month_w3");
            Node LST_w0 = net.getNode("LST_w0");
            Node NDVI_w0 = net.getNode("NDVI_w0");
            Node rainfall_w0 = net.getNode("Rainfall_w0");
//            Node rainfall_wm1 = net.getNode("Rainfall_w-1");
            Node Malaria_w0 = net.getNode("Malaria_w0");
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
            String csvFile = "/media/imrul/C/Latest-Analysis/model_data.csv";
            BufferedReader br = null;
            String line = "";
            String csvSplitBy = ",";

//            File file = new File("/media/imrul/C/Latest-Analysis/output");
//
//            if (!file.exists()) {
//                file.createNewFile();
//            }
//            FileWriter fw = new FileWriter(file.getAbsoluteFile());
//            BufferedWriter bw = new BufferedWriter(fw);

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
                        double malaria_1 = Double.valueOf(dataWithNoSeparator[13]);
                        int month_2_state = getMonthState(Double.valueOf(dataWithNoSeparator[19]));
                        int month_3_state = getMonthState(Double.valueOf(dataWithNoSeparator[29]));
//                        int rainfallwm1_state = getRainfallState(Double.valueOf(dataWithNoSeparator[39]));

                        Month_w0.finding().enterState(month_0_state);
                        dist_to_stream.finding().enterState(dist_to_strm_state);
                        dist_to_border.finding().enterState(dist_to_brdr_state);
                        slope.finding().enterState(slope_state);
                        strm_density.finding().enterState(strmDensty_state);
                        rainfall_w0.finding().enterState(rainfall_0_state);
                        NDVI_w0.finding().enterState(ndvi_0_state);
                        Malaria_w0.finding().enterState(malaria_0_state);
                        LST_w0.finding().enterState(lst_0_state);
                        Month_w1.finding().enterState(month_1_state);
                        Month_w2.finding().enterState(month_2_state);
                        Month_w3.finding().enterState(month_3_state);
//                        rainfall_wm1.finding().enterState(rainfallwm1_state);

//                        String content = M_NDVI_w1.getBeliefs()[0] + ";"
//                                + M_NDVI_w1.getBeliefs()[1] + ";" + M_NDVI_w1.getBeliefs()[2] + ";"
//                                + M_NDVI_w1.getBeliefs()[3] + ";" + M_NDVI_w1.getBeliefs()[4] + ","
//                                + M_Dist_to_Border_w1.getBeliefs()[0] + ";" + M_Dist_to_Border_w1.getBeliefs()[1] + ";"
//                                + M_Dist_to_Border_w1.getBeliefs()[2] + ";" + M_Dist_to_Border_w1.getBeliefs()[3] + ";"
//                                + M_Dist_to_Border_w1.getBeliefs()[4] + ","
//                                + M_Dist_to_Stream_w1.getBeliefs()[0] + ";" + M_Dist_to_Stream_w1.getBeliefs()[1] + ";"
//                                + M_Dist_to_Stream_w1.getBeliefs()[2] + ";" + M_Dist_to_Stream_w1.getBeliefs()[3] + ";"
//                                + M_Dist_to_Stream_w1.getBeliefs()[4] + ","
//                                + M_Slope_Rainfall_w1.getBeliefs()[0] + ";" + M_Slope_Rainfall_w1.getBeliefs()[1] + ";"
//                                + M_Slope_Rainfall_w1.getBeliefs()[2] + ";" + M_Slope_Rainfall_w1.getBeliefs()[3] + ";"
//                                + M_Slope_Rainfall_w1.getBeliefs()[4] + ","
//                                + M_Stream_Density_w1.getBeliefs()[0] + ";" + M_Stream_Density_w1.getBeliefs()[1] + ";"
//                                + M_Stream_Density_w1.getBeliefs()[2] + ";" + M_Stream_Density_w1.getBeliefs()[3] + ";"
//                                + M_Stream_Density_w1.getBeliefs()[4] + "," + malaria_1;
                        System.out.println(M_NDVI_w1.getBeliefs()[0]+";"
                                +M_NDVI_w1.getBeliefs()[1]+";"+M_NDVI_w1.getBeliefs()[2]+";"
                                +M_NDVI_w1.getBeliefs()[3]+";"+M_NDVI_w1.getBeliefs()[4]+","
                                +M_Dist_to_Border_w1.getBeliefs()[0]+";"+M_Dist_to_Border_w1.getBeliefs()[1]+";"
                                +M_Dist_to_Border_w1.getBeliefs()[2]+";"+M_Dist_to_Border_w1.getBeliefs()[3]+";"
                                +M_Dist_to_Border_w1.getBeliefs()[4]+","
                                +M_Dist_to_Stream_w1.getBeliefs()[0]+";"+M_Dist_to_Stream_w1.getBeliefs()[1]+";"
                                +M_Dist_to_Stream_w1.getBeliefs()[2]+";"+M_Dist_to_Stream_w1.getBeliefs()[3]+";"
                                +M_Dist_to_Stream_w1.getBeliefs()[4]+","
                                +M_Slope_Rainfall_w1.getBeliefs()[0]+";"+M_Slope_Rainfall_w1.getBeliefs()[1]+";"
                                +M_Slope_Rainfall_w1.getBeliefs()[2]+";"+M_Slope_Rainfall_w1.getBeliefs()[3]+";"
                                +M_Slope_Rainfall_w1.getBeliefs()[4]+","
                                +M_Stream_Density_w1.getBeliefs()[0]+";"+M_Stream_Density_w1.getBeliefs()[1]+";"
                                +M_Stream_Density_w1.getBeliefs()[2]+";"+M_Stream_Density_w1.getBeliefs()[3]+";"
                                +M_Stream_Density_w1.getBeliefs()[4]+","+malaria_1);
                        System.out.println(dataWithNoSeparator[39]);
//                        try {
//                            bw.write("imrul");
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }

//                        System.out.println("Done");

                        NDVI_w0.finding().clear();
                        Malaria_w0.finding().clear();
                        LST_w0.finding().clear();
                        rainfall_w0.finding().clear();
                        Month_w0.finding().clear();
//                        dist_to_stream.finding().clear();
//                        dist_to_border.finding().clear();
//                        slope.finding().clear();
//                        strm_density.finding().clear();
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

    public static int getMonthState(double monthData) {
        int state = 0;
        if (monthData >= 0 && monthData < 3.50) {
            state = 0;
        }
        if (monthData >= 3.50 && monthData < 5.50) {
            state = 1;
        }
        if (monthData >= 5.50 && monthData < 7.50) {
            state = 2;
        }
        if (monthData >= 7.50 && monthData < 9.50) {
            state = 3;
        }
        if (monthData >= 9.50 && monthData <= 12) {
            state = 4;
        }
        return state;
    }

    public static int getRainfallState(double rainfallData) {
        int state = 0;
        if (rainfallData >= 0 && rainfallData < 1.6328) {
            state = 0;
        }
        if (rainfallData >= 1.6328 && rainfallData < 3.2657) {
            state = 1;
        }
        if (rainfallData >= 3.2657 && rainfallData < 4.8985) {
            state = 2;
        }
        if (rainfallData >= 4.8985 && rainfallData <= 6.5313) {
            state = 3;
        }
        return state;
    }

    public static int getLSTstate(double lstData) {
        int state = 0;
        if (lstData >= 17.0 && lstData < 25.0) {
            state = 0;
        }
        if (lstData >= 25.0 && lstData < 27.4) {
            state = 1;
        }
        if (lstData >= 27.4 && lstData < 30) {
            state = 2;
        }
        if (lstData >= 30 && lstData <= 39) {
            state = 3;
        }
        return state;
    }

    public static int getSlopeState(double slopeData) {
        int state = 0;
        if (slopeData >= 0.0 && slopeData < 7.92) {
            state = 0;
        }
        if (slopeData >= 7.92 && slopeData < 13.66) {
            state = 1;
        }
        if (slopeData >= 13.66 && slopeData < 19.4) {
            state = 2;
        }
        if (slopeData >= 19.4 && slopeData <= 25.14) {
            state = 3;
        }
        return state;
    }

    public static int getBorderDistState(double borderDistData) {
        int state = 0;
        if (borderDistData >= 0.0 && borderDistData < 5280.4877) {
            state = 0;
        }
        if (borderDistData >= 5280.4877 && borderDistData < 10204.6585) {
            state = 1;
        }
        if (borderDistData >= 10204.6585 && borderDistData < 15128.8293) {
            state = 2;
        }
        if (borderDistData >= 15128.8293 && borderDistData <= 20053) {
            state = 3;
        }
        return state;
    }

    public static int getStreamDistState(double streamDistData) {
        int state = 0;
        if (streamDistData >= 0.0 && streamDistData < 912.9731) {
            state = 0;
        }
        if (streamDistData >= 912.9731 && streamDistData < 1821.8954) {
            state = 1;
        }
        if (streamDistData >= 1821.8954 && streamDistData < 2730.8177) {
            state = 2;
        }
        if (streamDistData >= 2730.8177 && streamDistData <= 3639.74) {
            state = 3;
        }
        return state;
    }

    public static int getStreamDensityState(double streamDensityData) {
        int state = 0;
        if (streamDensityData >= 0.0 && streamDensityData < 0.1082) {
            state = 0;
        }
        if (streamDensityData >= 0.1082 && streamDensityData < 0.2165) {
            state = 1;
        }
        if (streamDensityData >= 0.2165 && streamDensityData < 0.3247) {
            state = 2;
        }
        if (streamDensityData >= 0.3247 && streamDensityData <= 0.59) {
            state = 3;
        }
        return state;
    }

    public static int getMalariaState(double malariaData) {
        int state = 0;
        if (malariaData >= 0.0 && malariaData < 0.0005) {
            state = 0;
        }
        if (malariaData >= 0.0005 && malariaData < 0.001339) {
            state = 1;
        }
        if (malariaData >= 0.001339 && malariaData < 0.002547) {
            state = 2;
        }
        if (malariaData >= 0.002547 && malariaData < 0.005289) {
            state = 3;
        }
        if (malariaData >= 0.005289 && malariaData < 0.0673953) {
            state = 4;
        }
        return state;
    }

    public static int getNDVIstate(double ndviData) {
        int state = 0;
        if (ndviData >= 0.0 && ndviData < 0.5206) {
            state = 0;
        }
        if (ndviData >= 0.5206 && ndviData < 0.6567) {
            state = 1;
        }
        if (ndviData >= 0.6567 && ndviData < 0.7928) {
            state = 2;
        }
        if (ndviData >= 0.7928 && ndviData < 0.9290) {
            state = 3;
        }
        return state;
    }

}
