package battleship;

import java.util.ArrayList;
import java.util.Arrays;

public class Board {
    ArrayList<String> gameField = new ArrayList<>();

    public void initBoard() {
        gameField.add("~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
        gameField.add("~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
        gameField.add("~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
        gameField.add("~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
        gameField.add("~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
        gameField.add("~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
        gameField.add("~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
        gameField.add("~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
        gameField.add("~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
        gameField.add("~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
    }



    /**
     * place ship on the board
     * update gameField with O for the ship's coordinates
     * at this point the ship is already validated
     */
    public void placeShip(Ship ship) {
        ArrayList<Coordinate> coordinates = ship.allCoordinates;
        for (Coordinate coordinate : coordinates) {
            int row = coordinate.getYinNumber();
            int col = coordinate.x - 1;
            String[] rowArray = gameField.get(row).split(" ");
            rowArray[col] = "O";
            gameField.set(row, String.join(" ", rowArray));
        }
    }



    public void logGameField() {
        String firstRow = "  1 2 3 4 5 6 7 8 9 10";
        ArrayList<String> rowPrefix = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J"));
        System.out.println(firstRow);
        for (int i = 0; i < gameField.size(); i++) {
            System.out.println(rowPrefix.get(i) + " " + gameField.get(i));
        }
    }

}
