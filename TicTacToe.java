package tictactoe;

import java.util.Collections;
import java.util.Scanner;

public class TicTacToe {
    public static void play(Grid grid) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter the coordinates: ");
            String coordinates = scanner.nextLine();
            while (!CoordinatesConstraints.isInputValid(coordinates)) {
                System.out.println("You should enter numbers!");
                play(grid);
            }

            Scanner scanner1 = new Scanner(coordinates);
            int y = scanner1.nextInt();
            int x = scanner1.nextInt();

            while (!(CoordinatesConstraints.checkIfCorrectCoordinates(y, x) &&
                    CoordinatesConstraints.checkIfNotOccupied(y, x, grid))) {
                if (!CoordinatesConstraints.checkIfCorrectCoordinates(y, x)) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    play(grid);
                } else if (!CoordinatesConstraints.checkIfNotOccupied(y, x, grid)) {
                    System.out.println("This cell is occupied! Choose another one!");
                    play(grid);
                }
            }
            String sign = "X";
            if (Collections.frequency(grid.getSignsList(), "X") > Collections.frequency(grid.getSignsList(), "O")) {
                sign = "O";
            }

            grid.updateGrid(y, x, sign);
            grid.showGrid();

        } while (!ResultChecker.check(grid));

        System.exit(0);
    }
    public static void main(String[] args) {
        System.out.println("Enter the cells: ");
        Scanner scanner = new Scanner(System.in);
        String cells = scanner.nextLine();
        Grid grid = new Grid(cells);
        grid.showGrid();
        play(grid);

    }
}
