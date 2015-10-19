package poissondist;

import java.io.BufferedReader;
import java.io.FileReader;
import norsys.netica.Environ;
import norsys.netica.Node;
import norsys.netica.Streamer;
import norsys.neticaEx.aliases.Net;

/**
 *
 * @author imrul
 */
public class poissonSample {

    public static void main(String[] arg) {
        System.out.println("This the poisson Sample class");
        try {
            Environ environ = new Environ("+HaddawyP/AIT/120,310-5-A/11987");

            Net net = new Net(new Streamer("/home/imrul/Downloads/NET-1.dne"));

            Node Malaria_w1 = net.getNode("Malaria_w1");
            Node Malaria_w2 = net.getNode("Malaria_w2");
            Node Malaria_w3 = net.getNode("Malaria_w3");

//            net.compile();
            String csvFileComboFile = "/media/imrul/C/Latest-Analysis/Poisson-Distribution/all_combination_of_states.csv";
            BufferedReader br = null;
            String comboline = "";

            String csvFileCPTFile = "/media/imrul/C/Latest-Analysis/Poisson-Distribution/cpt.csv";
            BufferedReader br1 = null;
            String cptline = "";

            try {
                br = new BufferedReader(new FileReader(csvFileComboFile));
                br1 = new BufferedReader(new FileReader(csvFileCPTFile));
                while ((comboline = br.readLine()) != null && (cptline = br1.readLine()) != null) {
                    String[] probStr = cptline.split(",");
                    float[] probabilites = new float[5];
                    for (int i = 0; i <= 4; i++) {
                        probabilites[i] = Float.valueOf(probStr[i]);
                    }
//                    System.out.println(comboline + " " + probabilites[0] + "" + probabilites[0]);
                    Malaria_w1.setCPTable(comboline, probabilites);
                    Malaria_w2.setCPTable(comboline, probabilites);
                    Malaria_w3.setCPTable(comboline, probabilites);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            net.write(new Streamer("/media/imrul/C/Latest-Analysis/Poisson-Distribution/LEARNED-NET-1.dne"));
            net.finalize();
            System.out.println("Done");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
