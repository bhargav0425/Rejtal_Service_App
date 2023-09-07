package model;

import java.util.ArrayList;

public abstract class Building {
	
	String streetName;
	String city;
	String postalCode;
	String province;
	String country;
	boolean isRented;
	ArrayList<Tenant> subscriber = new ArrayList<>();
	
	abstract String display_address();
	public abstract void subscribe(Tenant tenant);
}
