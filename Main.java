package battleship;

import java.util.Scanner;

public class Main {
	Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		Main game = new Main();
		Board board = new Board();
		board.initBoard();
		board.logGameField();

		// ask for ships to place
		Ship aircraftCarrier = game.askForShipsToPlace("Aircraft Carrier", 5);
		if (aircraftCarrier != null) {
			board.placeShip(aircraftCarrier);
			board.logGameField();
		}

		String coordinatesString = game.askForCoordinates();
		String[] parts = coordinatesString.split(" ");
		Coordinate start = Coordinate.parseCoordinate(parts[0]);
		Coordinate end = Coordinate.parseCoordinate(parts[1]);

		Boolean startIsValid = Coordinate.coordinateIsValid(start);
		Boolean endIsValid = Coordinate.coordinateIsValid(end);

		if (!startIsValid || !endIsValid) {
			System.out.println("Error!");
			return;
		}

		Ship ship = new Ship(start, end);
		ship.printFullCoordinates();
		ship.printLength();
	}



	/**
	 * ask the user to place ships
	 * - Aircraft Carrier is 5 cells
	 * - Battleship is 4 cells
	 * - Submarine is 3 cells
	 * - Cruiser is also 3 cells
	 * - Destroyer is 2 cells.
	 * will also check if the length is correct for the type of ship
	 * will also check that ships do not overlap and are not adjacent
	 * log Error otherwise
	 * if ship was placed update the board with O
	 */
	private Ship askForShipsToPlace(String type, int askingLength) {
		System.out.println("Enter the coordinates of the " + type + " (" + askingLength + " cells):");
		// example: A1 A5
		String coordinatesString = scanner.nextLine();
		String[] parts = coordinatesString.split(" ");
		Coordinate start = Coordinate.parseCoordinate(parts[0]);
		Coordinate end = Coordinate.parseCoordinate(parts[1]);

		Boolean startIsValid = Coordinate.coordinateIsValid(start);
		Boolean endIsValid = Coordinate.coordinateIsValid(end);

		if (!startIsValid || !endIsValid) {
			System.out.println("Error!");
			return null;
		}

		Ship ship = new Ship(start, end);

		if (ship.length != askingLength) {
			System.out.println("Error! Invalid ship length");
			return null;
		}

		return ship;
	}



	private String askForCoordinates() {
		System.out.println("Enter the coordinates of the ship:");
		// example: A1 A2
		return scanner.nextLine();
	}

}
