package tictactoe;

import java.util.List;

public abstract class ResultChecker {
    private static String checkDiagonally(Grid grid) {
        List<String> gridList = grid.getSignsList();
        if (    (gridList.get(0).equals(gridList.get(4)) && gridList.get(4).equals(gridList.get(8))) ||
                (gridList.get(2).equals(gridList.get(4)) && gridList.get(4).equals(gridList.get(6))) &&
                !gridList.get(4).equals(" ")){
            return gridList.get(4);
        }
        return "";
    }

    private static String checkVertically(Grid grid) {
        List<String> gridList = grid.getSignsList();
        for (int i = 0; i <= 2; i++) {
            if ((gridList.get(i).equals(gridList.get(i + 3)) && (gridList.get(i + 3).equals(gridList.get(i + 6))))&&
                    !gridList.get(i).equals(" ")) {
                return gridList.get(i);
            }
        }
        return "";
    }

    private static String checkHorizontally(Grid grid) {
        List<String> gridList = grid.getSignsList();
        for (int i = 0; i <= 6; i += 3) {
            if ((gridList.get(i).equals(gridList.get(i + 1)) && (gridList.get(i + 1).equals(gridList.get(i + 2)))) &&
            !gridList.get(i).equals(" ")){
                return gridList.get(i);
            }
        }
        return "";
    }

    private static String getResult(Grid grid) {
        String vertically = checkVertically(grid);
        String horizontally = checkHorizontally(grid);
        String diagonally = checkDiagonally(grid);
        if (!diagonally.isEmpty()) {
            return diagonally;
        } else if (!vertically.isEmpty()) {
            return vertically;
        } else if (!horizontally.isEmpty()) {
            return horizontally;
        } else {
            return "";
        }
    }

    public static boolean check(Grid grid) {
        String result = getResult(grid);
        if (!result.isEmpty() ) {
            System.out.printf("%s wins\n", result);
            return true;
        } else if (!grid.getSignsList().contains(" ")) {
            System.out.println("Draw");
            return true;
        } else {
            System.out.println("Game not finished");
            return false;
        }
    }
}

