package tictactoe;

import java.util.Collections;
import java.util.Scanner;

public class TicTacToe {
    public static void play(Grid grid, Player player, Computer computer) {
        while (!ResultChecker.check(grid)) {
            player.move(grid);
            if (ResultChecker.check(grid)) {
                System.exit(0);
            } else {
                computer.move(grid);
            }
        }
    }

    public static void play(Grid grid, Player player1, Player player2) {
        while (!ResultChecker.check(grid)) {
            player1.move(grid);
            if (ResultChecker.check(grid)) {
                System.exit(0);
            } else {
                player2.move(grid);
            }
        }
    }

    public static void play(Grid grid, Computer computer1, Computer computer2) {
        while (!ResultChecker.check(grid)) {
            computer1.move(grid);
            if (ResultChecker.check(grid)) {
                System.exit(0);
            } else {
                computer2.move(grid);
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Grid grid = new Grid();
        System.out.print("Input command: ");
        String command = scanner.nextLine();
        grid.showGrid();
        String[] commandSplit = command.split(" ");
        if (commandSplit.length == 3) {
            if (commandSplit[0].equals("start") && commandSplit[1].equals("user") && commandSplit[2].equals("user")) {
                play(grid, new Player("X"), new Player("O"));
            } else if (commandSplit[0].equals("start") && commandSplit[1].equals("easy") && commandSplit[2].equals("easy")) {
                play(grid, new Computer("X", "easy"), new Computer("O", "easy"));
            } else if ((commandSplit[0].equals("start") && commandSplit[1].equals("user") && commandSplit[2].equals("easy")) ||
                    commandSplit[1].equals("easy") && commandSplit[2].equals("user")) {
                play(grid, new Player("X"), new Computer("O", "easy"));
            } else if (commandSplit[0].equals("start") && ((commandSplit[1].equals("user") && commandSplit[2].equals("medium")) ||
                    (commandSplit[1].equals("medium") && commandSplit[2].equals("user")))) {
                play(grid, new Player("X"), new Computer("O", "medium"));
            } else if(commandSplit[0].equals("start") && ((commandSplit[1].equals("easy") && commandSplit[2].equals("medium")) ||
                    (commandSplit[1].equals("medium") && commandSplit[2].equals("easy")))) {
                play(grid, new Computer("X", "easy"), new Computer("O", "medium"));
            } else {
                System.out.println("Bad parameters!");
                TicTacToe.main(new String[]{});
            }
        } else if (commandSplit.length == 1 && commandSplit[0].equals("exit")) {
            System.exit(0);
        } else {
            System.out.println("Bad parameters!");
            TicTacToe.main(new String[]{});
        }
        grid.showGrid();


    }
}
