package battleship;

import java.util.ArrayList;

public class Ship {
	Coordinate				start			= null;
	Coordinate				end				= null;
	Integer					length			= null;
	ArrayList<Coordinate>	allCoordinates	= new ArrayList<>();

	public Ship(Coordinate start, Coordinate end) {
		this.start = start;
		this.end = end;
		this.calculateShip();
	}



	public void calculateShip() {
		// diagonal is not allowed
		if (!(start.x.equals(end.x)) && !(start.y.equals(end.y))) {
			System.out.println("Error! Diagonal is not allowed!");
		}
		// vertical ship
		if (start.x.equals(end.x)) {
			int se = start.getYinNumber() - end.getYinNumber();
			int es = end.getYinNumber() - start.getYinNumber();

			// calculate the all coordinates
			if (start.getYinNumber() > end.getYinNumber()) {
				for (int i = end.getYinNumber(); i <= start.getYinNumber(); i++) {
					allCoordinates.add(new Coordinate(Coordinate.getYinString(i), start.x));
				}
			}
			// calculate the all coordinates
			if (end.getYinNumber() > start.getYinNumber()) {
				for (int i = start.getYinNumber(); i <= end.getYinNumber(); i++) {
					allCoordinates.add(new Coordinate(Coordinate.getYinString(i), start.x));
				}
			}
			// calculate the length
			this.length = Math.max(se, es) + 1; // including
		}

		// horizontal ship
		if (start.y.equals(end.y)) {
			int se = start.x - end.x;
			int es = end.x - start.x;

			// calculate the all coordinates
			if (start.x > end.x) {
				for (int i = end.x; i <= start.x; i++) {
					allCoordinates.add(new Coordinate(start.y, i));
				}
			}
			// calculate the all coordinates
			if (end.x > start.x) {
				for (int i = start.x; i <= end.x; i++) {
					allCoordinates.add(new Coordinate(start.y, i));
				}
			}
			this.length = Math.max(se, es) + 1; // including
		}
	}



	public void printFullCoordinates() {
		System.out.print("Parts: ");
		for (Coordinate c : allCoordinates) {
			System.out.print(c.getCoordinateAsString());
		}
		System.out.println();
	}



	public void printLength() {
		System.out.println("Length: " + this.length);
	}
}
