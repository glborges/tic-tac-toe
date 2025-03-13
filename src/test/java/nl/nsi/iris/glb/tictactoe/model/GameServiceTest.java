package nl.nsi.iris.glb.tictactoe.model;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameServiceTest implements WithAssertions {
    GameService gameService;

    @BeforeEach
    void setUp() {
        gameService = new GameService();
    }

    @Test
    void testBoardIsCreatedEmpty() {
        String[][] board = gameService.getBoard();

        assertNotNull(board);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertThat(board[i][j]).isEqualTo("-");
            }
        }
    }

    @Test
    void testNewGameClearsTheBoard() {
        gameService.newGame();
        String[][] board = gameService.getBoard();

        assertNotNull(board);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertThat(board[i][j]).isEqualTo("-");
            }
        }
    }

    @Test
    void testWritePlayerSymbol() {
        gameService.writePlayerSymbol(1, 1, "X");

        assertThat(gameService.getBoard()[1][1]).isEqualTo("X");
    }

    @Test
    void testPlayerWinsByRow() {
        gameService.getBoard()[1][0] = "X";
        gameService.getBoard()[1][1] = "X";
        gameService.getBoard()[1][2] = "X";

        assertThat(gameService.didPlayerWin("X"))
                .as("Player X should win by row.")
                .isTrue();
    }

    @Test
    void testPlayerWinsByColumn() {
        gameService.getBoard()[0][2] = "O";
        gameService.getBoard()[1][2] = "O";
        gameService.getBoard()[2][2] = "O";

        assertThat(gameService.didPlayerWin("O"))
                .as("Player O should win by column.")
                .isTrue();
    }

    @Test
    void testPlayerWinsByMainDiagonal() {
        gameService.getBoard()[0][0] = "X";
        gameService.getBoard()[1][1] = "X";
        gameService.getBoard()[2][2] = "X";

        assertThat(gameService.didPlayerWin("X"))
                .as("Player X should win by main diagonal.")
                .isTrue();
    }

    @Test
    void testPlayerWinsByAntiDiagonal() {
        gameService.getBoard()[0][2] = "O";
        gameService.getBoard()[1][1] = "O";
        gameService.getBoard()[2][0] = "O";

        assertThat(gameService.didPlayerWin("O"))
                .as("Player O should win by anti-diagonal.")
                .isTrue();
    }

    @Test
    void testNoWinCondition() {
        gameService.getBoard()[0][0] = "X";
        gameService.getBoard()[0][1] = "O";
        gameService.getBoard()[0][2] = "X";
        gameService.getBoard()[1][0] = "O";
        gameService.getBoard()[1][1] = "X";
        gameService.getBoard()[1][2] = "O";
        gameService.getBoard()[2][0] = "O";
        gameService.getBoard()[2][1] = "X";
        gameService.getBoard()[2][2] = "O";

        gameService.printBoard();

        assertThat(gameService.didPlayerWin("X"))
                .as("Player X should not win.")
                .isFalse();
        assertThat(gameService.didPlayerWin("O"))
                .as("Player O should not win.")
                .isFalse();
    }

    @Test
    void testCaseInsensitiveCheck() {
        gameService.getBoard()[0][0] = "x";
        gameService.getBoard()[1][1] = "x";
        gameService.getBoard()[2][2] = "x";

        assertThat(gameService.didPlayerWin("X"))
                .as("The method should be case-insensitive.")
                .isTrue();
    }

    @Test
    void testGameIsOver() {
        gameService.getBoard()[0][0] = "X";
        gameService.getBoard()[0][1] = "O";
        gameService.getBoard()[0][2] = "X";
        gameService.getBoard()[1][0] = "O";
        gameService.getBoard()[1][1] = "X";
        gameService.getBoard()[1][2] = "O";
        gameService.getBoard()[2][0] = "O";
        gameService.getBoard()[2][1] = "X";
        gameService.getBoard()[2][2] = "O";

        assertThat(gameService.isGameOver())
                .as("Game should be over since there no more moves to make.")
                .isTrue();
    }

    @Test
    void testGameIsNotOver() {
        gameService.getBoard()[0][0] = "X";
        gameService.getBoard()[0][1] = "O";
        gameService.getBoard()[0][2] = "X";


        assertThat(gameService.isGameOver())
                .as("Game should not be over since there still moves to make.")
                .isFalse();
    }

}