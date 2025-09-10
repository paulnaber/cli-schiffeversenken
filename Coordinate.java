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
		String letter = s.replaceAll("[0-9]", "");
		int number = Integer.parseInt(s.replaceAll("[A-Za-z]", ""));
		return new Coordinate(letter, number);
	}


	public static Boolean coordinateIsValid(Coordinate c) {
		return yOrder.contains(c.y) && (c.x >= 1 && c.x <= 10);
	}
}
