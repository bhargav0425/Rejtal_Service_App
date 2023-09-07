package View;

import javafx.application.Application;
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
import javafx.scene.control.Label;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import Controller.rentalController;
import Controller.tenantController;
import Util.rentalFactory;
import model.Apartment;
import model.Building;
import model.Condo;
import model.House;
import model.Tenant;

public class DriverFx extends Application {
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		    Label welcomeMessage = new Label("*****	Welcome to Rental Services	*****");
		    ToggleGroup mainMenu = new ToggleGroup();
		    RadioButton addProperty = new RadioButton("Add A Property");
		    RadioButton addTenant = new RadioButton("Add A New Tenant");
		    RadioButton rentUnit = new RadioButton("Rent A Unit");
		    RadioButton displayProperties = new RadioButton("Display Properties");
		    RadioButton displayTenants = new RadioButton("Display Registered Tenants");
		    RadioButton displayRentedProperties = new RadioButton("Display Rented Properties");
		    RadioButton displayVacantProperties = new RadioButton(" Display Vacant Properties");
		    RadioButton displayAllLesses = new RadioButton("Display all The Signed Leases");
		    RadioButton changeRentalStatus = new RadioButton("Change Rental Status");
		    RadioButton systemExit = new RadioButton("Exit");
		    
		    addProperty.setToggleGroup(mainMenu);
		    addTenant.setToggleGroup(mainMenu);
		    rentUnit.setToggleGroup(mainMenu);
		    displayProperties.setToggleGroup(mainMenu);
		    displayTenants.setToggleGroup(mainMenu);
		    displayRentedProperties.setToggleGroup(mainMenu);
		    displayVacantProperties.setToggleGroup(mainMenu);
		    displayAllLesses.setToggleGroup(mainMenu);
		    changeRentalStatus.setToggleGroup(mainMenu);
		    systemExit.setToggleGroup(mainMenu);
		    
		    Button submit = new Button("Submit");

		    
//		    VBox root = new VBox();
		    //we need to add this button to this layout
//		    root.getChildren().add(welcomeMessage);
//		    root.getChildren().addAll(addProperty,addTenant,rentUnit,displayProperties,displayTenants,displayRentedProperties,displayVacantProperties,displayAllLesses,changeRentalStatus,systemExit);
		    //we need to add this layout to a scene
		    
