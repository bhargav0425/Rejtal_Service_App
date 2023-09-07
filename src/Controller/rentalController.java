package Controller;

import model.Lease;
import model.Tenant;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import View.Driver;
import model.Apartment;
import model.Building;
import model.Condo;
import model.House;

public class rentalController {

	private Building model;
	private Driver view;
	public static ArrayList<Building> building = new ArrayList<>();
	Lease lease;
	static ArrayList<Lease> leaseRecords = new ArrayList<>();
//	private rentalFactory rf = new rentalFactory();
//
//	model=rf.getBuilding(null);

	public rentalController() {
	}

	public rentalController(Building model) {
		this.model = model;
		building.add(model);
	}

	public void addProperty(Building model) {
		this.model = model;
		building.add(model);
	}

	public static void displayProperties() {
		if (building.size() == 0) {
			System.out.println("No properties are available right now!");
		} else {
			for (Building property : building) {
				System.out.println(property.toString());
			}
			System.out.println();
		}
	}
	// adding a method to displayproperties in javafx
	
	public static ArrayList<Building> getProperties()
	{
		return building;
	}

	public static void displayRentedProperties() {
		boolean areAllRented = false;
		if (building.size() == 0) {
			System.out.println("No rented properties are available right now!");
		} else {
			for (Building property : building) {
				if (property instanceof Apartment) {
					Apartment apartment = (Apartment) property;
					if (apartment.getIsRented().equals(true)) {
						areAllRented = true;
						System.out.println(apartment.toString());
					}
				} else if (property instanceof Condo) {
					Condo condo = (Condo) property;
					if (condo.getIsRented().equals(true)) {
						areAllRented = true;
						System.out.println(condo.toString());
					}
				} else if (property instanceof House) {
					House house = (House) property;
					if (house.getIsRented().equals(true)) {
						areAllRented = true;
						System.out.println(house.toString());
					}
				}
			}
			System.out.println();
			if (!areAllRented) {
				System.out.println("There are no rented properties...");
			}
		}
	}
	public static boolean getRentedProperties(Building property)
	{
		
				if (property instanceof Apartment) {
					Apartment apartment = (Apartment) property;
					if (apartment.getIsRented().equals(true)) {
						return true;
					}
				} else if (property instanceof Condo) {
					Condo condo = (Condo) property;
					if (condo.getIsRented().equals(true)) {
						return true;
					}
				} else if (property instanceof House) {
					House house = (House) property;
					if (house.getIsRented().equals(true)) {
						return true;
					}
				}
			
			return false;
		
	}

	public static boolean displayVacantProperties() {
		boolean areAllRented = true;
		if (building.size() == 0) {
			System.out.println("No vacant properties are available right now!");
		} else {
			for (Building property : building) {
				if (property instanceof Apartment) {
					Apartment apartment = (Apartment) property;
					if (apartment.getIsRented().equals(false)) {
						System.out.println(apartment.toString());
						areAllRented = false;
					}
				} else if (property instanceof Condo) {
					Condo condo = (Condo) property;
					if (condo.getIsRented().equals(false)) {
						System.out.println(condo.toString());
						areAllRented = false;
					}
				} else if (property instanceof House) {
					House house = (House) property;
					if (house.getIsRented().equals(false)) {
						System.out.println(house.toString());
						areAllRented = false;
					}
				}
			}
			System.out.println();
		}

		return areAllRented;
	}

	public void rentProperty(String pId, Tenant tenant, String emailId, String startDate, String endDate, int rent)
			throws ParseException {
		// TODO Auto-generated method stub

		lease = new Lease();

		String dateFormate = "dd/mm/yyyy";
		for (Building property : building) {
			if (property instanceof Apartment) {
				// if (pId.toCharArray()[0] == 'A') {
				Apartment apartment = (Apartment) property;
				if (pId.equals(apartment.getId())) {
					apartment.setIsRented(true, apartment);
					lease.setStartDate(new SimpleDateFormat(dateFormate).parse(startDate));
					lease.setEndDate(new SimpleDateFormat(dateFormate).parse(endDate));
					lease.setRentAmount(rent);
					lease.setBuilding(apartment);
					lease.setTenant(tenant);
					leaseRecords.add(lease);
					System.out.println("Congratulations!! Your Lease has been created.\n");
					System.out.println(lease.toString());
					break;
				}
			} else if (property instanceof Condo) {
				// else if (pId.toCharArray()[0] == 'C') {
				Condo condo = (Condo) property;
				if (pId.equals(condo.getId())) {
					condo.setIsRented(true, condo);
					lease.setStartDate(new SimpleDateFormat(dateFormate).parse(startDate));
					lease.setEndDate(new SimpleDateFormat(dateFormate).parse(endDate));
					lease.setRentAmount(rent);
					lease.setBuilding(condo);
					lease.setTenant(tenant);
					leaseRecords.add(lease);
					System.out.println("Congratulations!! Your Lease has been created.\n");
					System.out.println(lease.toString());
					break;
				}
			} else if (property instanceof House) {
				// else if (pId.toCharArray()[0] == 'H') {
				House house = (House) property;
				if (pId.equals(house.getId())) {
					house.setIsRented(true, house);
					lease.setStartDate(new SimpleDateFormat(dateFormate).parse(startDate));
					lease.setEndDate(new SimpleDateFormat(dateFormate).parse(endDate));
					lease.setRentAmount(rent);
					lease.setBuilding(house);
					lease.setTenant(tenant);
					leaseRecords.add(lease);
					System.out.println("Congratulations!! Your Lease has been created.\n");
					System.out.println(lease.toString());
					break;
				}
			}
			System.out.println();
		}
		System.out.println();
	}

	/*
	 * display all the leases in the database
	 */
	public void displayLeases() {
		try {
			if (leaseRecords.size() == 0) {
				System.out.println("No lease are available right now!");
			} else {
				System.out.println("Here's the leases : ");
				for (Lease l : leaseRecords) {
					System.out.println(l.toString());
				}
				System.out.println("Thank you!");
			}
		} catch (Exception e) {
			System.out.println("It seems something went wrong");
		}

	}
	public ArrayList<Lease> getLeases()
	{
		return leaseRecords;
	}

	public Building getProperty(String sId) {

		for (Building property : building) {
			if (property instanceof Apartment) {
				Apartment apartment = (Apartment) property;
				if (sId.equals(apartment.getId()))
					return apartment;
			} else if (property instanceof Condo) {
				Condo condo = (Condo) property;
				if (sId.equals(condo.getId()))
					return condo;
			} else if (property instanceof House) {
				House house = (House) property;
				if (sId.equals(house.getId()))
					return house;
			}

			System.out.println();
		}
		System.out.println();
		return null;
	}
}