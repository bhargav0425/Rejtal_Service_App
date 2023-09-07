package View;

import model.Building;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

import javafx.scene.paint.Color;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import Controller.rentalController;
import Controller.tenantController;
import Util.rentalFactory;
import View.DriverFx.RegistrationForm;
import model.Apartment;
import model.Building;
import model.Condo;
import model.House;
import model.Lease;
import model.Tenant;

public class DriverGUI extends Application {
	Scene sc;
	rentalController rc = new rentalController();
	tenantController tc = new tenantController();

	@Override
	public void start(Stage primaryStage) throws Exception {
//		    Label welcomeMessage = new Label("*****	Welcome to Rental Services	*****");
//		    ToggleGroup mainMenu = new ToggleGroup();
//		    RadioButton addProperty = new RadioButton("Add A Property");
//		    RadioButton addTenant = new RadioButton("Add A New Tenant");
//		    RadioButton rentUnit = new RadioButton("Rent A Unit");
//		    RadioButton displayProperties = new RadioButton("Display Properties");
//		    RadioButton displayTenants = new RadioButton("Display Registered Tenants");
//		    RadioButton displayRentedProperties = new RadioButton("Display Rented Properties");
//		    RadioButton displayVacantProperties = new RadioButton(" Display Vacant Properties");
//		    RadioButton displayAllLesses = new RadioButton("Display all The Signed Leases");
//		    RadioButton changeRentalStatus = new RadioButton("Change Rental Status");
//		    RadioButton systemExit = new RadioButton("Exit");

		Thread menu = Thread.currentThread();
		menu.setName("Main Thread");
		System.out.println(menu.getName());
		
		
		Text greeting = new Text("Welcome to Rental Management System!");
		greeting.setFont(Font.font("Arial", 20));

		// Create six buttons
		Button addProperty = new Button("Add Property");
		Button addTenant = new Button("Add Tenant");
		Button rentUnit = new Button("Rent Unit");
		Button displayProperties = new Button("Display All Units");
		Button displayTenants = new Button("Display Tenants");
		Button displayRentedProperties = new Button("Display Rented Properties");
		Button displayVacantProperties = new Button("Display Vacant Units");
		Button displayAllLesses = new Button("Display All Leases");
		Button changeRentalStatus = new Button("Change Rental Status");
		Button systemExit = new Button("Exit");

		// Set the button sizes
		addProperty.setPrefSize(300, 50);
		addTenant.setPrefSize(300, 50);
		rentUnit.setPrefSize(300, 50);
		displayProperties.setPrefSize(300, 50);
		displayTenants.setPrefSize(300, 50);
		displayRentedProperties.setPrefSize(300, 50);
		displayVacantProperties.setPrefSize(300, 50);
		displayAllLesses.setPrefSize(300, 50);
		changeRentalStatus.setPrefSize(300, 50);
		systemExit.setPrefSize(300, 50);

		GridPane grid = new GridPane();
		grid.setVgap(5);
		grid.setHgap(5);
		grid.setAlignment(Pos.CENTER);
		grid.add(addProperty, 0, 0);
		grid.add(addTenant, 0, 1);
		grid.add(rentUnit, 0, 2);
		grid.add(displayProperties, 0, 3);
		grid.add(displayTenants, 0, 4);
		grid.add(displayRentedProperties, 0, 5);
		grid.add(displayVacantProperties, 0, 6);

		grid.add(displayAllLesses, 0, 7);
		grid.add(changeRentalStatus, 0, 8);
		grid.add(systemExit, 0, 9);

		VBox vbox = new VBox(20);
		vbox.setAlignment(Pos.CENTER);
		vbox.getChildren().addAll(greeting, grid);

		Scene scene = new Scene(vbox, 800, 700);

		primaryStage.setTitle("Rental System");
		primaryStage.setScene(scene);
		primaryStage.show();

		String buttonstl = "-fx-font-size: 18px;";
		addProperty.setStyle(buttonstl);
		addTenant.setStyle(buttonstl);
		rentUnit.setStyle(buttonstl);
		displayProperties.setStyle(buttonstl);
		displayTenants.setStyle(buttonstl);
		displayRentedProperties.setStyle(buttonstl);
		displayVacantProperties.setStyle(buttonstl);
		displayAllLesses.setStyle(buttonstl);
		changeRentalStatus.setStyle(buttonstl);

		String buttonStyle = "-fx-background-color: #808080; -fx-font-size: 18px;";
		systemExit.setStyle(buttonStyle);
		addProperty.setOnAction(args -> {

			System.out.println(Thread.currentThread().getName());

			// Create Four buttons
			Button apartmentOption = new Button("Apartment");
			Button condoOption = new Button("Condo");
			Button houseOption = new Button("House");
			Button goToMainMenu = new Button("Go To Main Menu");
			apartmentOption.setPrefSize(300, 50);
			condoOption.setPrefSize(300, 50);
			houseOption.setPrefSize(300, 50);
			goToMainMenu.setPrefSize(300, 50);
			apartmentOption.setStyle(buttonStyle);
			condoOption.setStyle(buttonStyle);
			houseOption.setStyle(buttonStyle);
			goToMainMenu.setStyle(buttonStyle);
			GridPane addPropertyGrid = new GridPane();
			addPropertyGrid.setVgap(5);
			addPropertyGrid.setHgap(5);
			addPropertyGrid.setAlignment(Pos.CENTER);
			addPropertyGrid.add(apartmentOption, 0, 0);
			addPropertyGrid.add(condoOption, 0, 1);
			addPropertyGrid.add(houseOption, 0, 2);
			addPropertyGrid.add(goToMainMenu, 0, 3);

			VBox addPropertyVbox = new VBox(20);
			addPropertyVbox.setAlignment(Pos.CENTER);
			addPropertyVbox.getChildren().addAll(greeting, addPropertyGrid);

			Scene addPropertyScene = new Scene(addPropertyVbox, 800, 700);

			primaryStage.setTitle("Rental Management System");
//            Stage addPropertyStage = new Stage();
			primaryStage.setScene(addPropertyScene);
			primaryStage.show();

			// START : Click Event Of Add an Apartment

			apartmentOption.setOnAction(addPropertyArgs -> {
				RegistrationForm form = new RegistrationForm();
				form.showForm(primaryStage);
				form.gotoMain.setOnAction(formArgs -> {
					primaryStage.setScene(addPropertyScene);
					primaryStage.show();
				});
			});
			// END : Click Event Of Add an Apartment

			// START : Click Event Of Add an Condo
			condoOption.setOnAction(condoOptionArgs -> {
				CondoRegistrationForm form = new CondoRegistrationForm();
				form.showForm(primaryStage);
				form.gotoMain.setOnAction(formArgs -> {
					primaryStage.setScene(addPropertyScene);
					primaryStage.show();
				});
			});
			// END : Click Event Of Add an Condo

			// START : Click Event Of Add an house
			houseOption.setOnAction(houseOptionArgs -> {
				HouseRegistrationForm form = new HouseRegistrationForm();
				form.showForm(primaryStage);
				form.gotoMain.setOnAction(formArgs -> {
					primaryStage.setScene(addPropertyScene);
					primaryStage.show();
				});
			});
			// END : Click Event Of Add an house

			// START : Click Event Of Main menu
			goToMainMenu.setOnAction(goToMainMenuArgs -> {
				primaryStage.setScene(scene);
//				primaryStage.setFullScreen(true);
				primaryStage.show();
			});
			// END : Click Event Of Main menu

		});

		// Click event of the the add a tenent

		addTenant.setOnAction(args -> {

			System.out.println(Thread.currentThread().getName());

			NewTenantForm form = new NewTenantForm();
			form.showForm(primaryStage);
			form.gotoMain.setOnAction(formArgs -> {
				primaryStage.setScene(scene);
				primaryStage.show();
			});
		});

		// Click Event of Rent A Unit
		rentUnit.setOnAction(args -> {

			System.out.println(Thread.currentThread().getName());

			RentAUnitForm form = new RentAUnitForm();
			form.showForm(primaryStage);
			form.gotoMain.setOnAction(formArgs -> {
				primaryStage.setScene(scene);
				primaryStage.show();
			});
		});

		displayProperties.setOnAction(args -> {

			Thread t = new Thread(() -> {

				displayProperties properties = new displayProperties(primaryStage);

				properties.display();
			});

			t.start();
			t.setName("Display Property Thread");
			System.out.println(t.getName());

		});

		displayTenants.setOnAction(args -> {

			System.out.println(Thread.currentThread().getName());

			displayTenant tenants = new displayTenant(primaryStage);

			tenants.display();
		});

		displayRentedProperties.setOnAction(args -> {

			System.out.println(Thread.currentThread().getName());

			displayRentedProperties rentedProperties = new displayRentedProperties(primaryStage);

			rentedProperties.display();
		});

		displayVacantProperties.setOnAction(args -> {

			System.out.println(Thread.currentThread().getName());

			displayVacantProperties vacantProperties = new displayVacantProperties(primaryStage);

			vacantProperties.display();
		});

		displayAllLesses.setOnAction(args -> {

			System.out.println(Thread.currentThread().getName());

			displayLease leasedProperties = new displayLease(primaryStage);

			leasedProperties.display();
		});
		changeRentalStatus.setOnAction(args -> {

			System.out.println(Thread.currentThread().getName());

			changeRentalStatus form = new changeRentalStatus();
			form.showForm(primaryStage);
			form.gotoMain.setOnAction(formArgs -> {
				primaryStage.setScene(scene);
				primaryStage.show();
			});
		});

		systemExit.setOnAction(args -> {
			primaryStage.close();
		});

	}

