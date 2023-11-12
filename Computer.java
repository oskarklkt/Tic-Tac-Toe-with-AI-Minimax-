package tictactoe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Computer {
    private String sign;
    private String difficulty;

    public Computer(String sign, String difficulty) {
        this.sign = sign;
        this.difficulty = difficulty;
    }

    public void move(Grid grid) {
        if (difficulty.equals("easy")) {
            easyMove(grid);
        } else if (difficulty.equals("medium")) {
            mediumMove(grid);
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
}
