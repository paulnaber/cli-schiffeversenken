package battleship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	ArrayList<String> gameField = new ArrayList<>();
	Scanner           scanner   = new Scanner(System.in);



	public static void main(String[] args) {
		Main game = new Main();
		game.init();
		game.logGameField();
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



	private void init() {
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



	private String askForCoordinates() {
		System.out.println("Enter the coordinates of the ship:");
		// example: A1 A2
		return scanner.nextLine();
	}



	private void logGameField() {
		String firstRow = "  1 2 3 4 5 6 7 8 9 10";
		ArrayList<String> rowPrefix = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J"));
		System.out.println(firstRow);
		for (int i = 0; i < gameField.size(); i++) {
			System.out.println(rowPrefix.get(i) + " " + gameField.get(i));
		}
	}
}
