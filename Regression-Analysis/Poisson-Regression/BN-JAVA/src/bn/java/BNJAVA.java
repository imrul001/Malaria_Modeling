package bn.java;

import norsys.netica.Environ;
import norsys.netica.Net;
import norsys.neticaEx.aliases.Node;

/**
 *
 * @author imrul
 */
public class BNJAVA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("here is the starting point");
        try {
            Node.setConstructorClass("norsys.neticaEx.aliases.Node");
            Environ env = new Environ("+HaddawyP/AIT/120,310-5-A/11987");

            Net net = new Net();

            Node visitAsia = new Node("VisitAsia", "visit,no_visit", net);
            Node tuberculosis = new Node("Tuberculosis", "present,absent", net);
            Node smoking = new Node("Smoking", "smoker,nonsmoker", net);
            Node cancer = new Node("Cancer", "present,absent", net);
            Node tbOrCa = new Node("TbOrCa", "true,false", net);
            Node xRay = new Node("XRay", "abnormal,normal", net);

            tuberculosis.addLink(visitAsia);
            cancer.addLink(smoking);
            tbOrCa.addLink(tuberculosis);
            tbOrCa.addLink(cancer);
            xRay.addLink(tbOrCa);

            float[] asiaProbs = {0.01F, 0.99F};
            int[] asiaParentStates = null;
            visitAsia.setCPTable(asiaParentStates, asiaProbs);

            tuberculosis.setCPTable("visit", 0.05, 0.95);
            tuberculosis.setCPTable("no_visit", 0.01, 0.99);

            smoking.setCPTable(0.5, 0.5);

            cancer.setCPTable("smoker", 0.1, 0.9);
            cancer.setCPTable("nonsmoker", 0.01, 0.99);

            tbOrCa.setEquation("TbOrCa (Tuberculosis, Cancer) = Tuberculosis || Cancer");
            tbOrCa.equationToTable(1, false, false);

            //               TbOrCa     abnormal normal
            xRay.setCPTable("true", 0.98, 0.02);
            xRay.setCPTable("false", 0.05, 0.95);

            net.compile();

            double belief = tuberculosis.getBelief("present");
            System.out.println("\nThe probability of tuberculosis is " + belief);

            xRay.finding().enterState("abnormal");
            belief = tuberculosis.getBelief("present");
            System.out.println("\nGiven an abnormal X-ray,\n"
                    + "the probability of tuberculosis is " + belief);

            visitAsia.finding().enterState("visit");
            belief = tuberculosis.getBelief("present");
            System.out.println("\nGiven an abnormal X-ray and a visit to Asia,\n"
                    + "the probability of tuberculosis is " + belief);

            cancer.finding().enterState("present");
            belief = tuberculosis.getBelief("present");
            System.out.println("\nGiven an abnormal X-ray, Asia visit, and lung cancer,\n"
                    + "the probability of tuberculosis is " + belief + "\n");

            net.finalize();   // not strictly necessary, but a good habit
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
