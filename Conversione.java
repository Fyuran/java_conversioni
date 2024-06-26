package esercizioConversione;
import java.util.Scanner;

public class Conversione {

	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Benvenuto nel programma di conversione unità");
		System.out.println("Scegli il tipo conversione: "
				+ "\n 1. Da Celsius a Fahrenheit "
				+ "\n 2. Da Fahrenheit a Celsius. "
				
				+ "\n 3. Da Km a Miglia"
				+ "\n 4. Da Miglia a Km"
				
				+ "\n 5. Da Kg a Libbre"
				+ "\n 6. Da Libbre a Kg");
		
			int choice = retrieveChoice();
			double value = retrieveValue();
			double newVal = 0;
			String choiceDesc = "";
			
			switch(choice) {
			//temperature
			case 1:
				newVal = fromCtoF(value);
				choiceDesc = "da Celsius a Fahrenheit";
				break;
			case 2:
				newVal = fromFtoC(value);
				choiceDesc = "da Fahrenheit a Celsius";
				break;

			//velocità
			case 3:
				newVal = fromKmtoM(value);
				choiceDesc = "da Chilometri a Miglia";
				break;
			case 4:
				newVal = fromMtoKm(value);
				choiceDesc = "da Miglia a Chilometri";
				break;
				
			//pesi
			case 5:
				newVal = fromKgtoP(value);
				choiceDesc = "da Chili a Libbre";
				break;
			case 6:
				newVal = fromPtoKg(value);
				choiceDesc = "da Libbre a Chili";
				break;
			}
			scan.close();
			System.out.println("Il numero " + value + " convertito " + choiceDesc + " è: " + newVal);
	}


	private static int retrieveChoice() {
		int choice = 0;
		
		boolean hasValue = false;
		while(!hasValue) {
			if(scan.hasNextInt()) {
				choice = scan.nextInt();
				if(choice < 1 || choice > 6) {
					System.out.println("Scelta invalida, deve essere tra 1 e 6");
					scan.nextLine();
				} else
					hasValue = true;
			}			
			else {
				System.out.println("Non hai inserito un numero, reinseriscilo");
				scan.nextLine();
			}
		}
		return choice;		
	}
	
	private static double retrieveValue() {
		double value = 0;
		System.out.print("Inserisci il numero da convertire: ");
		
		boolean hasValue = false;
		while(!hasValue) {
			if(scan.hasNextDouble()) {
				value = scan.nextDouble();
				hasValue = true;
			}			
			else {
				System.out.println("Non hai inserito un numero, reinseriscilo");
				scan.nextLine();
			}
		}
		return value;		
	}
	
	//formule temperature
	private static double fromCtoF(double temp) {
		if(temp == 0) return 32;
		return (temp * 9/5) + 32;
	}
	
	private static double fromFtoC(double temp) {
		if(temp == 0) return -17.7778;
		return (temp - 32) * 5/9;
	}
	
	//formule velocità
	private static double fromKmtoM(double speed) {
		if(speed == 0) return 0;
		return speed * 0.621371;
	}
	private static double fromMtoKm(double speed) {
		if(speed == 0) return 0;
		return speed / 0.621371;
	}
	
	//formule pesi
	private static double fromKgtoP(double weight) {
		if(weight <= 0) return 0;
		return weight * 2.20462;
	}
	private static double fromPtoKg(double weight) {
		if(weight <= 0) return 0;
		return weight / 2.20462;
	}
}
