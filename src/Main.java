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
        if (tipo == 1) {
            System.out.println("    - '" + titolo + "'");
            String prefix = "";
            for (int posizione = 1; 10 >= posizione; posizione++) {
                // sparatemi
                String linea = "    - '" + prefix + posizione + " &f- %ajlb_lb_" + placeholder + "_" + posizione + "_alltime_name% " + colorep + "%ajlb_lb_" + placeholder + "_" + posizione + "_alltime_value%'";
                if (colori) {
                    if (posizione == 1) {
                        System.out.println("posizione:" + posizione);
                        prefix = "&#FCD05C#";
                        System.out.println(linea);
                    } else if (posizione == 2) {
                        prefix = "&#BCB8AF#";
                        System.out.println(linea);
                    } else if (posizione == 3) {
                        prefix = "&#AC8A30#";
                        System.out.println(linea);
                    } else {
                        prefix = "&7#";
                        System.out.println(linea);
                    }
                } else {
                    System.out.println(linea);
                }

            }
            System.out.println("    - '" + prefix + "%ajlb_position_" + placeholder + "_alltime% &f- %player_name% "+colorep+"%ajlb_value_" + placeholder + "_alltime%");



        } else if (tipo == 2) {
            System.out.println("  - content: '"+titolo+"'\n    height: 0.3");
            String prefix = "";
            for (int posizione = 1; 10 >= posizione; posizione++) {
                // woah ora si vede qualcosa
                String linea = "  - content: " + prefix
                        + posizione
                        + " &f- %ajlb_lb_" + placeholder + "_" + posizione + "_alltime_name% "
                        + colorep + "%ajlb_lb_" + placeholder + "_" + posizione + "_alltime_value%'";
                if (colori) {
                    if (posizione == 1) {
                        System.out.println("posizione:" + posizione);
                        prefix = "&#FCD05C#";
                        System.out.println(linea);
                    } else if (posizione == 2) {
                        prefix = "&#BCB8AF#";
                        System.out.println(linea);
                    } else if (posizione == 3) {
                        prefix = "&#AC8A30#";
                        System.out.println(linea);
                    } else {
                        prefix = "&7#";
                        System.out.println(linea);
                    }
                } else {
                    System.out.println(linea);
                }
            }
        }
    }

    public static boolean yn(String x) {
        return !x.toLowerCase(Locale.ROOT).contains("n");
    }
}