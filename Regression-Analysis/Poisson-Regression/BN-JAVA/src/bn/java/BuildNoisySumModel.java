/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bn.java;

import norsys.netica.Environ;
import norsys.netica.Net;
import norsys.netica.Node;

/**
 *
 * @author imrul
 */
public class BuildNoisySumModel {
    
    public static void main(String[] args){
        System.out.println("here is the starting");
        try{
            
            Node.setConstructorClass("norsys.neticaEx.aliases.Node");
            Environ env = new Environ("+HaddawyP/AIT/120,310-5-A/11987");
            
            Net net = new Net();
            net.setName("NoisySumModel");
        
            Node month_w0 = new Node("Month_w0", "s0_0_3p5, s1_3p5_5p5, s2_5p5_7p5, s3_7p5_9p5, s4_9p5_12", net);
            Node month_w1 = new Node("Month_w1", "s0_0_3p5, s1_3p5_5p5, s2_5p5_7p5, s3_7p5_9p5, s4_9p5_12", net);
            Node month_w2 = new Node("Month_w2", "s0_0_3p5, s1_3p5_5p5, s2_5p5_7p5, s3_7p5_9p5, s4_9p5_12", net);
            Node month_w3 = new Node("Month_w3", "s0_0_3p5, s1_3p5_5p5, s2_5p5_7p5, s3_7p5_9p5, s4_9p5_12", net);
            

            Node rainfall_w0 = new Node("Rainfall_w0", "s0_0_1p6328,s1_1p6328_3p2657,s2_3p2657_4p8985,s3_4p8985_6p5313", net);
            Node rainfall_w1 = new Node("Rainfall_w1", "s0_0_1p6328,s1_1p6328_3p2657,s2_3p2657_4p8985,s3_4p8985_6p5313", net);
            Node rainfall_w2 = new Node("Rainfall_w2", "s0_0_1p6328,s1_1p6328_3p2657,s2_3p2657_4p8985,s3_4p8985_6p5313", net);
            Node rainfall_w3 = new Node("Rainfall_w3", "s0_0_1p6328,s1_1p6328_3p2657,s2_3p2657_4p8985,s3_4p8985_6p5313", net);
            Node rainfall_wm1 = new Node("Rainfall_wm1", "s0_0_1p6328,s1_1p6328_3p2657,s2_3p2657_4p8985,s3_4p8985_6p5313", net);
            

            Node lst_w0 = new Node("LST_w0", "s0_17_25,s1_25_27p4,s2_27p4_30,s3_30_39", net);
            Node lst_w1 = new Node("LST_w1", "s0_17_25,s1_25_27p4,s2_27p4_30,s3_30_39", net);
            Node lst_w2 = new Node("LST_w2", "s0_17_25,s1_25_27p4,s2_27p4_30,s3_30_39", net);
            Node lst_w3 = new Node("LST_w3", "s0_17_25,s1_25_27p4,s2_27p4_30,s3_30_39", net);
            
            
            Node ndvi_w0 = new Node("NDVI_w0", "s0_0_0p5206,s1_0p5206_0p6567,s2_0p6567_0p7928,s3_0p7928_0p9290", net);
            Node ndvi_w1 = new Node("NDVI_w1", "s0_0_0p5206,s1_0p5206_0p6567,s2_0p6567_0p7928,s3_0p7928_0p9290", net);
            Node ndvi_w2 = new Node("NDVI_w2", "s0_0_0p5206,s1_0p5206_0p6567,s2_0p6567_0p7928,s3_0p7928_0p9290", net);
            Node ndvi_w3 = new Node("NDVI_w3", "s0_0_0p5206,s1_0p5206_0p6567,s2_0p6567_0p7928,s3_0p7928_0p9290", net);
            
            Node malaria_w0 = new Node("Malaria_w0", "s0,s1,s2,s3,s4", net);
            Node malaria_w1 = new Node("Malaria_w1", "s0,s1,s2,s3,s4", net);
            Node malaria_w2 = new Node("Malaria_w2", "s0,s1,s2,s3,s4", net);
            Node malaria_w3 = new Node("Malaria_w3", "s0,s1,s2,s3,s4", net);
            
            
            Node m_slope_rainfall_w1 = new Node("M_SLOPE_RAINFALL_w1", "s0,s1,s2,s3,s4", net);
            Node m_dist_border_w1 = new Node("M_DIST_BORDER_w1", "s0,s1,s2,s3,s4", net);
            Node m_ndvi_w1 = new Node("M_NDVI_w1", "s0,s1,s2,s3,s4", net);
            Node m_dist_stream_w1 = new Node("M_DIST_STREAM_w1", "s0,s1,s2,s3,s4", net);
            Node m_stream_density_w1 = new Node("M_STREAM_DENSITY_w1", "s0,s1,s2,s3,s4", net);
            
            Node m_slope_rainfall_w2 = new Node("M_SLOPE_RAINFALL_w2", "s0,s1,s2,s3,s4", net);
            Node m_dist_border_w2 = new Node("M_DIST_BORDER_w2", "s0,s1,s2,s3,s4", net);
            Node m_ndvi_w2 = new Node("M_NDVI_w2", "s0,s1,s2,s3,s4", net);
            Node m_dist_stream_w2 = new Node("M_DIST_STREAM_w2", "s0,s1,s2,s3,s4", net);
            Node m_stream_density_w2 = new Node("M_STREAM_DENSITY_w2", "s0,s1,s2,s3,s4", net);
            
            Node m_slope_rainfall_w3 = new Node("M_SLOPE_RAINFALL_w3", "s0,s1,s2,s3,s4", net);
            Node m_dist_border_w3 = new Node("M_DIST_BORDER_w3", "s0,s1,s2,s3,s4", net);
            Node m_ndvi_w3 = new Node("M_NDVI_w3", "s0,s1,s2,s3,s4", net);
            Node m_dist_stream_w3 = new Node("M_DIST_STREAM_w3", "s0,s1,s2,s3,s4", net);
            Node m_stream_density_w3 = new Node("M_STREAM_DENSITY_w3", "s0,s1,s2,s3,s4", net);
            
            
            Node slope = new Node("SLOPE","s0_0_7p92,s1_7p92_13p66,s2_13p66_19p4,s3_19p4_25p14", net);                 
            Node dist_to_stream = new Node("DIST_TO_STREAM","s0_0_912p9731,s1_912p9731_1821p8954,"
                    + "s2_1821p8954_2730p8177,s3_2730p8177_3639p74",net);            
            Node dist_to_border = new Node("DIST_TO_BORDER","s0_0_5280p4877,s1_5280p4877_10204p6585,s2_10204p6585_15128p8293,"
                    + "s3_15128p8293_20053",net);
            Node stream_density = new Node("STREAM_DENSITY", "s0_0_0p1082,s1_0p1082_0p2165, s2_0p2165_0p3247,s3_0p3247_0p59",net);


         
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
