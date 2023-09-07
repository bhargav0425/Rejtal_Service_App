package View;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.text.ParseException;
import java.util.Scanner;
import Controller.rentalController;
import Controller.tenantController;
import Util.rentalFactory;
import model.Apartment;
import model.Building;
import model.Condo;
import model.House;
import model.Tenant;
public class Driver extends Application{

	rentalController rc = new rentalController();
	tenantController tc = new tenantController();
	

    @Override
    public void start(Stage primaryStage) {
        // Create a menu bar
        MenuBar menuBar = new MenuBar();
        
        // Create a menu
        Menu fileMenu = new Menu("File");
        
        // Create menu items
        Menu Item1 = new Menu("Add A Property");
        
        // Create a sub menu of Item1
        
        MenuItem rentApartment = new MenuItem("Rent An Apartmant");
        MenuItem rentCondo = new MenuItem("Rent A Condo");
        MenuItem rentHouse = new MenuItem("Rent A House");
        
        Item1.getItems().addAll(rentApartment,rentCondo,rentHouse);
        
        MenuItem Item2 = new MenuItem("Add A New Tenant");
        MenuItem Item3 = new MenuItem("Rent A Unit");
        MenuItem Item4 = new MenuItem("Display Properties");
        MenuItem Item5 = new MenuItem("Display Registered Tenants");
        MenuItem Item6 = new MenuItem("Display Rented Properties");
        MenuItem Item7 = new MenuItem("Display Vacant Propertie");
        MenuItem Item8 = new MenuItem("Display all The Signed Leases");
        MenuItem Item9 = new MenuItem("Change Rental Status");
        MenuItem Item10 = new MenuItem("Exit");
        
        // Add menu items to the menu      
            fileMenu.getItems().addAll(Item1,Item2,Item3,Item4,Item5,Item6,Item7,Item8,Item9,Item10);
 
        
        // Add the menu to the menu bar
        menuBar.getMenus().add(fileMenu);
        
       
        // Create a border pane to hold the menu bar
        BorderPane root = new BorderPane();
        root.setTop(menuBar);
        
        // Create a scene and add it to the stage
        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);
        
        // Show the stage
        primaryStage.show();
        
        rentApartment.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	Alert alert = new Alert(Alert.AlertType.INFORMATION);
                GridPane gridPane = new GridPane();
                
                // New Scene
                Scene sceneNew = new Scene(gridPane, 400, 300);
               
                // Close Button To Close the current view.
                Button btn = new Button();
		        btn.setText("Close");
		        HBox layout = new HBox(btn);
		        layout.setAlignment(Pos.CENTER);
		        // Adding button to the new seen
		        
		        TextField CivicAddress = new TextField();
		        TextField StreetNumber = new TextField();
		       
		        
		        Label label1 = new Label("Civic Address: ");
		        Label label2 = new Label("StreetNumber: ");
		        Button button = new Button("Submit");
		        Text text = new Text("");
		        
		        text.setTranslateX(115);
		        text.setTranslateY(12115);
		       
		        text.maxWidth(580);
		        text.setWrappingWidth(580);
		        
		        button.setOnAction(e -> {
		            //Retrieving data
		            String name = CivicAddress.getText();
		            String email = StreetNumber.getText();
		            text.setText("Hello "+CivicAddress+ "at "+StreetNumber);
		         });
		        
		        gridPane.getChildren().add(btn);
		        gridPane.getChildren().addAll(CivicAddress,StreetNumber,button);
                primaryStage.setScene(sceneNew);
                primaryStage.show();
                
                
//				gridPane.add(titleLabel, 0, 0, 2, 1);	
				
				
		        
