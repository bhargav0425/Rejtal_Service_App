package Controller;

import java.util.ArrayList;

import View.Driver;
import model.Building;
import model.Tenant;

public class tenantController {
	private Tenant model;
	private Driver view;
	public static ArrayList<Tenant> tenant = new ArrayList<>();
	ArrayList<String> property = new ArrayList<>();
//	private rentalFactory rf = new rentalFactory();
//
//	model=rf.getBuilding(null);

	public tenantController() {
	}

	public tenantController(Tenant model) {
		this.model = model;
		tenant.add(model);
	}

	public void addTenant(Tenant model) {
		this.model = model;
		tenant.add(model);
	}

	public void addInterestedProperty(Tenant newTenant, Building building) {
		this.model = newTenant;
		model.addInterestedProperty(building);
		building.subscribe(model);

	}

	public static void displayTenant() {
		for (Tenant tenant : tenant) {
			System.out.println(tenant.toString());
		}
		System.out.println();
	}
	public ArrayList<Tenant> getTenant()
	{
		return tenant;
	}

	public void myProperty(String pId, String tId) {
		// TODO Auto-generated method stub
		for (Tenant tenant : tenant) {
			if (tenant.getId().equals(tId)) {
				property.add(pId);
				tenant.addProperty(pId, tId);
				break;
			}
		}
	}

	public Tenant getTenant(String tenantId) {
		for (Tenant tenant : tenant)
			if (tenant.getId().equals(tenantId))
				return tenant;

		return null;
	}

}