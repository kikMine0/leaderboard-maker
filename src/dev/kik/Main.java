package dev.kik;

import org.jline.prompt.*;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> coloriMC = List.of("&4", "&c", "&6", "&e", "&2", "&a", "&b", "&3", "&1", "&9", "&d", "&5", "&f", "&7", "&8", "&0");
        Terminal terminale = TerminalBuilder.builder().system(true).build();
        Prompter prompter = PrompterFactory.create(terminale);
        PromptBuilder hologramma = prompter.newBuilder();
        PromptBuilder placeholder = prompter.newBuilder();
        PromptBuilder colori = prompter.newBuilder();
        PromptBuilder titolo = prompter.newBuilder();
        PromptBuilder coloritop = prompter.newBuilder();

        terminale.writer().println("""
                 _                _           _                         _                   _            \s
                | |              | |         | |                       | |                 | |           \s
                | | ___  __ _  __| | ___ _ __| |__   ___   __ _ _ __ __| |  _ __ ___   __ _| | _____ _ __\s
                | |/ _ \\/ _` |/ _` |/ _ \\ '__| '_ \\ / _ \\ / _` | '__/ _` | | '_ ` _ \\ / _` | |/ / _ \\ '__|
                | |  __/ (_| | (_| |  __/ |  | |_) | (_) | (_| | | | (_| | | | | | | | (_| |   <  __/ |  \s
                |_|\\___|\\__,_|\\__,_|\\___|_|  |_.__/ \\___/ \\__,_|_|  \\__,_| |_| |_| |_|\\__,_|_|\\_\\___|_|  \s
                
                
                """);
        hologramma.createListPrompt()
                .name("hologramma")
                .message("Per quale plugin vuoi fare la leaderboard?")
                .newItem("FancyHolograms")
                .text("FancyHolograms")
                .add()
                .newItem("DecentHolograms")
                .text("DecentHolograms")
                .add()
                .pageSize(2)
                .addPrompt();

        placeholder.createInputPrompt().name("placeholder")
                .message("Inserire il placeholder")
                .defaultValue("place_hold_er")
                .addPrompt();
        colori.createInputPrompt().name("colori")
                .message("Che colore dovrebbero essere i valori della leaderboard?")
                .defaultValue("&a")
                .addPrompt();
        // Claude -> mixare SearchPrompt con InputPrompt
        // Ci starebbe molto avere quelli di default nella lista coloriMC e poi tutti i colori HEX
//                .searchFunction(query -> {
//                    List<String> matches = new ArrayList<>(coloriMC.stream()
//                            .filter(p -> p.toLowerCase().contains(query.toLowerCase()))
//                            .toList());
//                    if (!query.isBlank() && !matches.contains(query)) {
//                        matches.add(query); // permette "input libero" come opzione extra
//                    }
//                    return matches;
//                })
        titolo.createInputPrompt().name("titolo")
                .message("Inserire titolo leaderboard")
                .defaultValue("Classifica x")
                .addPrompt();
        coloritop.createConfirmPrompt().name("coloritop")
                .message("I top 3 dovrebbero avere colori della posizione differenti?")
                .defaultValue(true)
                .addPrompt();

        String tipo = prompter.prompt(List.of(), hologramma.build()).get("hologramma").getResult();
        String placeholders = prompter.prompt(List.of(), placeholder.build()).get("placeholder").getResult();
        String colore = prompter.prompt(List.of(), colori.build()).get("colori").getResult();
        String titolo1 = prompter.prompt(List.of(), titolo.build()).get("titolo").getResult();
        String top = prompter.prompt(List.of(), coloritop.build()).get("coloritop").getResult();
        leaderboard(tipo, titolo1, placeholders, colore, top);
    }


    public static void leaderboard(String tipo, String titolo, String placeholder, String colorep, String colori) {
        if (tipo.contains("FancyHolograms")) {
            System.out.println("    - '" + titolo + "'");
            String prefix = "";
            for (int posizione = 1; 10 >= posizione; posizione++) {
                // sparatemi
                if (colori.equalsIgnoreCase("yes")) {
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
            System.out.println("  - content: '&f'\n    height: 0.3");
            System.out.println("    - '" + prefix + "%ajlb_position_" + placeholder + "_alltime% &f- %player_name% " + colorep + "%ajlb_value_" + placeholder + "_alltime%");


        } else if (tipo.contains("DecentHolograms")) {
            System.out.println("  - content: '" + titolo + "'\n    height: 0.3");
            String prefix = "";
            for (int posizione = 1; 10 >= posizione; posizione++) {
                // woah ora si vede qualcosa
                if (colori.equalsIgnoreCase("yes")) {
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
            System.out.println("  - content: '" + prefix + "%ajlb_position_" + placeholder + "_alltime% &f- %player_name% " + colorep + "%ajlb_value_" + placeholder + "_alltime%'" + "\n    height: 0.3");
        }
    }


    // https://www.baeldung.com/java-clipboard-copy-paste-text
    public static void copyToClipboard(String text) {
        Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection data = new StringSelection(text);
        cb.setContents(data, null);
    }
}