		    BorderPane border_pane = new BorderPane();
		    border_pane.setCenter(new VBox(10,welcomeMessage,addProperty,addTenant,rentUnit,displayProperties,displayTenants,displayRentedProperties,displayVacantProperties,displayAllLesses,changeRentalStatus,systemExit,submit));
		    BorderPane.setAlignment(welcomeMessage, Pos.BOTTOM_RIGHT);
		    Scene sc = new Scene(border_pane);		    
		    primaryStage.setFullScreen(true);
		    primaryStage.setTitle("Radio Button Demo");
		    primaryStage.setScene(sc);
		    primaryStage.show();
		    submit.setOnAction(new EventHandler<ActionEvent>() {
		        
		        @Override
		        public void handle(ActionEvent event) {
		          // TODO Auto-generated method stub
		        	
		         // 1. If Add Property is selected from the Menu...
		          if(addProperty.isSelected()){
		        	Label selectProperty = new Label("*****	Please select the property	*****");
		  		    ToggleGroup propertyMenu = new ToggleGroup();
		  		    RadioButton apartmentOption = new RadioButton("Apartment");
				    RadioButton condoOption = new RadioButton("Condo");
				    RadioButton houseOption = new RadioButton("House");
				    RadioButton goToMainMenu = new RadioButton("Go To Main Menu");
				    Button select = new Button("Submit");
				    apartmentOption.setToggleGroup(propertyMenu);
				    condoOption.setToggleGroup(propertyMenu);
				    houseOption.setToggleGroup(propertyMenu);
				    goToMainMenu.setToggleGroup(propertyMenu);
				    
				    BorderPane selectPropertyPane = new BorderPane();
				    selectPropertyPane.setCenter(new VBox(apartmentOption,condoOption,houseOption,goToMainMenu,select));
				    BorderPane.setAlignment(welcomeMessage, Pos.BOTTOM_RIGHT);
				    Scene displayPropertyScene = new Scene(selectPropertyPane);
				    primaryStage.setScene(displayPropertyScene);
				    primaryStage.setFullScreen(true);
				    primaryStage.show();
				    
				    
				    select.setOnAction(arg0 ->{
				    	
							if(apartmentOption.isSelected()) {
								RegistrationForm form = new RegistrationForm();
							    form.showForm(primaryStage);
							}
							if(condoOption.isSelected()) {
								CondoRegistrationForm form = new CondoRegistrationForm();
							    form.showForm(primaryStage);
							}
							if(houseOption.isSelected()) {
								HouseRegistrationForm form = new HouseRegistrationForm();
							    form.showForm(primaryStage);
							}
							if(goToMainMenu.isSelected()) {
								primaryStage.setScene(sc);
								 primaryStage.setFullScreen(true);
							    primaryStage.show();
							}
							
						}
				    );
				    }		
		          if(addTenant.isSelected()) {
		        	  NewTenantForm form = new NewTenantForm();
					    form.showForm(primaryStage);
		          }
		          else
		          {
		            
		          }

		        }
		      });
		    
		 
		
	}
	
	public static void main(String[] args) {
		 launch(args);
	}
	
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
		  private List<TextField> fields = new ArrayList<TextField>(Arrays.asList(civicAddress,apartmentNumber,bedrooms,bathrooms,squareFootArea,streetName,city,postalCode,province,country));			
		  ObservableList<Node> children;
		  
		  public void showForm(Stage primaryStage) {			  
			  civicAddressLabel = new Label("Civic Address");
			  civicAddress = new TextField();
			   apartmentNumberLabel  = new Label("Apartment Number");
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
			   provinceLabel = new Label("Civic Address");
			   province = new TextField();
			   countryLabel = new Label("Province");
			   country = new TextField();
			   errorlbl = new Label("");
			   List<TextField> fields = new ArrayList<TextField>(Arrays.asList(civicAddress,apartmentNumber,bedrooms,bathrooms,squareFootArea,streetName,city,postalCode,province,country));			
				
			  BorderPane apartmentRegisterForm = new BorderPane();
			  apartmentRegisterForm.setCenter(new VBox(10,civicAddressLabel,civicAddress,apartmentNumberLabel,apartmentNumber,bedroomsLabel,bedrooms,bathroomsLabel,bathrooms,squareFootAreaLabel,squareFootArea,streetNameLabel,streetName,cityLabel,city,postalCodeLabel,postalCode,provinceLabel,province,countryLabel,country,addApartmentDetails,errorlbl));
			  Scene displayApartmentScene = new Scene(apartmentRegisterForm);
			  children =  apartmentRegisterForm.getChildren();
			  primaryStage.setScene(displayApartmentScene);
			  primaryStage.setFullScreen(true);
			  primaryStage.show();
			  
			  addApartmentDetails.setOnAction(args ->{
					Building model =  new Apartment(civicAddress.getText(),apartmentNumber.getText(),Integer.parseInt(bedrooms.getText()),Integer.parseInt(bathrooms.getText()),Integer.parseInt(squareFootArea.getText()),streetName.getText(),city.getText(),postalCode.getText(),province.getText(),country.getText(),false);
					errorlbl.setText("Apartment Has been Added Succesfully.");
					errorlbl.setTextFill(Color.RED);
					System.out.println(model);
					
					for(int i=0;i<fields.size();i++) {
						TextField currentField = fields.get(i);
						currentField.setText("");
			    	  }
					
				}
			    );
		   
		  }
		 
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
		 
		  BorderPane condoRegisterPane = new BorderPane();
		  condoRegisterPane.setCenter(new VBox(10,unitNumberLabel,unitNumber,streetNumberLabel,streetNumber,streetNameLabel,streetName,cityLabel,city,postalCodeLabel,postalCode,provinceLabel,province,countryLabel,country,addCondoDetails,errorlbl));
		  Scene displayApartmentScene = new Scene(condoRegisterPane);
		  primaryStage.setScene(displayApartmentScene);
		  primaryStage.setFullScreen(true);
		  primaryStage.show();
		  
		  addCondoDetails.setOnAction(args ->{
				Building model =  new Condo (Integer.parseInt(unitNumber.getText()),Integer.parseInt(streetNumber.getText()),streetName.getText(),city.getText(),postalCode.getText(),province.getText(),country.getText(),false);
				errorlbl.setText("Condo Has been Added Succesfully.");
				errorlbl.setTextFill(Color.RED);
				System.out.println(model);
				
			}
		    );
	   
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
	  Button addCondoDetails = new Button("Add House Details");
	  

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
		 
		  BorderPane houseRegisterPane = new BorderPane();
		  houseRegisterPane.setCenter(new VBox(10,streetNumberLabel,streetNumber,streetNameLabel,streetName,cityLabel,city,postalCodeLabel,postalCode,provinceLabel,province,countryLabel,country,addCondoDetails,errorlbl));
		  Scene displayHouseScene = new Scene(houseRegisterPane);
		  primaryStage.setScene(displayHouseScene);
		  primaryStage.setFullScreen(true);
		  primaryStage.show();
		  
		  addCondoDetails.setOnAction(args ->{
				Building model =  new House (Integer.parseInt(streetNumber.getText()),streetName.getText(),city.getText(),postalCode.getText(),province.getText(),country.getText(),false);
				errorlbl.setText("House Has been Added Succesfully.");
				errorlbl.setTextFill(Color.RED);
				System.out.println(model);
				
			}
		    );
	   
	  }
	}

class NewTenantForm{
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
	  Label errorlbl;
	  
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
			interestedPropertieLabel = new Label("Are you interested in looking any of our preperties? (yes/no)");
			interestedPropertie = new TextField();
		   errorlbl = new Label("");
		   
		 //creating listview
		    ListView allProperties = new ListView();
		    allProperties.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
//		    subjects.getItems().add("English");
//		    subjects.getItems().add("physics");
//		    subjects.getItems().add("chemistry");
//		    subjects.getItems().add("history");
		   BorderPane tenantRegisterPane = new BorderPane();
		   tenantRegisterPane.setCenter(new VBox(10,firstNameLabel,firstName,lastNameLabel,lastName,ageLabel,age,contactNumberLabel,contactNumber,emailLabel,email,interestedPropertieLabel,interestedPropertie,addTenantDetails,errorlbl));
			  Scene displayTenantScene = new Scene(tenantRegisterPane);
			  primaryStage.setScene(displayTenantScene);
			  primaryStage.setFullScreen(true);
			  primaryStage.show();
		   addTenantDetails.setOnAction(args ->{
			   Tenant newTenant = new Tenant(firstName.getText(),lastName.getText(),Integer.parseInt(age.getText()),contactNumber.getText(),email.getText());
			   errorlbl.setText("Tenant Has been Added Succesfully.");
				errorlbl.setTextFill(Color.RED);
				System.out.println(newTenant);			
			}
		    );	   
	  }
}



