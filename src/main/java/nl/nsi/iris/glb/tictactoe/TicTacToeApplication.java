package nl.nsi.iris.glb.tictactoe;

import ch.qos.logback.classic.Logger;
import nl.nsi.iris.glb.tictactoe.model.GameService;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class TicTacToeApplication implements CommandLineRunner {

    private final GameService gameService;
    Logger logger = (Logger) LoggerFactory.getLogger(TicTacToeApplication.class);

    public TicTacToeApplication(GameService gameService) {
        this.gameService = gameService;
    }

    public static void main(String[] args) {
        SpringApplication.run(TicTacToeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Starting TicTacToeApplication");
        logger.info("Lets play TicTacToe");

        gameService.newGame();
        playTicTacToe();

    }

    private void playTicTacToe() {
        String currentPlayer = "X";
        List<String> availableMoves = getListOfMoves();
        Random random = new Random();

        while (!gameService.isGameOver()) {
            var moves = availableMoves.remove(random.nextInt(availableMoves.size())).split(",");
            int row = Integer.parseInt(moves[0]);
            int col = Integer.parseInt(moves[1]);
            System.out.println(gameService.writePlayerSymbol(row, col, currentPlayer));
            currentPlayer = getNextPlayer(currentPlayer);
        }
    }

    private String getNextPlayer(String currentPlayer) {
        return currentPlayer.equals("X") ? "O" : "X";
    }

    private List<String> getListOfMoves() {
        List<String> availableMoves = new ArrayList<>();
        availableMoves.add("0,0");
        availableMoves.add("0,1");
        availableMoves.add("0,2");
        availableMoves.add("1,0");
        availableMoves.add("1,1");
        availableMoves.add("1,2");
        availableMoves.add("2,0");
        availableMoves.add("2,1");
        availableMoves.add("2,2");
        return availableMoves;
    }
}
