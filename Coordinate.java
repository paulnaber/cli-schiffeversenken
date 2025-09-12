package battleship;

import java.util.ArrayList;
import java.util.Arrays;

public class Coordinate {
	Integer x = null;
	String  y = null;
	static ArrayList<String> yOrder = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J"));



	public Coordinate(String y, Integer x) {
		this.x = x;
		this.y = y;
	}



	/**
	 * get the y (A, B, C...) as a number this way the Ship can calculate its length
	 */
	public int getYinNumber() {
		return yOrder.indexOf(this.y);
	}



	public static String getYinString(int number) {
		return yOrder.get(number);
	}



	public String getCoordinateAsString() {
		return this.y + this.x.toString() + " ";
	}



	/**
	 * will get "A1" for example and split it
	 * @return Coordinate from it
	 */
	public static Coordinate parseCoordinate(String s) {
		// split into letter(s) and number(s)
		String letter;
		int number;
		try {
			letter = s.replaceAll("[0-9]", "");
			number = Integer.parseInt(s.replaceAll("[A-Za-z]", ""));
		} catch (Exception err) {
			System.out.println("Error! Failed to parse coordinate!");
			return null;
		}
		return new Coordinate(letter, number);
	}


	public static Boolean coordinateIsValid(Coordinate c) {
		if (c != null) {
			return yOrder.contains(c.y) && (c.x >= 1 && c.x <= 10);
		} else {
			return false;
		}
	}
}
