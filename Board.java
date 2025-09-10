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
	 * place ship on the board update gameField with O for the ship's coordinates at this point the ship is already
	 * validated also check whether the ship can be placed, cannot touch already placed ships
	 */
	public void placeShip(Ship ship) {
		ArrayList<Coordinate> coordinates = ship.allCoordinates;

		for (Coordinate coordinate : coordinates) {
			int row = coordinate.getYinNumber();
			int col = coordinate.x - 1;

			if (!isCellAvailable(row, col)) {
				System.out.println("Error! cannot place your ship there.");
				return;
			}
		}


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



	/**
	 * Check if a cell is free and has no adjacent ships
	 */
	private boolean isCellAvailable(int row, int col) {
		// The cell itself
		if (hasShipAt(row, col))
			return false;

		if (hasShipAt(row - 1, col))
			return false; // up
		if (hasShipAt(row + 1, col))
			return false; // down
		if (hasShipAt(row, col - 1))
			return false; // left
		if (hasShipAt(row, col + 1))
			return false; // right

		if (hasShipAt(row - 1, col - 1))
			return false; // up-left
		if (hasShipAt(row - 1, col + 1))
			return false; // up-right
		if (hasShipAt(row + 1, col - 1))
			return false; // down-left
		if (hasShipAt(row + 1, col + 1))
			return false; // down-right

		return true;
	}



	/**
	 * Check if a coordinate is inside the board and occupied by a ship
	 */
	private boolean hasShipAt(int row, int col) {
		if (!isInsideBoard(row, col))
			return false;
		String[] rowArray = gameField.get(row).split(" ");
		return rowArray[col].equals("O");
	}



	/**
	 * Ensure row and col are within board boundaries
	 */
	private boolean isInsideBoard(int row, int col) {
		return row >= 0 && row < gameField.size()
				&& col >= 0 && col < gameField.get(row).split(" ").length;
	}
}
