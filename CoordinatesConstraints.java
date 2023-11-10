package tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
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
        char[] chars = input.toCharArray();
        try {
            boolean isFirstDigit = Character.isDigit(chars[0]);
            boolean isSecondDigit = Character.isDigit(chars[2]);
            return isSecondDigit && isFirstDigit && input.length() == 3;
        } catch (Exception e) {
            return false;
        }
    }
}
