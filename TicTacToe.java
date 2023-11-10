package tictactoe;

import java.util.Collections;
import java.util.Scanner;

public class TicTacToe {
    public static void play(Grid grid) {
        while (!ResultChecker.check(grid)) {
            Player.move(grid);
            if (ResultChecker.check(grid)) {
                System.exit(0);
            } else {
                Computer.easyMove(grid);
            }
        }


    }
    public static void main(String[] args) {
        Grid grid = new Grid();

        grid.showGrid();
        play(grid);

    }
}
