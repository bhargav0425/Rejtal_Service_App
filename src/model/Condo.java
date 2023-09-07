package model;

import java.util.ArrayList;

public class Condo extends Building {

	private static int count = 1000;
	private String id;
	int unitNumber;
	int streetNumber;

	public Condo() {
		super();
		count++;
		this.id = "C" + count;
		this.unitNumber = 0;
		this.streetNumber = 0;
		this.streetName = "";
		this.city = "";
		this.postalCode = "";
		this.province = "";
		this.country = "";
		this.isRented = false;
	}

	public Condo(int unitNumber, int streetNumber, String streetName, String city, String postalCode, String province,
			String country, Boolean isRented) {
		super();
		count++;
		this.id = "C" + count;
		this.unitNumber = unitNumber;
		this.streetNumber = streetNumber;
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
	 * @return the unitNumber
	 */
	public int getUnitNumber() {
		return unitNumber;
	}

	/**
	 * @param unitNumber the unitNumber to set
	 */
	public void setUnitNumber(int unitNumber) {
		this.unitNumber = unitNumber;
	}

	/**
	 * @return the streetNumber
	 */
	public int getStreetNumber() {
		return streetNumber;
	}

	/**
	 * @param streetNumber the streetNumber to set
	 */
	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
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
	 * @param condo 
	 * @return 
	 */
	public ArrayList<String> setIsRented(Boolean isRented, Condo condo) {
		this.isRented = isRented;

		if (this.isRented == false) {
			return notifyTenant(condo);
		}
		
		return null;
	}

	@Override
	public String display_address() {
		return "Condo [unitNumber=" + unitNumber + ", streetNumber=" + streetNumber + ", streetName=" + streetName
				+ ", city=" + city + ", postalCode=" + postalCode + ", province=" + province + ", country=" + country
				+ "]";

	}

	@Override
	public String toString() {
		return "Condo [id=" + id + ", unitNumber=" + unitNumber + ", streetNumber=" + streetNumber + ", streetName="
				+ streetName + ", city=" + city + ", postalCode=" + postalCode + ", province=" + province + ", country="
				+ country + ", isRented=" + isRented + "]";
	}

	public void subscribe(Tenant tenant) {
		subscriber.add(tenant);
	}

	public ArrayList<String> notifyTenant(Condo condo) {
		ArrayList<String> notify = new ArrayList<String>();
		for (Tenant t : subscriber) {
			notify.add(t.update()+ "\n"+condo);
			System.out.println(condo);
		}
		return notify;
	}

}