	public static void main(String[] args) {
		launch(args);
	}

	String textFieldStyle = "-fx-pref-width: 200; -fx-pref-height: 30; -fx-min-width: 100; -fx-max-width: 400; -fx-min-height: 20; -fx-max-height: 50;";

	public class RegistrationForm {
		Label civicAddressLabel;
		TextField civicAddress;
		Label apartmentNumberLabel;
		TextField apartmentNumber;
		Label bedroomsLabel;
		TextField bedrooms;
		Label bathroomsLabel;
		TextField bathrooms;
		Label squareFootAreaLabel;
		TextField squareFootArea;
		Label streetNameLabel;
		TextField streetName;
		Label cityLabel;
		TextField city;
		Label postalCodeLabel;
		TextField postalCode;
		Label provinceLabel;
		TextField province;
		Label countryLabel;
		TextField country;
		Label errorlbl;
		Button addApartmentDetails = new Button("Add Apartment Details");
		Button gotoMain = new Button("Previous Menu");
		private List<TextField> fields = new ArrayList<TextField>(Arrays.asList(civicAddress, apartmentNumber, bedrooms,
				bathrooms, squareFootArea, streetName, city, postalCode, province, country));
		ObservableList<Node> children;

		public void showForm(Stage primaryStage) {
			civicAddressLabel = new Label("Civic Address");
			civicAddress = new TextField();
			apartmentNumberLabel = new Label("Apartment Number");
			apartmentNumber = new TextField();
			bedroomsLabel = new Label("Number of Bedrooms");
			bedrooms = new TextField();
			bathroomsLabel = new Label("Number of Bathrooms");
			bathrooms = new TextField();
			squareFootAreaLabel = new Label("Square Foot Area");
			squareFootArea = new TextField();
			streetNameLabel = new Label("Street Name");
			streetName = new TextField();
			cityLabel = new Label("Citys");
			city = new TextField();
			postalCodeLabel = new Label("Postal Code");
			postalCode = new TextField();
			provinceLabel = new Label("Province");
			province = new TextField();
			countryLabel = new Label("Country");
			country = new TextField();
			errorlbl = new Label("");
			List<TextField> fields = new ArrayList<TextField>(Arrays.asList(civicAddress, apartmentNumber, bedrooms,
					bathrooms, squareFootArea, streetName, city, postalCode, province, country));

			for (int i = 0; i < fields.size(); i++) {
				TextField currentField = fields.get(i);
				currentField.setStyle(textFieldStyle);
			}
			GridPane apartmentRegisterForm = new GridPane();
			apartmentRegisterForm.setVgap(5);
			apartmentRegisterForm.setHgap(5);
			apartmentRegisterForm.setAlignment(Pos.CENTER);
			apartmentRegisterForm.add(civicAddressLabel, 0, 0);
			apartmentRegisterForm.add(civicAddress, 0, 1);
			apartmentRegisterForm.add(apartmentNumberLabel, 0, 2);
			apartmentRegisterForm.add(apartmentNumber, 0, 3);

			apartmentRegisterForm.add(bedroomsLabel, 0, 4);
			apartmentRegisterForm.add(bedrooms, 0, 5);
			apartmentRegisterForm.add(bathroomsLabel, 0, 6);
			apartmentRegisterForm.add(bathrooms, 0, 7);
			apartmentRegisterForm.add(squareFootAreaLabel, 0, 8);
			apartmentRegisterForm.add(squareFootArea, 0, 9);
			apartmentRegisterForm.add(streetNameLabel, 0, 10);
			apartmentRegisterForm.add(streetName, 0, 11);
			apartmentRegisterForm.add(cityLabel, 0, 12);
			apartmentRegisterForm.add(city, 0, 13);
			apartmentRegisterForm.add(provinceLabel, 0, 14);
			apartmentRegisterForm.add(province, 0, 15);
			apartmentRegisterForm.add(countryLabel, 0, 16);
			apartmentRegisterForm.add(country, 0, 17);
			apartmentRegisterForm.add(addApartmentDetails, 0, 18);
			apartmentRegisterForm.add(gotoMain, 0, 19);
			apartmentRegisterForm.add(errorlbl, 0, 20);
			VBox addPropertyVbox = new VBox(20);
			addPropertyVbox.setAlignment(Pos.CENTER);
			addPropertyVbox.getChildren().addAll(apartmentRegisterForm);

			Scene addPropertyScene = new Scene(addPropertyVbox, 800, 700);

//			  BorderPane apartmentRegisterForm = new BorderPane();
//			  apartmentRegisterForm.setCenter(new VBox(10,civicAddressLabel,civicAddress,apartmentNumberLabel,apartmentNumber,bedroomsLabel,bedrooms,bathroomsLabel,bathrooms,squareFootAreaLabel,squareFootArea,streetNameLabel,streetName,cityLabel,city,postalCodeLabel,postalCode,provinceLabel,province,countryLabel,country,addApartmentDetails,gotoMain,errorlbl));
//			  Scene displayApartmentScene = new Scene(apartmentRegisterForm);
//			  children =  apartmentRegisterForm.getChildren();
			primaryStage.setScene(addPropertyScene);
//			  primaryStage.setFullScreen(true);
			primaryStage.show();

			addApartmentDetails.setOnAction(args -> {
				Building model = new Apartment(civicAddress.getText(), apartmentNumber.getText(),
						Integer.parseInt(bedrooms.getText()), Integer.parseInt(bathrooms.getText()),
						Integer.parseInt(squareFootArea.getText()), streetName.getText(), city.getText(),
						postalCode.getText(), province.getText(), country.getText(), false);
				rc.addProperty(model);
				errorlbl.setText("Apartment Has been Added Succesfully.");
				errorlbl.setTextFill(Color.GREEN);
				System.out.println(model);

				for (int i = 0; i < fields.size(); i++) {
					TextField currentField = fields.get(i);
					currentField.setText("");
				}

			});
			gotoMain.setOnAction(args -> {
				primaryStage.setScene(sc);
				primaryStage.setFullScreen(true);
				primaryStage.show();

			});

		}

	}

