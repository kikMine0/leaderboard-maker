public class Main {
    public static void main(String[] args) throws IOException {
        Terminal terminale = TerminalBuilder.builder().system(true).build();
        Prompter professore = PrompterFactory.create(terminale);
        PromptBuilder costruttore = professore.newBuilder();
        costruttore.createListPrompt()
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

        
    }
}