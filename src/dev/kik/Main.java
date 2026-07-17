package dev.kik;

import org.jline.prompt.*;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import javax.annotation.processing.SupportedSourceVersion;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> coloriMC = List.of("&4","&c","&6","&e","&2","&a","&b","&3","&1","&9","&d","&5","&f","&7","&8","&0");
        Terminal terminale = TerminalBuilder.builder().system(true).build();
        Prompter prompter = PrompterFactory.create(terminale);
        PromptBuilder hologramma = prompter.newBuilder();
        PromptBuilder placeholder = prompter.newBuilder();
        PromptBuilder colori = prompter.newBuilder();
        PromptBuilder titolo = prompter.newBuilder();
        PromptBuilder coloritop = prompter.newBuilder();
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

        ArrayList<String> risultati = new ArrayList<>();
        risultati.add(prompter.prompt(List.of(),hologramma.build()).get("hologramma").getResult());
        risultati.add(prompter.prompt(List.of(),placeholder.build()).get("placeholder").getResult());
        risultati.add(prompter.prompt(List.of(),colori.build()).get("colori").getResult());
        risultati.add(prompter.prompt(List.of(),titolo.build()).get("titolo").getResult());
        risultati.add(prompter.prompt(List.of(),coloritop.build()).get("coloritop").getResult());
        leaderboard(risultati);
    }


    public static void leaderboard(ArrayList<String> valori){

    }



    // https://www.baeldung.com/java-clipboard-copy-paste-text
    public static void copyToClipboard(String text) {
        Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection data = new StringSelection(text);
        cb.setContents(data, null);
    }
}