	class CondoRegistrationForm {

		Label unitNumberLabel;
		TextField unitNumber;
		Label streetNumberLabel;
		TextField streetNumber;
		Label streetNameLabel;
		TextField streetName;
		Label cityLabel;
		TextField city;
		Label postalCodeLabel;
		TextField postalCode;
		Label provinceLabel;
		TextField province;
		Label countryLabel;
		TextField country;
		Label errorlbl;
		Button addCondoDetails = new Button("Add Condo Details");
		Button gotoMain = new Button("Previous Menu");
		private List<TextField> fields = new ArrayList<TextField>(
				Arrays.asList(unitNumber, streetNumber, streetName, city, postalCode, province, country));

		public void showForm(Stage primaryStage) {

			unitNumberLabel = new Label("Unit Number ");
			unitNumber = new TextField();
			streetNumberLabel = new Label("Street Number ");
			streetNumber = new TextField();
			streetNameLabel = new Label("Street Name");
			streetName = new TextField();
			cityLabel = new Label("City");
			city = new TextField();
			postalCodeLabel = new Label("Postal Code");
			postalCode = new TextField();
			provinceLabel = new Label("Province");
			province = new TextField();
			countryLabel = new Label("Country");
			country = new TextField();
			errorlbl = new Label("");
			fields = new ArrayList<TextField>(
					Arrays.asList(unitNumber, streetNumber, streetName, city, postalCode, province, country));

//		  BorderPane condoRegisterPane = new BorderPane();
//		  condoRegisterPane.setCenter(new VBox(10,unitNumberLabel,unitNumber,streetNumberLabel,streetNumber,streetNameLabel,streetName,cityLabel,city,postalCodeLabel,postalCode,provinceLabel,province,countryLabel,country,addCondoDetails,gotoMain,errorlbl));
//		  Scene displayApartmentScene = new Scene(condoRegisterPane);
			GridPane condoRegisterGrid = new GridPane();
			condoRegisterGrid.setVgap(5);
			condoRegisterGrid.setHgap(5);
			condoRegisterGrid.setAlignment(Pos.CENTER);
			condoRegisterGrid.add(unitNumberLabel, 0, 0);
			condoRegisterGrid.add(unitNumber, 0, 1);
			condoRegisterGrid.add(streetNumberLabel, 0, 2);
			condoRegisterGrid.add(streetNumber, 0, 3);
			condoRegisterGrid.add(streetNameLabel, 0, 4);
			condoRegisterGrid.add(streetName, 0, 5);
			condoRegisterGrid.add(cityLabel, 0, 6);
			condoRegisterGrid.add(city, 0, 7);
			condoRegisterGrid.add(provinceLabel, 0, 8);
			condoRegisterGrid.add(province, 0, 9);
			condoRegisterGrid.add(countryLabel, 0, 10);
			condoRegisterGrid.add(country, 0, 11);
			condoRegisterGrid.add(addCondoDetails, 0, 12);
			condoRegisterGrid.add(gotoMain, 0, 13);
			condoRegisterGrid.add(errorlbl, 0, 14);
			for (int i = 0; i < fields.size(); i++) {
				TextField currentField = fields.get(i);
				currentField.setStyle(textFieldStyle);
			}
			VBox condoRegisterVbox = new VBox(20);
			condoRegisterVbox.setAlignment(Pos.CENTER);
			condoRegisterVbox.getChildren().addAll(condoRegisterGrid);

			Scene condoRegisterScene = new Scene(condoRegisterVbox, 800, 700);
			primaryStage.setScene(condoRegisterScene);
//		  primaryStage.setFullScreen(true);
			primaryStage.show();

			addCondoDetails.setOnAction(args -> {
				Building model = new Condo(Integer.parseInt(unitNumber.getText()),
						Integer.parseInt(streetNumber.getText()), streetName.getText(), city.getText(),
						postalCode.getText(), province.getText(), country.getText(), false);
				rc.addProperty(model);
				errorlbl.setText("Condo Has been Added Succesfully.");
				errorlbl.setTextFill(Color.GREEN);
				System.out.println(model);

			});
			gotoMain.setOnAction(args -> {
				primaryStage.setScene(sc);
				primaryStage.setFullScreen(true);
				primaryStage.show();

			});

		}
	}

