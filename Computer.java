package tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Computer {
    public static String sign = "O";

    public static void easyMove(Grid grid) {
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
}
