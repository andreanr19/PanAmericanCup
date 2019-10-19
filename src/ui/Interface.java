package ui;

import model.PanAmericanCup;
import model.PossibleParticipant;

import java.util.*;

import javax.swing.JOptionPane;

public class Interface {

	private PanAmericanCup myPAC;
	private Scanner reader;

	public Interface() {
		myPAC = new PanAmericanCup();
		reader = new Scanner(System.in);
	}

	public static void main(String[] args) {
		
		Interface ui= new Interface();
		ui.showmenu();
	}

	public void showmenu() {
		int input = 0, elemento;
		do {
			try {
				input = Integer.parseInt(
						JOptionPane.showInputDialog(null, "Welcome to the PanAmericanCup, what would you like to do?\n"
						+"1.To register a possible Participant\n"
								+"2.To add registered participants randomly\n"
						+"3. To search for a possible participant\n"
								+"4.To search for a registered participant\n"
						+"5.To charge the system's information\n"
								+"6.To Exit\n"));
				switch(input) {
				case 1:
					System.out.println("Enter the name of the Possible participant");
					String name= reader.nextLine();
					System.out.println("Enter the id of the participant");
					String id= reader.nextLine();
					System.out.println("Enter the lastName of the participant");
					String ln= reader.nextLine();
					System.out.println("Enter the email of the participant");
					String email = reader.nextLine();
					System.out.println("Enter the gender of the participant");
					String gender = reader.nextLine();
					System.out.println("Enter the country of the participant");
					String country = reader.nextLine();
					System.out.println("Enter the birthdate of the participant in the format M/d/yyyy");
					String birthdate = reader.nextLine();

					PossibleParticipant theNew= new PossibleParticipant(name, ln, id, email, gender, country, birthdate);
					myPAC.toAddAPossibleParticipant(theNew);
					System.out.println("The participant " + name+ " has been added");
					break;
				case 2:
					System.out.println(myPAC.toAddARegisteredParticipant());
					break;
				case 3:
//					System.out.println("Enter the id of the possible participant");
//					String idP= reader.nextLine();
//					System.out.println(myPAC.showTheInfoOfPP(idP));
					boolean continueCicle=true;
					do {
						try {
							System.out.println("Enter the id of the possible participant");
							String idP= reader.nextLine();
							System.out.println(myPAC.showTheInfoOfPP2(idP));
							continueCicle=false;
						}catch(Exception e) {
							e.printStackTrace();
						}
					}while(continueCicle==true);
					break;
				case 4:
//					System.out.println("Enter the id of the Registered participant");
//					String idR= reader.nextLine();
//					System.out.println(myPAC.showTheInfoOfRP(idR));
//					break;
					
					boolean continueCicle4=true;
					do {
						try {
							System.out.println("Enter the id of the Registered participant");
							String idR= reader.nextLine();
							System.out.println(myPAC.showTheInfoOfRP(idR));
							continueCicle4=false;
							
						}catch(Exception e) {
							e.printStackTrace();
						}
					}while(continueCicle4==true);
					break;
				case 5:
					System.out.println("Would you like to charge the information by: Choose the option\n"+
							"1.default rooth\n"+
							"2.Your own rooth");
					int answer= reader.nextInt();
					reader.nextLine();
				if(answer==1) {
					System.out.println(myPAC.toChargeData(myPAC.roothInfo));
				}else {
					System.out.println("Enter the rooth");
					String roothUser= reader.nextLine();
					System.out.println(myPAC.toChargeData(roothUser));
				}
				break;
				case 6:
					JOptionPane.showMessageDialog(null, "Application finished", "End",
							JOptionPane.INFORMATION_MESSAGE);
					break;
				default:
					JOptionPane.showMessageDialog(null, "Wrong option", "Warning!",
							JOptionPane.INFORMATION_MESSAGE);
				}

			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
			}

		} while (input != 6);
	}

}
