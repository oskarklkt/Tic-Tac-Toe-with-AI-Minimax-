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

    public String getSigns() {
        return signs;
    }

    public List<String> getSignsList() {
        return signsList;
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
        System.out.println("---------");
    }

    public void updateGrid(int y, int x, String sign) {
        signsList.set(y * 3 - 3 + x - 1, sign);
    }

    public List<List<String>> getRowsList() {
        List<List<String>> result = new ArrayList<>();
        result.set(0, signsList.subList(0, 3));
        result.set(1, signsList.subList(3, 6));
        result.set(2, signsList.subList(6, 9));
        return result;
    }

    public List<List<String>> getCollumnsList() {
        List<List<String>> result = new ArrayList<>();
        List<List<String>> rows = getRowsList();
        for (int i = 0; i <= 2; i++) {
            List<String> temp = new ArrayList<>();
            for (List<String> row : rows) {
                temp.add(row.get(i));
            }
            result.set(0, temp);
        }
        return result;
    }
        
}
