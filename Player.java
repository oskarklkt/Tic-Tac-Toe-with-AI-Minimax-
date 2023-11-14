package tictactoe;


import java.util.Scanner;

public class Player {
    public String sign;
    public Player(String sign) {
        this.sign = sign;
    }
    public void move(Grid grid) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the coordinates: ");
        String coordinates = scanner.nextLine();
        if (CoordinatesConstraints.isInputValid(coordinates)) {
            int y = Integer.parseInt(String.valueOf(coordinates.charAt(0)));
            int x = Integer.parseInt(String.valueOf(coordinates.charAt(2)));

            while (!(CoordinatesConstraints.checkIfCorrectCoordinates(y, x) &&
                    CoordinatesConstraints.checkIfNotOccupied(y, x, grid))) {
                if (!CoordinatesConstraints.checkIfCorrectCoordinates(y, x)) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    move(grid);
                } else if (!CoordinatesConstraints.checkIfNotOccupied(y, x, grid)) {
                    System.out.println("This cell is occupied! Choose another one!");
                    move(grid);
                }
            }
            grid.updateGrid(y, x, sign);
            grid.showGrid();
        } else {
            System.out.println("You should enter numbers!");
            move(grid);
        }
    }
}
