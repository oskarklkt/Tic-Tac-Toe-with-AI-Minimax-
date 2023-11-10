package tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class CoordinatesConstraints {
    public static boolean checkIfCorrectCoordinates (int y, int x) {
        List<Integer> validCoords = new ArrayList<>();
        validCoords.add(1);
        validCoords.add(2);
        validCoords.add(3);
        return validCoords.contains(x) && validCoords.contains(y);
    }

    public static boolean checkIfNotOccupied(int y, int x, Grid grid) {
        return (grid.getSignsList().get((y * 3 - 3) + x - 1).equals(" "));
    }

    public static boolean isInputValid(String input) {
        try {
            Scanner scanner = new Scanner(input);
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
