import java.util.Locale;
import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Valore placeholder ->");
        String placeholder = s.nextLine();
        System.out.print("Colore ->");
        String colore = s.nextLine();
        System.out.print("\nTitolo leaderboard ->");
        String titolo = s.nextLine();
        placeholder.replaceAll("%", "");
        System.out.println("\nColori per top 3? [Y,n]");
        String x = s.nextLine();
        boolean top3colori = yn(x);
        leaderboard(titolo, placeholder, colore, top3colori);
    }

    public static void leaderboard(String titolo, String placeholder, String colorep, boolean colori) {
        System.out.println("    -'" + titolo + "'");
        String prefix = "&7";
        for(int posizione = 1; 10 >= posizione; ++posizione) {
            // sparatemi
            String linea = "    -'"+ prefix + posizione + " &f- %ajlb_lb_"+placeholder+"_"+posizione+"_alltime_name%";
            if (colori) {
                if (posizione == 1) {
                    // System.out.println("    - '&#FCD05C#" + posizione + " &f- %ajlb_lb_" + placeholder + "_" + posizione + "_alltime_name% " + colorep + "%ajlb_lb_" + placeholder + "_" + posizione + "_alltime_value%'");
                } else if (posizione == 2) {
                    // System.out.println("    - '&#AAAAAA#" + posizione + " &f- %ajlb_lb_" + placeholder + "_" + posizione + "_alltime_name% " + colorep + "%ajlb_lb_" + placeholder + "_" + posizione + "_alltime_value%'");
                } else if (posizione == 3) {
                    // System.out.println("    - '&#604D1B#" + posizione + " &f- %ajlb_lb_" + placeholder + "_" + posizione + "_alltime_name% " + colorep + "%ajlb_lb_" + placeholder + "_" + posizione + "_alltime_value%'");
                }
            }

            System.out.println("    - '&7#" + posizione + " &f- %ajlb_lb_" + placeholder + "_" + posizione + "_alltime_name% " + colorep + "%ajlb_lb_" + placeholder + "_" + posizione + "_alltime_value%'");
        }


        System.out.println("%ajlb_position_"+placeholder+"_alltime%");

    }

    public static boolean yn(String x) {
        return !x.toLowerCase(Locale.ROOT).contains("n");
    }
}