	class HouseRegistrationForm {

		Label streetNumberLabel;
		TextField streetNumber;
		Label streetNameLabel;
		TextField streetName;
		Label cityLabel;
		TextField city;
		Label postalCodeLabel;
		TextField postalCode;
		Label provinceLabel;
		TextField province;
		Label countryLabel;
		TextField country;
		Label errorlbl;
		Button addHouseDetails = new Button("Add House Details");
		Button gotoMain = new Button("Previous Menu");
		private List<TextField> fields = new ArrayList<TextField>(
				Arrays.asList(streetNumber, streetName, city, postalCode, province, country));

		public void showForm(Stage primaryStage) {

			streetNumberLabel = new Label("Street Number ");
			streetNumber = new TextField();
			streetNameLabel = new Label("Street Name");
			streetName = new TextField();
			cityLabel = new Label("City");
			city = new TextField();
			postalCodeLabel = new Label("Postal Code");
			postalCode = new TextField();
			provinceLabel = new Label("Province");
			province = new TextField();
			countryLabel = new Label("Country");
			country = new TextField();
			errorlbl = new Label("");
			fields = new ArrayList<TextField>(
					Arrays.asList(streetNumber, streetName, city, postalCode, province, country));

			for (int i = 0; i < fields.size(); i++) {
				TextField currentField = fields.get(i);
				currentField.setStyle(textFieldStyle);
			}
//		  BorderPane houseRegisterPane = new BorderPane();
//		  houseRegisterPane.setCenter(new VBox(10,streetNumberLabel,streetNumber,streetNameLabel,streetName,cityLabel,city,postalCodeLabel,postalCode,provinceLabel,province,countryLabel,country,addCondoDetails,gotoMain,errorlbl));
//		  Scene displayHouseScene = new Scene(houseRegisterPane);
//		  primaryStage.setScene(displayHouseScene);
//		  primaryStage.setFullScreen(true);
			GridPane houseRegisterGrid = new GridPane();
			houseRegisterGrid.setVgap(5);
			houseRegisterGrid.setHgap(5);
			houseRegisterGrid.setAlignment(Pos.CENTER);
			houseRegisterGrid.add(streetNumberLabel, 0, 1);
			houseRegisterGrid.add(streetNumber, 0, 2);
			houseRegisterGrid.add(streetNameLabel, 0, 3);
			houseRegisterGrid.add(streetName, 0, 4);
			houseRegisterGrid.add(cityLabel, 0, 5);
			houseRegisterGrid.add(city, 0, 6);
			houseRegisterGrid.add(provinceLabel, 0, 7);
			houseRegisterGrid.add(province, 0, 8);
			houseRegisterGrid.add(countryLabel, 0, 9);
			houseRegisterGrid.add(country, 0, 10);
			houseRegisterGrid.add(addHouseDetails, 0, 11);
			houseRegisterGrid.add(gotoMain, 0, 12);
			houseRegisterGrid.add(errorlbl, 0, 13);
			for (int i = 0; i < fields.size(); i++) {
				TextField currentField = fields.get(i);
				currentField.setStyle(textFieldStyle);
			}
			VBox houseRegisterVbox = new VBox(20);
			houseRegisterVbox.setAlignment(Pos.CENTER);
			houseRegisterVbox.getChildren().addAll(houseRegisterGrid);

			Scene condoRegisterScene = new Scene(houseRegisterVbox, 800, 700);
			primaryStage.setScene(condoRegisterScene);
//		  primaryStage.setFullScreen(true);
			primaryStage.show();

			addHouseDetails.setOnAction(args -> {
				Building model = new House(Integer.parseInt(streetNumber.getText()), streetName.getText(),
						city.getText(), postalCode.getText(), province.getText(), country.getText(), false);
				rc.addProperty(model);
				errorlbl.setText("House Has been Added Succesfully.");
				errorlbl.setTextFill(Color.GREEN);
				System.out.println(model);

			});
			gotoMain.setOnAction(args -> {
				primaryStage.setScene(sc);
				primaryStage.setFullScreen(true);
				primaryStage.show();

			});

		}
	}

