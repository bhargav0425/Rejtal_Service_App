package Generics_Set;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class newSetDriver {
	public static void main(String[] args) {
		newSet<identifiableImpl> test = new newSet<>();

		Scanner input = new Scanner(System.in);

		System.out.println("\t\t**********\t\tWelcome To \"The Set Driver\" Class\t\t**********");
		int choice;
		do {
			System.out.println("\n1. Add An Element");
			System.out.println("2. Remove An Element");
			System.out.println("3. Check Element's Presence");
			System.out.println("4. Get The Size Of The Set");
			System.out.println("5. Compare Two Sets");
			System.out.println("6. Display All The Set Elements");
			System.out.println("7. Exit");
			System.out.print("\nPlease Enter Your Choice : ");
			choice = Integer.parseInt(input.nextLine());
			System.out.println();

			switch (choice) {
			case 1: {
				System.out.println("Please enter an element : ");
				// int id = Integer.parseInt(input.nextLine());
				String id = input.nextLine();
				identifiableImpl newElement = new identifiableImpl(id);
				test.add(newElement);
				break;
			}
			case 2: {
				System.out.println("Please enter an element : ");
				// int id = Integer.parseInt(input.nextLine());
				String id = input.nextLine();
				identifiableImpl updatedList = test.delete(id);
				if (updatedList != null)
					System.out.println(updatedList);
				break;
			}
			case 3: {
				System.out.println("Please enter an element to verify : ");
				// int id = Integer.parseInt(input.nextLine());
				String id = input.nextLine();
				if (test.peek(id))
					System.out.println("\nExists!!");
				else
					System.out.println("\nDoesn't Exist!!");

				break;
			}
			case 4: {
				System.out.println("The Size Of The Set Is :" + test.size());
				break;
			}
			case 5: {
				newSet<identifiableImpl> test1 = new newSet<>();
				test1.add(new identifiableImpl("1"));
				test1.add(new identifiableImpl("2"));
				//System.out.println(test1);
				
				//System.out.println(test);
				
				newSet<identifiableImpl> test2 = new newSet<>();
				test2.add(new identifiableImpl("Bhargav"));
				test2.add(new identifiableImpl("Dhrvuil"));
				//System.out.println(test2);
				
				newSet<identifiableImpl> test3 = new newSet<>();
				test3.add(new identifiableImpl("Bhargav"));
				test3.add(new identifiableImpl("Dhrvuil"));
				//System.out.println(test3);
				
				
				if (test.equals(test1))
					System.out.println("\nSets Identical!!");
				else
					System.out.println("\nSets Unidentical!!");
				break;
			}
			case 6: {

				test.displayElements();
				break;
			}
			case 7: {
				System.out
						.println("\t\t**********\t\tThank You For Exploring \"The Set Driver\" Class!!!\t\t**********");
				break;
			}
			default:
				System.out.println("\nInvalid Choice!!\nPlease Select An Option Between 1-7\n");
				break;
			}

		} while (choice != 7);

	}
}
