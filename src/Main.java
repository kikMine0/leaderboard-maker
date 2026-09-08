import java.util.Locale;
import java.util.Scanner;

public class Main {
    static String tipo;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("""
                 _                _           _                         _                   _            \s
                | |              | |         | |                       | |                 | |           \s
                | | ___  __ _  __| | ___ _ __| |__   ___   __ _ _ __ __| |  _ __ ___   __ _| | _____ _ __\s
                | |/ _ \\/ _` |/ _` |/ _ \\ '__| '_ \\ / _ \\ / _` | '__/ _` | | '_ ` _ \\ / _` | |/ / _ \\ '__|
                | |  __/ (_| | (_| |  __/ |  | |_) | (_) | (_| | | | (_| | | | | | | | (_| |   <  __/ |  \s
                |_|\\___|\\__,_|\\__,_|\\___|_|  |_.__/ \\___/ \\__,_|_|  \\__,_| |_| |_| |_|\\__,_|_|\\_\\___|_|  \s
                
                
                1. FancyHolograms
                2. DecentHolograms
                Selezionare [1,2] ->
                """);
        tipo = s.nextLine();
        System.out.print("\nValore placeholder ->");
        String placeholder = s.nextLine();
        System.out.print("Colore ->");
        String colore = s.nextLine();
        System.out.print("\nTitolo leaderboard ->");
        String titolo = s.nextLine();
        placeholder.replaceAll("%", "");
        System.out.println("Colori per top 3? [Y,n]");
        String x = s.nextLine();
        boolean top3colori = yn(x);
        leaderboard(titolo, placeholder, colore, top3colori);
    }

    public static void leaderboard(String titolo, String placeholder, String colorep, boolean colori) {
        if (tipo.contains("1")) {
            System.out.println("    - '" + titolo + "'");
            String prefix = "";
            for (int posizione = 1; 10 >= posizione; posizione++) {
                // sparatemi
                if (colori) {
                    if (posizione == 1) {
                        // molto debuggings
//                        System.out.println("posizione:" + posizione);
                        prefix = "&#FCD05C#";
                    } else if (posizione == 2) {
                        prefix = "&#BCB8AF#";
                    } else if (posizione == 3) {
                        prefix = "&#AC8A30#";
                    } else {
                        prefix = "&7#";
                    }
                }
                String linea = "    - '" + prefix + posizione
                        + " &f- %ajlb_lb_" + placeholder + "_" + posizione + "_alltime_name% "
                        + colorep + "%ajlb_lb_" + placeholder + "_" + posizione + "_alltime_value%'";
                System.out.println(linea);

            }
            System.out.println("    - '" + prefix + "%ajlb_position_" + placeholder + "_alltime% &f- %player_name% "+colorep+"%ajlb_value_" + placeholder + "_alltime%");



        } else if (tipo.contains("2")) {
            System.out.println("  - content: '"+titolo+"'\n    height: 0.3");
            String prefix = "";
            for (int posizione = 1; 10 >= posizione; posizione++) {
                // woah ora si vede qualcosa
                if (colori) {
                    if (posizione == 1) {
                        prefix = "&#FCD05C#";
                    } else if (posizione == 2) {
                        prefix = "&#BCB8AF#";
                    } else if (posizione == 3) {
                        prefix = "&#AC8A30#";
                    } else {
                        prefix = "&7#";
                    }
                }
                String linea = "  - content: '" + prefix
                        + posizione
                        + " &f- %ajlb_lb_" + placeholder + "_" + posizione + "_alltime_name% "
                        + colorep + "%ajlb_lb_" + placeholder + "_" + posizione + "_alltime_value%'\n    height: 0.3";
                System.out.println(linea);
            }
            System.out.println("  - content: '&f'\n    height: 0.3");
            System.out.println("  - content: '"+ prefix + "%ajlb_position_" + placeholder + "_alltime% &f- %player_name% "+colorep+"%ajlb_value_" + placeholder + "_alltime%'"+"\n    height: 0.3");
        }
    }

    public static boolean yn(String x) {
        return !x.toLowerCase(Locale.ROOT).contains("n");
    }
}