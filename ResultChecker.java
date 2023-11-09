package tictactoe;

import java.util.List;

public class ResultChecker {
    private String checkDiagonally(Grid grid) {
        List<String> gridList = grid.getSignsList();
        if (    (gridList.get(0).equals(gridList.get(4)) && gridList.get(4).equals(gridList.get(8))) ||
                (gridList.get(2).equals(gridList.get(4)) && gridList.get(4).equals(gridList.get(6)))) {
            return gridList.get(4);
        }
        return "";
    }

    private String checkVertically(Grid grid) {
        List<String> gridList = grid.getSignsList();
        for (int i = 0; i <= 2; i++) {
            if ((gridList.get(i).equals(gridList.get(i + 3)) && (gridList.get(i + 3).equals(gridList.get(i + 6))))) {
                return gridList.get(i);
            }
        }
        return "";
    }

    private String checkHorizontally(Grid grid) {
        List<String> gridList = grid.getSignsList();
        for (int i = 0; i <= 6; i += 3) {
            if ((gridList.get(i).equals(gridList.get(i + 1)) && (gridList.get(i + 1).equals(gridList.get(i + 2))))) {
                return gridList.get(i);
            }
        }
        return "";
    }

    private String getResult(Grid grid) {
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

    public boolean check(Grid grid) {
        String result = getResult(grid);
        if (!result.isEmpty() && grid.getSignsList().contains(" ")) {
            System.out.printf("%s wins\n", result);
            return true;
        } else if (!grid.getSignsList().contains(" ") && result.isEmpty()) {
            System.out.println("Draw");
            return true;
        } else {
            System.out.println("Game not finished");
            return false;
        }
    }
}

