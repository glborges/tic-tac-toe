package nl.nsi.iris.glb.tictactoe.model;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Arrays;

@Service
public class GameService {
    private String[][] board = new String[3][3];
    private boolean gameOver = false;

    public GameService() {
        newGame();
    }

    public void newGame() {
        for(String[] row : board) {
            Arrays.fill(row, "-");
        }
        gameOver = false;
    }

    public String[][] getBoard() {
        return board;
    }

    public String writePlayerSymbol(int row, int col, String playerSymbol) {
        if (gameOver) {
            return "Game is over. Start a new game.";
        }

        board[row][col] = playerSymbol;
        printBoard();
        if (didPlayerWin(playerSymbol)) {
            gameOver = true;
            return "Player " + playerSymbol + " has won!";
        } else if (isBoardFull()) {
            gameOver = true;
            return "It's a tie!";
        }
        return "Other player's turn!";
    }

    public boolean didPlayerWin(String playerSymbol) {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0].equalsIgnoreCase(playerSymbol) && board[i][1].equalsIgnoreCase(playerSymbol) && board[i][2].equalsIgnoreCase(playerSymbol)) ||
                    (board[0][i].equalsIgnoreCase(playerSymbol) && board[1][i].equalsIgnoreCase(playerSymbol) && board[2][i].equalsIgnoreCase(playerSymbol))) {
                return true;
            }
        }
        return (board[0][0].equalsIgnoreCase(playerSymbol) && board[1][1].equalsIgnoreCase(playerSymbol) && board[2][2].equalsIgnoreCase(playerSymbol)) ||
                (board[0][2].equalsIgnoreCase(playerSymbol) && board[1][1].equalsIgnoreCase(playerSymbol) && board[2][0].equalsIgnoreCase(playerSymbol));
    }

    public boolean isBoardFull() {
        for( String[] row : board) {
            if (Arrays.asList(row).contains("-")) {
                return false;
            }
        }
        return true;
    }

    public boolean isGameOver() {
        return gameOver || isBoardFull();
    }

    public void printBoard() {
        System.out.println("  0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(StringUtils.hasLength(board[i][j]) ? board[i][j] : "-");
                if (j < 2) System.out.print("|");
            }
            System.out.println();
        }
    }

}
