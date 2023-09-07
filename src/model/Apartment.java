package model;

import java.util.ArrayList;

public class Apartment extends Building {

	
	private static int count = 1000;
	private String id;
	String civicAddress;
	String apartmentNumber;
	int noOfBedrooms;
	int noOfBathrooms;
	int squareFootage;

	public Apartment() {
		super();
		count++;
		this.id = "A" + count;
		this.civicAddress = "";
		this.apartmentNumber = "";
		this.noOfBedrooms = 0;
		this.noOfBathrooms = 0;
		this.squareFootage = 0;
		this.streetName = "";
		this.city = "";
		this.postalCode = "";
		this.province = "";
		this.country = "";
		this.isRented = false;
	}

	public Apartment(String civicAddress, String apartmentNumber, int noOfBedrooms, int noOfBathrooms,
			int squareFootage, String streetName, String city, String postalCode, String province, String country,
			Boolean isRented) {
		super();
		count++;
		this.id = "A" + count;
		this.civicAddress = civicAddress;
		this.apartmentNumber = apartmentNumber;
		this.noOfBedrooms = noOfBedrooms;
		this.noOfBathrooms = noOfBathrooms;
		this.squareFootage = squareFootage;
		this.streetName = streetName;
		this.city = city;
		this.postalCode = postalCode;
		this.province = province;
		this.country = country;
		this.isRented = isRented;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the civicAddress
	 */
	public String getCivicAddress() {
		return civicAddress;
	}

	/**
	 * @param civicAddress the civicAddress to set
	 */
	public void setCivicAddress(String civicAddress) {
		this.civicAddress = civicAddress;
	}

	/**
	 * @return the apartmentNumber
	 */
	public String getApartmentNumber() {
		return apartmentNumber;
	}

	/**
	 * @param apartmentNumber the apartmentNumber to set
	 */
	public void setApartmentNumber(String apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}

	/**
	 * @return the noOfBedrooms
	 */
	public int getNoOfBedrooms() {
		return noOfBedrooms;
	}

	/**
	 * @param noOfBedrooms the noOfBedrooms to set
	 */
	public void setNoOfBedrooms(int noOfBedrooms) {
		this.noOfBedrooms = noOfBedrooms;
	}

	/**
	 * @return the noOfBathrooms
	 */
	public int getNoOfBathrooms() {
		return noOfBathrooms;
	}

	/**
	 * @param noOfBathrooms the noOfBathrooms to set
	 */
	public void setNoOfBathrooms(int noOfBathrooms) {
		this.noOfBathrooms = noOfBathrooms;
	}

	/**
	 * @return the squareFootage
	 */
	public int getSquareFootage() {
		return squareFootage;
	}

	/**
	 * @param squareFootage the squareFootage to set
	 */
	public void setSquareFootage(int squareFootage) {
		this.squareFootage = squareFootage;
	}

	/**
	 * @return the streetName
	 */
	public String getStreetName() {
		return streetName;
	}

	/**
	 * @param streetName the streetName to set
	 */
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * @param postalCode the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * @return the province
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * @param province the province to set
	 */
	public void setProvince(String province) {
		this.province = province;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the isRented
	 */
	public Boolean getIsRented() {
		return isRented;
	}

	/**
	 * @param isRented the isRented to set
	 * @param apartment 
	 * @return 
	 */
	public ArrayList<String> setIsRented(Boolean isRented, Apartment apartment) {
		
		
		this.isRented = isRented;
		
		if (this.isRented == false) {
			return notifyTenant(apartment);
		}
		return null;
	}

	public String display_address() {
		return "Apartment [civic_address=" + civicAddress + ", apartment_number=" + apartmentNumber + ", bedrooms="
				+ noOfBedrooms + ", bathrooms=" + noOfBathrooms + ", square_footage=" + squareFootage + ", street_name="
				+ streetName + ", postal_code=" + postalCode + ", city=" + city + ", province =" + province
				+ ", country=" + country + "]";
	}

	@Override
	public String toString() {
		return "Apartment [id=" + id + ", civicAddress=" + civicAddress + ", apartmentNumber=" + apartmentNumber
				+ ", noOfBedrooms=" + noOfBedrooms + ", noOfBathrooms=" + noOfBathrooms + ", squareFootage="
				+ squareFootage + ", streetName=" + streetName + ", city=" + city + ", postalCode=" + postalCode
				+ ", province=" + province + ", country=" + country + ", isRented=" + isRented + "]";
	}
	
	public void subscribe(Tenant tenant) {
		subscriber.add(tenant);
	}
	
	public ArrayList<String> notifyTenant(Apartment apartment) {
		
		ArrayList<String> notify = new ArrayList<String>();
		for (Tenant t : subscriber) {
			notify.add(t.update()+ "\n"+apartment);
			System.out.println(apartment);
		}
		return notify;
	}
	
	
}
