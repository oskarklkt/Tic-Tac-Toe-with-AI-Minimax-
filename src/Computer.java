package tictactoe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Computer {
    private final String sign;
    private final String difficulty;
    private final String oppositeSign;

    public Computer(String sign, String difficulty) {
        this.sign = sign;
        this.difficulty = difficulty;
        if (sign.equals("X")) {
            this.oppositeSign = "O";
        } else {
            this.oppositeSign = "X";
        }
    }



    public void move(Grid grid) {
        if (difficulty.equals("easy")) {
            easyMove(grid);
        } else if (difficulty.equals("medium")) {
            mediumMove(grid);
        } else {
            hardMove(grid);
        }
    }


    public void easyMove(Grid grid) {
        System.out.println("Making move level \"easy\"");
        List<String> signsList = grid.getSignsList();
        List<Integer> onlyNotOccupied = new ArrayList<>();
        for (int i = 0; i < signsList.size(); i++) {
            if (signsList.get(i).equals(" ")) {
                onlyNotOccupied.add(i);
            }
        }
        Random random = new Random();
        int index = onlyNotOccupied.get(random.nextInt(onlyNotOccupied.size()));
        int y = index/3 + 1;
        int x;
        if (index == 1 || index == 4 || index == 7 ) {
            x = 2;
        } else if (index == 2 || index == 5 || index == 8) {
            x = 3;
        } else {
            x = 1;
        }
        grid.updateGrid(y, x, sign);
        grid.showGrid();
    }

    public void mediumMove(Grid grid) {
        List<List<String>> rows = grid.getRowsList();
        List<List<String>> columns = grid.getColumnsList();
        boolean flag = false;
        for (List<String> row : rows) {
            if (Collections.frequency(row, "O") == 2 && !flag && row.contains(" ") ||
                    Collections.frequency(row, "X") == 2 && !flag && row.contains(" ")) {
                grid.updateGrid(rows.indexOf(row) + 1, row.indexOf(" ") + 1, sign);
                flag = true;
                grid.showGrid();
            }
        }
        for (List<String> column : columns) {
            if (Collections.frequency(column, "O") == 2 && !flag && column.contains(" ") ||
                    Collections.frequency(column, "X") == 2 && !flag && column.contains(" ")) {
                grid.updateGrid(column.indexOf(" ") + 1, columns.indexOf(column) + 1, sign);
                flag = true;
                grid.showGrid();
            }
        }
        if ((grid.getSignsList().get(0).equals(grid.getSignsList().get(4))) && !flag && grid.getSignsList().get(8).equals(" ")) {
            grid.updateGrid(3, 3, sign);
            flag = true;
            grid.showGrid();
        }
        if ((grid.getSignsList().get(0).equals(grid.getSignsList().get(8))) && !flag && grid.getSignsList().get(4).equals(" ")) {
            grid.updateGrid(2, 2, sign);
            flag = true;
            grid.showGrid();
        }
        if ((grid.getSignsList().get(4).equals(grid.getSignsList().get(8))) && !flag && grid.getSignsList().get(0).equals(" ")) {
            grid.updateGrid(1, 1, sign);
            flag = true;
            grid.showGrid();
        }
        if ((grid.getSignsList().get(2).equals(grid.getSignsList().get(4))) && !flag && grid.getSignsList().get(6).equals(" ")) {
            grid.updateGrid(3, 1, sign);
            flag = true;
            grid.showGrid();
        }
        if ((grid.getSignsList().get(2).equals(grid.getSignsList().get(6))) && !flag && grid.getSignsList().get(4).equals(" ")) {
            grid.updateGrid(2, 2, sign);
            flag = true;
            grid.showGrid();
        }
        if ((grid.getSignsList().get(4).equals(grid.getSignsList().get(6))) && !flag && grid.getSignsList().get(2).equals(" ")) {
            grid.updateGrid(1, 3, sign);
            flag = true;
            grid.showGrid();
        }
        if (!flag) {
            easyMove(grid);
        }

    }

    public void hardMove(Grid grid) {
        int bestScore = Integer.MIN_VALUE;
        int[] move = new int[2];
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if ((grid.getRowsList().get(y)).get(x).equals(" ")) {
                    grid.updateGrid(y + 1, x + 1, sign);
                    int score = minimax(grid, false, Integer.MIN_VALUE, Integer.MAX_VALUE);
                    grid.updateGrid(y + 1, x + 1, " ");
                    if (score > bestScore) {
                        bestScore = score;
                        move[0] = y;
                        move[1] = x;
                    }
                }
            }
        }
        grid.updateGrid(move[0] + 1, move[1] + 1, sign);
    }


    //minimax implementation
    public int minimax(Grid grid, boolean isMaximizing, int alpha, int beta) {
        if (ResultChecker.check(grid)) {
            return 1;
        }

        if (isMaximizing) {
            int bestScore = Integer.MIN_VALUE;
            for (int x = 0; x < 3; x++) {
                for (int y = 0; y < 3; y++) {
                    if ((grid.getRowsList().get(y)).get(x).equals(" ")) {
                        grid.updateGrid(y + 1, x + 1, sign);
                        int score = minimax(grid, false, alpha, beta);
                        grid.updateGrid(y + 1, x + 1, " ");
                        bestScore = Math.max(score, bestScore);
                        alpha = Math.max(bestScore, alpha);
                        if (beta <= alpha) {
                            break;
                        }
                    }
                }
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;
            for (int x = 0; x < 3; x++) {
                for (int y = 0; y < 3; y++) {
                    if ((grid.getRowsList().get(y)).get(x).equals(" ")) {
                        grid.updateGrid(y + 1, x + 1, oppositeSign);
                        int score = minimax(grid, true, alpha, beta);
                        grid.updateGrid(y + 1, x + 1, " ");
                        bestScore = Math.min(score, bestScore);
                        beta = Math.min(bestScore, beta);
                        if (beta <= alpha) {
                            break;
                        }
                    }
                }
            }
            return bestScore;
        }
    }

}