		        btn.setOnAction(new EventHandler<ActionEvent>() {

		            @Override
		            public void handle(ActionEvent event) {
		            	primaryStage.setScene(scene);
						  primaryStage.show();
		            }
		        });
				
				  
//                stage.close();
//				
//                
            }
        });
        
    }
	public static void main(String[] args) throws ParseException {
		System.out.println("\n*****	Welcome to Rental Services	*****\n\n");

		while (true) {
			new Driver().printMenu();
		}
		
//		  launch(args);

	}

	/**
	 * Method to print the main menu for the customers.
	 * 
	 * @throws ParseException
	 */
	public void printMenu() throws ParseException {
		System.out.println("\nPlease choose your action from this menu :- \n1. Add A Property\n" + "2. Add A New Tenant\n"
				+ "3. Rent A Unit\n" + "4. Display Properties\n5. Display Registered Tenants\n"
				+ "6. Display Rented Properties\n7. Display Vacant Properties\n8. Display all The Signed Leases\n9. Change Rental Status");
		System.out.println("10. Exit");
		Scanner sc = new Scanner(System.in);
		int input = Integer.parseInt(sc.nextLine());
		switch (input) {
		case 1: {
			System.out.println("Please select your choice :\n1. Apartment\n2. Condo\n3. House");
			int ch = Integer.parseInt(sc.nextLine());
			
			Building model;
			switch (ch) {
			case 1: {
				model = getApartmentDetails();
				rc.addProperty(model);

				break;
			}
			case 2: {
				model = getCondoDetails();
				rc.addProperty(model);
				break;
			}
			case 3: {
				model = getHouseDetails();
				rc.addProperty(model);
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + ch);
			}

			break;
		}
		case 2: {
			Tenant newTenant = getTenantDetails();

			System.out.println("Are you interested in looking any of our preperties? (yes/no)");
			String ch = sc.nextLine();

			if (ch.equalsIgnoreCase("YES")) {
				rc.displayProperties();

				System.out.println("Please enter the property Ids that you are interested in : ");
				String interestedIds = sc.nextLine();

				String[] propertyIds = interestedIds.split(" ");
				for (String s : propertyIds) {
					Building building = rc.getProperty(s);
					tc.addInterestedProperty(newTenant, building);
				}
			}

			tc.addTenant(newTenant);
			break;
		}
		case 3: {

			System.out.println("Please enter your tenant id : ");
			String tId = sc.nextLine();

			
			boolean propertyAvailability = rc.displayVacantProperties();
			if (propertyAvailability) {
				System.out.println("No property available for rent!!\n");
			} else {

				System.out.println("Enter property ID from above : ");
				String pId = sc.nextLine();

				System.out.println("Please enter the email of the tenant:");
				String emailId = sc.nextLine();
				System.out.println("Please enter the start date of the lease in the format dd/mm/yyyy:");
				String startDate = sc.nextLine();
				System.out.println("Please enter the end date of the lease in the format dd/mm/yyyy:");
				String endDate = sc.nextLine();
				System.out.println("Please enter the monthly rent :");
				int rent = Integer.parseInt(sc.nextLine());

				Tenant tenant = tc.getTenant(tId);
				rc.rentProperty(pId, tenant, emailId, startDate, endDate, rent);
				tc.myProperty(pId, tId);
			}
			break;
		}
		case 4: {
			rc.displayProperties();

			break;
		}
		case 5: {
			tc.displayTenant();
			break;
		}
		case 6: {
			rc.displayRentedProperties();
			break;
		}
		case 7: {
			rc.displayVacantProperties();

			break;
		}
		case 8: {
			rc.displayLeases();
			break;
		}
		case 9: {
			rc.displayRentedProperties();
			System.out.println("Please enter the property Ids whose rent period is over : ");
			String interestedIds = sc.nextLine();
			String[] propertyIds = interestedIds.split(" ");
			for (String s : propertyIds) {
				Building building = rc.getProperty(s);
				if (building instanceof Apartment) {
					Apartment apartment = (Apartment) building;
					apartment.setIsRented(false, apartment);
					//System.out.println("Apartment is free now..");
				} else if (building instanceof Condo) {
					Condo condo = (Condo) building;
					condo.setIsRented(false, condo);
					//System.out.println("Condo is free now..");
				} else if (building instanceof House) {
					House house = (House) building;
					house.setIsRented(false, house);
					//System.out.println("House is free now..");
				}

				// tc.addInterestedProperty(building);
			}
			break;
		}
		case 10: {
			System.err.println(
					"\n\n********************************************\n\nThank you for using our service! \nHave a good day!!\n\n********************************************");
			System.exit(0);
			break;
		}
		default: {
			System.err.println("\nThis is not a valid Menu option! Please select another option.\n");
			break;
		}
		}
	}

	private static Tenant getTenantDetails() {
		// TODO Auto-generated method stub

		Tenant tenant = new Tenant();
		Scanner sc = new Scanner(System.in);

		System.out.println("First Name : ");
		tenant.setFirstName(sc.nextLine());
		System.out.println("Last Name : ");
		tenant.setLastName(sc.nextLine());
		System.out.println("Age : ");
		tenant.setAge(Integer.parseInt(sc.nextLine()));
		System.out.println("Contact Number : ");
		tenant.setContactNumber(sc.nextLine());
		System.out.println("Email id : ");
		tenant.setEmail(sc.nextLine());

		return tenant;

	}

	private static void printMessage() {
		System.out.println("Data added successfully.");
	}

	private static Apartment getApartmentDetails() {

		Apartment apartment = new Apartment();
		Scanner sc = new Scanner(System.in);

		System.out.println("Civic Address : ");
		apartment.setCivicAddress(sc.nextLine());
		System.out.println("Apartment Number : ");
		apartment.setApartmentNumber(sc.nextLine());
		System.out.println("Number of Bedrooms : ");
		apartment.setNoOfBedrooms(Integer.parseInt(sc.nextLine()));
		System.out.println("Number of Bathrooms : ");
		apartment.setNoOfBathrooms(Integer.parseInt(sc.nextLine()));
		System.out.println("Square Foot Area : ");
		apartment.setSquareFootage(Integer.parseInt(sc.nextLine()));
		System.out.println("Street Name : ");
		apartment.setStreetName(sc.nextLine());
		System.out.println("City : ");
		apartment.setCity(sc.nextLine());
		System.out.println("Postal Code : ");
		apartment.setPostalCode(sc.nextLine());
		System.out.println("Province : ");
		apartment.setProvince(sc.nextLine());
		System.out.println("Country : ");
		apartment.setCountry(sc.nextLine());

		return apartment;
	}

	private static Condo getCondoDetails() {

		Condo condo = new Condo();
		Scanner sc = new Scanner(System.in);

		System.out.println("Unit Number : ");
		condo.setUnitNumber(Integer.parseInt(sc.nextLine()));
		System.out.println("Street Number:");
		condo.setStreetNumber(Integer.parseInt(sc.nextLine()));
		System.out.println("Street Name :");
		condo.setStreetName(sc.nextLine());
		System.out.println("City :");
		condo.setCity(sc.nextLine());
		System.out.println("Postal Code :");
		condo.setPostalCode(sc.nextLine());
		System.out.println("Province :");
		condo.setProvince(sc.nextLine());
		System.out.println("Country :");
		condo.setCountry(sc.nextLine());

		return condo;
	}

	private static House getHouseDetails() {

		House house = new House();
		Scanner sc = new Scanner(System.in);

		System.out.println("Street Number:");
		house.setStreetNumber(Integer.parseInt(sc.nextLine()));
		System.out.println("Street Name :");
		house.setStreetName(sc.nextLine());
		System.out.println("City :");
		house.setCity(sc.nextLine());
		System.out.println("Postal Code :");
		house.setPostalCode(sc.nextLine());
		System.out.println("Province :");
		house.setProvince(sc.nextLine());
		System.out.println("Country :");
		house.setCountry(sc.nextLine());

		return house;
	}
}