	class NewTenantForm {
		Label firstNameLabel;
		TextField firstName;
		Label lastNameLabel;
		TextField lastName;
		Label ageLabel;
		TextField age;
		Label contactNumberLabel;
		TextField contactNumber;
		Label emailLabel;
		TextField email;
		Label interestedPropertieLabel;
		TextField interestedPropertie;
		Button addTenantDetails = new Button("Add A New Tenant");
		Button gotoMain = new Button("Go to Main Menu");
		Label errorlbl;
		private List<TextField> fields = new ArrayList<TextField>(
				Arrays.asList(firstName, lastName, age, contactNumber, email, interestedPropertie));

		public void showForm(Stage primaryStage) {

			firstNameLabel = new Label("First Name : ");
			firstName = new TextField();
			lastNameLabel = new Label("Last Name : ");
			lastName = new TextField();
			ageLabel = new Label("Age : ");
			age = new TextField();
			contactNumberLabel = new Label("Contact Number : ");
			contactNumber = new TextField();
			emailLabel = new Label("Email id :");
			email = new TextField();

			ListView allProperties = new ListView();
			allProperties.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
			ArrayList<Building> allBuilding = rentalController.building;
			for (int i = 0; i < allBuilding.size(); i++) {
//				   allProperties.getItems().add(allBuilding.get(i).toString());				   
				Building property = allBuilding.get(i);
				if (property instanceof Apartment) {
					Apartment apartment = (Apartment) property;
					allProperties.getItems().add(apartment.getId());
				} else if (property instanceof Condo) {
					Condo condo = (Condo) property;
					allProperties.getItems().add(condo.getId());

				} else if (property instanceof House) {
					House house = (House) property;
					allProperties.getItems().add(house.getId());
				} else {
					allProperties.getItems().add("Testtt");
				}

			}
			// showing available properties
//			ArrayList<Building> building = new ArrayList<>();
//			building=Building.getProperties();
//			
//				for (Building property : building) {
//					
//					Label properyLabel = new Label(property.toString());
//					BorderPane properties = new BorderPane();
//					properties.setCenter(new VBox(1,properyLabel));
//					Scene displayTenantScene = new Scene(properties);
//					  primaryStage.setScene(displayTenantScene);
//					  primaryStage.setFullScreen(true);
//					  primaryStage.show();
//				}

			interestedPropertieLabel = new Label("Please type instrested property ID");
			interestedPropertie = new TextField();

			errorlbl = new Label("");

			fields = new ArrayList<TextField>(
					Arrays.asList(firstName, lastName, age, contactNumber, email, interestedPropertie));

//		   BorderPane tenantRegisterPane = new BorderPane();
//		   tenantRegisterPane.setCenter(new VBox(10,firstNameLabel,firstName,lastNameLabel,lastName,ageLabel,age,contactNumberLabel,contactNumber,emailLabel,email,interestedPropertieLabel,allProperties,addTenantDetails,gotoMain,errorlbl));
//			  Scene displayTenantScene = new Scene(tenantRegisterPane);
//			  primaryStage.setScene(displayTenantScene);
//			  primaryStage.setFullScreen(true);
//			  primaryStage.show();

			GridPane tenantRegisterGrid = new GridPane();
			tenantRegisterGrid.setVgap(5);
			tenantRegisterGrid.setHgap(5);
			tenantRegisterGrid.setAlignment(Pos.CENTER);
			tenantRegisterGrid.add(firstNameLabel, 0, 1);
			tenantRegisterGrid.add(firstName, 0, 2);
			tenantRegisterGrid.add(lastNameLabel, 0, 3);
			tenantRegisterGrid.add(lastName, 0, 4);
			tenantRegisterGrid.add(ageLabel, 0, 5);
			tenantRegisterGrid.add(age, 0, 6);
			tenantRegisterGrid.add(contactNumberLabel, 0, 7);
			tenantRegisterGrid.add(contactNumber, 0, 8);
			tenantRegisterGrid.add(emailLabel, 0, 9);
			tenantRegisterGrid.add(email, 0, 10);
			tenantRegisterGrid.add(interestedPropertieLabel, 0, 11);
			tenantRegisterGrid.add(allProperties, 0, 12);
			tenantRegisterGrid.add(addTenantDetails, 0, 13);
			tenantRegisterGrid.add(gotoMain, 0, 14);
			tenantRegisterGrid.add(errorlbl, 0, 15);
			for (int i = 0; i < fields.size(); i++) {
				TextField currentField = fields.get(i);
				currentField.setStyle(textFieldStyle);
			}
			VBox tenantRegisterVbox = new VBox(20);
			tenantRegisterVbox.setAlignment(Pos.CENTER);
			tenantRegisterVbox.getChildren().addAll(tenantRegisterGrid);

			Scene condoRegisterScene = new Scene(tenantRegisterVbox, 800, 700);
			primaryStage.setScene(condoRegisterScene);
//		  primaryStage.setFullScreen(true);
			primaryStage.show();
			addTenantDetails.setOnAction(args -> {
				Tenant newTenant = new Tenant(firstName.getText(), lastName.getText(), Integer.parseInt(age.getText()),
						contactNumber.getText(), email.getText());
				errorlbl.setText("Tenant Has been Added Succesfully.");
				errorlbl.setTextFill(Color.GREEN);
				System.out.println(newTenant);
				String[] propertyIds = interestedPropertie.getText().split(" ");
//				for (String s : propertyIds) {
//					Building building = rc.getProperty(s);
//					tc.addInterestedProperty(newTenant, building);
//				}
				tc.addTenant(newTenant);
				ObservableList<String> selectedItems = allProperties.getSelectionModel().getSelectedItems();
				for (Object o : selectedItems) {
					System.out.println(o);
					Building building = rc.getProperty(o.toString());
					tc.addInterestedProperty(newTenant, building);
				}
				;
//			            for(int i=0;i<selectedItems.size();i++) {
//			            	Building currentBuilding =  selectedItems.get(i).getI;
//			            }

			});
			gotoMain.setOnAction(args -> {
				primaryStage.setScene(sc);
				primaryStage.setFullScreen(true);
				primaryStage.show();

			});

		}
	}

