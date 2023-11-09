package tictactoe;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Grid {
    private String signs;
    private List<String> signsList;

    public Grid (String signs) {
        this.signs = signs;
        this.signsList = signsStringToList();
    }

    public Grid() {
        this.signs = "_________";
        this.signsList = signsStringToList();
    }

    public List<String> signsStringToList() {
        return new ArrayList<>(List.of(signs.replaceAll("_", " ").split("")));
    }

    public void showGrid() {
        System.out.println("---------");
        for (int i = 0; i < 9; i += 3) {
            System.out.print("| ");
            System.out.printf("%s %s %s", signsList.get(i), signsList.get(i + 1), signsList.get(i + 2));
            System.out.println(" |");
        }
    }
}
