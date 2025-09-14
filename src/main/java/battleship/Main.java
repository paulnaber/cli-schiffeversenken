package battleship;

import java.util.Scanner;

public class Main {
	Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		Main game = new Main();

		Player player1 = new Player("Player 1");
		Player player2 = new Player("Player 2");

		System.out.println(player1.getName() + ", place your ships on the game field");
		player1.getBoard().initBoard();
		player1.getBoard().logGameField(Board.BoardType.REAL);
		game.askForShipAndPlaceWithRetry(game, player1.getBoard(), "Aircraft Carrier", 5);
		game.askForShipAndPlaceWithRetry(game, player1.getBoard(), "Battleship", 4);
		game.askForShipAndPlaceWithRetry(game, player1.getBoard(), "Submarine", 3);
		game.askForShipAndPlaceWithRetry(game, player1.getBoard(), "Cruiser", 3);
		game.askForShipAndPlaceWithRetry(game, player1.getBoard(), "Destroyer", 2);

		System.out.println("Press Enter and pass the move to another player");
		game.scanner.nextLine();
		clearScreen();

		System.out.println(player2.getName() + ", place your ships to the game field");
		player2.getBoard().initBoard();
		player2.getBoard().logGameField(Board.BoardType.REAL);
		game.askForShipAndPlaceWithRetry(game, player2.getBoard(), "Aircraft Carrier", 5);
		game.askForShipAndPlaceWithRetry(game, player2.getBoard(), "Battleship", 4);
		game.askForShipAndPlaceWithRetry(game, player2.getBoard(), "Submarine", 3);
		game.askForShipAndPlaceWithRetry(game, player2.getBoard(), "Cruiser", 3);
		game.askForShipAndPlaceWithRetry(game, player2.getBoard(), "Destroyer", 2);

		System.out.println("Press Enter and pass the move to another player");
		game.scanner.nextLine();
		clearScreen();

		boolean gameOver = false;
		Player currentPlayer = player1;
		Player opponent = player2;

		while (!gameOver) {
			// Show opponent's board (hidden) and current player's board (real)
			opponent.getBoard().logGameField(Board.BoardType.HIDDEN);
			System.out.println("---------------------");
			currentPlayer.getBoard().logGameField(Board.BoardType.REAL);

			System.out.println(currentPlayer.getName() + ", it's your turn:");
			boolean allShipsSank = game.askForShotAndShootWithRetry(opponent.getBoard());

			if (allShipsSank) {
				System.out.println(currentPlayer.getName() + " sank the last ship. You won. Congratulations!");
				gameOver = true;
			}

			System.out.println("Press Enter and pass the move to another player");
			game.scanner.nextLine();
			clearScreen();

			// Swap players
			Player temp = currentPlayer;
			currentPlayer = opponent;
			opponent = temp;
		}
	}



	/**
	 * Utility method to clear the console screen
	 */
	private static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
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
	 * ask the player to enter a coordinate shoot at the coordinate update the board log if the shot was not successfull
	 * it will try again until a shot was done returns true if all ships are sank
	 */
	public boolean askForShotAndShootWithRetry(Board board) {
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
			board.logGameField(Board.BoardType.HIDDEN);
			if (hitShip) {
				System.out.println("You hit a ship!");
			}
			else {
				System.out.println("You missed!");
			}
			boolean allShipsSank = board.checkAndUpdateLivingShips();
			if (allShipsSank) {
				return true;
			}
			shot = true;
		}
		return false;
	}
}