	class RentAUnitForm {
		Label TenantIdLabel;
		TextField TenantId;
		Label propertiesLabel;
		TextField properties;
		Label emailLabel;
		TextField email;
		Label startDateLabel;
		Label EndDateLabel;
		Label MonthlyRentLabel;
		TextField monthlyrent;
		Button addRentUnit = new Button("Rent a Unit");
		Button gotoMain = new Button("Previous Menu");
		Label errorlbl;

		public void showForm(Stage primaryStage) {

			TenantIdLabel = new Label("Please enter your tenant id : ");
			TenantId = new TextField();
			BorderPane unitRegisterPane;
			boolean propertyAvailability = rc.displayVacantProperties(); // getting true everytime ::::::
			if (propertyAvailability) {
				Label noPropertyLabel = new Label("No property available for rent!!");
				unitRegisterPane = new BorderPane();
				unitRegisterPane.setCenter(new VBox(noPropertyLabel));
				Scene displayRentUnitScene = new Scene(unitRegisterPane, 800, 700);
				primaryStage.setScene(displayRentUnitScene);
//				primaryStage.setFullScreen(true);
				primaryStage.show();
			} else {

				propertiesLabel = new Label("Enter property ID from above : ");
				properties = new TextField();
				emailLabel = new Label("Please enter the email of the tenant: ");
				email = new TextField();
				startDateLabel = new Label("Start Date ");
//				startDate = new TextField();
				EndDateLabel = new Label("End Date");
//				endDate = new TextField();
				MonthlyRentLabel = new Label("Please enter the monthly rent : ");
				monthlyrent = new TextField();
				errorlbl = new Label("");
				ListView allProperties = new ListView();
				allProperties.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
				ArrayList<Building> allBuilding = rentalController.building;
				for (int i = 0; i < allBuilding.size(); i++) {
//					   allProperties.getItems().add(allBuilding.get(i).toString());				   
					Building property = allBuilding.get(i);
					if (property instanceof Apartment) {
						Apartment apartment = (Apartment) property;
						if (apartment.getIsRented() == false)
							allProperties.getItems().add(apartment.getId());
					} else if (property instanceof Condo) {
						Condo condo = (Condo) property;
						if (condo.getIsRented() == false)
							allProperties.getItems().add(condo.getId());

					} else if (property instanceof House) {
						House house = (House) property;
						if (house.getIsRented() == false)
							allProperties.getItems().add(house.getId());
					} else {
						allProperties.getItems().add("Other..");
					}
				}
				ListView allTenantsList = new ListView();
				allProperties.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
				ArrayList<Tenant> allTenants = tenantController.tenant;
				for (int i = 0; i < allTenants.size(); i++) {
					allTenantsList.getItems().add(allTenants.get(i).getId());
				}

				DatePicker startDate = new DatePicker();
				DatePicker endDate = new DatePicker();
				GridPane rentAUnitRegisterForm = new GridPane();
				rentAUnitRegisterForm.setVgap(5);
				rentAUnitRegisterForm.setHgap(5);
				rentAUnitRegisterForm.setAlignment(Pos.CENTER);
				rentAUnitRegisterForm.add(TenantIdLabel, 0, 0);
				rentAUnitRegisterForm.add(allTenantsList, 0, 1);
				rentAUnitRegisterForm.add(propertiesLabel, 0, 2);
				rentAUnitRegisterForm.add(allProperties, 0, 3);

				rentAUnitRegisterForm.add(emailLabel, 0, 4);
				rentAUnitRegisterForm.add(email, 0, 5);
				rentAUnitRegisterForm.add(startDateLabel, 0, 6);
				rentAUnitRegisterForm.add(startDate, 0, 7);
				rentAUnitRegisterForm.add(EndDateLabel, 0, 8);
				rentAUnitRegisterForm.add(endDate, 0, 9);
				rentAUnitRegisterForm.add(MonthlyRentLabel, 0, 10);
				rentAUnitRegisterForm.add(monthlyrent, 0, 11);
				rentAUnitRegisterForm.add(addRentUnit, 0, 12);
				rentAUnitRegisterForm.add(gotoMain, 0, 13);
				rentAUnitRegisterForm.add(errorlbl, 0, 14);
				VBox rentAUnitVbox = new VBox(20);
				rentAUnitVbox.setAlignment(Pos.CENTER);
				rentAUnitVbox.getChildren().addAll(rentAUnitRegisterForm);

				Scene rentAUnitScene = new Scene(rentAUnitVbox, 800, 700);
				primaryStage.setScene(rentAUnitScene);
				primaryStage.show();
				ObservableList<String> selectedItems = allProperties.getSelectionModel().getSelectedItems();

				addRentUnit.setOnAction(args -> {

					try {
						String pId = "";
						Tenant tenant = null;
						for (Object o : selectedItems) {
							System.out.println(o.toString());
							pId = o.toString();
							System.out.println(o.toString());

						}
						;
						ObservableList<String> selectedTenantsItems = allTenantsList.getSelectionModel()
								.getSelectedItems();
						for (Object t : selectedTenantsItems) {
							System.out.println(t);
							tenant = tc.getTenant(t.toString());
						}
						;
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
						String formattedStartDate = startDate.getValue().format(formatter);
						String formattedEndDate = endDate.getValue().format(formatter);
						rc.rentProperty(pId, tenant, email.getText(), formattedStartDate, formattedEndDate,
								Integer.parseInt(monthlyrent.getText()));
					} catch (NumberFormatException | ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					tc.myProperty(properties.getText(), TenantId.getText());
					errorlbl.setText("Unit Has been Rented Succesfully.");
					errorlbl.setTextFill(Color.GREEN);
//					System.out.println(tenant);

				}

				);
				gotoMain.setOnAction(args -> {
					primaryStage.setScene(sc);
					primaryStage.setFullScreen(true);
					primaryStage.show();

				});
			}
		}
	}

