package model;

import java.util.Date;

public class Lease {

	private static int count = 1000;
	private String id;
	private Tenant tenant;
	private Building building;
	private Date startDate;
	private Date endDate;
	private double rentAmount;

	public Lease() {
		super();
		// TODO Auto-generated constructor stub
		count++;
		this.id = "L" + count;
		this.tenant = null;
		this.building = null;
		this.startDate = null;
		this.endDate = null;
		this.rentAmount = 0.0D;
	}

	public Lease(String id, Tenant tenant, Building building, Date startDate, Date endDate, double rentAmount) {
		super();
		count++;
		this.id = "L" + count;
		this.tenant = tenant;
		this.building = building;
		this.startDate = startDate;
		this.endDate = endDate;
		this.rentAmount = rentAmount;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * 
	 * /**
	 * 
	 * @return the tenant
	 */
	public Tenant getTenant() {
		return tenant;
	}

	/**
	 * @param tenant the tenant to set
	 */
	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}

	/**
	 * @return the building
	 */
	public Building getBuilding() {
		return building;
	}

	/**
	 * @param building the building to set
	 */
	public void setBuilding(Building building) {
		this.building = building;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the rentAmount
	 */
	public double getRentAmount() {
		return rentAmount;
	}

	/**
	 * @param rentAmount the rentAmount to set
	 */
	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}

	@Override
	public String toString() {
		return "Id=" + id + ", \nTenant = " + tenant.toString() + ", \nBuilding = " + building.toString() + ", \nStart Date = " + startDate
				+ ", \nEnd Date = " + endDate + ", \nRental Amount = " + rentAmount + "\n";
	}

}
