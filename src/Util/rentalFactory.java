package Util;

import model.Apartment;
import model.Building;
import model.Condo;
import model.House;

public class rentalFactory {
	// use getBuilding method to get object of type rental
	public Building getBuilding(String rentalType) {
		if (rentalType == null) {
			return null;
		}
		if (rentalType.equalsIgnoreCase("APARTMENT")) {
			return new Apartment();

		} else if (rentalType.equalsIgnoreCase("CONDO")) {
			return new Condo();

		} else if (rentalType.equalsIgnoreCase("HOUSE")) {
			return new House();
		}

		return null;
	}
}