	public class displayProperties {
		private final Stage stage;

		public displayProperties(Stage stage) {
			this.stage = stage;
		}

		public void display() {

			ArrayList<Building> units = rc.getProperties();

			ListView<String> displayListView = new ListView<>();

			displayListView.getItems().clear();

			if (units.size() == 0) {
				displayListView.getItems().add("No Properties Available to display");
			} else {
				for (Building building : units) {
					String buildingInfo = building.toString();
					displayListView.getItems().add(buildingInfo);
				}
			}
			Button goBack = new Button("Home Page");
			String buttonStyle = "-fx-background-color: #808080; -fx-font-size: 18px;";
			goBack.setStyle(buttonStyle);
			// Create a VBox to hold the ListView and the Refresh button
			VBox Box = new VBox(10, displayListView, goBack);
			Box.setPadding(new Insets(7));

			Platform.runLater(() -> {
				Stage rentalUnitStage = new Stage();
				rentalUnitStage.setTitle("Display Properties");
				rentalUnitStage.initOwner(this.stage);
				rentalUnitStage.setScene(new Scene(Box, 800, 400));
				rentalUnitStage.show();
				goBack.setOnAction(args -> {
					rentalUnitStage.close();
				});

			});

		}

	}

	public class displayTenant {

		private final Stage stage;

		public displayTenant(Stage stage) {
			this.stage = stage;
		}

		public void display() {
			ArrayList<Tenant> tenants = tc.getTenant();

			ListView<String> displayTenantListView = new ListView<>();

			if (tenants.size() == 0) {
				displayTenantListView.getItems().add("Nothing to Display");
			} else {
				for (Tenant tenant : tenants) {
					String tenantInfo = tenant.toString();
					displayTenantListView.getItems().add(tenantInfo);
				}
			}
			Button goBack = new Button("Home Page");
			String buttonStyle = "-fx-background-color: #808080; -fx-font-size: 18px;";
			goBack.setStyle(buttonStyle);
			// Create a VBox to hold the ListView and the Refresh button
			VBox Box = new VBox(10, displayTenantListView, goBack);
			Box.setPadding(new Insets(7));
			Stage rentalUnitStage = new Stage();
			Platform.runLater(() -> {
				rentalUnitStage.setTitle("Display Tenants");
				rentalUnitStage.initOwner(this.stage);
				rentalUnitStage.setScene(new Scene(Box, 800, 400));
				rentalUnitStage.show();
			});

			goBack.setOnAction(args -> {
				rentalUnitStage.close();

			});
		}
	}

	public class displayRentedProperties {

		private final Stage stage;

		public displayRentedProperties(Stage stage) {
			this.stage = stage;
		}

		public void display() {
			ArrayList<Building> building = rc.getProperties();
			ListView<String> displayRentedUnitsListView = new ListView<>();
			displayRentedUnitsListView.getItems().clear();
			boolean flag = false;
			// changes has to be done!!!!! -- checked
			if (building.size() == 0) {
				displayRentedUnitsListView.getItems().add("No properties are available right now!");
			} else {
				for (Building units : building) {

					if (rc.getRentedProperties(units)) {
						flag = true;
						String unitInfo = units.toString();
						displayRentedUnitsListView.getItems().add(unitInfo);
					}

				}
				if (flag == false) {
					displayRentedUnitsListView.getItems().add("No rented properties are available right now!");
				}
			}

			Button goBack = new Button("Home Page");
			String buttonStyle = "-fx-background-color: #808080; -fx-font-size: 18px;";
			goBack.setStyle(buttonStyle);
			// Create a VBox to hold the ListView and the Refresh button
			VBox Box = new VBox(10, displayRentedUnitsListView, goBack);
			Box.setPadding(new Insets(7));
			Stage rentalUnitStage = new Stage();
			Platform.runLater(() -> {
				rentalUnitStage.setTitle("All Rented Properties");
				rentalUnitStage.initOwner(this.stage);
				rentalUnitStage.setScene(new Scene(Box, 800, 400));
				rentalUnitStage.show();
			});

			goBack.setOnAction(args -> {
				rentalUnitStage.close();

			});
		}
	}

	public class displayVacantProperties {

		private final Stage stage;

		public displayVacantProperties(Stage stage) {
			this.stage = stage;
		}

