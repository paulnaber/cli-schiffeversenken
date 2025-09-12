package battleship;

import java.util.Scanner;

public class Main {
	Scanner scanner = new Scanner(System.in);



	public static void main(String[] args) {
		Main game = new Main();
		Board board = new Board();
		board.initBoard();
		board.logGameField(Board.BoardType.REAL);

		// ask for ships to place
		game.askForShipAndPlaceWithRetry(game, board, "Aircraft Carrier", 5);
		game.askForShipAndPlaceWithRetry(game, board, "Battleship", 4);
		game.askForShipAndPlaceWithRetry(game, board, "Submarine", 3);
		game.askForShipAndPlaceWithRetry(game, board, "Cruiser", 3);
		game.askForShipAndPlaceWithRetry(game, board, "Destroyer", 2);

		// start game / shooting
		System.out.println("The game starts!");
		board.logGameField(Board.BoardType.HIDDEN);
		game.askForShotandShootWithRetry(game, board);

	}



	/**
	 * ask the user to place ships - Aircraft Carrier is 5 cells - Battleship is 4 cells - Submarine is 3 cells -
	 * Cruiser is also 3 cells - Destroyer is 2 cells. will also check if the length is correct for the type of ship
	 * will also check that ships do not overlap and are not adjacent log Error otherwise if ship was placed update the
	 * board with O
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

		if (ship.length == null) {
			// ship calculation ran in an error
			return null;
		}

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



	private void askForShipAndPlaceWithRetry(Main game, Board board, String name, int size) {
		boolean placed = false;
		while (!placed) {
			Ship ship = game.askForShipsToPlace(name, size);
			if (ship == null) {
				continue; // if the ship is null the ship was not valid (size or direction)
			}
			placed = board.placeShip(ship);
			if (placed) {
				board.logGameField(Board.BoardType.REAL);
			}
		}
	}



	/**
	 * ask the player to enter a coordinate shoot at the coordinate update the board log
	 */
	private void askForShotandShootWithRetry(Main game, Board board) {
		System.out.println("Take a shot!");

		boolean shot = false;
		while (!shot) {
			// example: A1 A2
			String answer = scanner.nextLine();
			Coordinate targetCoordinate = Coordinate.parseCoordinate(answer);
			boolean targetCoordinateIsValid = Coordinate.coordinateIsValid(targetCoordinate);
			if (targetCoordinate == null || !targetCoordinateIsValid) {
				System.out.println("Error! Retry!");
				continue;
			}
			boolean hitShip = board.shoot(targetCoordinate);
			if (hitShip) {
				board.logGameField(Board.BoardType.HIDDEN);
				System.out.println("You hit a ship!");
			}
			else {
				System.out.println("You missed!");
			}
			board.logGameField(Board.BoardType.REAL);
			shot = true;
		}
	}

}
