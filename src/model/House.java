package model;

import java.util.ArrayList;

public class House extends Building {

	private static int count = 1000;
	private String id;
	int streetNumber;

	public House() {
		super();
		count++;
		this.id = "H" + count;
		this.streetNumber = 0;
		this.streetName = "";
		this.city = "";
		this.postalCode = "";
		this.province = "";
		this.country = "";
		this.isRented = false;
	}

	public House(int streetNumber, String streetName, String city, String postalCode, String province, String country,
			Boolean isRented) {
		super();
		
		System.out.println("Thread name : "+Thread.currentThread().getName());
		count++;
		this.id = "H" + count;
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
	 * @param house 
	 * @return 
	 */
	public ArrayList<String> setIsRented(Boolean isRented, House house) {
		this.isRented = isRented;

		if (this.isRented == false) {
			return notifyTenant(house);
		}
		
		return null;
	}

	@Override
	public String display_address() {
		return "House [streetNumber=" + streetNumber + ", streetName=" + streetName + ", city=" + city + ", postalCode="
				+ postalCode + ", province=" + province + ", country=" + country + "]";
	}

	@Override
	public String toString() {
		return "House [id=" + id + ", streetNumber=" + streetNumber + ", streetName=" + streetName + ", city=" + city
				+ ", postalCode=" + postalCode + ", province=" + province + ", country=" + country + ", isRented="
				+ isRented + "]";
	}

	public void subscribe(Tenant tenant) {
		subscriber.add(tenant);
	}

	public ArrayList<String> notifyTenant(House house) {
		ArrayList<String> notify = new ArrayList<String>();
		for (Tenant t : subscriber) {
			notify.add(t.update()+ "\n"+house);
			System.out.println(house);
		}
		return notify;
	}

}