		public void display() {
			ArrayList<Building> building = rc.getProperties();
			ListView<String> displayVecantUnitsListView = new ListView<>();
			displayVecantUnitsListView.getItems().clear();
			boolean flag = false;
			// changes has to be done!!!!!
			if (building.size() == 0) {
				displayVecantUnitsListView.getItems().add("No properties are available right now!");
			} else {
				for (Building units : building) {

					if (!rc.getRentedProperties(units)) {
						flag = true;
						String unitInfo = units.toString();
						displayVecantUnitsListView.getItems().add(unitInfo);
					}

				}
				if (flag == false) {
					displayVecantUnitsListView.getItems().add("No Vacant properties are available right now!");
				}
			}
			Button goBack = new Button("Home Page");
			String buttonStyle = "-fx-background-color: #808080; -fx-font-size: 18px;";
			goBack.setStyle(buttonStyle);
			// Create a VBox to hold the ListView and the Refresh button
			VBox Box = new VBox(10, displayVecantUnitsListView, goBack);
			Box.setPadding(new Insets(7));
			Stage rentalUnitStage = new Stage();
			Platform.runLater(() -> {
				rentalUnitStage.setTitle("All Vacant Properties");
				rentalUnitStage.initOwner(this.stage);
				rentalUnitStage.setScene(new Scene(Box, 800, 400));
				rentalUnitStage.show();
			});

			goBack.setOnAction(args -> {
				rentalUnitStage.close();

			});
		}

	}

	public class displayLease {

		private final Stage stage;

		public displayLease(Stage stage) {
			this.stage = stage;
		}

		public void display() {
			ArrayList<Lease> leases = rc.getLeases();
			ListView<String> displayLeaseListView = new ListView<>();
			displayLeaseListView.getItems().clear();
			if (leases.size() == 0) {
				displayLeaseListView.getItems().add("Nothing to display!!!");
			} else {
				for (Lease lease : leases) {

					String leaseInfo = lease.toString();
					displayLeaseListView.getItems().add(leaseInfo);

				}
			}
			Button goBack = new Button("Home Page");
			String buttonStyle = "-fx-background-color: #808080; -fx-font-size: 18px;";
			goBack.setStyle(buttonStyle);
			// Create a VBox to hold the ListView and the Refresh button
			VBox Box = new VBox(10, displayLeaseListView, goBack);
			Box.setPadding(new Insets(7));
			Stage rentalUnitStage = new Stage();
			Platform.runLater(() -> {
				rentalUnitStage.setTitle("Available Properties");
				rentalUnitStage.initOwner(this.stage);
				rentalUnitStage.setScene(new Scene(Box, 800, 400));
				rentalUnitStage.show();
			});

			goBack.setOnAction(args -> {
				rentalUnitStage.close();

			});
		}

	}

	public class changeRentalStatus {

		Label chageStatusLabel;
		Button chageStatusBtn;
		Button gotoMain = new Button("Go to Main Menu");
		Label errorlbl;

		public void showForm(Stage primaryStage) {
			errorlbl = new Label("");
			chageStatusLabel = new Label("Please select the property Ids whose rent period is over : ");
			Button chageStatusBtn = new Button("Change Rental Status");
			ListView allProperties = new ListView();
			allProperties.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
			ArrayList<Building> allBuilding = rentalController.building;
			for (int i = 0; i < allBuilding.size(); i++) {
//				   allProperties.getItems().add(allBuilding.get(i).toString());				   
				Building property = allBuilding.get(i);
				if (property instanceof Apartment) {
					Apartment apartment = (Apartment) property;
					if (apartment.getIsRented() == true)
						allProperties.getItems().add(apartment.getId());
				} else if (property instanceof Condo) {
					Condo condo = (Condo) property;
					if (condo.getIsRented() == true)
						allProperties.getItems().add(condo.getId());

				} else if (property instanceof House) {
					House house = (House) property;
					if (house.getIsRented() == true)
						allProperties.getItems().add(house.getId());
				} else {
					allProperties.getItems().add("Others");
				}

			}

			GridPane chnageStatusGrid = new GridPane();
			chnageStatusGrid.setVgap(5);
			chnageStatusGrid.setHgap(5);
			chnageStatusGrid.setAlignment(Pos.CENTER);
			chnageStatusGrid.add(chageStatusLabel, 0, 1);
			chnageStatusGrid.add(allProperties, 0, 2);
			chnageStatusGrid.add(chageStatusBtn, 0, 3);
			chnageStatusGrid.add(gotoMain, 0, 4);
			chnageStatusGrid.add(errorlbl, 0, 5);
			VBox chnageStatusGridVbox = new VBox(20);
			chnageStatusGridVbox.setAlignment(Pos.CENTER);
			chnageStatusGridVbox.getChildren().addAll(chnageStatusGrid);

			Scene chnageStatusScene = new Scene(chnageStatusGridVbox, 800, 700);
			primaryStage.setScene(chnageStatusScene);
//		  primaryStage.setFullScreen(true);
			primaryStage.show();

			chageStatusBtn.setOnAction(args -> {
				String displayEmail = "";
				ObservableList<String> selectedItems = allProperties.getSelectionModel().getSelectedItems();
				for (Object buildingID : selectedItems) {
					System.out.println(buildingID);
					Building building = rc.getProperty(buildingID.toString());
					ArrayList<String> displayMessage = new ArrayList<String>();
					if (buildingID.toString().startsWith("A")) {
						Apartment apartment = (Apartment) building;
						displayMessage = apartment.setIsRented(false, apartment);
						// System.out.println("Apartment is free now..");
					} else if (buildingID.toString().startsWith("C")) {
						Condo condo = (Condo) building;
						displayMessage = condo.setIsRented(false, condo);
						// System.out.println("Condo is free now..");
					} else if (buildingID.toString().startsWith("H")) {
						House house = (House) building;
						displayMessage = house.setIsRented(false, house);
						// System.out.println("House is free now..");
					}
					if (displayMessage != null) {
						for (int i = 0; i < displayMessage.size(); i++) {
							String message = displayMessage.get(i);
							displayEmail += "\n" + message;
						}
					}

				}
				errorlbl.setText(displayEmail);
				errorlbl.setTextFill(Color.GREEN);
				;
			});
		}
	}

}
