package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Tenant {

	private static int count = 1000;
	private String id;
	public String firstName;
	public String lastName;
	public int age;
	public String contactNumber;
	private String email;
	HashMap<String, ArrayList<String>> myProperty = new HashMap<>();
	ArrayList<Building> interestedProperty = new ArrayList<>();
	// Interested properties id attribute

	public Tenant() {
		super();
		// TODO Auto-generated constructor stub
		count++;
		this.id = "T" + count;
		this.firstName = "";
		this.lastName = "";
		this.age = 0;
		this.contactNumber = "";
		this.email = "";
		this.myProperty.put(id, new ArrayList<>());
	}

	public Tenant(String firstName, String lastName, int age, String contactNumber, String email) {
		super();
		count++;
		this.id = "T" + count;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.contactNumber = contactNumber;
		this.email = email;
		this.myProperty.put(id, new ArrayList<>());
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the contactNumber
	 */
	public String getContactNumber() {
		return contactNumber;
	}

	/**
	 * @param contactNumber the contactNumber to set
	 */
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	public void addProperty(String pId, String tId) {
		// TODO Auto-generated method stub
		ArrayList<String> a = myProperty.get(tId);

		a.add(pId);
		myProperty.put(tId, a);

	}

	public void addInterestedProperty(Building property) {
		// TODO Auto-generated method stub

		interestedProperty.add(property);

		if (property instanceof Apartment) {
			Apartment apartment = (Apartment) property;
			System.out.println("Hurray!! interested property " + apartment.getId() + " added into your wishlist..");
		} else if (property instanceof Condo) {
			Condo condo = (Condo) property;
			System.out.println("Hurray!! interested property " + condo.getId() + " added into your wishlist..");
		} else if (property instanceof House) {
			House house = (House) property;
			System.out.println("Hurray!! interested property " + house.getId() + " added into your wishlist..");
		}
	}

	@Override
	public String toString() {
		return "Tenant [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", contactNumber=" + contactNumber + ", email=" + email + ", myProperty=" + myProperty.toString() +"myProperty"+ interestedProperty.toString()
				+ "]";
	}

	public String update() {
		System.out.println("\nHi " + this.getFirstName() + " " + this.getLastName()
				+ ", I hope all is well with you.\nThis email is to inform you that following property is now available for the rent : \n");
		return "\nHi " + this.getFirstName() + " " + this.getLastName()
		+ ", I hope all is well with you.\nThis email is to inform you that following property is now available for the rent : \n";

	
	
}

}
